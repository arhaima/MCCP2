package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class FillFormS6Activity extends AppCompatActivity {

    private static final String TAG = "FILL_FORM_S6_ACTIVITY";


    private String formId;
    private Integer chid = 0;


    private Spinner mc601;
    private RadioGroup mc602;
    private RadioButton mc602_yes;
    private RadioButton mc602_no;
    private int mc602selected;

    private CheckBox mc603_1;
    private CheckBox mc603_2;
    private CheckBox mc603_3;
    private CheckBox mc603_4;
    private CheckBox mc603_5;
    private EditText mc603_X1;
    private CheckBox mc604_1;
    private CheckBox mc604_2;
    private CheckBox mc604_3;
    private CheckBox mc604_4;
    private CheckBox mc604_5;
    private CheckBox mc604_6;
    private CheckBox mc604_7;
    private CheckBox mc604_8;
    private CheckBox mc604_9;
    private CheckBox mc604_88;
    private EditText mc604x;
    private CheckBox mc605_1;
    private CheckBox mc605_2;
    private CheckBox mc605_3;
    private CheckBox mc605_4;
    private CheckBox mc605_5;
    private EditText mc605x;
    private RadioGroup mc606;
    private RadioButton mc606_yes;
    private RadioButton mc606_no;
    private int mc606selected;

    private CheckBox mc607_1;
    private CheckBox mc607_2;
    private CheckBox mc607_3;
    private CheckBox mc607_4;
    private CheckBox mc607_5;
    private CheckBox mc607_6;
    private CheckBox mc607_7;
    private CheckBox mc607_88;
    private EditText mc607x;
    private RadioGroup mc607A;
    private RadioButton mc607A_yes;
    private RadioButton mc607A_no;
    private RadioButton mc607A_dontknow;
    private int mc607Aselected;

    private Spinner mc607B;
    private EditText mc607Bx;
    private CheckBox mc608M1;
    private CheckBox mc608M2;
    private CheckBox mc608M3;
    private CheckBox mc608M4;
    private CheckBox mc608M5;
    private Spinner mc609;
    private Spinner mc610;

    private String mc601selected;
    private String mc607Bselected;
    private String mc609selected;
    private String mc610selected;


    private LinearLayout fldGrp601;
    private LinearLayout fldGrp602;
    private LinearLayout fldGrp602b;
    private LinearLayout fldGrp606;
    private LinearLayout fldGrp607a;
    private LinearLayout fldGrp609;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form_s6);

        formId = getIntent().getStringExtra("formId");


        mc601 = (Spinner) findViewById(R.id.MC_601);
        mc602 = (RadioGroup) findViewById(R.id.MC_602);
        mc602_yes = (RadioButton) findViewById(R.id.MC_602_Yes);
        mc602_no = (RadioButton) findViewById(R.id.MC_602_No);

        mc603_1 = (CheckBox) findViewById(R.id.MC_603_1);
        mc603_2 = (CheckBox) findViewById(R.id.MC_603_2);
        mc603_3 = (CheckBox) findViewById(R.id.MC_603_3);
        mc603_4 = (CheckBox) findViewById(R.id.MC_603_4);
        mc603_5 = (CheckBox) findViewById(R.id.MC_603_5);
        mc603_X1 = (EditText) findViewById(R.id.MC_603_X1);
        mc604_1 = (CheckBox) findViewById(R.id.MC_604_1);
        mc604_2 = (CheckBox) findViewById(R.id.MC_604_2);
        mc604_3 = (CheckBox) findViewById(R.id.MC_604_3);
        mc604_4 = (CheckBox) findViewById(R.id.MC_604_4);
        mc604_5 = (CheckBox) findViewById(R.id.MC_604_5);
        mc604_6 = (CheckBox) findViewById(R.id.MC_604_6);
        mc604_7 = (CheckBox) findViewById(R.id.MC_604_7);
        mc604_8 = (CheckBox) findViewById(R.id.MC_604_8);
        mc604_9 = (CheckBox) findViewById(R.id.MC_604_9);
        mc604_88 = (CheckBox) findViewById(R.id.MC_604_88);
        mc604x = (EditText) findViewById(R.id.MC_604_X);
        mc605_1 = (CheckBox) findViewById(R.id.MC_605_1);
        mc605_2 = (CheckBox) findViewById(R.id.MC_605_2);
        mc605_3 = (CheckBox) findViewById(R.id.MC_605_3);
        mc605_4 = (CheckBox) findViewById(R.id.MC_605_4);
        mc605_5 = (CheckBox) findViewById(R.id.MC_605_5);
        mc605x = (EditText) findViewById(R.id.MC_605X);
        mc606 = (RadioGroup) findViewById(R.id.MC_606);
        mc606_yes = (RadioButton) findViewById(R.id.MC_606_Yes);
        mc606_no = (RadioButton) findViewById(R.id.MC_606_No);
        mc607_1 = (CheckBox) findViewById(R.id.MC_607_1);
        mc607_2 = (CheckBox) findViewById(R.id.MC_607_2);
        mc607_3 = (CheckBox) findViewById(R.id.MC_607_3);
        mc607_4 = (CheckBox) findViewById(R.id.MC_607_4);
        mc607_5 = (CheckBox) findViewById(R.id.MC_607_5);
        mc607_6 = (CheckBox) findViewById(R.id.MC_607_6);
        mc607_7 = (CheckBox) findViewById(R.id.MC_607_7);
        mc607_88 = (CheckBox) findViewById(R.id.MC_607_88);
        mc607x = (EditText) findViewById(R.id.MC_607X);
        mc607A = (RadioGroup) findViewById(R.id.MC_607A);
        mc607A_yes = (RadioButton) findViewById(R.id.MC_607A_Yes);
        mc607A_no = (RadioButton) findViewById(R.id.MC_607A_No);
        mc607A_dontknow = (RadioButton) findViewById(R.id.MC_607A_Dontknow);
        mc607B = (Spinner) findViewById(R.id.MC_607B);
        mc607Bx = (EditText) findViewById(R.id.MC_607BX);
        mc608M1 = (CheckBox) findViewById(R.id.MC_608_M1);
        mc608M2 = (CheckBox) findViewById(R.id.MC_608_M2);
        mc608M3 = (CheckBox) findViewById(R.id.MC_608_M3);
        mc608M4 = (CheckBox) findViewById(R.id.MC_608_M4);
        mc608M5 = (CheckBox) findViewById(R.id.MC_608_M5);
        mc609 = (Spinner) findViewById(R.id.MC_609);
        mc610 = (Spinner) findViewById(R.id.MC_610);

        fldGrp601 = (LinearLayout) findViewById(R.id.fldGrp601);
        fldGrp602 = (LinearLayout) findViewById(R.id.fldGrp602);
        fldGrp602b = (LinearLayout) findViewById(R.id.fldGrp602b);
        fldGrp606 = (LinearLayout) findViewById(R.id.fldGrp606);
        fldGrp607a = (LinearLayout) findViewById(R.id.fldGrp607a);
        fldGrp609 = (LinearLayout) findViewById(R.id.fldGrp609);

        // SKIP PATTERNS


        mc601.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String mc601selected = getResources().getStringArray(R.array.MC_YN_value)[mc601.getSelectedItemPosition()];
                if (mc601selected.equals("1")) {
                    fldGrp601.setVisibility(View.VISIBLE);
                } else {
                    fldGrp601.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Required by super class
            }


        });
        // For Q.602

        mc602.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc602_no.getId()) {
                    fldGrp602.setVisibility(View.VISIBLE);
                    fldGrp602b.setVisibility(View.GONE);

                } else {
                    fldGrp602b.setVisibility(View.VISIBLE);
                    fldGrp602.setVisibility(View.GONE);
                }
            }
        });

        mc606.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc606_yes.getId()) {
                    fldGrp606.setVisibility(View.GONE);
                } else {
                    fldGrp606.setVisibility(View.VISIBLE);
                }
            }
        });


        mc607A.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc607A_no.getId()) {
                    fldGrp607a.setVisibility(View.VISIBLE);
                } else {
                    fldGrp607a.setVisibility(View.GONE);
                }
            }
        });

        mc609.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String mc609selected = getResources().getStringArray(R.array.MC_YN_value)[mc609.getSelectedItemPosition()];
                if (mc609selected.equals("1")) {
                    fldGrp609.setVisibility(View.VISIBLE);
                } else {
                    fldGrp609.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Required by super class
            }


        });


    }

    public void openSectionCF(View view) {

        // Make changes to String according to Section.
        Toast.makeText(getApplicationContext(), "Processing Section 6...", Toast.LENGTH_SHORT).show();


        // Initializing All Spinner Selected values from Form-Fields-Arrays _value (NOT _list).
        mc601selected = getResources().getStringArray(R.array.MC_YN_value)[mc601.getSelectedItemPosition()];
        mc607Bselected = getResources().getStringArray(R.array.MC_607B_value)[mc607B.getSelectedItemPosition()];
        mc609selected = getResources().getStringArray(R.array.MC_YN_value)[mc609.getSelectedItemPosition()];
        mc610selected = getResources().getStringArray(R.array.MC_YN_value)[mc610.getSelectedItemPosition()];

        // Initializing All RadioButton Selected values from Form-Fields-Arrays _value (NOT _list).
        mc602selected = mc602.getCheckedRadioButtonId();
        mc606selected = mc606.getCheckedRadioButtonId();
        mc607Aselected = mc607A.getCheckedRadioButtonId();


        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();

            // Make Changes acording to Section.
            Intent CF_form_intent = new Intent(getApplicationContext(), FillFormS6CFActivity.class);
            CF_form_intent.putExtra("formId", formId);
            CF_form_intent.putExtra("chid", chid);

            // Additional Variables For Next Section (if any)
            // Start Next Section
            startActivity(CF_form_intent);
        } else {
            Toast.makeText(getApplicationContext(), "Form Validation Failed!", Toast.LENGTH_SHORT).show();


        }

    }

    private void StoreTempValues() {

        Toast.makeText(getApplicationContext(), "Storing Temporary Form Values...", Toast.LENGTH_SHORT).show();


        SharedPreferences sharedPref = getSharedPreferences(FillFormActivity.FORM_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Value Selection for Spinners


        // Selected value of RadioGroups


        // Putting values of CheckBoxes

        editor.putString("sp603_1", (mc603_1.isChecked() ? "1" : ""));
        editor.putString("sp603_2", (mc603_2.isChecked() ? "2" : ""));
        editor.putString("sp603_3", (mc603_3.isChecked() ? "3" : ""));
        editor.putString("sp603_4", (mc603_4.isChecked() ? "4" : ""));
        editor.putString("sp603_5", (mc603_5.isChecked() ? "5" : ""));

        editor.putString("sp604_1", (mc604_1.isChecked() ? "1" : ""));
        editor.putString("sp604_2", (mc604_2.isChecked() ? "2" : ""));
        editor.putString("sp604_3", (mc604_3.isChecked() ? "3" : ""));
        editor.putString("sp604_4", (mc604_4.isChecked() ? "4" : ""));
        editor.putString("sp604_5", (mc604_5.isChecked() ? "5" : ""));
        editor.putString("sp604_6", (mc604_6.isChecked() ? "6" : ""));
        editor.putString("sp604_7", (mc604_7.isChecked() ? "7" : ""));
        editor.putString("sp604_8", (mc604_8.isChecked() ? "8" : ""));
        editor.putString("sp604_9", (mc604_9.isChecked() ? "9" : ""));
        editor.putString("sp604_88", (mc604_88.isChecked() ? "88" : ""));

        editor.putString("sp605_1", (mc605_1.isChecked() ? "1" : ""));
        editor.putString("sp605_2", (mc605_2.isChecked() ? "2" : ""));
        editor.putString("sp605_3", (mc605_3.isChecked() ? "3" : ""));
        editor.putString("sp605_4", (mc605_4.isChecked() ? "4" : ""));
        editor.putString("sp605_5", (mc605_5.isChecked() ? "5" : ""));

        editor.putString("sp607_1", (mc607_1.isChecked() ? "1" : ""));
        editor.putString("sp607_2", (mc607_2.isChecked() ? "2" : ""));
        editor.putString("sp607_3", (mc607_3.isChecked() ? "3" : ""));
        editor.putString("sp607_4", (mc607_4.isChecked() ? "4" : ""));
        editor.putString("sp607_5", (mc607_5.isChecked() ? "5" : ""));
        editor.putString("sp607_6", (mc607_6.isChecked() ? "6" : ""));
        editor.putString("sp607_7", (mc607_7.isChecked() ? "7" : ""));
        editor.putString("sp607_88", (mc607_88.isChecked() ? "88" : ""));

        editor.putString("sp608_m1", (mc608M1.isChecked() ? "1" : ""));
        editor.putString("sp608_m2", (mc608M2.isChecked() ? "2" : ""));
        editor.putString("sp608_m3", (mc608M3.isChecked() ? "3" : ""));
        editor.putString("sp608_m4", (mc608M4.isChecked() ? "4" : ""));
        editor.putString("sp608_m5", (mc608M5.isChecked() ? "5" : ""));


        // Initialising SharedPreference for temporary storage


        // -- RadioGroups
        switch (mc602selected) {
            case R.id.MC_602_No:
                editor.putString("sp602", "2");
                break;
            case R.id.MC_602_Yes:
                editor.putString("sp602", "1");
                break;
            default:
                editor.putString("sp602", "00");
                break;
        }

        switch (mc606selected) {
            case R.id.MC_606_No:
                editor.putString("sp606", "2");
                break;
            case R.id.MC_606_Yes:
                editor.putString("sp606", "1");
                break;
            case R.id.MC_606_Dontknow:
                editor.putString("sp606", "99");
                break;
            default:
                editor.putString("sp606", "00");
                break;
        }


        switch (mc607Aselected) {
            case R.id.MC_607A_No:
                editor.putString("sp607a", "2");
                break;
            case R.id.MC_607A_Yes:
                editor.putString("sp607a", "1");
                break;
            case R.id.MC_607A_Dontknow:
                editor.putString("sp607a", "99");
                break;
            default:
                editor.putString("sp607a", "00");
                break;
        }



        //Putting values for spinner
        editor.putString("sp601", mc601selected.toString());
        editor.putString("sp607b", mc607Bselected.toString());
        editor.putString("sp609", mc609selected.toString());
        editor.putString("sp610", mc610selected.toString());

        //Putting values for EditText

        editor.putString("sp603x1", mc603_X1.getText().toString());
        editor.putString("sp604x", mc604x.getText().toString());
        editor.putString("sp605x", mc605x.getText().toString());
        editor.putString("sp607x", mc607x.getText().toString());
        editor.putString("sp607bx", mc607Bx.getText().toString());


        editor.apply();
        Log.d(TAG, "Stored sharedValues.");

        JSONObject S6 = new JSONObject();
        long newFormId = 0;
        try {

            // Initialize JSON Object For Section 6
            S6.put("mc601", sharedPref.getString("sp601", "00"));
            S6.put("mc602", sharedPref.getString("sp602", "00"));
            S6.put("mc603_1", sharedPref.getString("sp603_1", "00"));
            S6.put("mc603_2", sharedPref.getString("sp603_2", "00"));
            S6.put("mc603_3", sharedPref.getString("sp603_3", "00"));
            S6.put("mc603_4", sharedPref.getString("sp603_4", "00"));
            S6.put("mc603_5", sharedPref.getString("sp603_5", "00"));
            S6.put("mc603x1", sharedPref.getString("sp603x1", "00"));
            S6.put("mc604_1", sharedPref.getString("sp604_1", "00"));
            S6.put("mc604_2", sharedPref.getString("sp604_2", "00"));
            S6.put("mc604_3", sharedPref.getString("sp604_3", "00"));
            S6.put("mc604_4", sharedPref.getString("sp604_4", "00"));
            S6.put("mc604_5", sharedPref.getString("sp604_5", "00"));
            S6.put("mc604_6", sharedPref.getString("sp604_6", "00"));
            S6.put("mc604_7", sharedPref.getString("sp604_7", "00"));
            S6.put("mc604_8", sharedPref.getString("sp604_8", "00"));
            S6.put("mc604_9", sharedPref.getString("sp604_9", "00"));
            S6.put("mc604_10", sharedPref.getString("sp604_10", "00"));
            S6.put("mc604_11", sharedPref.getString("sp604_11", "00"));
            S6.put("mc604_12", sharedPref.getString("sp604_12", "00"));
            S6.put("mc604x", sharedPref.getString("sp604x", "00"));
            S6.put("mc605_1", sharedPref.getString("sp605_1", "00"));
            S6.put("mc605_2", sharedPref.getString("sp605_2", "00"));
            S6.put("mc605_3", sharedPref.getString("sp605_3", "00"));
            S6.put("mc605_4", sharedPref.getString("sp605_4", "00"));
            S6.put("mc605_5", sharedPref.getString("sp605_5", "00"));
            S6.put("mc605x", sharedPref.getString("sp605x", "00"));

            S6.put("mc606", sharedPref.getString("sp606", "00"));
            S6.put("mc607_1", sharedPref.getString("sp607_1", "00"));
            S6.put("mc607_2", sharedPref.getString("sp607_2", "00"));
            S6.put("mc607_3", sharedPref.getString("sp607_3", "00"));
            S6.put("mc607_4", sharedPref.getString("sp607_4", "00"));
            S6.put("mc607_5", sharedPref.getString("sp607_5", "00"));
            S6.put("mc607_6", sharedPref.getString("sp607_6", "00"));
            S6.put("mc607_7", sharedPref.getString("sp607_7", "00"));
            S6.put("mc607_88", sharedPref.getString("sp607_88", "00"));
            S6.put("mc607x", sharedPref.getString("sp607x", "00"));
            S6.put("mc607a", sharedPref.getString("sp607a", "00"));
            S6.put("mc607b", sharedPref.getString("sp607b", "00"));
            S6.put("mc608_m1", sharedPref.getString("sp608_m1", "00"));
            S6.put("mc608_m2", sharedPref.getString("sp608_m2", "00"));
            S6.put("mc608_m3", sharedPref.getString("sp608_m3", "00"));
            S6.put("mc608_m4", sharedPref.getString("sp608_m4", "00"));
            S6.put("mc608_m5", sharedPref.getString("sp608_m5", "00"));
            S6.put("mc609", sharedPref.getString("sp609", "00"));
            S6.put("mc610", sharedPref.getString("sp610", "00"));


            Log.d(TAG, S6.toString());

            FormsContract.getInstance().setS6(S6.toString());

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
        Log.d(TAG, "Updated Form with Id: " + String.valueOf(newFormId));


    }

    private boolean formValidation() {
        Toast.makeText(getApplicationContext(), "Validating Form Values...", Toast.LENGTH_SHORT).show();


        // Field By Field Verification


        // -- Check at least one RadioButton selected (-1 = None Selected)
        if (mc601.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc601.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 601 empty");
            return false;
        }
        
        if (mc602selected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc602_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 602 not selected");
            return false;
        }

        if (mc602selected == 1) {
            if (mc606selected == -1) {
                Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
                mc606_no.setError("Please select an answer!");
                Log.d(TAG, "Error Type: 606 not selected");
                return false;
            }


            if (mc607Aselected == -1) {
                Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
                mc607A_no.setError("Please select an answer!");
                Log.d(TAG, "Error Type: 607A not selected");
                return false;
            }
            if (mc607A_no.isChecked() && mc607B.getSelectedItemPosition() == 0) {
                TextView errorText = (TextView) mc607B.getSelectedView();
                errorText.setError("anything here, just to add the icon");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Please select an answer");//changes the selected item text to this
                Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Error Type: 607B empty");
                return false;
            }
            if (mc609.getSelectedItemPosition() == 0) {
                TextView errorText = (TextView) mc609.getSelectedView();
                errorText.setError("anything here, just to add the icon");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Please select an answer");//changes the selected item text to this
                Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Error Type: 609 empty");
                return false;
            }
            if (mc609.getSelectedItemPosition() == 1 && mc610.getSelectedItemPosition() == 0) {
                TextView errorText = (TextView) mc610.getSelectedView();
                errorText.setError("anything here, just to add the icon");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Please select an answer");//changes the selected item text to this
                Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
                Log.d(TAG, "Error Type: 610 empty");
                return false;
            }
            return true;
        }


      /*  if (mc609selected.equals(null))
        {
            Toast.makeText(getApplicationContext(), "Please select correct option", Toast.LENGTH_SHORT).show();
            TextView errorText = (TextView) mc609.getSelectedView();
            errorText.setError(" ");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select correct option");//changes the selected item text to this
            return false;
        }


        if (mc610selected.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc610_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 610 not selected");
            return false;
        }*/

        // Return from fromValidation()
        return true;
    }
}
