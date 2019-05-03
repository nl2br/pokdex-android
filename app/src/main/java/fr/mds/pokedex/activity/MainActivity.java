package fr.mds.pokedex.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
//import android.support.v7.widget.SearchView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.mds.pokedex.adapter.PokeListRecyclerViewAdapter;
import fr.mds.pokedex.R;
import fr.mds.pokedex.model.Attack;
import fr.mds.pokedex.model.PokeCard;


public class MainActivity extends AppCompatActivity {

    private ArrayList<PokeCard> pokeCards = new ArrayList<>();
    private ArrayList<PokeCard> pokeCardsOriginal = new ArrayList<>();
    private ArrayList<PokeCard> pokeCardsFiltered = new ArrayList<>();
    private List<Attack> pokeCardAttack = new ArrayList<>();

    private RecyclerView recyclerView;
    private PokeListRecyclerViewAdapter pokeListRecyclerViewAdapter;
    private boolean isSearching = false;

    public static final String TAG = "pokedex";

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        menu.findItem(R.id.search).setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                isSearching = true;
                pokeCardsFiltered.clear();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                isSearching = false;
                pokeCards.clear();
                pokeCards.addAll(pokeCardsOriginal);
                pokeListRecyclerViewAdapter.notifyDataSetChanged();
                return true;
            }
        });

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
/*            case R.id.action_add:
                return true;

            case R.id.action_delete:
                return true;

            case R.id.action_edit:
                return true;*/

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d(TAG, "Intent incoming " + intent);
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d(TAG, "Search " + query);

            // rechercher l'élément dans la liste
            for(int i = 0; i < pokeCards.size(); i++){
                // Log.d(TAG, "compare " + pokeCards.get(i).getName());
                if(pokeCards.get(i).getName().equals(query)){
                    Log.d(TAG, "find " + pokeCards.get(i).getName());
                    pokeCardsFiltered.add(pokeCards.get(i));
                }
            }

            // réduire la liste
            Log.d(TAG, "count filtered " + pokeCardsFiltered.size());
            if(pokeCardsFiltered.size() != 0){
                pokeCards.clear();
                Log.d(TAG, "into the filtered " + pokeCards.size());

                pokeCards.addAll(pokeCardsFiltered);
                pokeListRecyclerViewAdapter.notifyDataSetChanged();
                pokeCardsFiltered.clear();
            }else{
                pokeCards.clear();
            }




        }
        super.onNewIntent(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ajout toolbar
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));



        for (int i = 0; i <= 100; i++) {
            addAttack("fulguro poing" + i);
            addPokeCard("test" + i, "0000"+i, "Pokemon", "100", pokeCardAttack);
        }

        pokeCardsOriginal.addAll(pokeCards);

        pokeListRecyclerViewAdapter = new PokeListRecyclerViewAdapter(pokeCards, this);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(pokeListRecyclerViewAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleCount = gridLayoutManager.getChildCount();
                int firstVisibleItemPoistion = gridLayoutManager.findFirstVisibleItemPosition();
                int totalItemCount = gridLayoutManager.getItemCount();

                if( (visibleCount + firstVisibleItemPoistion) >= totalItemCount && !isSearching){
                    Log.d(TAG, "endless");
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
