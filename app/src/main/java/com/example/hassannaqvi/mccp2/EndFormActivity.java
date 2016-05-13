package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class EndFormActivity extends AppCompatActivity {

    private static final String TAG = "End Form";
    private RadioGroup mc109;
    private int mc109Selected;
    private RadioButton mc109_complete;
    private int mc110Selected;
    private RadioButton mc109_incomplete;
    private RadioButton mc109_noQ;
    private TextView mc110_txt;
    private RadioGroup mc110;
    private RadioButton mc110_1;
    private RadioButton mc110_2;
    private RadioButton mc110_3;
    private RadioButton mc110_4;
    private RadioButton mc110_88;
    private TextView mc110x_txt;
    private EditText mc110x;
    private TextView formErrorTxt;
    private Boolean formError;
    private String formId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_form);

        formError = false;
        formId = FillFormActivity.FORM_ID;

        mc109 = (RadioGroup) findViewById(R.id.MC_109);
        mc109_complete = (RadioButton) findViewById(R.id.MC_109_complete);
        mc109_incomplete = (RadioButton) findViewById(R.id.MC_109_incomplete);
        mc109_noQ = (RadioButton) findViewById(R.id.MC_109_noQ);
        mc110_txt = (TextView) findViewById(R.id.MC_110_txt);
        mc110 = (RadioGroup) findViewById(R.id.MC_110);
        mc110_1 = (RadioButton) findViewById(R.id.MC_110_1);
        mc110_2 = (RadioButton) findViewById(R.id.MC_110_2);
        mc110_3 = (RadioButton) findViewById(R.id.MC_110_3);
        mc110_4 = (RadioButton) findViewById(R.id.MC_110_4);
        mc110_88 = (RadioButton) findViewById(R.id.MC_110_88);

        mc110x_txt = (TextView) findViewById(R.id.MC_110x_txt);
        mc110x = (EditText) findViewById(R.id.MC_110x);


        mc109.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != mc109_complete.getId()) {
                    mc110_txt.setVisibility(View.VISIBLE);
                    mc110.setVisibility(View.VISIBLE);
                } else {
                    mc110_txt.setVisibility(View.INVISIBLE);
                    mc110.setVisibility(View.INVISIBLE);
                }
            }
        });

        mc110.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc110_88.getId()) {
                    mc110x_txt.setVisibility(View.VISIBLE);
                    mc110x.setVisibility(View.VISIBLE);
                } else {
                    mc110x_txt.setVisibility(View.INVISIBLE);
                    mc110x.setVisibility(View.INVISIBLE);
                }
            }
        });


    }

    public void noInterview(View view) throws JSONException {

        mc109Selected = mc109.getCheckedRadioButtonId();
        mc110Selected = mc110.getCheckedRadioButtonId();
// Form Validation


        if (formValidation()) {
            StoreTempValues();
            Log.i(TAG, "Form Values Stored! Starting Interview... (S2)");
            Intent main_intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(main_intent);

        } else {
            Toast.makeText(getApplicationContext(), "Form Validation Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean formValidation() {
        if (mc109Selected == -1) {
            mc109_noQ.setError("Please select an answer!");
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();

            Log.d(TAG, "Error Type: 109");
            return false;
        }

        if (mc110Selected == -1) {
            mc110_88.setError("Please select an answer!");
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();


            Log.d(TAG, "Error Type: 110");
            return false;
        }


        if (mc110x.getText().toString().isEmpty() || mc110x.getText().toString() == null) {
            mc110x.setError("Specify other reason!");
            Toast.makeText(getApplicationContext(), "Specify other reason!", Toast.LENGTH_SHORT).show();

            Log.d(TAG, "Error Type: 110x");
            return false;
        }
        return true;
    }

    private void StoreTempValues() throws JSONException {

        SharedPreferences sharedPref = getSharedPreferences(formId, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();


        switch (mc109Selected) {
            case R.id.MC_109_complete:
                editor.putString("sp109", "1");
                break;
            case R.id.MC_109_incomplete:
                editor.putString("sp109", "2");
                break;
            case R.id.MC_109_noQ:
                editor.putString("sp109", "3");
                break;
        }

        switch (mc110Selected) {
            case R.id.MC_110_1:
                editor.putString("sp110", "1");
                break;
            case R.id.MC_110_2:
                editor.putString("sp110", "2");
                break;
            case R.id.MC_110_3:
                editor.putString("sp110", "3");
                break;
            case R.id.MC_110_4:
                editor.putString("sp110", "4");
                break;
            case R.id.MC_110_88:
                editor.putString("sp110", "88");
                break;
            default:
                editor.putString("sp110", "00");
                break;

        }
        editor.putString("sp110x", mc110x.getText().toString());

        // Comit to storage
        editor.commit();

        JSONObject ending = new JSONObject();
        Long newFormId;
        try {

            // Initialize JSON Object For Section 6
            ending.put("mc109", sharedPref.getString("sp109", "00"));
            ending.put("mc110", sharedPref.getString("sp110", "00"));


            Log.d(TAG, ending.toString());

            FormsContract.getInstance().setEnding(ending.toString());

            //FormsContract formContractS2 = new FormsContract(sharedPref.getString("spFrmNo", "00"), rowId, s2.toString());
            FormsDbHelper db = new FormsDbHelper(this);

            try {
                Log.d(TAG, "Updating DataBase...");
                Toast.makeText(this, "Updating DataBase...", Toast.LENGTH_SHORT).show();

                db.addForm(FormsContract.getInstance());
            } catch (SQLiteException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d(TAG, "Updated Form with Id: " + String.valueOf(newFormId));
        FormsContract.getInstance().Clear();


        JSONObject FormFull = new JSONObject();
        Map<String, ?> keys = sharedPref.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {


            FormFull.put(entry.getKey(), entry.getValue().toString());


        }





    }
}