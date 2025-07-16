package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddToCart extends AppCompatActivity {

    //ImageView img;
    TextView tv_name1,tv_product1,tv_price1,tv_name2,tv_product2,tv_price2,tv_name3,tv_product3,tv_price3,tv_name4,tv_product4,tv_price4,tv_name5,tv_product5,tv_price5;

    TextView dr_tv_name1,dr_tv_product1,dr_tv_price1,dr_tv_name2,dr_tv_product2,dr_tv_price2,dr_tv_name3,dr_tv_product3,dr_tv_price3,dr_tv_name4,dr_tv_product4,dr_tv_price4,dr_tv_name5,dr_tv_product5,dr_tv_price5;

    TextView wl_tv_name1,wl_tv_product1,wl_tv_price1,wl_tv_name2,wl_tv_product2,wl_tv_price2,wl_tv_name3,wl_tv_product3,wl_tv_price3,wl_tv_name4,wl_tv_product4,wl_tv_price4,wl_tv_name5,wl_tv_product5,wl_tv_price5;

    TextView ft_tv_name1,ft_tv_product1,ft_tv_price1,ft_tv_name2,ft_tv_product2,ft_tv_price2,ft_tv_name3,ft_tv_product3,ft_tv_price3,ft_tv_name4,ft_tv_product4,ft_tv_price4,ft_tv_name5,ft_tv_product5,ft_tv_price5;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_to_cart);

        setTitle("Add To Cart");

        preferences= PreferenceManager.getDefaultSharedPreferences(AddToCart.this);
        editor=preferences.edit();

        tv_name1=findViewById(R.id.item_name1);
        tv_product1=findViewById(R.id.product_details1);
        tv_price1=findViewById(R.id.price1);
       // img=findViewById(R.id.image);

        tv_name1.setText(preferences.getString("name1",""));
        tv_product1.setText(preferences.getString("product_name1",""));
        tv_price1.setText(preferences.getString("price1",""));

        tv_name2=findViewById(R.id.item_name2);
        tv_product2=findViewById(R.id.product_details2);
        tv_price2=findViewById(R.id.price2);
        // img=findViewById(R.id.image);

        tv_name2.setText(preferences.getString("name2",""));
        tv_product2.setText(preferences.getString("product_name2",""));
        tv_price2.setText(preferences.getString("price2",""));

        tv_name3=findViewById(R.id.item_name3);
        tv_product3=findViewById(R.id.product_details3);
        tv_price3=findViewById(R.id.price3);
        // img=findViewById(R.id.image);

        tv_name3.setText(preferences.getString("name3",""));
        tv_product3.setText(preferences.getString("product_name3",""));
        tv_price3.setText(preferences.getString("price3",""));

        tv_name4=findViewById(R.id.item_name4);
        tv_product4=findViewById(R.id.product_details4);
        tv_price4=findViewById(R.id.price4);
        // img=findViewById(R.id.image);

        tv_name4.setText(preferences.getString("name4",""));
        tv_product4.setText(preferences.getString("product_name4",""));
        tv_price4.setText(preferences.getString("price4",""));

        tv_name5=findViewById(R.id.item_name5);
        tv_product5=findViewById(R.id.product_details5);
        tv_price5=findViewById(R.id.price5);
        // img=findViewById(R.id.image);

        tv_name5.setText(preferences.getString("name5",""));
        tv_product5.setText(preferences.getString("product_name5",""));
        tv_price5.setText(preferences.getString("price5",""));



        ///////////////////////




        dr_tv_name1=findViewById(R.id.dr_item_name1);
        dr_tv_product1=findViewById(R.id.dr_product_details1);
        dr_tv_price1=findViewById(R.id.dr_price1);
        // img=findViewById(R.id.image);

        dr_tv_name1.setText(preferences.getString("dr_name1",""));
        dr_tv_product1.setText(preferences.getString("dr_product_name1",""));
        dr_tv_price1.setText(preferences.getString("dr_price1",""));

        dr_tv_name2=findViewById(R.id.dr_item_name2);
        dr_tv_product2=findViewById(R.id.dr_product_details2);
        dr_tv_price2=findViewById(R.id.dr_price2);
        // img=findViewById(R.id.image);

        dr_tv_name2.setText(preferences.getString("dr_name2",""));
        dr_tv_product2.setText(preferences.getString("dr_product_name2",""));
        dr_tv_price2.setText(preferences.getString("dr_price2",""));

        dr_tv_name3=findViewById(R.id.dr_item_name3);
        dr_tv_product3=findViewById(R.id.dr_product_details3);
        dr_tv_price3=findViewById(R.id.dr_price3);
        // img=findViewById(R.id.image);

        dr_tv_name3.setText(preferences.getString("dr_name3",""));
        dr_tv_product3.setText(preferences.getString("dr_product_name3",""));
        dr_tv_price3.setText(preferences.getString("dr_price3",""));

        dr_tv_name4=findViewById(R.id.dr_item_name4);
        dr_tv_product4=findViewById(R.id.dr_product_details4);
        dr_tv_price4=findViewById(R.id.dr_price4);
        // img=findViewById(R.id.image);

        dr_tv_name4.setText(preferences.getString("dr_name4",""));
        dr_tv_product4.setText(preferences.getString("dr_product_name4",""));
        dr_tv_price4.setText(preferences.getString("dr_price4",""));

        dr_tv_name5=findViewById(R.id.dr_item_name5);
        dr_tv_product5=findViewById(R.id.dr_product_details5);
        dr_tv_price5=findViewById(R.id.dr_price5);
        // img=findViewById(R.id.image);

        dr_tv_name5.setText(preferences.getString("dr_name5",""));
        dr_tv_product5.setText(preferences.getString("dr_product_name5",""));
        dr_tv_price5.setText(preferences.getString("dr_price5",""));


        ////////////////////////////




        wl_tv_name1=findViewById(R.id.wl_item_name1);
        wl_tv_product1=findViewById(R.id.wl_product_details1);
        wl_tv_price1=findViewById(R.id.wl_price1);
        // img=findViewById(R.id.image);

        wl_tv_name1.setText(preferences.getString("wl_name1",""));
        wl_tv_product1.setText(preferences.getString("wl_product_name1",""));
        wl_tv_price1.setText(preferences.getString("wl_price1",""));

        wl_tv_name2=findViewById(R.id.wl_item_name2);
        wl_tv_product2=findViewById(R.id.wl_product_details2);
        wl_tv_price2=findViewById(R.id.wl_price2);
        // img=findViewById(R.id.image);

        wl_tv_name2.setText(preferences.getString("wl_name2",""));
        wl_tv_product2.setText(preferences.getString("wl_product_name2",""));
        wl_tv_price2.setText(preferences.getString("wl_price2",""));

        wl_tv_name3=findViewById(R.id.wl_item_name3);
        wl_tv_product3=findViewById(R.id.wl_product_details3);
        wl_tv_price3=findViewById(R.id.wl_price3);
        // img=findViewById(R.id.image);

        wl_tv_name3.setText(preferences.getString("wl_name3",""));
        wl_tv_product3.setText(preferences.getString("wl_product_name3",""));
        wl_tv_price3.setText(preferences.getString("wl_price3",""));

        wl_tv_name4=findViewById(R.id.wl_item_name4);
        wl_tv_product4=findViewById(R.id.wl_product_details4);
        wl_tv_price4=findViewById(R.id.wl_price4);
        // img=findViewById(R.id.image);

        wl_tv_name4.setText(preferences.getString("wl_name4",""));
        wl_tv_product4.setText(preferences.getString("wl_product_name4",""));
        wl_tv_price4.setText(preferences.getString("wl_price4",""));

        wl_tv_name5=findViewById(R.id.wl_item_name5);
        wl_tv_product5=findViewById(R.id.wl_product_details5);
        wl_tv_price5=findViewById(R.id.wl_price5);
        // img=findViewById(R.id.image);

        wl_tv_name5.setText(preferences.getString("wl_name5",""));
        wl_tv_product5.setText(preferences.getString("wl_product_name5",""));
        wl_tv_price5.setText(preferences.getString("wl_price5",""));

        /////////////////////////////

        ft_tv_name1=findViewById(R.id.ft_item_name1);
        ft_tv_product1=findViewById(R.id.ft_product_details1);
        ft_tv_price1=findViewById(R.id.ft_price1);
        // img=findViewById(R.id.image);

        ft_tv_name1.setText(preferences.getString("ft_name1",""));
        ft_tv_product1.setText(preferences.getString("ft_product_name1",""));
        ft_tv_price1.setText(preferences.getString("ft_price1",""));

        ft_tv_name2=findViewById(R.id.ft_item_name2);
        ft_tv_product2=findViewById(R.id.ft_product_details2);
        ft_tv_price2=findViewById(R.id.ft_price2);
        // img=findViewById(R.id.image);

        ft_tv_name2.setText(preferences.getString("ft_name2",""));
        ft_tv_product2.setText(preferences.getString("ft_product_name2",""));
        ft_tv_price2.setText(preferences.getString("ft_price2",""));

        ft_tv_name3=findViewById(R.id.ft_item_name3);
        ft_tv_product3=findViewById(R.id.ft_product_details3);
        ft_tv_price3=findViewById(R.id.ft_price3);
        // img=findViewById(R.id.image);

        ft_tv_name3.setText(preferences.getString("ft_name3",""));
        ft_tv_product3.setText(preferences.getString("ft_product_name3",""));
        ft_tv_price3.setText(preferences.getString("ft_price3",""));

        ft_tv_name4=findViewById(R.id.ft_item_name4);
        ft_tv_product4=findViewById(R.id.ft_product_details4);
        ft_tv_price4=findViewById(R.id.ft_price4);
        // img=findViewById(R.id.image);

        ft_tv_name4.setText(preferences.getString("ft_name4",""));
        ft_tv_product4.setText(preferences.getString("ft_product_name4",""));
        ft_tv_price4.setText(preferences.getString("ft_price4",""));

        ft_tv_name5=findViewById(R.id.ft_item_name5);
        ft_tv_product5=findViewById(R.id.ft_product_details5);
        ft_tv_price5=findViewById(R.id.ft_price5);
        // img=findViewById(R.id.image);

        ft_tv_name5.setText(preferences.getString("ft_name5",""));
        ft_tv_product5.setText(preferences.getString("ft_product_name5",""));
        ft_tv_price5.setText(preferences.getString("ft_price5",""));
    }
}
