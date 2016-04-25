package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters

    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds


    private static final String TAG = "MAIN_ACTIVITY";

    protected LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FormsDbHelper db = new FormsDbHelper(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                MINIMUM_TIME_BETWEEN_UPDATES,
                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                new MyLocationListener()
        );


    }

    public void fillSurveyForm(View view) {
        Toast.makeText(getApplicationContext(), "Fill Survey Form", Toast.LENGTH_SHORT).show();

        Intent fill_form_intent = new Intent(getApplicationContext(), FillFormActivity.class);
        startActivity(fill_form_intent);
    }

    public void editStoredForm(View view) {
        Toast.makeText(getApplicationContext(), "Edit Stored From.", Toast.LENGTH_SHORT).show();

        Log.d("Hassan1", "Hassan1" + FillFormActivity.FORM_ID);
        if (FillFormActivity.FORM_ID != null) {
            SharedPreferences sharedPref = getSharedPreferences(FillFormActivity.FORM_ID, Context.MODE_PRIVATE);
            Boolean openForm = sharedPref.getBoolean("formOpen", false);
            Log.d("MainActivity", openForm.toString());
        } else {
            Log.d("Null", "True");
        }
        /*Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        }*/

    }

    public void syncForms(View view) {

        FormsDbHelper db = new FormsDbHelper(this);
        List<FormsContract> forms = db.getAllForms();

        for (FormsContract fc : forms) {
            Log.d(TAG, "Id: " + fc.getId()
                    + ", MC_101: " + fc.get101()
                    + ", MC_101TIME: " + fc.get101Time()
                    + ", MC_102: " + fc.get102()
                    + ", MC_103: " + fc.get103()
                    + ", MC_104: " + fc.get104()
                    + ", MC_105: " + fc.get105()
                    + ", MC_106: " + fc.get106()
                    + ", MC_EXT: " + fc.getExt()
                    + ", MC_107: " + fc.get107()
                    + ", MC_S_2: " + fc.getS2()
                    + ", MC_S_3: " + fc.getS3()
                    + ", MC_S_4: " + fc.getS4()
                    + ", MC_S_5: " + fc.getS5()
                    + ", MC_S_6: " + fc.getS6()

            );
            // Writing Contacts to log
        }



    }

    public void deleteForms(View view) {
        Intent s2_form_intent = new Intent(getApplicationContext(), FillFormS3Activity.class);

        startActivity(s2_form_intent);

    }

    public void testFormS2(View view) {

        Intent s2_form_intent = new Intent(getApplicationContext(), FillFormS2Activity.class);

        startActivity(s2_form_intent);
    }

    public void moveDbToSd() {

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            String android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            String curDateTime = DateFormat.getDateTimeInstance().format(new Date());
            String DBName = FormsDbHelper.DATABASE_NAME;


            if (sd.canWrite()) {
                String currentDBPath = "/data/" + getPackageName() + "/databases/" + DBName;
                String backupDBPath = "TVI_MCCP2_" + DBName + "_" + curDateTime + ".db";
                File currentDB = new File(currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                    Toast.makeText(getApplicationContext(), "Database Moved to SD!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Database Not Found!", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {

        }

    }

    public void showDeviceID(View view) {
        String android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Toast.makeText(getApplicationContext(), "DEVICE ID: " + android_id, Toast.LENGTH_SHORT).show();


    }


    // getLocationButton is the name of your button.  Not the best name, I know.
    public void showGPSCoordinates(View v) {
        showCurrentLocation();


    }

    protected void showCurrentLocation() {

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location != null) {
            String message = String.format(
                    "Current Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude()
            );
            Toast.makeText(getApplicationContext(), message,
                    Toast.LENGTH_SHORT).show();
        }

    }

    private class MyLocationListener implements LocationListener {

        public void onLocationChanged(Location location) {
            SharedPreferences sharedPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            editor.putString("Longitude", String.valueOf(location.getLongitude()));
            editor.putString("Latitude", String.valueOf(location.getLatitude()));

        }

        public void onStatusChanged(String s, int i, Bundle b) {

        }

        public void onProviderDisabled(String s) {

        }

        public void onProviderEnabled(String s) {

        }

    }

}
