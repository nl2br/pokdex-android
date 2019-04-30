package fr.mds.pokedex.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.mds.pokedex.R;
import fr.mds.pokedex.viewHolder.PokeListViewHolder;
import fr.mds.pokedex.model.PokeCard;

public class PokeListRecyclerViewAdapter extends RecyclerView.Adapter<PokeListViewHolder> {

    private ArrayList<PokeCard> pokeCards;
    //private View.OnClickListener onClickListener;
    public static final String TAG = "pokedex";

    public PokeListRecyclerViewAdapter(ArrayList<PokeCard> pokeCards){
        this.pokeCards = pokeCards;
    }

    @Override
    public void onBindViewHolder(@NonNull final PokeListViewHolder holder,final int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "item clicked " + pokeCards.get(holder.getAdapterPosition()).getName());
               // onClickListener.onClick(v);
            }
        });
    }

    @NonNull
    @Override
    public PokeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        PokeListViewHolder pokeListViewHolder = new PokeListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false));
        return pokeListViewHolder;
    }

//    public void setOnClickListener(View.OnClickListener onClickListener){
//        Log.d(TAG, "click " + onClickListener);
//        this.onClickListener = onClickListener;
//    }

    @Override
    public void onBindViewHolder(@NonNull PokeListViewHolder holder, int position) {
        PokeCard currentPokeCard = pokeCards.get(position);
        holder.getCardViewInfoText().setText(currentPokeCard.getName());
    }

    @Override
    public int getItemCount() {
        return pokeCards.size();
    }



}
