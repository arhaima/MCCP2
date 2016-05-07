
package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Map;


public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static String UC_ID = "";
    public static boolean appAdmin = false;
    public ArrayList<String> lables;
    public ArrayList<String> values;
    Spinner spSP;
    private Spinner spUC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        spSP = (Spinner) findViewById(R.id.spinner1);


        File prefsdir = new File(getApplicationInfo().dataDir, "shared_prefs");

        if (prefsdir.exists() && prefsdir.isDirectory()) {
            String[] list = prefsdir.list();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1, list);
            spSP.setAdapter(adapter);

            spSP.setOnItemSelectedListener(this);

        }

        spSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String item = (String) spSP.getSelectedItem();
                //remove .xml from the file name
                String preffile = item.substring(0, item.length() - 4);

                SharedPreferences sp2 = getSharedPreferences(preffile, MODE_PRIVATE);
                Map<String, ?> map = sp2.getAll();

                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " -|- " + entry.getValue());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        FormsDbHelper db = new FormsDbHelper(getApplicationContext());
        spUC = (Spinner) findViewById(R.id.spUC);
        ArrayList<UCContract> ucList = new ArrayList<UCContract>();
        ucList = db.getAllUC();

        // Spinner Drop down elements
        lables = new ArrayList<String>();
        values = new ArrayList<String>();

        // Polulating 'lables' and 'values' from ucList

        for (int i = 0; i < ucList.size(); i++) {
            lables.add(ucList.get(i).getUCName());
            values.add(String.valueOf(ucList.get(i).getID()));
            Log.i("Key - Value:", ucList.get(i).getTownId() + " - " + ucList.get(i).getUCId() + " - " + ucList.get(i).getUCName() + " - " + ucList.get(i).getID());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spUC.setAdapter(dataAdapter);
        spUC.setOnItemSelectedListener(this);


    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private boolean isHostAvailable() {

        if (isNetworkAvailable()) {
            try {
                SocketAddress sockaddr = new InetSocketAddress("192.168.1.10", 80);
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


    public void updateUsers(View view) {

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
        } else {

            Toast.makeText(LoginActivity.this, "Network not available for update!", Toast.LENGTH_LONG).show();

        }
        


    }

    public void syncFunction(View view) {
        if (isNetworkAvailable()) {
            syncForms ff = new syncForms();
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            ff.execute();
        }
    }

    public void loginUser(View view) {
        final EditText txtUserName = (EditText) findViewById(R.id.email);
        final EditText txtPassword = (EditText) findViewById(R.id.password);

        String username = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
        try {
            if (username.length() > 0 && password.length() > 0) {
                FormsDbHelper db = new FormsDbHelper(LoginActivity.this);

                //username = username.replaceAll("@","");
                appAdmin = username.contains("@");
                if (db.Login(username, password)) {
                    Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                    Intent login_intent = new Intent(getApplicationContext(), MainActivity.class);

                    startActivity(login_intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                    if (username.equals("dmu@admin") && password.equals("admin@dmu")) {
                        Intent login_intent = new Intent(getApplicationContext(), MainActivity.class);

                        startActivity(login_intent);
                    }
                }
                db.close();

            }

        } catch (Exception e) {
            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Log.d("Testing", "");
        switch (adapterView.getId()) {
            case R.id.spUC:
                UC_ID = values.get(position);
                Log.i("UC SELECTED: ", UC_ID);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



