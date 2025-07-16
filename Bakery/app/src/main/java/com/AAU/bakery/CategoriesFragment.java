package com.AAU.bakery;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class CategoriesFragment extends Fragment {
   ImageView cd_cupcake,cd_birthday,cd_wedding,cd_enagement,cd_baby_shower;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_categories, container, false);
        cd_cupcake=view.findViewById(R.id.img_cupcakes);
        cd_birthday=view.findViewById(R.id.img_birthday);
        cd_wedding=view.findViewById(R.id.img_wedding);
        cd_enagement=view.findViewById(R.id.img_engagement);
        cd_baby_shower=view.findViewById(R.id.img_baby_shower);

        cd_cupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getActivity(), CupCakeActivity.class);
                startActivity(i);
            }
        });
        cd_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getActivity(), BirthdayActivity.class);
                startActivity(i);
            }
        });
        cd_wedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getActivity(), WeddingActivity.class);
                startActivity(i);
            }
        });
        cd_enagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getActivity(), EngagementActivity.class);
                startActivity(i);
            }
        });
        cd_baby_shower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getActivity(), BabyShowerActivity.class);
                startActivity(i);
            }
        });
    return view;
    }
}