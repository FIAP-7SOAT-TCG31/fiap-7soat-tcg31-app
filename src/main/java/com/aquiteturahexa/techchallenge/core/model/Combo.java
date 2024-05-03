package com.aquiteturahexa.techchallenge.core.model;

import java.util.List;

public class Combo {
    private List<Item> itens;

    public Combo() {

    }

    public Combo(List<Item> itens) {
        this.itens = itens;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
