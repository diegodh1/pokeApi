package com.example.poke.pokeApi.services;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.example.poke.pokeApi.models.Pokemon;
import com.example.poke.pokeApi.models.PokemonListResponse;
import com.example.poke.pokeApi.models.Exceptions.InternalResponseError;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiChainEvolution;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiCharacteristic;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiSpecie;
import com.example.poke.pokeApi.models.ExternalApi.PokemonInfoApiResponse;
import com.example.poke.pokeApi.repositories.PokemonApiRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class PokeApiService {
	
	//variables
	@Autowired
	private PokemonApiRepositoryImpl repository;

	// empty constructor
	public PokeApiService() {

	}

	// get the pokemons list
	@Cacheable("pokemons")
	public PokemonListResponse getPokemons(String limit, String offset) {
		// call the pokemons list from the external api
		PokemonApiListResponse result = repository.getAllPokemons(limit, offset);
		// prepare the final response
		PokemonListResponse pokemonList = new PokemonListResponse();
		
		if (result != null) {
			// the total number of elements
			pokemonList.setCount(result.getCount());
			// the next elements of the list
			if (result.getNext() != null)
				pokemonList.setNext(result.getNext());
			// the previous elements of the list
			if (result.getPrevious() != null)
				pokemonList.setPrevious(result.getPrevious());
			ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
			// for each pokemon from the external api list get the basic information of each one
			ArrayList<Callable<Pokemon>> callableTasks = new ArrayList<Callable<Pokemon>>();
			for (int i = 0; i < result.getResults().size(); i++) {
				callableTasks.add(getPokemon(result.getResults().get(i).getName()));
			}
			//create executor service to make asynchronous calls
			ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
					new LinkedBlockingQueue<Runnable>());
			//call to all requests of asynchronous way and wait for results
			try {
				ArrayList<Future<Pokemon>> futures = (ArrayList<Future<Pokemon>>) executorService.invokeAll(callableTasks);
				executorService.shutdown();
				//get the results 
				for(int j=0; j < futures.size(); j++) {
					pokemons.add(futures.get(j).get());
				}
			} catch (InterruptedException e) {
				executorService.shutdownNow();
				throw new InternalResponseError(e.toString());
			} catch (ExecutionException e) {
				executorService.shutdownNow();
				throw new InternalResponseError(e.toString());
			}
			//final result
			pokemonList.setResults(pokemons);
		}
		// return the pokemon list
		return pokemonList;
	}

	//auxiliar method to create a Callable object
	Callable<Pokemon> getPokemon(String name) {
		// return
		Callable<Pokemon> result = new Callable<Pokemon>() {
			@Override
			public Pokemon call() throws Exception {
				PokemonInfoApiResponse pokemonTemp = repository.getPokemonInfo(name);
				// the code below is only possible if pokemon exists
				Pokemon temp = new Pokemon();
				temp.setID(pokemonTemp.getID());
				temp.setPhoto(pokemonTemp.getSprites().getOther().getOfficialArtWork().getFrontDefault());
				temp.setHeight(pokemonTemp.getHeight());
				temp.setWeight(pokemonTemp.getWeight());
				temp.setName(pokemonTemp.getName());
				temp.setAbilities(pokemonTemp.getAbilities());
				temp.setTypes(pokemonTemp.getTypes());
				return temp;
			}
		};
		
		return result;
	}

	// get the information detail from a pokemon
	@Cacheable("pokemon")
	public Pokemon getInfoPokemon(String nameOrID) {
		Pokemon pokemon = new Pokemon();
		// search the pokemon in the external api rest
		PokemonInfoApiResponse result = repository.getPokemonInfo(nameOrID);
		if (result != null) {
			// setting the attributes
			pokemon.setPhoto(result.getSprites().getOther().getOfficialArtWork().getFrontDefault());
			pokemon.setHeight(result.getHeight());
			pokemon.setWeight(result.getWeight());
			pokemon.setName(result.getName());
			pokemon.setStats(result.getStats());
			pokemon.setAbilities(result.getAbilities());
			pokemon.setTypes(result.getTypes());
			PokemonApiSpecie specie = repository.getPokemonSpecie(nameOrID);
			PokemonApiChainEvolution chain = repository.getEvolutions(specie.getEvolutionChain().getUrl());
			int characteristicID = repository.getPokemonCharacteristicID(pokemon.getStats());
			// get the pokemon's description
			if (characteristicID > 0) {
				PokemonApiCharacteristic characteristic = repository.getPokemonCharacteristics(characteristicID);
				if (characteristic != null) {
					pokemon.setDescriptions(characteristic.getDescriptions());
				}
			}
			pokemon.setEvolutions(chain);
		}
		// only returns if the pokemon exists if not we throw an exception 404 not found
		return pokemon;
	}

}
