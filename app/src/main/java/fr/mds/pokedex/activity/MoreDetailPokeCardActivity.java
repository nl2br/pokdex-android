package fr.mds.pokedex.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import fr.mds.pokedex.R;
import fr.mds.pokedex.model.Attack;
import fr.mds.pokedex.model.PokeCard;

public class MoreDetailPokeCardActivity extends Activity {

    public static final String TAG = "pokedex";

    protected TextView tv_card_name;
    protected TextView tv_card_id;
    protected TextView tv_card_type;
    protected TextView tv_card_hp;
    protected LinearLayout ll_more_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.more_detail_card_view);

        tv_card_name = findViewById(R.id.tv_card_name);
        tv_card_id = findViewById(R.id.tv_card_id);
        tv_card_type = findViewById(R.id.tv_card_type);
        tv_card_hp = findViewById(R.id.tv_card_hp);
        ll_more_detail = findViewById(R.id.ll_more_detail);

        // recuperer les datas envoyées
        Bundle extras = getIntent().getExtras();
        if(extras != null) {

            PokeCard pokeCard = (PokeCard) extras.getSerializable("pokeCard");
            Log.d(TAG, "pokeCard: " + pokeCard);

            tv_card_name.setText(pokeCard.getName());
            tv_card_id.setText(pokeCard.getId());
            tv_card_type.setText(pokeCard.getTypes().toString());
            tv_card_hp.setText(pokeCard.getHp());

            TextView tv_attack = new TextView(this);
            tv_attack.setText("LIST ATTACKS :");
            tv_attack.setTextSize(22);
            tv_attack.setPadding(20, 30, 20, 20);
            ll_more_detail.addView(tv_attack);
            // TODO https://www.android-examples.com/android-create-textview-programmatically-example/
            for (Attack attack : pokeCard.getAttacks()) {
                TextView tv = new TextView(this);
                tv.setText(attack.getAttack());
                tv.setTextSize(15);
                tv.setPadding(20, 30, 20, 20);

                ll_more_detail.addView(tv);
            }
        }
    }
}
