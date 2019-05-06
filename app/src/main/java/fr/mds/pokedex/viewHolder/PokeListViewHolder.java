package fr.mds.pokedex.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import fr.mds.pokedex.R;

public class PokeListViewHolder extends RecyclerView.ViewHolder {

    private TextView cv_poke_card_info_text;
    private ImageView iw_img_card;

    public PokeListViewHolder(View itemView) {
        super(itemView);
        this.cv_poke_card_info_text = itemView.findViewById(R.id.cv_poke_card_info_text);
        this.iw_img_card = itemView.findViewById(R.id.iw_img_card);
    }

    public ImageView getIw_img_card() {
        return iw_img_card;
    }

    public TextView getCardViewInfoText(){
        return this.cv_poke_card_info_text;
    }


}
