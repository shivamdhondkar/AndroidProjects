package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

public class CupCakeActivity extends AppCompatActivity {
    ImageView img_cup_chocolate,img_cup_vanilla,img_cup_pineapple;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cup_cake);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();
        img_cup_chocolate=findViewById(R.id.img_chocolate_cupcake);
        img_cup_vanilla=findViewById(R.id.img_vanilla_cupcake);
        img_cup_pineapple=findViewById(R.id.img_pineapple_cupcake);
        img_cup_chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(CupCakeActivity.this, OrderActivity.class);
               editor.putString("Chocolate","Cupcake");
                startActivity(i);
            }
        });
        img_cup_vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(CupCakeActivity.this, OrderActivity.class);
                editor.putString("Vanilla","Cupcake");
                startActivity(i);
            }
        });
        img_cup_pineapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(CupCakeActivity.this, OrderActivity.class);
                editor.putString("Pineapple","Cupcake");
                startActivity(i);
            }
        });
    }
}