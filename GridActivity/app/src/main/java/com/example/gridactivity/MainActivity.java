package com.example.gridactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button addToCartButton1 = findViewById(R.id.add_1);
        Button buyNowButton1 = findViewById(R.id.buy_1);
        Button detailsButton1 = findViewById(R.id.product_1);

        addToCartButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("MuscleBlaze Peanut Butter Added In Cart", MyProduct.class);
            }
        });

        buyNowButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("MuscleBlaze Peanut Butter Buy", MyProduct.class);
            }
        });

        detailsButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Product Details of MuscleBlaze Peanut Butter", MyProduct.class);
            }
        });



        Button addToCartButton2 = findViewById(R.id.add_2);
        Button buyNowButton2 = findViewById(R.id.buy_2);
        Button detailsButton2 = findViewById(R.id.product_2);

        addToCartButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Whey Protein Go Added In Cart", MyProduct.class);
            }
        });

        buyNowButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Whey Protein Buy", MyProduct.class);
            }
        });

        detailsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Product Details of Whey Protein", MyProduct.class);
            }
        });



        Button addToCartButton3 = findViewById(R.id.add_3);
        Button buyNowButton3 = findViewById(R.id.buy_3);
        Button detailsButton3 = findViewById(R.id.product_3);

        addToCartButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("WellCore Creatine Monohydrate Added In Cart", MyProduct.class);
            }
        });

        buyNowButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("WellCore Creatine Monohydrate Buy", MyProduct.class);
            }
        });

        detailsButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Product Details of WellCore Creatine Monohydrate", MyProduct.class);
            }
        });



        Button addToCartButton4 = findViewById(R.id.add_1);
        Button buyNowButton4 = findViewById(R.id.buy_4);
        Button detailsButton4 = findViewById(R.id.product_4);

        addToCartButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Asitis Soy Protein Added In Cart", MyProduct.class);
            }
        });

        buyNowButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Asitis Soy Protein Buy", MyProduct.class);
            }
        });

        detailsButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Product Details of Asitis Soy Protein", MyProduct.class);
            }
        });



        Button addToCartButton5 = findViewById(R.id.add_5);
        Button buyNowButton5 = findViewById(R.id.buy_5);
        Button detailsButton5 = findViewById(R.id.product_5);

        addToCartButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Soy Fish-Oil Added In Cart", MyProduct.class);
            }
        });

        buyNowButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Soy Fish-Oil Buy", MyProduct.class);
            }
        });

        detailsButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastAndNavigate("Product Details of Soy Fish-Oil", MyProduct.class);
            }
        });


    }


    private void showToastAndNavigate(String message, Class<?> targetActivity) {
        showToast(message);
        Intent intent = new Intent(MainActivity.this, targetActivity);
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
