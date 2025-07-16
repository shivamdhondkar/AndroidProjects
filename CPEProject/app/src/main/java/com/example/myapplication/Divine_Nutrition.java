package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Divine_Nutrition extends AppCompatActivity {
    Button buy_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divine_nutrition);

        buy_now=findViewById(R.id.wellcarebtn);

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Divine_Nutrition.this,Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}