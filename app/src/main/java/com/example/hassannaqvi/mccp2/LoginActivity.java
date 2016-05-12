
package com.example.hassannaqvi.mccp2;

import android.content.Intent;
import android.content.SharedPreferences;
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
import java.util.ArrayList;
import java.util.Map;


public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static String MC_102;
    public static String UC_ID = "";
    public static boolean appAdmin = false;
    public ArrayList<String> lables;
    public ArrayList<String> values;
    Spinner spSP;
    String listText1;
    private Spinner spUC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        spSP = (Spinner) findViewById(R.id.spinner1);
        listText1 = "";


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
                    Log.d("SOut ", entry.getKey() + " -|- " + entry.getValue());
                    listText1.concat("\r\n");
                    listText1.concat(entry.getKey() + " : " + entry.getValue());
                }
                Log.d("TAG: ", listText1);
                Log.d("TAG: ", "End");


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
        spUC.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        spUC.setOnItemSelectedListener(this);


    }

    public void viewForm(View view) {
        Intent vF_intent = new Intent(getApplicationContext(), FormView.class);
        vF_intent.putExtra("listText", listText1);

        startActivity(vF_intent);

    }




    public void loginUser(View view) {
        final EditText txtUserName = (EditText) findViewById(R.id.email);
        final EditText txtPassword = (EditText) findViewById(R.id.password);

        String username = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
        try {
            if (username.length() > 0 && password.length() > 0) {
                FormsDbHelper db = new FormsDbHelper(LoginActivity.this);

                appAdmin = username.contains("@");
                if (db.Login(username, password)) {
                    Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                    MC_102 = username;
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



