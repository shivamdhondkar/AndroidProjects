package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BabyShowerActivity extends AppCompatActivity {
    ImageView img_baby_chocolate,img_baby_vanilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_shower);
        img_baby_chocolate=findViewById(R.id.img_chocolate_baby_cake);
        img_baby_vanilla=findViewById(R.id.img_vanilla_baby_cake);
        img_baby_chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(BabyShowerActivity.this, OrderActivity.class);
                startActivity(i);
            }
        });
        img_baby_vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(BabyShowerActivity.this, OrderActivity.class);
                startActivity(i);
            }
        });
    }
}