package com.example.springpokemon.services;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public class BattleService {
    public PokedexRepository repo;

    public BattleService(PokedexRepository mockRepo) {
        repo = mockRepo;
    }

    public String getWinnerName(Pokemon p1, Pokemon p2) throws SQLException {
        Pokemon pokemon1 = repo.getSingleById(p1.getPokedexNumber());
        Pokemon pokemon2 = repo.getSingleById(p2.getPokedexNumber());

        if (pokemon1 == null || pokemon2 == null) {
            throw new NoSuchElementException("Pokemon not found");
        }

        int stats1 = pokemon1.getTotalStats();
        int stats2 = pokemon2.getTotalStats();

        if (stats1 > stats2) return pokemon1.getName();
        if (stats2 > stats1) return pokemon2.getName();

        return "Draw";
    }

    public String getArchetype(Pokemon pokemon) {
        /* TODO */
        return null;
    }

    public String getAdvantage(int id1, int id2) throws SQLException {
        Pokemon pokemon1 = repo.getSingleById(id1);
        Pokemon pokemon2 = repo.getSingleById(id2);

        if (pokemon1 == null || pokemon2 == null) {
            throw new NoSuchElementException("Pokemon not found");
        }

        if (pokemon1.getPrimaryType().equals("Water") && pokemon2.getPrimaryType().equals("Fire")) {
            return pokemon1.getName();
        }
        if (pokemon1.getPrimaryType().equals("Fire") && pokemon2.getPrimaryType().equals("Grass")) {
            return pokemon1.getName();
        }

        if (pokemon1.getPrimaryType().equals("Grass") && pokemon2.getPrimaryType().equals("Water")) {
            return pokemon1.getName();
        }

        if (pokemon2.getPrimaryType().equals("Water") && pokemon1.getPrimaryType().equals("Fire")) {
            return pokemon2.getName();
        }
        if (pokemon2.getPrimaryType().equals("Fire") && pokemon1.getPrimaryType().equals("Grass")) {
            return pokemon2.getName();
        }

        if (pokemon2.getPrimaryType().equals("Grass") && pokemon1.getPrimaryType().equals("Water")) {
            return pokemon2.getName();
        }
        if (pokemon2.getPrimaryType().equals(pokemon1.getPrimaryType())) {
            return "No advantage(Same pokemon type)";
        }
        if (!pokemon2.getPrimaryType().equals("Grass") || !pokemon2.getPrimaryType().equals("Fire") || !pokemon2.getPrimaryType().equals("Water")) {
            return "No advantage for p2";
        }
        if (!pokemon1.getPrimaryType().equals("Grass") || !pokemon1.getPrimaryType().equals("Fire") || !pokemon1.getPrimaryType().equals("Water")) {
            return "No advantage for p1";
        }
        else return "No advantage(Did not fullfill any criteria)";
    }
}
