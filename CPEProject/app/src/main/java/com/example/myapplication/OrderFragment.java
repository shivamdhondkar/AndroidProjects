package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class OrderFragment extends Fragment{

   // ImageView img;
    TextView tv_name,tv_product,tv_price;
    Button order;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.fragment_order, container, false);

        preferences= PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor=preferences.edit();
        order=view.findViewById(R.id.dadd_1);
        tv_name=view.findViewById(R.id.item_name1);
        tv_product=view.findViewById(R.id.product_details1);
        tv_price=view.findViewById(R.id.price1);
        //img=view.findViewById(R.id.image);

//        tv_name.setText(preferences.getString("name1",""));
//        tv_product.setText(preferences.getString("product_name1",""));
//        tv_price.setText(preferences.getString("price1",""));



        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Orders.class);
                startActivity(intent);

            }
        });

        return view;
    }


}


