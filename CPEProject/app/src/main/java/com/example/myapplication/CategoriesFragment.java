package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class CategoriesFragment extends Fragment {
    CardView ayurveda,drink,wellness,sport,fitness,medicine;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_categories, container, false);

        ayurveda=view.findViewById(R.id.ayurvedaHerbsCard);
        drink=view.findViewById(R.id.drinkCard);
        wellness=view.findViewById(R.id.wellnessCard);
        sport=view.findViewById(R.id.sportCard);
        fitness=view.findViewById(R.id.fitnessCard);
        medicine=view.findViewById(R.id.medicineCard);


        ayurveda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Ayurveda.class);
                startActivity(intent);

            }
        });

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Drinks.class);
                startActivity(intent);
            }
        });

        wellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WellnessCat.class);
                startActivity(intent);

            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SportNutrition.class);
                startActivity(intent);
            }
        });

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),FitnessCat.class);
                startActivity(intent);

            }
        });

        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MedicineCat.class);
                startActivity(intent);
            }
        });

        return view;


    }
}