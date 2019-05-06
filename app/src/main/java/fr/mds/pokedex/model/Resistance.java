package fr.mds.pokedex.model;

import java.io.Serializable;

public class Resistance implements Serializable {
    private String type;

    public Resistance(String type){
        this.type = type;
    }
}

