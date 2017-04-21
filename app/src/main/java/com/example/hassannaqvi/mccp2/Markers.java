package com.example.hassannaqvi.mccp2;

import com.google.android.gms.maps.model.LatLng;

public class Markers {
    private final LatLng mPosition;

    public Markers(double lat, double lng) {

        mPosition = new LatLng(lat, lng);
    }

    public Markers(LatLng karachi) {
        mPosition = karachi;
    }

}
