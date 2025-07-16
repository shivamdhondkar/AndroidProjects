package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SportNutrition extends AppCompatActivity {

    Button btndescription1,btndescription2, btndescription3,btndescription4,btndescription5;
    TextView rating,description,price;
    ImageView detailImage;

    TextView name1,name2,name3,name4,name5;
    TextView price1,price2,price3,price4,price5;
    TextView dect1,dect2,dect3,dect4,dect5;
    Button buyNow1,buyNow2,buyNow3,buyNow4,buyNow5;
    Button addToCart1,addToCart2,addToCart3,addToCart4,addToCart5;

    SharedPreferences preference1;
    SharedPreferences.Editor editor1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_nutrition);

        addToCart1 = findViewById(R.id.sadd_1);
        addToCart2 = findViewById(R.id.sadd_2);
        addToCart3 = findViewById(R.id.sadd_3);
        addToCart4 = findViewById(R.id.sadd_4);
        addToCart5 = findViewById(R.id.sadd_5);

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

        name1 = findViewById(R.id.itemname1);
        name2 = findViewById(R.id.itemname2);
        name3 = findViewById(R.id.itemname3);
        name4 = findViewById(R.id.itemname4);
        name5 = findViewById(R.id.item_name5);

        price1 = findViewById(R.id.sprice1);
        price2 = findViewById(R.id.sprice2);
        price3 = findViewById(R.id.sprice3);
        price4 = findViewById(R.id.sprice4);
        price5 = findViewById(R.id.sprice5);

        dect1 = findViewById(R.id.sdescription1);
        dect2 = findViewById(R.id.sdescription2);
        dect3 = findViewById(R.id.sdescription3);
        dect4 = findViewById(R.id.sdescription4);
        dect5 = findViewById(R.id.sdescription5);

        preference1 = PreferenceManager.getDefaultSharedPreferences(this);
        editor1= preference1.edit();

        btndescription1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, MuscleBlazeDetails.class);
                startActivity(intent);

            }
        });

//        buyNow1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(SportNutrition.this,OrderFragment.class);
//                startActivity(i);
//
//                editor1.putString("name11",name1.getText().toString()).commit();
//                editor1.putString("product_name11",dect1.getText().toString()).commit();
//                editor1.putString("price11",price1.getText().toString()).commit();
//
//            }
//        });

        buyNow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buyNow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buyNow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buyNow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buyNow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });



        btndescription2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, WheyProtein.class);
                startActivity(intent);

            }
        });

        btndescription3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, WellcareCreatine.class);
                startActivity(intent);

            }
        });

        btndescription4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, AsitisSoyProtein.class);
                startActivity(intent);

            }
        });

        btndescription5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportNutrition.this, SoyFishOil.class);
                startActivity(intent);

            }
        });




    }

}