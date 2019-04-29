package fr.mds.pokedex.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class PokeCard{

    private String id;
    private String name;
    private String imageUrl;
    private String hp;
    private List<String> types;
    private List<Attack> attacks;
    private List<Resistance> resistances;
    private List<Weakness> weaknesses;


    public PokeCard(String name) {
        this.name = name;
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
}
