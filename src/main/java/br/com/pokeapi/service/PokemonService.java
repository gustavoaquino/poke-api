package br.com.pokeapi.service;

import br.com.pokeapi.api.PokeApi;
import br.com.pokeapi.api.to.PokemonTO;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service responsável em isolar o controller da chamada da API.
 *
 * @author Gustavo Aquino
 * @since 26/09/2020
 *
 * */


@Service
public class PokemonService {

    private final PokeApi pokeApi;

    public PokemonService(PokeApi pokeApi) {
        this.pokeApi = pokeApi;
    }

    public List<PokemonTO> getFirstPokemonGenerationByQuantity(int quantityPokemon){
        return this.pokeApi.getFirstGeneration(quantityPokemon);
    }
}
