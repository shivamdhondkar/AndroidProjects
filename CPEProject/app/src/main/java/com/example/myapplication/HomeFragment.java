package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {

    CardView card11,card12,card13;
    CardView card21,card22,card23;
    CardView card31,card32,card33;
    CardView card41,card42,card43;
    CardView card51,card52,card53;
    CardView card61,card62,card63;

    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_home, container, false);

        btn = view.findViewById(R.id.hadbtn1);

        card11 = view.findViewById(R.id.item11);
        card12 = view.findViewById(R.id.item12);
        card13 = view.findViewById(R.id.item13);

        card21 = view.findViewById(R.id.item21);
        card22 = view.findViewById(R.id.item22);
        card23 = view.findViewById(R.id.item23);

        card31 = view.findViewById(R.id.item31);
        card32 = view.findViewById(R.id.item32);
        card33 = view.findViewById(R.id.item_33);

        card41 = view.findViewById(R.id.item41);
        card42 = view.findViewById(R.id.item42);
        card43 = view.findViewById(R.id.item43);

        card51 = view.findViewById(R.id.item51);
        card52 = view.findViewById(R.id.item52);
        card53 = view.findViewById(R.id.item53);

        card61 = view.findViewById(R.id.item61);
        card62 = view.findViewById(R.id.item62);
        card63 = view.findViewById(R.id.item63);







        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SportNutrition.class);
                startActivity(intent);
                // Inflate the layout for this fragment
            }
            });

//        card11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), MussleBlazefatHM.class);
//                startActivity(intent);
//            }
//        });
//
//        card12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), VitalFIshOilHM.class);
//                startActivity(intent);
//            }
//        });



        //Intents of Home page

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Supradyn_Activity.class);
                startActivity(intent);
            }
        });
        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Divine_Nutrition.class);
                startActivity(intent);
            }
        });
        card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GNC_Calcium.class);
                startActivity(intent);
            }
        });

        card21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Himalaya_Ashvagandha.class);
                startActivity(intent);
            }
        });
        card22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Organic_India_Tulsi60.class);
                startActivity(intent);
            }
        });
        card23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Dabur_Shilajit.class);
                startActivity(intent);
            }
        });

        card31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Herbalife_Energy_Drink.class);
                startActivity(intent);
            }
        });
        card32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), XLR_Isonotic_Drink.class);
                startActivity(intent);
            }
        });
        card33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Nutriorg_Amla_Juice.class);
                startActivity(intent);
            }
        });


        card41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Wellcore_Pure.class);
                startActivity(intent);
            }
        });
        card42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MuscleBlaze_MB_Burner.class);
                startActivity(intent);
            }
        });
        card43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Asitis_Nutrition_Whey.class);
                startActivity(intent);
            }
        });

        card51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MusleBlaze_Carb.class);
                startActivity(intent);
            }
        });
        card52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyFitness_Peanut_Butter.class);
                startActivity(intent);
            }
        });
        card53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Protinex_Protein_Shake.class);
                startActivity(intent);
            }
        });

        card61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Diabetes_Medicine_Tablets.class);
                startActivity(intent);
            }
        });
        card62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Nasal_Spray.class);
                startActivity(intent);
            }
        });
        card63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Paracetamol_Medicine.class);
                startActivity(intent);
            }
        });




        return view;
    }
}
