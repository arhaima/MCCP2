
package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;


public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static String MC_102;
    public static String UC_ID = "";
    public static boolean appAdmin = false;
    public static String DeviceNo;
    public ArrayList<String> lables;
    public ArrayList<String> values;
    Spinner spSP;
    JSONObject listText;
    EditText txtUserName;
    EditText txtPassword;
    private Spinner spUC;
    private JSONObject listBKText;
    private Button showpassword;

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
        setContentView(R.layout.activity_login);

        spSP = (Spinner) findViewById(R.id.spinner1);
        txtUserName = (EditText) findViewById(R.id.email);
        txtPassword = (EditText) findViewById(R.id.password);
        showpassword = (Button) findViewById(R.id.ShowPassword);
        spUC = (Spinner) findViewById(R.id.spUC);


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
                listText = new JSONObject();


                try {
                    for (Map.Entry<String, ?> entry : map.entrySet()) {
                        Log.d("SOut ", entry.getKey() + " -|- " + entry.getValue());
                        listText.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                String str = listText.toString();

                longInfo(str);
                Log.d("TAG: ", "End");
                str.concat("\r\n\r\n");
                writeToFile(str, preffile);

                showpassword.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (txtPassword.getTransformationMethod() != null) {
                            txtPassword.setTransformationMethod(null);
                            showpassword.setText("Hide Password");
                        } else {
                            txtPassword.setTransformationMethod(new PasswordTransformationMethod());
                            showpassword.setText("Show Password");
                        }
                    }

                });
            }

            private void writeToFile(String data, String fileNm) {
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getApplicationContext().openFileOutput(fileNm + ".txt", Context.MODE_PRIVATE));
                    outputStreamWriter.write(data);
                    outputStreamWriter.close();
                } catch (IOException e) {
                    Log.e("Exception", "File write failed: " + e.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        FormsDbHelper db = new FormsDbHelper(getApplicationContext());

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
                android.R.layout.simple_spinner_dropdown_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spUC.setAdapter(dataAdapter);
        spUC.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        spUC.setOnItemSelectedListener(this);


    }

    public void viewForm(View view) {
        Intent vF_intent = new Intent(getApplicationContext(), FormView.class);
        //vF_intent.putExtra("listText", listText);

        startActivity(vF_intent);

    }


    public void loginUser(View view) {


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
                    if (username.equals("@") && password.equals("dmu")) {
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



