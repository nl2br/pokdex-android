package fr.mds.pokedex.rest.container;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import fr.mds.pokedex.model.PokeCard;

public class PokeContainer {

    @SerializedName("cards")
    private List<PokeCard> cards;

    public List<PokeCard> getCards() {
        return cards;
    }

    public void setCards(List<PokeCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
