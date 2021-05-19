package com.example.poke.pokeApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.example.poke.pokeApi.models.ExternalApi.PokemonApiChainEvolution;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiCharacteristic;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiGenericResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiSpecie;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiStat;
import com.example.poke.pokeApi.models.ExternalApi.PokemonInfoApiResponse;
import com.example.poke.pokeApi.repositories.PokemonApiRepositoryImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PokeApiApplicationTests {

	@Autowired
    private PokemonApiRepositoryImpl repository;

	@Test
	public void getPokemonCharacteristicIDTest() {
		//create the data to test the method
		ArrayList<PokemonApiStat> stats = new ArrayList<PokemonApiStat>();
		stats.add(new PokemonApiStat(40, 0, new PokemonApiGenericResponse("hp", "https://pokeapi.co/api/v2/stat/1/")));
		stats.add(new PokemonApiStat(80, 0, new PokemonApiGenericResponse("attack", "https://pokeapi.co/api/v2/stat/2/")));
		stats.add(new PokemonApiStat(100, 1, new PokemonApiGenericResponse("defense", "https://pokeapi.co/api/v2/stat/3/")));
		stats.add(new PokemonApiStat(30, 0, new PokemonApiGenericResponse("defense", "https://pokeapi.co/api/v2/stat/4/")));
		stats.add(new PokemonApiStat(157, 0, new PokemonApiGenericResponse("special-defense", "https://pokeapi.co/api/v2/stat/5/")));
		stats.add(new PokemonApiStat(30, 0, new PokemonApiGenericResponse("speed", "https://pokeapi.co/api/v2/stat/6/")));
		//expected result 6 * 2 + 5 = 17
		int expectedResult = 17;
		assertEquals(expectedResult, repository.getPokemonCharacteristicID(stats));
	}

	
	@Test
	public void getAllPokemonsTest(){
		//test for limit = 10 and offset = 10
		PokemonApiListResponse result = repository.getAllPokemons("10", "10");
		//expected result next = serverUrl/pokemons?offset=20&limit=10
		//expected result previous = serverUrl/pokemons?offset=0&limit=10
		//expected result results.size() = 10
		String next = "offset=20&limit=10";
		String previous = "offset=0&limit=10";
		int size = 10;
		//real results
		String[] nextReal = result.getNext().split("\\?");
		String[] prevReal = result.getPrevious().split("\\?");
		assertEquals(
			true, result.getResults().size() == size && 
			next.equals(nextReal[1]) &&
			previous.equals(prevReal[1])
		);
	}

	@Test
	public void getPokemonInfoTest(){
		//call the method
		PokemonInfoApiResponse result = repository.getPokemonInfo("geodude");
		//expected result
		//height = 4
		//weight = 200
		//abilitiesSize = 3
		int height = 4;
		int weight = 200;
		int abilitiesSize = 3;
		//test
		assertEquals(
			true, height == result.getHeight() && 
			weight == result.getWeight() &&
			abilitiesSize == result.getAbilities().size()
		);
	}

	@Test
	public void PokemonApiChainEvolutionTest(){
		//test with url https://pokeapi.co/api/v2/evolution-chain/10
		PokemonApiChainEvolution result = repository.getEvolutions("https://pokeapi.co/api/v2/evolution-chain/10");
		//expected results
		//basic form = pichu
		//evolution 1 = pikachu
		//evolution 2 = raichu
		String basicForm = "pichu";
		String evolution1 = "pikachu";
		String evolution2 = "raichu";

		assertEquals(
			true, basicForm.equals(result.getChain().getSpecies().getName())&& 
			evolution1.equals(result.getChain().getEvolvesTo().get(0).getSpecies().getName()) &&
			evolution2.equals(result.getChain().getEvolvesTo().get(0).getEvolvesTo().get(0).getSpecies().getName())
		);

	}

	@Test
	public void getPokemonCharacteristicsTest(){
		//test for characteristic Id = 1
		PokemonApiCharacteristic result = repository.getPokemonCharacteristics(1);
		//expected results
		//description in english = Loves to eat
		String description = "Loves to eat";
		assertEquals(
			true, description.equals(result.getDescriptions().get(2).getDescription())
		);
	}

	@Test
	public void getPokemonSpecieTest(){
		//test for pokemon  charmander
		PokemonApiSpecie result = repository.getPokemonSpecie("charmander");
		//expected results
		//description in english = Loves to eat
		//evolution chain = https://pokeapi.co/api/v2/evolution-chain/2/
		String evolutionChain = "https://pokeapi.co/api/v2/evolution-chain/2/";
		assertEquals(
			true, evolutionChain.equals(result.getEvolutionChain().getUrl())
		);
	}

}
