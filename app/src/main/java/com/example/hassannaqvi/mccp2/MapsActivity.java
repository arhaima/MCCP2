package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean Todays;
    private CoordinatorLayout coordinatorLayout;
    private ClusterManager<Markers> mClusterManager;
    private LatLng karachi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Todays = Boolean.parseBoolean(getIntent().getStringExtra("today"));
        
        setContentView(R.layout.activity_maps);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);
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


        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(karachi, 15));
        setUpClusterer();
    }


    private void setUpClusterer() {


        // Declare a variable for the cluster manager.

        // Position the map.
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.503186, -0.126446), 10));

        // Initialize the manager with the context and the map.
        // (Activity extends context, so we can pass 'this' in the constructor.)
        mClusterManager = new ClusterManager<>(this, mMap);

        // Point the map's listeners at the listeners implemented by the cluster
        // manager.
        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);

        // Add cluster items (markers) to the cluster manager.
        addMarkers();
    }


    private void addMarkers() {

        FormsDbHelper db = new FormsDbHelper(this);
        List<FormsContract> gpsList;
        if (Todays) {
            gpsList = db.getTodaysGPS();
            if (gpsList.size() < 1) {
                gpsList = db.getAllGPS();
                Snackbar.make(coordinatorLayout, "No Forms for Today, showing All Forms " + gpsList.size(), Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(coordinatorLayout, "Today's Forms", Snackbar.LENGTH_LONG).show();

            }
        } else {
            gpsList = db.getAllGPS();
            Snackbar.make(coordinatorLayout, "Showing All Forms" + String.valueOf(Todays), Snackbar.LENGTH_LONG).show();
        }
        SharedPreferences sharedPref = getSharedPreferences("MC_" + FillFormActivity.FORM_ID, Context.MODE_PRIVATE);
        Double mLat = Double.valueOf(sharedPref.getString("spGPSLat", "0"));
        Double mLong = Double.valueOf(sharedPref.getString("spGPSLng", "0"));
        // Add a marker in Karachi and move the camera

        for (FormsContract gps : gpsList) {

            Float markerHue = Float.valueOf(gps.get105().substring(0, 6)) / 1000;

            karachi = new LatLng(Double.valueOf(gps.getGPSLat()), Double.valueOf(gps.getGPSLng()));
            //mMap.addMarker(new MarkerOptions().position(karachi).icon(BitmapDescriptorFactory.defaultMarker(markerHue)).title("Form Submission for HH:" + gps.get106() + " Cluster: " + gps.get105().substring(0, 6)));
            Log.d("MAP", "Form Submission here! LAT:" + gps.getGPSLat() + " LNG: " + gps.getGPSLng());
            // Set some lat/lng coordinates to start with.
            Markers offsetItem = new Markers(karachi);
            mClusterManager.addItem(offsetItem);
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(karachi, 15));


    }
}

