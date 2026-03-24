package com.example.springpokemon.services;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BattleServiceTest {

    private BattleService battleService;
    private PokedexRepository mockRepo;


    @BeforeEach
    void setUp() {
        mockRepo = mock(PokedexRepository.class);
        battleService = new BattleService(mockRepo);

    }

    @Test
    void getWinnerName_returnP1() throws SQLException {
        // Arrange
        Pokemon p1 = new Pokemon(151, "Mew", 100, 100, 100, 100, 100, 100, "Psychic", "");
        Pokemon p2 = new Pokemon(91, "Cloyster", 70, 45, 85, 180, 95, 50, "Water", "Ice");
        when(mockRepo.getSingleById(151)).thenReturn(p1);
        when(mockRepo.getSingleById(91)).thenReturn(p2);
        // Act
        String result = battleService.getWinnerName(p1, p2);
        // Assert
        assertEquals("Mew", result);
    }


    @Test
    void getAdvantage_returnBetterAdvantage() throws SQLException{
        Pokemon p1 = new Pokemon(7, "Squirtle", 43, 64, 50, 65, 48, 44, "Water", "");
        Pokemon p2 = new Pokemon(4, "Charmander", 65, 50, 60, 43, 52, 39, "Fire", "");
        when(mockRepo.getSingleById(7)).thenReturn(p1);
        when(mockRepo.getSingleById(4)).thenReturn(p2);
        // Act
        String result = battleService.getAdvantage(p1.getPokedexNumber(), p2.getPokedexNumber());
        // Assert
        assertEquals("Squirtle", result);
    }

    }
