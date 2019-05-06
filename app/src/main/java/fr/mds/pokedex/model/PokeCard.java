package fr.mds.pokedex.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokeCard implements Serializable {

    private String id;
    private String name;
    private String imageUrl;
    private String hp;
    private List<String> types = new ArrayList<String>();
    private List<Attack> attacks = new ArrayList<Attack>();
    private List<Resistance> resistances = new ArrayList<Resistance>();
    private List<Weakness> weaknesses = new ArrayList<Weakness>();


    public PokeCard(String name, String id, String type, String hp, List<Attack> attack) {

        this.name = name;
        this.id = id;
        this.types.add(type);
        this.hp = hp;
        this.attacks = attack;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getHp() {
        return hp;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public List<Resistance> getResistances() {
        return resistances;
    }

    public List<Weakness> getWeaknesses() {
        return weaknesses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public void setResistances(List<Resistance> resistances) {
        this.resistances = resistances;
    }

    public void setWeaknesses(List<Weakness> weaknesses) {
        this.weaknesses = weaknesses;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
