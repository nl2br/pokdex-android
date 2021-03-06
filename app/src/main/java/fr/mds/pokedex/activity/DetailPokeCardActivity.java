package fr.mds.pokedex.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.mds.pokedex.R;
import fr.mds.pokedex.model.Attack;
import fr.mds.pokedex.model.PokeCard;

public class DetailPokeCardActivity extends Activity {

    public static final String TAG = "pokedex";

    private PokeCard currentCard;

    protected TextView tv_card_name;
    protected TextView tv_card_id;
    protected TextView tv_card_type;
    protected TextView tv_card_hp;
    protected LinearLayout ll_more_detail;
    protected Button bt_more_detail;
    protected Button bt_no_detail;
    protected ConstraintLayout cl_detail;
    protected ImageView iv_img_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Details" );
        setContentView(R.layout.detail_card_view);

        tv_card_name = findViewById(R.id.tv_card_name);
        tv_card_id = findViewById(R.id.tv_card_id);
        tv_card_type = findViewById(R.id.tv_card_type);
        tv_card_hp = findViewById(R.id.tv_card_hp);
        iv_img_card = findViewById(R.id.iv_img_card);
        ll_more_detail = findViewById(R.id.ll_more_detail);
        bt_more_detail = findViewById(R.id.bt_more_detail);
        bt_no_detail = findViewById(R.id.bt_no_detail);
        cl_detail = findViewById(R.id.cl_detail);

        bt_more_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "more detail ");
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(DetailPokeCardActivity.this,R.layout.more_detail_card_view);
                TransitionManager.beginDelayedTransition(cl_detail);
                constraintSet.applyTo(cl_detail);
            }
        });
        bt_no_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "no detail ");
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(DetailPokeCardActivity.this,R.layout.detail_card_view);
                TransitionManager.beginDelayedTransition(cl_detail);
                constraintSet.applyTo(cl_detail);
            }
        });

        //


        // recuperer les datas envoyées
        Bundle extras = getIntent().getExtras();
        if(extras != null) {

            PokeCard pokeCard = (PokeCard) extras.getSerializable("pokeCard");
            Log.d(TAG, "pokeCard: " + pokeCard);
            Log.d(TAG, "pokeCard type size: " + pokeCard.getTypes());

            // get name
            tv_card_name.setText(pokeCard.getName());
            // get id
            tv_card_id.setText(pokeCard.getId());

            // get type
            if(pokeCard.getTypes() != null){
                if(pokeCard.getTypes().size() != 0){
                    tv_card_type.setText(pokeCard.getTypes().get(0).toString());
                }
            }else{
                tv_card_type.setText("common");
            }

            // get HP
            if(pokeCard.getHp() != null) {
                tv_card_hp.setText(pokeCard.getHp());
            }
            // get image
            Picasso.get().load(pokeCard.getImageUrl()).into(iv_img_card);

            // get attacks
            if(pokeCard.getAttacks() != null) {
                TextView tv_attack = new TextView(this);
                tv_attack.setText("LIST ATTACKS :");
                tv_attack.setTextSize(22);
                tv_attack.setPadding(20, 30, 20, 20);
                ll_more_detail.addView(tv_attack);

                for (Attack attack : pokeCard.getAttacks()) {
                    Log.d(TAG, "attack: " + attack.getAttack());
                    TextView tv = new TextView(this);
                    tv.setText(attack.getAttack());
                    tv.setTextSize(15);
                    tv.setPadding(20, 30, 20, 20);
                    ll_more_detail.addView(tv);
                }
            }
        }
    }
}
