package fr.mds.pokedex.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.mds.pokedex.adapter.PokeListRecyclerViewAdapter;
import fr.mds.pokedex.R;
import fr.mds.pokedex.model.Attack;
import fr.mds.pokedex.model.PokeCard;


public class MainActivity extends Activity {

    private ArrayList<PokeCard> pokeCards = new ArrayList<>();
    private List<Attack> pokeCardAttack = new ArrayList<>();

    public static final String TAG = "pokedex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i <= 100; i++) {
            addAttack("fulguro poing" + i);
            addPokeCard("test" + i, "0000"+i, "Pokemon", "100", pokeCardAttack);
        }

        final PokeListRecyclerViewAdapter pokeListRecyclerViewAdapter = new PokeListRecyclerViewAdapter(pokeCards, this);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(pokeListRecyclerViewAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleCount = gridLayoutManager.getChildCount();
                int firstVisibleItemPoistion = gridLayoutManager.findFirstVisibleItemPosition();
                int totalItemCount = gridLayoutManager.getItemCount();

                if( (visibleCount + firstVisibleItemPoistion) >= totalItemCount ){
                    pokeCards.addAll(pokeCards);
                    pokeListRecyclerViewAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    void addAttack(String attackDescription){
        Attack attack = new Attack(attackDescription);
        Log.d(TAG, "Attack details " + attack.getAttack());
        pokeCardAttack.add(attack);
    }


    void addPokeCard(String name, String id, String type, String hp, List<Attack> pokeCardAttack){
        PokeCard pokeCard = new PokeCard(name, id, type, hp, pokeCardAttack);
        Log.d(TAG, "pokeCard details " + pokeCard.getName());
        pokeCards.add(pokeCard);
    }
}
