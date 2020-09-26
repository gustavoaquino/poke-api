package br.com.pokeapi.controller;

import br.com.pokeapi.api.to.PokemonTO;
import br.com.pokeapi.service.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * Controller onde é feito o mapeamento das páginas
 *
 * @author Gustavo Aquino
 * @since 26/09/2020
 *
 * */


@Controller
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping({"", "/"})
    public String getIndex(Model model){

       final List<PokemonTO> listaPokemonTO = pokemonService.getFirstPokemonGenerationByQuantity(9);

        model.addAttribute("botaoTodosAtivo", true);
        model.addAttribute("listaPokemon", listaPokemonTO);

        return "index.html";
    }

    @GetMapping("/todos")
    public String getAllPokemons(Model model){

        final List<PokemonTO> listaPokemonTO = pokemonService.getFirstPokemonGenerationByQuantity(151);

        model.addAttribute("botaoTodosAtivo", false);
        model.addAttribute("listaPokemon", listaPokemonTO);

        return "index.html";

    }
}
