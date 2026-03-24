package com.example.springpokemon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;



@SpringBootTest
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })

class  SpringPokemonApplicationTests {


    @Test
    void contextLoads() {
    }

}
