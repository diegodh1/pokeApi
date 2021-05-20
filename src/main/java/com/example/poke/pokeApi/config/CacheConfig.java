package com.example.poke.pokeApi.config;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    Config  config() {
        Config config = new Config();

        MapConfig mapConfig = new MapConfig();
        //time to be in the cache infinity
        mapConfig.setTimeToLiveSeconds(0);
        config.getMapConfigs().put("pokemons", mapConfig);
        config.getMapConfigs().put("pokemon", mapConfig);
         return config;
    }
}
