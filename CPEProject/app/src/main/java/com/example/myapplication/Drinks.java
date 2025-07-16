package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Drinks extends AppCompatActivity {

    Button buy_1,buy_2,buy_3,buy_4,buy_5;
    Button btndescription1,btndescription2, btndescription3,btndescription4,btndescription5;

    TextView textview_name1;
    TextView textview_name2;
    TextView textview_name3;
    TextView textview_name4;
    TextView textview_name5;

    TextView textview_description1;
    TextView textview_description2;
    TextView textview_description3;
    TextView textview_description4;
    TextView textview_description5;

    TextView textview_price1;
    TextView textview_price2;
    TextView textview_price3;
    TextView textview_price4;
    TextView textview_price5;
    Button add_to_cart1, add_to_cart2, add_to_cart3, add_to_cart4, add_to_cart5;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);


        buy_1=findViewById(R.id.dbuy_1);
        buy_2=findViewById(R.id.dbuy_2);

        buy_3=findViewById(R.id.dbuy_3);

        buy_4=findViewById(R.id.dbuy_4);

        buy_5=findViewById(R.id.dbuy_5);

        btndescription1 = findViewById(R.id.dproduct_1);
        btndescription2 = findViewById(R.id.dproduct_2);
        btndescription3 = findViewById(R.id.dproduct_3);
        btndescription4 = findViewById(R.id.dproduct_4);
        btndescription5 = findViewById(R.id.dproduct_5);

        textview_name1=findViewById(R.id.ditemname1);
        textview_name2=findViewById(R.id.ditemname2);
        textview_name3=findViewById(R.id.ditemname3);
        textview_name4=findViewById(R.id.ditemname4);
        textview_name5=findViewById(R.id.ditemname5);

        textview_description1=findViewById(R.id.p1);
        textview_description2=findViewById(R.id.p2);
        textview_description3=findViewById(R.id.p3);
        textview_description4=findViewById(R.id.p4);
        textview_description5=findViewById(R.id.p5);

        textview_price1=findViewById(R.id.price1);
        textview_price2=findViewById(R.id.price2);
        textview_price3=findViewById(R.id.price3);
        textview_price4=findViewById(R.id.price4);
        textview_price5=findViewById(R.id.price5);



        add_to_cart1=findViewById(R.id.dadd_1);
        add_to_cart2=findViewById(R.id.dadd_2);
        add_to_cart3=findViewById(R.id.dadd_3);
        add_to_cart4=findViewById(R.id.dadd_4);
        add_to_cart5=findViewById(R.id.dadd_5);


        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();

        buy_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buy_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buy_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buy_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buy_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btndescription1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, XLR_Isonotic_Drink.class);
                startActivity(intent);

            }
        });
        btndescription2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, Redbull.class);
                startActivity(intent);

            }
        });
        btndescription3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, Herbalife_Energy_Drink.class);
                startActivity(intent);

            }
        });
        btndescription4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, XLR_isotonic_2.class);
                startActivity(intent);

            }
        });
        btndescription5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Drinks.this, Nutriorg_Amla_Juice.class);
                startActivity(intent);

            }
        });






        /////////////




        add_to_cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Drinks.this,AddToCart.class);
                startActivity(i);
//                 String str_name = preferences.getString("name1","");
//                 String str_product_details = preferences.getString("product_name1","");
//                 String str_price = preferences.getString("price1","");

                editor.putString("dr_name1",textview_name1.getText().toString()).commit();
                editor.putString("dr_product_name1",textview_description1.getText().toString()).commit();
                editor.putString("dr_price1",textview_price1.getText().toString()).commit();

            }
        });

        add_to_cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Drinks.this,AddToCart.class);
                startActivity(i);
//                 String str_name = preferences.getString("name1","");
//                 String str_product_details = preferences.getString("product_name1","");
//                 String str_price = preferences.getString("price1","");

                editor.putString("dr_name1",textview_name1.getText().toString()).commit();
                editor.putString("dr_product_name1",textview_description1.getText().toString()).commit();
                editor.putString("dr_price1",textview_price1.getText().toString()).commit();

            }
        });

        add_to_cart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Drinks.this,AddToCart.class);
                startActivity(i);
//                String str_name = preferences.getString("name2","");
//                String str_product_details = preferences.getString("product_name2","");
//                String str_price = preferences.getString("price2","");

                editor.putString("dr_name2",textview_name2.getText().toString()).commit();
                editor.putString("dr_product_name2",textview_description2.getText().toString()).commit();
                editor.putString("dr_price2",textview_price2.getText().toString()).commit();

            }
        });

        add_to_cart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Drinks.this,AddToCart.class);
                startActivity(i);
//                String str_name = preferences.getString("name3","");
//                String str_product_details = preferences.getString("product_name3","");
//                String str_price = preferences.getString("price3","");

                editor.putString("dr_name3",textview_name3.getText().toString()).commit();
                editor.putString("dr_product_name3",textview_description3.getText().toString()).commit();
                editor.putString("dr_price3",textview_price3.getText().toString()).commit();

            }
        });

        add_to_cart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Drinks.this,AddToCart.class);
                startActivity(i);
//                String str_name = preferences.getString("name4","");
//                String str_product_details = preferences.getString("product_name4","");
//                String str_price = preferences.getString("price4","");

                editor.putString("dr_name4",textview_name4.getText().toString()).commit();
                editor.putString("dr_product_name4",textview_description4.getText().toString()).commit();
                editor.putString("dr_price4",textview_price4.getText().toString()).commit();

            }
        });

        add_to_cart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Drinks.this,AddToCart.class);
                startActivity(i);
//                String str_name = preferences.getString("name5","");
//                String str_product_details = preferences.getString("product_name5","");
//                String str_price = preferences.getString("price5","");

                editor.putString("dr_name5",textview_name5.getText().toString()).commit();
                editor.putString("dr_product_name5",textview_description5.getText().toString()).commit();
                editor.putString("dr_price5",textview_price5.getText().toString()).commit();

            }
        });


    }
}