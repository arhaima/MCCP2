package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by hassan.naqvi on 5/7/2016.
 */
public class MyLocationListener implements LocationListener {

    SharedPreferences.Editor editor = sharedPref.edit();
    private Context mContext;
    /*protected LocationManager locationManager;*/
    SharedPreferences sharedPref = mContext.getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);


    public MyLocationListener(Context context) {
        mContext = context;
    }

    public void onLocationChanged(Location location) {
        sharedPref = mContext.getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);


        editor.putString("Longitude", String.valueOf(Double.doubleToLongBits(location.getLongitude())));
        editor.putString("Latitude", String.valueOf(Double.doubleToLongBits(location.getLatitude())));
        editor.putString("Time", String.valueOf(Double.doubleToLongBits(location.getTime())));
        editor.putString("Accuracy", String.valueOf(Double.doubleToLongBits(location.getAccuracy())));

        editor.commit();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    // getLocationButton is the name of your button.  Not the best name, I know.
    /*public void showGPSCoordinates(View v) {
        showCurrentLocation();


    }*/

    /*protected void showCurrentLocation() {

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location != null) {
            String message = String.format(
                    "Current Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude()
            );
            Toast.makeText(getApplicationContext(), message,
                    Toast.LENGTH_SHORT).show();
        }

    }*/

    public Double getLat() {

        return Double.longBitsToDouble(sharedPref.getLong("Latitude", 0));

    }

    public Double getLng() {

        return Double.longBitsToDouble(sharedPref.getLong("Longitude", 0));

    }

}
