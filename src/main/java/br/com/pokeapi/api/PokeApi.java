package br.com.pokeapi.api;

import br.com.pokeapi.api.to.PokemonTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe responsável em fazer a requisição para a PokéApi
 *
 * @author Gustavo Aquino
 * @since 26/09/2020
 *
 * */

@Component
public class PokeApi {

    private static final String URL_API = "https://pokeapi.co/api/v2/pokemon/";

    public List<PokemonTO> getFirstGeneration(int quantidadePokemons) {

       final List<PokemonTO> listaPokemonTO = new ArrayList<>();

        try {
            for (int i = 1; i <= quantidadePokemons; i++) {

               final Connection.Response response = Jsoup.connect(URL_API.concat(String.valueOf(i)))
                        .ignoreContentType(true)
                        .timeout(10 * 1000).execute().bufferUp();

                final ObjectMapper objectMapper = new ObjectMapper();

                objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

                final PokemonTO pokemonTO = objectMapper.readValue(response.body(), PokemonTO.class);

                listaPokemonTO.add(pokemonTO);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaPokemonTO;
    }


}
