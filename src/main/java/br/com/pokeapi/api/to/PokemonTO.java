package br.com.pokeapi.api.to;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * TO responsável em mapear as informações recebidas da API.
 *
 * @author Gustavo Aquino
 * @since 26/09/2020
 *
 * */

public class PokemonTO {

    private List<Form> forms;

    private Sprites sprites;

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    //Método responsável em simplificar a busca pelo nome do pokémon.
    public String getNomePokemon(){
        return this.getForms().get(0).getName();
    }

    //Método responsável em simplificar a busca pela imagem do pokémon.
    public String getImgPokemon(){
        return this.getSprites().getListaImagens().getDreamWorld().getUrlImg();
    }

}

class Form {

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


class Sprites {

    @JsonProperty("other")
    private Imagens listaImagens;

    public Imagens getListaImagens() {
        return listaImagens;
    }

    public void setListaImagens(Imagens listaImagens) {
        this.listaImagens = listaImagens;
    }
}

class Imagens {

    @JsonProperty("dream_world")
    private DreamWorld dreamWorld;


    public DreamWorld getDreamWorld() {
        return dreamWorld;
    }

    public void setDreamWorld(DreamWorld dreamWorld) {
        this.dreamWorld = dreamWorld;
    }
}

class DreamWorld{

    @JsonProperty("front_default")
    private String urlImg;

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}

