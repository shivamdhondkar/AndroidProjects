package com.AAU.bakery;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.AAU.bakery.databinding.ActivityLocationBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.PolylineOptions;

public class LocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityLocationBinding binding;
    Button btn_normal,btn_satellite,btn_terrain,btn_hybrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_normal=findViewById(R.id.btn_normal);
        btn_satellite=findViewById(R.id.btn_satellite);
        btn_terrain=findViewById(R.id.btn_terrain);
        btn_hybrid=findViewById(R.id.btn_hybrid);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng myLocation = new LatLng(20.94347533016812, 77.76829643703606);
        mMap.addMarker(new MarkerOptions().position(myLocation).title("Marker in Dr.PD Polytechnic,Amravati"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation,16),5000,null);
        mMap.addCircle(new CircleOptions()
                .center(myLocation)
                .radius(70)
                .strokeColor(Color.BLUE)
                .fillColor(Color.parseColor("#1B98E01A"))
        );
        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        btn_satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        btn_terrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
        btn_hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        LatLng kendriyaVidyalayBEG= new LatLng(18.545749231531584, 73.87556656601923);
        mMap.addMarker(new MarkerOptions().position(kendriyaVidyalayBEG).title("Marker at Kendriya Vidyalaya BEG,Pune"));
         mMap.addCircle(new CircleOptions()
                 .center(kendriyaVidyalayBEG)
                 .radius(70)
                 .strokeColor(Color.BLUE)
                 .fillColor(Color.parseColor("#1B98E01A"))
                 );
         mMap.addPolyline(new PolylineOptions()
                 .geodesic(true)
                 .width(5)
                 .add(myLocation,kendriyaVidyalayBEG)
                 );
    }
}