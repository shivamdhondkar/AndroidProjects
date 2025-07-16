package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    Boolean doubletap=false;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;
    String str_username,str_password;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferences = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
        editor = preferences.edit();

        Intent intent= getIntent();
        str_username=intent.getStringExtra("username");
        str_password=intent.getStringExtra("password");

        Toast.makeText(HomeActivity.this,str_username+""+str_password,Toast.LENGTH_SHORT).show();


        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new CategoriesFragment(), "Categories");
        viewPagerAdapter.addFragment(new HomeFragment(), "Home");
//        viewPagerAdapter.addFragment(new OrderFragment(), "Orders");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean isFirstTime = preferences.getBoolean("first time", true);
        if (isFirstTime) {
            welcome();
        }

        setTitle("Home Activity");



    }

    private void welcome() {
        AlertDialog.Builder ad = new AlertDialog.Builder(HomeActivity.this);
        ad.setTitle("WELLNEST");
        ad.setMessage("Welcome to our Application!!!");
        ad.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();

        editor=preferences.edit();
        editor.putBoolean("first time",false).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        if (item.getItemId()==R.id.home_menu_location)
        {

            Toast.makeText(HomeActivity.this,"My Location is Click",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(HomeActivity.this,MyLocationActivity.class);
            startActivity(i);

        }
        if (item.getItemId()==R.id.home_menu_my_profile)
        {

           Toast.makeText(HomeActivity.this,"My Profile Item is Click",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(HomeActivity.this,MyProfileActivity.class);
            i.putExtra("username",str_username);
            i.putExtra("password",str_password);
            startActivity(i);

        } else if (item.getItemId()==R.id.home_menu_settingd) {

            Toast.makeText(HomeActivity.this,"Setting Item is Click",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(HomeActivity.this, AddToCart.class);
            startActivity(i);

        } else if (item.getItemId()==R.id.home_menu_contact_us) {

            Toast.makeText(HomeActivity.this,"Contact Us Item is Click",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(HomeActivity.this,ContactUsActivity.class);
            startActivity(i);

        } else if (item.getItemId()==R.id.home_menu_about_us) {



            Toast.makeText(HomeActivity.this,"About Us Item is Click",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(HomeActivity.this,AboutUsActivity.class);
            startActivity(i);
        } else if (item.getItemId()==R.id.home_menu_logout)

        {
            AlertDialog.Builder ad=new AlertDialog.Builder(HomeActivity.this);
            ad.setTitle("Logout");
            ad.setMessage("Are you Sure you to Logout?");
            ad.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            ad.setNegativeButton("Logout", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Intent intent=new Intent(HomeActivity.this, LoginActivity2.class);
                    editor.putBoolean("Login",false).commit();
                    startActivity(intent);
                    finish();
                }
            }).create().show();



        }


        return true;
    }

    @Override
    public void onBackPressed() {
        if(doubletap)
        {

            super.onBackPressed();
        }
        else {
            Toast.makeText(HomeActivity.this,"Press again to Exit",Toast.LENGTH_SHORT).show();
            doubletap=true;
            Handler h=new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletap=false;

                }
            },2000);
        }

    }


}