package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class FillFormS2Activity extends AppCompatActivity {

    // Section 2 Field Variables
    public static String FORM_ID;
    public static boolean gndrChk;

    // Activity Variables
    private final String TAG = "FILL_FORM_S2_ACTIVITY";
    private final Integer AGE_LIMIT = 16;
    private final Integer MONTH_LIMIT = 10;
    private final Integer WEEK_LIMIT = 42;
    public JSONObject S2;
    private String mcFrmNo;
    private EditText mc201nm;
    private Spinner mc201gndr;
    private Spinner mc201type;
    private TextView mc201type_error;
    private EditText mc201age;
    private EditText mc201edu;
    private Spinner mc201ocu;
    private EditText mc202nm;
    private Spinner mc202gndr;
    private EditText mc202age;
    private EditText mc202edu;
    private Spinner mc202ocu;
    private EditText mc203tot;
    private EditText mc203m;
    private EditText mc203f;
    private EditText mc204t;
    private EditText mc204m;
    private EditText mc204f;
    private EditText mc205yy;
    private EditText mc205mm;
    private RadioGroup mc206;
    private RadioButton mc206_yes;
    private RadioButton mc206_no;
    private int mc206selected;
    private EditText mc2071w;
    private EditText mc2071m;
    private EditText mc2072w;
    private EditText mc2072m;
    private EditText mc2073w;
    private EditText mc2073m;
    private LinearLayout mc207;

    // Variable declarations for All Spinner Selected Values
    private String mc201typeSelected;
    private String mc201ocuSelected;
    private String mc202ocuSelected;

    // Form Variables
    private String formId;
    private String rowId;


    // onCreate Function for Form S2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form_s2);

        // Initializing From Variables
        formId = getIntent().getStringExtra("formId");


        Log.d(TAG, "Form Id: " + formId);

        // Initializing Form Field Variables with layout field IDs
        mc201nm = (EditText) findViewById(R.id.MC_201NM);
        mc201gndr = (Spinner) findViewById(R.id.MC_201GNDR);
        mc201type = (Spinner) findViewById(R.id.MC_201TYPE);
        mc201type_error = (TextView) findViewById(R.id.MC_201type_error);
        mc201age = (EditText) findViewById(R.id.MC_201AGE);
        mc201edu = (EditText) findViewById(R.id.MC_201EDU);
        mc201ocu = (Spinner) findViewById(R.id.MC_201OCU);
        mc202nm = (EditText) findViewById(R.id.MC_202NM);
        mc202gndr = (Spinner) findViewById(R.id.MC_202GNDR);
        mc202age = (EditText) findViewById(R.id.MC_202AGE);
        mc202edu = (EditText) findViewById(R.id.MC_202EDU);
        mc202ocu = (Spinner) findViewById(R.id.MC_202OCU);
        mc203tot = (EditText) findViewById(R.id.MC_203TOT);
        mc203m = (EditText) findViewById(R.id.MC_203M);
        mc203f = (EditText) findViewById(R.id.MC_203F);
        mc204t = (EditText) findViewById(R.id.MC_204T);
        mc204m = (EditText) findViewById(R.id.MC_204M);
        mc204f = (EditText) findViewById(R.id.MC_204F);
        mc205yy = (EditText) findViewById(R.id.MC_205YY);
        mc205mm = (EditText) findViewById(R.id.MC_205MM);
        mc206 = (RadioGroup) findViewById(R.id.MC_206);
        mc206_yes = (RadioButton) findViewById(R.id.MC_206_Yes);
        mc206_no = (RadioButton) findViewById(R.id.MC_206_No);
        mc206selected = mc206.getCheckedRadioButtonId();
        mc2071w = (EditText) findViewById(R.id.MC_207_1W);
        mc2071m = (EditText) findViewById(R.id.MC_207_1M);
        mc2072w = (EditText) findViewById(R.id.MC_207_2W);
        mc2072m = (EditText) findViewById(R.id.MC_207_2M);
        mc2073w = (EditText) findViewById(R.id.MC_207_3W);
        mc2073m = (EditText) findViewById(R.id.MC_207_3M);
        mc207 = (LinearLayout) findViewById(R.id.MC_207);


        // Validation for age of Respondent (MIN_AGE_LIMIT = 18)
        mc201age.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int age201 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc201age.getText().toString().isEmpty()) {
                        age201 = Integer.valueOf(mc201age.getText().toString());
                    }
                    if (age201 < AGE_LIMIT) {
                        mc201age.setError("Too Young for Interview!");
                    } else {
                        mc201age.setError(null);

                    }
                }
            }
        });


        // Validation for Education of Respondent
        mc201edu.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            int edu201 = 0;
            int age201 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc201age.getText().toString().isEmpty()) {
                        age201 = Integer.valueOf(mc201age.getText().toString());
                    }
                    if (!mc201edu.getText().toString().isEmpty()) {
                        edu201 = Integer.valueOf(mc201edu.getText().toString());
                    }
                    if (edu201 > age201 - 5 && edu201 != 77) {
                        mc201edu.setError("Education does not match Age.");

                    } else {
                        mc201age.setError(null);

                    }
                }
            }
        });

        // Validation for age of HH Head (MIN_AGE_LIMIT = 18)
        mc202age.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int age202 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc202age.getText().toString().isEmpty()) {
                        age202 = Integer.valueOf(mc202age.getText().toString());
                    }
                    if (age202 < AGE_LIMIT) {
                        mc202age.setError("Too Young for Interview!");


                    } else {
                        mc202age.setError(null);


                    }
                }
            }
        });

        // Validation for Education of HH Head
        mc202edu.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int edu202 = 0;
            int age202 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc202edu.getText().toString().isEmpty()) {
                        edu202 = Integer.valueOf(mc202edu.getText().toString());
                    }
                    if (!mc202age.getText().toString().isEmpty()) {
                        age202 = Integer.valueOf(mc202age.getText().toString());
                    }
                    if (edu202 > age202 - 5 && edu202 != 77) {
                        mc202edu.setError("Education does not match Age.");

                    } else {
                        mc202age.setError(null);


                    }
                }
            }
        });


        // Checking Total number of HH members against 203M+203F
        mc203m.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int m203 = 0;
            int f203 = 0;
            int t203 = 0;
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc203m.getText().toString().isEmpty()) {
                        m203 = Integer.valueOf(mc203m.getText().toString());
                    }
                    if (!mc203f.getText().toString().isEmpty()) {
                        f203 = Integer.valueOf(mc203f.getText().toString());
                    }
                    if (!mc203f.getText().toString().isEmpty() && !mc203m.getText().toString().isEmpty() && !mc203tot.getText().toString().isEmpty()) {
                        if ((m203 + f203) != Integer.valueOf(mc203tot.getText().toString())) {
                            mc203tot.setError("Total do not match!");
                        }
                    }
                    
                }
            }
        });

        mc204m.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int m204 = 0;
            int f204 = 0;
            int t204 = 0;
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc204m.getText().toString().isEmpty()) {
                        m204 = Integer.valueOf(mc204m.getText().toString());
                    }
                    if (!mc204f.getText().toString().isEmpty()) {
                        f204 = Integer.valueOf(mc204f.getText().toString());
                    }
                    if (!mc204f.getText().toString().isEmpty() && !mc204m.getText().toString().isEmpty() && !mc204t.getText().toString().isEmpty()) {
                        if ((m204 + f204) != Integer.valueOf(mc204t.getText().toString())) {
                            mc204t.setError("Total do not match!");
                        }
                    }

                }
            }
        });


        // SKIP PATTERNS

        // For Q.206 
        mc206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc206_yes.getId()) {
                    mc207.setVisibility(View.VISIBLE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mc207.getWindowToken(), 0);
                } else {
                    mc207.setVisibility(View.GONE);
                }
            }
        });


    }

    public void openMap(View view) {
        Intent map_intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(map_intent);

    }

    public void startFormS3(View view) {

        // Make changes to String according to Section.
        Toast.makeText(getApplicationContext(), "Processing Section 2...", Toast.LENGTH_SHORT).show();


        // Initializing All Spinner Selected values from Form-Fields-Arrays _value (NOT _list). 
        mc201typeSelected = getResources().getStringArray(R.array.MC_201TYPE_list)[mc201type.getSelectedItemPosition()];
        mc201ocuSelected = getResources().getStringArray(R.array.MC_OCU_value)[mc201ocu.getSelectedItemPosition()];
        mc202ocuSelected = getResources().getStringArray(R.array.MC_OCU_value)[mc202ocu.getSelectedItemPosition()];

        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();

            gndrChk = false;
            // Make Changes acording to Section.
            Intent s2_form_intent = new Intent(getApplicationContext(), FillFormS3Activity.class);
            s2_form_intent.putExtra("formId", formId);

            // Additional Variables For Next Section (if any) 
            s2_form_intent.putExtra("boyCount", mc204m.getText().toString());
            s2_form_intent.putExtra("girlCount", mc204f.getText().toString());

            // Start Next Section
            startActivity(s2_form_intent);
        } else {
            Toast.makeText(getApplicationContext(), "Form Validation Failed!" + mcFrmNo, Toast.LENGTH_SHORT).show();


        }

    }


    private void StoreTempValues() {

        Toast.makeText(getApplicationContext(), "Storing Temporary Form Values...", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences(FillFormActivity.FORM_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Value Selection for Spinners


        // Selected value of RadioGroups
        mc206selected = mc206.getCheckedRadioButtonId();

        // Initialising SharedPreference for temporary storage

        // -- EditText & Spinners
        editor.putString("sp201nm", mc201nm.getText().toString());  // EditText Respondent's Name
        editor.putString("sp201age", mc201age.getText().toString()); // EditText Respondent's Age
        editor.putString("sp201gndr", mc201gndr.getSelectedItem().toString()); // Spinner Respondent's Gender
        editor.putString("sp201type", mc201typeSelected.toString()); // Spinner with No _value Respondent's Type (Mother/CareTaker)
        editor.putString("sp201ocu", mc201ocuSelected.toString()); // Spinner Respondent's Occupation
        editor.putString("sp201edu", mc201edu.getText().toString()); // EditText Respondent's Education
        editor.putString("sp202nm", mc202nm.getText().toString());  // EditText House Head's Name
        editor.putString("sp202age", mc202age.getText().toString()); // EditText House Head's Age
        editor.putString("sp202gndr", mc202gndr.getSelectedItem().toString()); // Spinner with no _value House Head's Gender
        editor.putString("sp202edu", mc202edu.getText().toString()); // EditText House Head's Type (Mother/CareTaker)
        editor.putString("sp202ocu", mc202ocuSelected.toString()); // Spinner Respondent's Occupation
        editor.putString("sp203tot", mc203tot.getText().toString()); // EditText Total members
        editor.putString("sp203m", mc203m.getText().toString()); // EditText Male members
        editor.putString("sp203f", mc203f.getText().toString()); // EditText Female members
        editor.putString("sp204t", mc204t.getText().toString()); // EditText Total Children
        editor.putString("sp204m", mc204m.getText().toString()); // EditText Boys count
        editor.putString("sp204f", mc204f.getText().toString()); // EditText Girls count
        editor.putString("sp205mm", mc205mm.getText().toString()); // EditText Living Duration
        editor.putString("sp205yy", mc205yy.getText().toString()); // EditText Living Duration
        editor.putString("sp205yy", mc205yy.getText().toString()); // EditText Living Duration
        editor.putString("sp2071w", mc2071w.getText().toString()); // EditText Living Duration
        editor.putString("sp2071m", mc2071m.getText().toString()); // EditText Living Duration
        editor.putString("sp2072w", mc2072w.getText().toString()); // EditText Living Duration
        editor.putString("sp2072m", mc2072m.getText().toString()); // EditText Living Duration
        editor.putString("sp2073w", mc2073w.getText().toString()); // EditText Living Duration
        editor.putString("sp2073m", mc2073m.getText().toString()); // EditText Living Duration

        // -- RadioGroups
        switch (mc206selected) {
            case R.id.MC_206_No:
                editor.putString("sp206", "2");
                break;
            case R.id.MC_206_Yes:
                editor.putString("sp206", "1");
                break;
            default:
                editor.putString("sp206", "00");
                break;
        }

        editor.apply();
        Log.d(TAG, "Stored sharedValues.");


        long newFormId = 0;
        try {

            S2 = new JSONObject();
            // Initialize JSON Object For Section 2
            S2.put("mc201nm", sharedPref.getString("sp201nm", "00"));
            S2.put("mc201gndr", sharedPref.getString("sp201gndr", "00"));
            S2.put("mc201type", sharedPref.getString("sp201type", "00"));
            S2.put("mc201age", sharedPref.getString("sp201age", "00"));
            S2.put("mc201edu", sharedPref.getString("sp201edu", "00"));
            S2.put("mc201ocu", sharedPref.getString("sp201ocu", "00"));
            S2.put("mc202nm", sharedPref.getString("sp202nm", "00"));
            S2.put("mc202gndr", sharedPref.getString("sp202gndr", "00"));
            S2.put("mc202age", sharedPref.getString("sp202age", "00"));
            S2.put("mc202edu", sharedPref.getString("sp202edu", "00"));
            S2.put("mc202ocu", sharedPref.getString("sp202ocu", "00"));
            S2.put("mc203tot", sharedPref.getString("sp203tot", "00"));
            S2.put("mc203m", sharedPref.getString("sp203m", "00"));
            S2.put("mc203f", sharedPref.getString("sp203f", "00"));
            S2.put("mc204t", sharedPref.getString("sp204t", "00"));
            S2.put("mc204m", sharedPref.getString("sp204m", "00"));
            S2.put("mc204f", sharedPref.getString("sp204f", "00"));
            S2.put("mc205mm", sharedPref.getString("sp205mm", "00"));
            S2.put("mc205yy", sharedPref.getString("sp205yy", "00"));
            S2.put("mc206", sharedPref.getString("sp206", "00"));
            S2.put("mc2071w", sharedPref.getString("sp2071w", "00"));
            S2.put("mc2071m", sharedPref.getString("sp2071m", "00"));
            S2.put("mc2072w", sharedPref.getString("sp2072w", "00"));
            S2.put("mc2072m", sharedPref.getString("sp2072m", "00"));
            S2.put("mc2073w", sharedPref.getString("sp2073w", "00"));
            S2.put("mc2073m", sharedPref.getString("sp2073m", "00"));

            Log.d(TAG, S2.toString());

            FormsContract.getInstance().setS2(S2.toString());

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
        // 201name EditText
        if (mc201nm.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Name is Empty...", Toast.LENGTH_SHORT).show();
            mc201nm.setError("Name not Given!");
            Log.d(TAG, "Error Type: 201nm  missing");
            return false;
        } else {
            mc201nm.setError(null);
        }
        if (mc201gndr.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc201gndr.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select a Gender");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Gender.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 201gndr mismatch");
            return false;
        }

        if (mc202gndr.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc202gndr.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select a Gender");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Gender.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 202gndr mismatch");
            return false;
        }


        // 201Gender Spinner
        if (mc201gndr.getSelectedItem().toString().equals("Male") && mc201ocuSelected.toString().equals("1")) {
            Toast.makeText(getApplicationContext(), "Please select correct Profession Type.", Toast.LENGTH_SHORT).show();
            TextView errorText = (TextView) mc201ocu.getSelectedView();
            errorText.setError(" ");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select correct Profession Type.");//changes the selected item text to this

            Log.d(TAG, "Error Type: 201ocu-gndr mismatch");
            return false;
        }

        // 202Gender Spinner
        if (mc202gndr.getSelectedItem().toString().equals("Male") && mc202ocuSelected.toString().equals("1")) {
            Toast.makeText(getApplicationContext(), "Please select correct Profession Type.", Toast.LENGTH_SHORT).show();
            TextView errorText = (TextView) mc202ocu.getSelectedView();
            errorText.setError(" ");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select correct Profession Type.");//changes the selected item text to this

            Log.d(TAG, "Error Type: 202ocu mismatch");
            return false;
        }

        // 202Occupation Spinner
        if (mc201gndr.getSelectedItem().toString().equals("Male") && mc201type.getSelectedItem().toString().equals("Mother")) {
            Toast.makeText(getApplicationContext(), "Please select correct Relation Type.", Toast.LENGTH_SHORT).show();
            mc201type_error.setVisibility(View.VISIBLE);
            TextView errorText = (TextView) mc201gndr.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select correct Relation Type.");//changes the selected item text to this

            Log.d(TAG, "Error Type: 201gndr mismatch");
            return false;
        }

        if (mc201type.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc201type.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select a Relation");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Gender.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 201gndr mismatch");
            return false;
        }

        if (!mc201age.getText().toString().isEmpty() && Integer.valueOf(mc201age.getText().toString()) < AGE_LIMIT) {
            Toast.makeText(getApplicationContext(), "Too young to answer! Must be atleast " + AGE_LIMIT, Toast.LENGTH_SHORT).show();
            mc201age.setError("Too young to answer! Must be atleast " + AGE_LIMIT);
            Log.d(TAG, "Error Type: Too young");
            return false;
        }

        if (mc201age.getText().toString().isEmpty() || mc201age.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Age not Given!", Toast.LENGTH_SHORT).show();
            mc201age.setError("Age not Given!");
            Log.d(TAG, "Error Type: 201age Empty");
            return false;
        }

        if (mc201edu.getText().toString().isEmpty() || mc201edu.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Education not Given!", Toast.LENGTH_SHORT).show();
            mc201edu.setError("Education not Given!");
            Log.d(TAG, "Error Type: 201edu Empty");
            return false;
        }
        if (mc201ocu.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc201ocu.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Occupation");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an Occupation", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 201ocu empty");
            return false;
        }

        if (mc202nm.getText().toString().isEmpty() || mc202nm.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Name not Given!", Toast.LENGTH_SHORT).show();
            mc202nm.setError("Name not Given!");
            Log.d(TAG, "Error Type: 202nm Empty");
            return false;
        }

        if (mc202age.getText().toString().isEmpty() || mc202age.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Age not Given!", Toast.LENGTH_SHORT).show();
            mc202age.setError("Age not Given!");
            Log.d(TAG, "Error Type: 202age Empty");
            return false;
        }

        if (mc202edu.getText().toString().isEmpty() || mc202edu.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Education not Given!", Toast.LENGTH_SHORT).show();
            mc202edu.setError("Education not Given!");
            Log.d(TAG, "Error Type: 202edu Empty");
            return false;
        }
        if (mc202ocu.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc202ocu.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Occupation");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an Occupation.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 202ocu empty");
            return false;
        }
        if (mc203tot.getText().toString().isEmpty() || mc203tot.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Total members not Given!", Toast.LENGTH_SHORT).show();
            mc203tot.setError("Total members not Given!");
            Log.d(TAG, "Error Type: 203tot Empty");
            return false;
        }

        if (!mc203tot.getText().toString().isEmpty() && !mc203m.getText().toString().isEmpty() && !mc203f.getText().toString().isEmpty()) {
            if (Integer.valueOf(mc203m.getText().toString()) + Integer.valueOf(mc203f.getText().toString()) != Integer.valueOf(mc203tot.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Total members do not match!", Toast.LENGTH_SHORT).show();
                mc203tot.setError("Total members do not match!");
                Log.d(TAG, "Error Type: 203tot do not match.");
                return false;
            }
        }
        if (!mc204t.getText().toString().isEmpty() && !mc204m.getText().toString().isEmpty() && !mc204f.getText().toString().isEmpty()) {
            if (Integer.valueOf(mc204m.getText().toString()) + Integer.valueOf(mc204f.getText().toString()) != Integer.valueOf(mc204t.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Total children do not match!", Toast.LENGTH_SHORT).show();
                mc204t.setError("Total children do not match!");
                Log.d(TAG, "Error Type: 204t do not match");
                return false;
            }
        }

        if (mc203m.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Male count not Given!", Toast.LENGTH_SHORT).show();
            mc203m.setError("Male count not Given!");
            Log.d(TAG, "Error Type: 203m Empty");
            return false;
        }

        if (mc203f.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Female count not Given!", Toast.LENGTH_SHORT).show();
            mc203f.setError("Female count not Given!");
            Log.d(TAG, "Error Type: 203f Empty");
            return false;
        }

        if (mc204m.getText().toString().isEmpty() || mc204m.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Boy count not Given!", Toast.LENGTH_SHORT).show();
            mc204m.setError("Boy count not Given!");
            Log.d(TAG, "Error Type: 204m Empty");
            return false;
        }
        if (mc204f.getText().toString().isEmpty() || mc204f.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Girl count not Given!", Toast.LENGTH_SHORT).show();
            mc204f.setError("Girl count not Given!");
            Log.d(TAG, "Error Type: 204f Empty");
            return false;
        }


        if (Integer.valueOf(mc204t.getText().toString()) > Integer.valueOf(mc203tot.getText().toString()) - 1) {
            Toast.makeText(getApplicationContext(), "Total Children cannot be more than Total Members!", Toast.LENGTH_SHORT).show();
            mc204t.setError("Total Children cannot be more than Total Members!");
            Log.d(TAG, "Error Type: 204t more than 203tot");
            return false;
        }

        if (Integer.valueOf(mc204m.getText().toString()) > Integer.valueOf(mc203m.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Total Male U5 Children cannot be more than Total Male Members!", Toast.LENGTH_SHORT).show();
            mc204m.setError("Total Male U5 Children cannot be more than Total Male Members!");
            Log.d(TAG, "Error Type: 204m more than 203m");
            return false;
        }

        if (Integer.valueOf(mc204f.getText().toString()) > Integer.valueOf(mc203f.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Total Female U5 Children cannot be more than Total Female Members!", Toast.LENGTH_SHORT).show();
            mc204f.setError("Total Female U5 Children cannot be more than Total Female Members!");
            Log.d(TAG, "Error Type: 204f more than 203f");
            return false;
        }
        if (!mc204t.getText().toString().isEmpty() && Integer.valueOf(mc204t.getText().toString()) < 1) {
            Toast.makeText(getApplicationContext(), "Number of Children not Given!", Toast.LENGTH_SHORT).show();
            mc204t.setError("Number of Children not Given!");
            Log.d(TAG, "Error Type: 204t Empty");
            return false;
        }

        if ((mc205mm.getText().toString().isEmpty()) && (mc205yy.getText().toString().isEmpty())) {
            Toast.makeText(getApplicationContext(), "Living duration not Given!", Toast.LENGTH_SHORT).show();
            mc205mm.setError("Living duration not Given!");
            Log.d(TAG, "Error Type: 205mm && 205yy Both Empty");
            return false;
        }

        // 206 RadioGroup
        mc206selected = mc206.getCheckedRadioButtonId();

        // -- Check at least one RadioButton selected (-1 = None Selected)
        if (mc206selected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc206_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 206 not selected");
            return false;
        }

        // If 206 is 'YES' THAN Check 207 EditText -- months and weeks are not empty
        if (mc206selected == 2) {
            if (
                    (mc2071m.toString().isEmpty() && mc2071w.toString().isEmpty())
                            && (mc2072m.toString().isEmpty() && mc2072w.toString().isEmpty())
                            && (mc2073m.toString().isEmpty() && mc2073w.toString().isEmpty())
                    ) {
                Toast.makeText(getApplicationContext(), "Please answer!", Toast.LENGTH_SHORT).show();
                mc2071m.setError("Please answer!");
                Log.d(TAG, "Error Type: 206 not selected");
                return false;
            }
        }

        // 207 EditText -- Months & Weeks
        if (!mc2071w.getText().toString().isEmpty() && Integer.valueOf(mc2071w.getText().toString()) > WEEK_LIMIT) {

            Toast.makeText(getApplicationContext(), "Gestational age in weeks is over limit!", Toast.LENGTH_SHORT).show();
            mc2071w.setError("Gestational age in weeks is over limit!");
            Log.d(TAG, "Error Type: 2071w");
            return false;
        }
        if (!mc2073w.getText().toString().isEmpty() && Integer.valueOf(mc2073w.getText().toString()) > WEEK_LIMIT) {

            Toast.makeText(getApplicationContext(), "Gestational age in weeks is over limit!", Toast.LENGTH_SHORT).show();
            mc2073w.setError("Gestational age in weeks is over limit!");
            Log.d(TAG, "Error Type: 2073w");
            return false;
        }
        if (!mc2072w.getText().toString().isEmpty() && Integer.valueOf(mc2072w.getText().toString()) > WEEK_LIMIT) {

            Toast.makeText(getApplicationContext(), "Gestational age in weeks is over limit!", Toast.LENGTH_SHORT).show();
            mc2072w.setError("Gestational age in weeks is over limit!");
            Log.d(TAG, "Error Type: 2072w");
            return false;
        }
        if (!mc2071m.getText().toString().isEmpty() && Integer.valueOf(mc2071m.getText().toString()) > MONTH_LIMIT) {

            Toast.makeText(getApplicationContext(), "Gestational age in weeks is over limit!", Toast.LENGTH_SHORT).show();
            mc2071m.setError("Gestational age in weeks is over limit!");
            Log.d(TAG, "Error Type: 2071m");
            return false;
        }
        if (!mc2073m.getText().toString().isEmpty() && Integer.valueOf(mc2073m.getText().toString()) > MONTH_LIMIT) {

            Toast.makeText(getApplicationContext(), "Gestational age in weeks is over limit!", Toast.LENGTH_SHORT).show();
            mc2073m.setError("Gestational age in weeks is over limit!");
            Log.d(TAG, "Error Type: 2073m");
            return false;
        }
        if (!mc2073m.getText().toString().isEmpty() && Integer.valueOf(mc2072m.getText().toString()) > MONTH_LIMIT) {

            Toast.makeText(getApplicationContext(), "Gestational age in weeks is over limit!", Toast.LENGTH_SHORT).show();
            mc2072m.setError("Gestational age in weeks is over limit!");
            Log.d(TAG, "Error Type: 2072m");
            return false;
        }
        

        // Return from fromValidation()
        return true;
    }

    @Override
    public void onBackPressed() {
    }
}
