package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FillFormS6CFActivity extends AppCompatActivity {

    private static final String TAG = "FILL_FORM_CF_ACTIVITY";
    public static List<String> CF_chids = new ArrayList<String>();
    public static JSONObject CF;
    public static JSONObject JsonCF;
    private static Integer CF_CHID;
    public Integer CF_chid_no;
    public String cfchid;
    private String formId;
    private String CF_FRMNO = FillFormActivity.FORM_ID;
    private String CF_COMPID;
    private CheckBox CF_Q1;
    private CheckBox CF_Q2;
    private CheckBox CF_Q2_1;
    private CheckBox CF_Q2_2;
    private CheckBox CF_Q2_3;
    private CheckBox CF_Q2_4;
    private CheckBox CF_Q2_5;
    private CheckBox CF_Q2_6;
    private CheckBox CF_Q3;
    private CheckBox CF_Q4;

    private LinearLayout fldGrp606_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form_s6_cf);
        if (getIntent().getStringExtra("formId") == null) {
            formId = "NNNNNNN";

        } else {
            formId = getIntent().getStringExtra("formId");
        }

        if (FillFormS6CFActivity.CF_CHID == null) {
            FillFormS6CFActivity.CF_CHID = 1;
        } else {
            FillFormS6CFActivity.CF_CHID++;
        }
        /*if (getIntent().getStringExtra("CF_CHID").isEmpty()) {
            FillFormS6CFActivity.CF_CHID = 1;
        } else {
            FillFormS6CFActivity.CF_CHID = Integer.valueOf(getIntent().getStringExtra("CF_CHID"))+1;
        }*/
        Log.d(TAG, String.valueOf(FillFormS6CFActivity.CF_CHID));
        CF_Q1 = (CheckBox) findViewById(R.id.CF_Q1);
        CF_Q2 = (CheckBox) findViewById(R.id.CF_Q2);
        CF_Q2_1 = (CheckBox) findViewById(R.id.CF_Q2_1);
        CF_Q2_2 = (CheckBox) findViewById(R.id.CF_Q2_2);
        CF_Q2_3 = (CheckBox) findViewById(R.id.CF_Q2_3);
        CF_Q2_4 = (CheckBox) findViewById(R.id.CF_Q2_4);
        CF_Q2_5 = (CheckBox) findViewById(R.id.CF_Q2_5);
        CF_Q2_6 = (CheckBox) findViewById(R.id.CF_Q2_6);
        CF_Q3 = (CheckBox) findViewById(R.id.CF_Q3);
        CF_Q4 = (CheckBox) findViewById(R.id.CF_Q4);

        fldGrp606_2 = (LinearLayout) findViewById(R.id.fldGrp606_2);

        CF_Q2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CF_Q2.isChecked()) {
                    Log.d(TAG, "Here");
                    fldGrp606_2.setVisibility(View.VISIBLE);
                } else {
                    Log.d(TAG, "There");
                    fldGrp606_2.setVisibility(View.GONE);
                }
            }
        });


    }

    public void startFormCF(View view) {

        // Make changes to String according to Section.
        Toast.makeText(getApplicationContext(), "Processing Section CF...", Toast.LENGTH_SHORT).show();


        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();

            // Make Changes according to Section.
            Intent end_form_intent = new Intent(getApplicationContext(), EndFormActivity.class);
            end_form_intent.putExtra("formId", formId);

            // Additional Variables For Next Section (if any)
            // Start Next Section
            startActivity(end_form_intent);
        } else {
            Toast.makeText(getApplicationContext(), "Form Validation Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void openSection6(View view) {

        // Make changes to String according to Section.
        Toast.makeText(getApplicationContext(), "Processing Section CF...", Toast.LENGTH_SHORT).show();
        if (CF_Q1.isChecked() || CF_Q2.isChecked() || CF_Q3.isChecked() || CF_Q4.isChecked()) {

            if (formValidation()) {
                Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

                StoreTempValues();

                // Make Changes acording to Section.
                Intent end_form_intent = new Intent(getApplicationContext(), FillFormS6CFActivity.class);
                end_form_intent.putExtra("formId", formId);
                end_form_intent.putExtra("CF_CHID", FillFormS6CFActivity.CF_CHID);

                // Additional Variables For Next Section (if any)
                // Start Next Section
                startActivity(end_form_intent);
            } else {
                Toast.makeText(getApplicationContext(), "Form Validation Failed!", Toast.LENGTH_SHORT).show();


            }
        } else {
            Intent end_form_intent = new Intent(getApplicationContext(), FillFormS6CFActivity.class);
            end_form_intent.putExtra("formId", formId);

            // Additional Variables For Next Section (if any)
            // Start Next Section
            startActivity(end_form_intent);
        }

    }

    // End Interview Form 1 - Section 1
    public void endInterview(View view) {
        Log.d(TAG, "endInterview");
        Toast.makeText(getApplicationContext(), "Starting End of Form Section... ", Toast.LENGTH_SHORT).show();

    /*    FORM_ID = mc106hhno.getText().toString() + "-" + mcExt.getSelectedItem().toString();
        spDateT = DateFormat.getDateInstance().format(mc101date.getCalendarView().getDate());
        spTimeT = mc101time.getCurrentHour() + ":" + mc101time.getCurrentMinute();*/

        // Form Validation - Section 1

        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation...Successful!", Toast.LENGTH_SHORT).show();
            StoreTempValues();
            Intent end_form_intent = new Intent(getApplicationContext(), EndFormActivity.class);
/*
            end_form_intent.putExtra("frmNoId", GenerateFormId());
*/
            startActivity(end_form_intent);

        } else {
            Toast.makeText(getApplicationContext(), "Form Validation...Failed!", Toast.LENGTH_SHORT).show();

          /*  formError = false;
            formErrorTxt.setText("Please remove all errors to continue!");
            formErrorTxt.setVisibility(View.VISIBLE);*/

        }

    }

    private void StoreTempValues() {

        Toast.makeText(getApplicationContext(), "Storing Temporary Form Values...", Toast.LENGTH_SHORT).show();
        cfchid = formId + String.format("%02d", CF_CHID);

        CF_chids.add(cfchid);

        SharedPreferences sharedPref = getSharedPreferences("CF_" + cfchid, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Value Selection for Spinners


        // Selected value of RadioGroups


        // Putting values of CheckBoxes

        editor.putString("spcf_FrmNo", cfchid);
        editor.putString("spFrmNo", FillFormActivity.mcFrmNo);
        editor.putString("spcf_Chid", String.valueOf(CF_CHID));
        editor.putString("spcf_Q1", (CF_Q1.isChecked() ? "1" : ""));
        editor.putString("spcf_Q2", (CF_Q2.isChecked() ? "2" : ""));
        editor.putString("spcf_Q2_1", (CF_Q2_1.isChecked() ? "1" : ""));
        editor.putString("spcf_Q2_2", (CF_Q2_2.isChecked() ? "2" : ""));
        editor.putString("spcf_Q2_3", (CF_Q2_3.isChecked() ? "3" : ""));
        editor.putString("spcf_Q2_4", (CF_Q2_4.isChecked() ? "4" : ""));
        editor.putString("spcf_Q2_5", (CF_Q2_5.isChecked() ? "5" : ""));
        editor.putString("spcf_Q2_6", (CF_Q2_6.isChecked() ? "6" : ""));
        editor.putString("spcf_Q3", (CF_Q3.isChecked() ? "3" : ""));
        editor.putString("spcf_Q4", (CF_Q4.isChecked() ? "4" : ""));
        editor.putString("spcfDeviceID", Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));


        editor.apply();
        Log.d(TAG, "Stored sharedValues.");

        CF = new JSONObject();
        JsonCF = new JSONObject();
        long newFormId = 0;
        try {
            CF.put("chid", sharedPref.getString("spcf_Q1", "00"));
            CF.put("cfFrmNo", sharedPref.getString("spcf_FrmNo", "00"));

            // Initialize JSON Object For Section 6
            JsonCF.put("cfChid", sharedPref.getString("spcf_Chid", "00"));
            JsonCF.put("cf_Q1", sharedPref.getString("spcf_Q1", "00"));
            JsonCF.put("cf_Q2", sharedPref.getString("spcf_Q2", "00"));
            JsonCF.put("cf_Q2_1", sharedPref.getString("spcf_Q2_1", "00"));
            JsonCF.put("cf_Q2_2", sharedPref.getString("spcf_Q2_2", "00"));
            JsonCF.put("cf_Q2_3", sharedPref.getString("spcf_Q2_3", "00"));
            JsonCF.put("cf_Q2_4", sharedPref.getString("spcf_Q2_4", "00"));
            JsonCF.put("cf_Q2_5", sharedPref.getString("spcf_Q2_5", "00"));
            JsonCF.put("cf_Q2_6", sharedPref.getString("spcf_Q2_6", "00"));
            JsonCF.put("cf_Q3", sharedPref.getString("spcf_Q3", "00"));
            JsonCF.put("cf_Q4", sharedPref.getString("spcf_Q4", "00"));
            JsonCF.put("cfDeviceID", sharedPref.getString("spcfDeviceID", "00"));
            CF.put("cf", JsonCF);

            Log.d(TAG, CF.toString());
            /*FormsContract formContractS2 = new FormsContract(sharedPref.getString("spFrmNo", "00"), rowId, s2.toString());
            FormsDbHelper db = new FormsDbHelper(this);

            try {
                Log.d(TAG, "Updating Section 2 of the Form to DB...");
                newFormId = db.updateForm(formContractS2);
            } catch (SQLiteException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d(TAG, "Updated Form with Id: " + String.valueOf(newFormId));


    }

    private boolean formValidation() {

        if (CF_Q2.isChecked() && !(CF_Q2_1.isChecked()
                || CF_Q2_2.isChecked()
                || CF_Q2_3.isChecked()
                || CF_Q2_4.isChecked()
                || CF_Q2_5.isChecked()
                || CF_Q2_6.isChecked()
        )
                ) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            CF_Q2_6.setError("Please select an answer!");
            Log.d(TAG, "Error Type: CF_Q2_6 not selected");
            return false;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Button NOT Allowed!", Toast.LENGTH_SHORT).show();
    }

}
