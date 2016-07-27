package com.example.hassannaqvi.mccp2;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class Markers implements ClusterItem {
    private final LatLng mPosition;

    public Markers(double lat, double lng) {

        mPosition = new LatLng(lat, lng);
    }

    public Markers(LatLng karachi) {
        mPosition = karachi;
    }


    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
