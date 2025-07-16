package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VitalFIshOilHM extends AppCompatActivity {

    Button buy;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_fish_oil_hm);

        buy=findViewById(R.id.wellcarebtn);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VitalFIshOilHM.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}