package fr.mds.pokedex.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import fr.mds.pokedex.R;
import fr.mds.pokedex.model.PokeCard;

public class DetailPokeCardActivity extends Activity {

    public static final String TAG = "pokedex";

    private PokeCard currentCard;

    protected TextView tv_card_name;
    protected TextView tv_card_id;
    protected TextView tv_card_type;
    protected TextView tv_card_hp;
    protected Button bt_more_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Details" );
        setContentView(R.layout.detail_card_view);

        tv_card_name = findViewById(R.id.tv_card_name);
        tv_card_id = findViewById(R.id.tv_card_id);
        tv_card_type = findViewById(R.id.tv_card_type);
        tv_card_hp = findViewById(R.id.tv_card_hp);
        bt_more_detail = findViewById(R.id.bt_more_detail);

        bt_more_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "item clicked " + currentCard.getName());
                // explicit car on spécifie quelle classe utliser
                Intent intent = new Intent(DetailPokeCardActivity.this, MoreDetailPokeCardActivity.class);
                intent.putExtra("pokeCard", currentCard);
                //startActivity(intent);
                startActivityForResult(intent,0);
            }
        });

        // recuperer les datas envoyées
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            Integer position = null;
            position = extras.getInt("position");
            Log.d(TAG, "Position: " + position );

            PokeCard pokeCard = (PokeCard) extras.getSerializable("pokeCard");
            Log.d(TAG, "current pokeCard: " + pokeCard);

            currentCard = pokeCard;

            tv_card_name.setText(pokeCard.getName());
            tv_card_id.setText(pokeCard.getId());
            tv_card_type.setText(pokeCard.getTypes().toString());
            tv_card_hp.setText(pokeCard.getHp());
        }
    }
}
