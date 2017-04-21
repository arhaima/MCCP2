package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static final int PROGRESS = 0x1;
    private static final String TAG = "MAIN_ACTIVITY";
    private static String ipAddress = "43.245.13.159";
    public EditText clusterNo;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    private TextView RecordSummary;
    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    private String rSumText = "";
    private JSONObject listBKText;

    public static void longInfo(String str) {
        if (str.length() > 4000) {
            Log.i("TAG: ", str.substring(0, 4000));
            longInfo(str.substring(4000));
        } else
            Log.i("TAG: ", str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        RecordSummary = (TextView) findViewById(R.id.recordSummary);


        ShareDBHelper sdb = new ShareDBHelper(this);
        List<String> forms = sdb.getAllForms();
        Log.d(TAG, forms.toString());


        FormsDbHelper db = new FormsDbHelper(this);
        List<FormsContract> todaysForms = new ArrayList<>();

        todaysForms = db.getTodayForms();

        rSumText += "TODAY'S RECORDS SUMMARY\r\n";
        rSumText += "=======================";
        rSumText += "\r\n\r\n";
        rSumText += "Total Forms Today: "+todaysForms.size();
        rSumText += "\r\n";
        rSumText += "    Forms List: \r\n";
        String iStatus = "";
        for(FormsContract fc : todaysForms){

            switch (fc.get109()) {
                case "1":
                    iStatus = "Complete";
                    break;
                case "2":
                    iStatus = "Incomplete";
                    break;
                case "3":
                    iStatus = "Form Incomplete";
                    break;
            }

            rSumText += fc.get105() + " " + fc.get106() + " " + iStatus;
            rSumText += "\r\n";

        }

        rSumText += "--------------------------------------------------\r\n";
        if (LoginActivity.appAdmin) {
            findViewById(R.id.adminOptions).setVisibility(View.VISIBLE);
            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            rSumText += "Last Update: " + syncPref.getString("LastUpdate", "Never Updated");
            rSumText += "\r\n";
            rSumText += "Last Synced(DB): " + syncPref.getString("LastSyncDB", "Never Synced");
            rSumText += "\r\n    Database Version: " + FormsDbHelper.DATABASE_VERSION;
            rSumText += "\r\nLast Synced(Files): " + syncPref.getString("LastSyncF", "Never Synced");
            rSumText += "\r\n";
        }
        RecordSummary.setText(rSumText);


        Log.d(TAG, String.valueOf(db.getFormCount()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.admin_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Update_Device:
                updateUsers();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

   /* public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }*/


    public void fillSurveyForm(View view) {
        Toast.makeText(getApplicationContext(), "Fill Survey Form", Toast.LENGTH_SHORT).show();

        Intent fill_form_intent = new Intent(getApplicationContext(), FillFormActivity.class);
        startActivity(fill_form_intent);
    }

    public void CheckCluster(View v) {
        clusterNo = (EditText) findViewById(R.id.clusterNo);

        Intent cluster_list = new Intent(getApplicationContext(), FormsList.class);
        cluster_list.putExtra("clusterno", clusterNo.getText().toString());
        startActivity(cluster_list);

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
        String str = "";
        FormsDbHelper db = new FormsDbHelper(this);
        List<FormsContract> forms = db.getAllForms();

        for (FormsContract fc : forms) {
            str = "Id: " + fc.getId()
                    + ", MC_101: " + fc.get101()
                    + ", MC_101TIME: " + fc.get101Time()
                    + ", MC_102: " + fc.get102()
                    + ", MC_103: " + fc.get103()
                    + ", MC_104: " + fc.get104()
                    + ", MC_105: " + fc.get105()
                    + ", MC_106: " + fc.get106()
                    + ", MC_107: " + fc.get107()
                    + ", MC_108: " + fc.get108()
                    + ", MC_S_2: " + fc.getS2()
                    + ", MC_S_4: " + fc.getS4()
                    + ", MC_S_5: " + fc.getS5()
                    + ", MC_S_6: " + fc.getS6();


            // Writing Contacts to log
        }
        longInfo(str);


    }

    public void deleteForms(View view) {
        Intent s2_form_intent = new Intent(getApplicationContext(), FillFormS3Activity.class);

        startActivity(s2_form_intent);

    }

    public void testFormS1(View view) {
/*
        FormsDbHelper db = new FormsDbHelper(getApplicationContext());
        ArrayList<ClustersContract> clusterList;
        Log.d(TAG,"UC_ID: "+LoginActivity.UC_ID);
        clusterList = db.getAllClusters();
        for(ClustersContract UC : clusterList){
            Log.d(TAG, "C_ID: "+UC.getId()+" C_Code: "+UC.getClusterCode()+" UC_ID: "+UC.getUCId()+" TownID: "+UC.getTownId()+" C_Name: "+UC.getClusterName());
        }*/


   /*Log.i(TAG, "User Count: " + db.getUserCount());*/



        /*GetUsers users = new GetUsers(getApplicationContext());
        users.execute();*/

        Intent s1_form_intent = new Intent(getApplicationContext(), FillFormActivity.class);
        startActivity(s1_form_intent);
    }

    public void testFormS2(View view) {

        Intent s2_form_intent = new Intent(getApplicationContext(), FillFormS2Activity.class);

        startActivity(s2_form_intent);
    }

    public void testFormS3(View view) {

        Intent s3_form_intent = new Intent(getApplicationContext(), FillFormS3Activity.class);

        startActivity(s3_form_intent);
    }

    public void testFormS4(View view) {

        Intent s4_form_intent = new Intent(getApplicationContext(), FillFormS4Activity.class);

        startActivity(s4_form_intent);
    }

    public void testFormS5(View view) {

        Intent s5_form_intent = new Intent(getApplicationContext(), FillFormS5Activity.class);

        startActivity(s5_form_intent);
    }

    public void testFormS6(View view) {

        Intent s6_form_intent = new Intent(getApplicationContext(), FillFormS6Activity.class);

        startActivity(s6_form_intent);
    }

    public void moveDbToSd(View view) {

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            String android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            String curDateTime = DateFormat.getDateTimeInstance().format(new Date());
            String DBName = FormsDbHelper.DATABASE_NAME;


            if (sd.canWrite()) {
                String currentDBPath = "//data//data//" + getPackageName() + "//databases//" + DBName;
                String backupDBPath = "TVI_MCCP2_" + DBName + "_" + curDateTime;
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




    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private boolean isHostAvailable() {

        if (isNetworkAvailable()) {
            try {
                SocketAddress sockaddr = new InetSocketAddress(ipAddress, 80);
                // Create an unbound socket
                Socket sock = new Socket();

                // This method will block no more than timeoutMs.
                // If the timeout occurs, SocketTimeoutException is thrown.
                int timeoutMs = 2000;   // 2 seconds
                sock.connect(sockaddr, timeoutMs);
                return true;
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Server Not Available for Update", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else {
            Toast.makeText(getApplicationContext(), "Network not available for Update", Toast.LENGTH_SHORT).show();
            return false;

        }
    }

    public void updateUsers() {

        if (isNetworkAvailable()) {
            // Syncing Towns Table from Server
            getTowns towns = new getTowns(getApplicationContext());
            Toast.makeText(getApplicationContext(), "Syncing Towns from Server...", Toast.LENGTH_SHORT).show();
            towns.execute();

            // Syncing Clusters Table from Server
            getClusters clusters = new getClusters(getApplicationContext());
            Toast.makeText(getApplicationContext(), "Syncing Clusters from Server...", Toast.LENGTH_SHORT).show();
            clusters.execute();

            // Syncing UCs Table from Server
            getUC UC = new getUC(getApplicationContext());
            Toast.makeText(getApplicationContext(), "Syncing UC from Server...", Toast.LENGTH_SHORT).show();
            UC.execute();

            GetUsers users = new GetUsers(getApplicationContext());
            Toast.makeText(getApplicationContext(), "Syncing Users from Server...", Toast.LENGTH_SHORT).show();
            users.execute();

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastUpdate", dtToday);

            editor.apply();


        } /*else {

            Toast.makeText(MainActivity.this, "Network not available for update!", Toast.LENGTH_LONG).show();

        }*/


    }

    public void syncFunction(View view) {
        if (isNetworkAvailable()) {
            syncForms ff = new syncForms(this);
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            ff.execute();
            syncIms im = new syncIms(this);
            im.execute();


            //            Camps section commented out for GADAP

            /*syncCfs cf = new syncCfs(this);
            cf.execute();*/


            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastSyncDB", dtToday);

            editor.apply();
        } /*else {
            Toast.makeText(getApplicationContext(), "Network Not Available", Toast.LENGTH_SHORT).show();

        }*/
    }

    public void openMap(View view) {
        Intent map_intent = new Intent(getApplicationContext(), MapsActivity.class);
        map_intent.putExtra("today", "true");
        startActivity(map_intent);
    }

    public void GetRawData(View view) {
        ShareDBHelper db = new ShareDBHelper(this);
        File prefsBKdir = new File(getApplicationInfo().dataDir, "shared_prefs");

        if (prefsBKdir.exists() && prefsBKdir.isDirectory()) {
            String[] list = prefsBKdir.list();
            int listLen = list.length;
            int itemCount = 0;
            int progress;
            db.deleteAllForms();

            Toast.makeText(getApplicationContext(), "Syncing XML Files to SQLite...     ", Toast.LENGTH_SHORT).show();

            for (String item : list) {

                String prefBKfile = item.substring(0, item.length() - 4);
                SharedPreferences spForm = getSharedPreferences(prefBKfile, MODE_PRIVATE);
                Map<String, ?> map = spForm.getAll();
                listBKText = new JSONObject();

                try {
                    for (Map.Entry<String, ?> entry : map.entrySet()) {
                        listBKText.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                itemCount++;
                progress = (itemCount / listLen) * 100;
                mProgress.setProgress(progress);
                String deviceid = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);

                db.addForm(prefBKfile, listBKText.toString(), deviceid);

            }
            Toast.makeText(getApplicationContext(), "Syncing XML Files to SQLite... DONE!", Toast.LENGTH_SHORT).show();
            DumpFiles2DB();
        }
    }


    public void DumpFiles2DB() {
        Toast.makeText(getApplicationContext(), "Sync Initiated", Toast.LENGTH_SHORT).show();

        if (isNetworkAvailable()) {
            SyncFilesData sf = new SyncFilesData(this);
            Toast.makeText(getApplicationContext(), "Syncing MYSQL from SQLite...     ", Toast.LENGTH_SHORT).show();
            sf.execute();

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastSyncF", dtToday);

            editor.apply();
        } /*else {
            Toast.makeText(getApplicationContext(), "No Network Available", Toast.LENGTH_SHORT).show();

        }
*/

    }

    public void openDBManager(View v) {
        Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }


    public void onBackPressed() {
        Intent back_intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(back_intent);

    }


}
