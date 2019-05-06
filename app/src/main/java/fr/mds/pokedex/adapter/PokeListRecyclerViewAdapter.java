package fr.mds.pokedex.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import fr.mds.pokedex.R;
import fr.mds.pokedex.activity.DetailPokeCardActivity;
import fr.mds.pokedex.activity.MainActivity;
import fr.mds.pokedex.viewHolder.PokeListViewHolder;
import fr.mds.pokedex.model.PokeCard;

public class PokeListRecyclerViewAdapter extends RecyclerView.Adapter<PokeListViewHolder> {

    private ArrayList<PokeCard> pokeCards;
    //private View.OnClickListener onClickListener;
    public static final String TAG = "pokedex";
    private Activity currentActivity;

    public PokeListRecyclerViewAdapter(ArrayList<PokeCard> pokeCards, Activity currentActivity){
        this.pokeCards = pokeCards;
        this.currentActivity = currentActivity;
    }

    @Override
    public void onBindViewHolder(@NonNull final PokeListViewHolder holder,final int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            Log.d(TAG, "item clicked " + pokeCards.get(holder.getAdapterPosition()).getName());
            // onClickListener.onClick(v);
            // explicit car on spécifie quelle classe utliser
            Intent intent = new Intent(currentActivity, DetailPokeCardActivity.class);
            Log.d(TAG, "onClick " + holder.getAdapterPosition());
            intent.putExtra("position",holder.getAdapterPosition());
            intent.putExtra("pokeCard", pokeCards.get(holder.getAdapterPosition()));
            //startActivity(intent);
            currentActivity.startActivityForResult(intent,0);
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
        Picasso.get().load(currentPokeCard.getImageUrl()).into(holder.getIw_img_card());
    }

    @Override
    public int getItemCount() {
        return pokeCards.size();
    }



}
