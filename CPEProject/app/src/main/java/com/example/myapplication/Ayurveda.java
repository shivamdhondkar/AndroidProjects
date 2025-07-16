package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ayurveda extends AppCompatActivity {

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

    Button buy_1,buy_2,buy_3,buy_4,buy_5;

    Button description1,description2,description3,description4,description5;
    Button add_to_cart1, add_to_cart2, add_to_cart3, add_to_cart4, add_to_cart5;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayurveda);

        textview_name1=findViewById(R.id.aitemname1);
        textview_name2=findViewById(R.id.aitemname2);
        textview_name3=findViewById(R.id.aitemname3);
        textview_name4=findViewById(R.id.aitemname4);
        textview_name5=findViewById(R.id.aitemname5);

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

        description1 = findViewById(R.id.aproduct_1);
        description2 = findViewById(R.id.aproduct_2);
        description3 = findViewById(R.id.aproduct_3);
        description4 = findViewById(R.id.aproduct_4);
        description5 = findViewById(R.id.aproduct_5);

        add_to_cart1=findViewById(R.id.aadd_1);
        add_to_cart2=findViewById(R.id.aadd_2);
        add_to_cart3=findViewById(R.id.aadd_3);
        add_to_cart4=findViewById(R.id.aadd_4);
        add_to_cart5=findViewById(R.id.aadd_5);


        buy_1=findViewById(R.id.abuy_1);
        buy_2=findViewById(R.id.abuy_2);

        buy_3=findViewById(R.id.abuy_3);

        buy_4=findViewById(R.id.abuy_4);

        buy_5=findViewById(R.id.abuy_5);





        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();

        description1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, AyurvedicHairOil.class);
                startActivity(intent);

            }
        });

        buy_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buy_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buy_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buy_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buy_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });

        add_to_cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ayurveda.this,AddToCart.class);
                startActivity(i);
//                 String str_name = preferences.getString("name1","");
//                 String str_product_details = preferences.getString("product_name1","");
//                 String str_price = preferences.getString("price1","");

                 editor.putString("name1",textview_name1.getText().toString()).commit();
                 editor.putString("product_name1",textview_description1.getText().toString()).commit();
                 editor.putString("price1",textview_price1.getText().toString()).commit();

            }
        });

        description2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, AyurK3Juice.class);
                startActivity(intent);


            }
        });
        add_to_cart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ayurveda.this,AddToCart.class);
                startActivity(i);
//                String str_name = preferences.getString("name2","");
//                String str_product_details = preferences.getString("product_name2","");
//                String str_price = preferences.getString("price2","");

                editor.putString("name2",textview_name2.getText().toString()).commit();
                editor.putString("product_name2",textview_description2.getText().toString()).commit();
                editor.putString("price2",textview_price2.getText().toString()).commit();

            }
        });

        description3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, HarbalHairOil.class);
                startActivity(intent);

            }
        });

        add_to_cart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ayurveda.this,AddToCart.class);
                startActivity(i);
//                String str_name = preferences.getString("name3","");
//                String str_product_details = preferences.getString("product_name3","");
//                String str_price = preferences.getString("price3","");

                editor.putString("name3",textview_name3.getText().toString()).commit();
                editor.putString("product_name3",textview_description3.getText().toString()).commit();
                editor.putString("price3",textview_price3.getText().toString()).commit();

            }
  });

        description4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, Herbal20Plant.class);
                startActivity(intent);

            }
        });

        add_to_cart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ayurveda.this,AddToCart.class);
                startActivity(i);
//                String str_name = preferences.getString("name4","");
//                String str_product_details = preferences.getString("product_name4","");
//                String str_price = preferences.getString("price4","");

                editor.putString("name4",textview_name4.getText().toString()).commit();
                editor.putString("product_name4",textview_description4.getText().toString()).commit();
                editor.putString("price4",textview_price4.getText().toString()).commit();

            }
        });

        description5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ayurveda.this, kalmegh.class);
                startActivity(intent);

            }
        });

        add_to_cart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ayurveda.this,AddToCart.class);
                startActivity(i);
//                String str_name = preferences.getString("name5","");
//                String str_product_details = preferences.getString("product_name5","");
//                String str_price = preferences.getString("price5","");

                editor.putString("name5",textview_name5.getText().toString()).commit();
                editor.putString("product_name5",textview_description5.getText().toString()).commit();
                editor.putString("price5",textview_price5.getText().toString()).commit();

            }
        });

    }
}