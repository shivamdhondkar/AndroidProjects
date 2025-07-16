package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MedicineCat extends AppCompatActivity {
    Button buyNow1,buyNow2,buyNow3,buyNow4,buyNow5;
    Button btndescription1,btndescription2, btndescription3,btndescription4,btndescription5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_cat);

        buyNow1 = findViewById(R.id.sbuy_1);
        buyNow2 = findViewById(R.id.sbuy_2);
        buyNow3 = findViewById(R.id.sbuy_3);
        buyNow4 = findViewById(R.id.sbuy_4);
        buyNow5 = findViewById(R.id.sbuy_5);

        btndescription1 = findViewById(R.id.sproduct_1);
        btndescription2 = findViewById(R.id.sproduct_2);
        btndescription3 = findViewById(R.id.sproduct_3);
        btndescription4 = findViewById(R.id.sproduct_4);
        btndescription5 = findViewById(R.id.sproduct_5);



        buyNow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buyNow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buyNow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buyNow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buyNow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btndescription1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Aminorich_Tablet.class);
                startActivity(intent);

            }
        });

        btndescription2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Acrotac_Capsule.class);
                startActivity(intent);

            }
        });

        btndescription3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Cough_Syurup.class);
                startActivity(intent);

            }
        });

        btndescription4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Luco_Line_Tablet.class);
                startActivity(intent);

            }
        });
        btndescription5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicineCat.this, Solvin_Cough_Tablet.class);
                startActivity(intent);

            }
        });
    }
}