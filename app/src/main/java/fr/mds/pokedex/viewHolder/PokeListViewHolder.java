package fr.mds.pokedex.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fr.mds.pokedex.R;

public class PokeListViewHolder extends RecyclerView.ViewHolder {

    private TextView cv_poke_card_info_text;

    public PokeListViewHolder(View itemView) {
        super(itemView);
        this.cv_poke_card_info_text = itemView.findViewById(R.id.cv_poke_card_info_text);
    }

    public TextView getCardViewInfoText(){
        return this.cv_poke_card_info_text;
    }


}
