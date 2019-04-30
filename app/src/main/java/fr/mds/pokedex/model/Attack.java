package fr.mds.pokedex.model;

import java.io.Serializable;

public class Attack implements Serializable {
    private String attack;

    public Attack(String attack){
        this.attack = attack;
    }

    public String getAttack() {
        return attack;
    }

}

