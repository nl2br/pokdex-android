package fr.mds.pokedex.model;

import java.io.Serializable;

public class Weakness implements Serializable {
    private String type;

    public Weakness(String type){
        this.type = type;
    }
}
