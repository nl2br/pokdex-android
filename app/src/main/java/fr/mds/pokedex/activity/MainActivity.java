package fr.mds.pokedex.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

import fr.mds.pokedex.adapter.PokeListRecyclerViewAdapter;
import fr.mds.pokedex.R;
import fr.mds.pokedex.model.PokeCard;


public class MainActivity extends Activity {

    private ArrayList<PokeCard> pokeCards = new ArrayList<>();
    public static final String TAG = "pokedex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getActionBar().show();

        for (int i = 0; i <= 100; i++) {
            addPokeCard("test" + i);
        }

        final PokeListRecyclerViewAdapter pokeListRecyclerViewAdapter = new PokeListRecyclerViewAdapter(pokeCards);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);

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

    void addPokeCard(String name){
        PokeCard pokeCard = new PokeCard(name);
        Log.d(TAG, "pokeCard details " + pokeCard.getName());
        pokeCards.add(pokeCard);
    }
}
