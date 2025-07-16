package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.databinding.ActivityMyLocationBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MyLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMyLocationBinding binding;

    Button btn_satellite,btn_terrain,btn_hybrid,btn_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        btn_satellite=findViewById(R.id.btn_mylocation_satellite);
        btn_terrain=findViewById(R.id.btn_mylocation_terrain);
        btn_hybrid=findViewById(R.id.btn_mylocation_hybrid);
        btn_normal=findViewById(R.id.btn_mylocation_normal);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        LatLng mylocation = new LatLng(20.932010996567413, 77.77735795108693);

                mMap.addMarker(new MarkerOptions().position(mylocation).title("Marker in P.D.Poly Amravati"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mylocation,16),5000,null);
        mMap.addCircle(new CircleOptions()
                .center(mylocation)
                .fillColor(Color.parseColor("#8ED4F4"))
                .strokeColor(Color.TRANSPARENT)
                .radius(150)


        );

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

        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });





        MarkerOptions markerOptions=new MarkerOptions();
        LatLng myhome=new LatLng(20.959966, 77.778206);
        markerOptions.position(myhome);
        markerOptions.title("Marker in Arjun Nagar");
        mMap.addMarker(markerOptions);

        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(20.932010996567413, 77.77735795108693),
                        (new LatLng(20.959966, 77.778206)))
                .width(5)
                .color(Color.RED)
                .geodesic(true)

        );

    }
}