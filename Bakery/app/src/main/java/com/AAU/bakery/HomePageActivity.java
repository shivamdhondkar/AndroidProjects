package com.AAU.bakery;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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

import com.google.android.material.tabs.TabLayout;
public class HomePageActivity extends AppCompatActivity {
    boolean doubletap = false;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    String str_username,str_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        setTitle("Home Page");
        preferences = PreferenceManager.getDefaultSharedPreferences(HomePageActivity.this);
        editor = preferences.edit();

        Intent i=getIntent();
        str_username=i.getStringExtra("username");
        str_password=i.getStringExtra("password");

        Toast.makeText(HomePageActivity.this,str_username+" "+str_password,Toast.LENGTH_SHORT).show();
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tablayout);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new TextToSpeechFragment(),"Text to Speech");
        viewPagerAdapter.addFragment(new CategoriesFragment(), "Categories");
        viewPagerAdapter.addFragment(new OrderNowFragment(), "Order");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean isFirstTime = preferences.getBoolean("FirstTime", true);
        if (isFirstTime) {
            welcome();
        }
    }
    private void welcome() {
        AlertDialog.Builder ad = new AlertDialog.Builder(HomePageActivity.this);
        ad.setTitle("Confectionery");
        ad.setMessage("!! Welcome to our app !!");
        ad.setPositiveButton("Thank you", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
        editor = preferences.edit();
        editor.putBoolean("FirstTime", false).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      if (item.getItemId()==R.id.menu_bluetooth){
          Toast.makeText(HomePageActivity.this,"Bluetooth",Toast.LENGTH_SHORT).show();
          Intent i=new Intent(HomePageActivity.this,BluetoothActivity.class);
          startActivity(i);
      }
        if (item.getItemId() == R.id.menu_location) {
            Toast.makeText(HomePageActivity.this, "Location", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(HomePageActivity.this, LocationActivity.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.home_menu_my_profile) {
            Toast.makeText(HomePageActivity.this, "My Profile", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(HomePageActivity.this, MyProfileActivity.class);
            i.putExtra("username",str_username);
            i.putExtra("password",str_password);
            startActivity(i);
        } else if (item.getItemId() == R.id.home_menu_order) {
            Toast.makeText(HomePageActivity.this, "Order Placed Details", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(HomePageActivity.this, OrderActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.home_menu_setting) {
            Toast.makeText(HomePageActivity.this, "Settings", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(HomePageActivity.this, SettingActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.home_menu_contact_us) {
            Toast.makeText(HomePageActivity.this, "Contact Us", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(HomePageActivity.this, ContactUsActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.home_menu_about_us) {
            Toast.makeText(HomePageActivity.this, "About Us", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(HomePageActivity.this, AboutUsActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.home_menu_help) {
            Toast.makeText(HomePageActivity.this, "Help Center", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(HomePageActivity.this, HelpActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.home_menu_log_out) {
            AlertDialog.Builder ad = new AlertDialog.Builder(HomePageActivity.this);
            ad.setTitle("Log Out");
            ad.setMessage("Are you sure to Logout");
            ad.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            ad.setNegativeButton("Logout", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                    editor.putBoolean("Login", false).commit();
                    startActivity(intent);
                    finish();
                }
            }).create().show();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (doubletap = true) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            doubletap = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletap = false;
                }
            }, 2000);
        }

    }
}