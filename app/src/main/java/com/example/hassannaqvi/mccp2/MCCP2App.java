package com.example.hassannaqvi.mccp2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.LocationRequest;

/**
 * Created by hassan.naqvi on 7/29/2016.
 */
public class MCCP2App extends Application {

    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds
    private static final int TWENTY_MINUTES = 1000 * 60 * 20;


    protected LocationManager locationManager;
    Location location;
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/JameelNooriNastaleeq.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                MINIMUM_TIME_BETWEEN_UPDATES,
                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                new MyLocationListener()
        );

    }


    protected void showCurrentLocation() {

        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location != null) {
            String message = String.format(
                    "Current Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude()
            );
            //Toast.makeText(getApplicationContext(), message,
            //Toast.LENGTH_SHORT).show();
        }

    }

    public void showGPSCoordinates(View v) {
        showCurrentLocation();


    }

    protected boolean isBetterLocation(Location location, Location currentBestLocation) {
        if (currentBestLocation == null) {
            // A new location is always better than no location
            Toast.makeText(getApplicationContext(), "New Location -- Accuracy: " + String.valueOf(location.getAccuracy()), Toast.LENGTH_SHORT).show();

            return true;
        }

        // Check whether the new location fix is newer or older
        long timeDelta = location.getTime() - currentBestLocation.getTime();
        boolean isSignificantlyNewer = timeDelta > TWENTY_MINUTES;
        boolean isSignificantlyOlder = timeDelta < -TWENTY_MINUTES;
        boolean isNewer = timeDelta > 2;

        // If it's been more than two minutes since the current location, use the new location
        // because the user has likely moved
        if (isSignificantlyNewer) {
            Toast.makeText(getApplicationContext(), "Significantly Newer Location -- Time: " + String.valueOf(location.getTime()), Toast.LENGTH_SHORT).show();

            return true;
            // If the new location is more than two minutes older, it must be worse
        } else if (isSignificantlyOlder) {
            Toast.makeText(getApplicationContext(), "Significantly Older Location -- Time: " + String.valueOf(location.getTime()), Toast.LENGTH_SHORT).show();

            return false;
        }

        // Check whether the new location fix is more or less accurate
        int accuracyDelta = (int) (location.getAccuracy() - currentBestLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;

        // Check if the old and new location are from the same provider
        boolean isFromSameProvider = isSameProvider(location.getProvider(),
                currentBestLocation.getProvider());

        // Determine location quality using a combination of timeliness and accuracy
        if (isMoreAccurate) {
            Toast.makeText(getApplicationContext(), "More Accurate Location -- Accuracy: " + String.valueOf(location.getAccuracy()), Toast.LENGTH_SHORT).show();

            return true;
        } else if (isNewer && !isLessAccurate) {
            Toast.makeText(getApplicationContext(), "New Location, More Accurate -- Accuracy: " + String.valueOf(location.getAccuracy()), Toast.LENGTH_SHORT).show();

            return true;
        } else if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
            Toast.makeText(getApplicationContext(), "New Location, Significatly More Accurate -- Accuracy: " + String.valueOf(location.getAccuracy()), Toast.LENGTH_SHORT).show();

            return true;
        }
        Toast.makeText(getApplicationContext(), "Older/Worse Location -- Accuracy: " + String.valueOf(location.getAccuracy()), Toast.LENGTH_SHORT).show();

        return false;
    }

    /**
     * Checks whether two providers are the same
     */
    private boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }

    private class MyLocationListener implements LocationListener {

        public void onLocationChanged(Location location) {


            SharedPreferences sharedPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            Location savedlocation = new Location("sharedPref");

            savedlocation.setLongitude(Double.parseDouble(sharedPref.getString("Longitude", "00")));
            savedlocation.setLatitude(Double.parseDouble(sharedPref.getString("Latitude", "00")));
            savedlocation.setAccuracy(Float.parseFloat(sharedPref.getString("Accuracy", "00")));
            savedlocation.setTime(Long.parseLong(sharedPref.getString("Time", "00")));


            if (isBetterLocation(location, savedlocation)) {
                editor.putString("Longitude", String.valueOf(location.getLongitude()));
                editor.putString("Latitude", String.valueOf(location.getLatitude()));
                editor.putString("Accuracy", String.valueOf(location.getAccuracy()));
                editor.putString("Time", String.valueOf(location.getTime()));

                editor.apply();
            }
        }

        public void onStatusChanged(String s, int i, Bundle b) {
            showCurrentLocation();
        }

        public void onProviderDisabled(String s) {

        }

        public void onProviderEnabled(String s) {

        }

    }
}
