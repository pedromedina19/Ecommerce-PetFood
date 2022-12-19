package com.web.petfood.models;

public enum Categoria {

    CAES("Cães"),
    GATOS("Gatos"),
    PEIXES("Peixes"),
    PASSAROS("Pássaros"),
    ROEDORES("Roedores"),
    REPTEIS("Répteis"),
    EQUINOS("Equinos"),
    OURICOS("Ouriços");

    private String descricao;

    private Categoria(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
