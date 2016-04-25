package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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

    private static final String TAG = "FILL_FORM_S2_ACTIVITY";
    private static final Integer AGE_LIMIT = 18;
    public static String FORM_ID;
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

    private String mc201typeSelected;
    private String mc201ocuSelected;
    private String mc202ocuSelected;

    private TextView formErrorTxt;
    private Boolean formError;
    private String formId;
    private String rowId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form_s2);

        formId = getIntent().getStringExtra("formId");

        Log.d(TAG, "i.fromId: " + formId);
        formError = false;

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

        // Spinner Selected Value from List Array
        mc201ocuSelected = getResources().getStringArray(R.array.MC_OCU_value)[mc201ocu.getSelectedItemPosition()];
        mc202ocuSelected = getResources().getStringArray(R.array.MC_OCU_value)[mc202ocu.getSelectedItemPosition()];


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
                        formError = true;
                    } else {
                        mc201age.setError(null);
                        formError = false;

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
                    if (edu201 > age201 - 5) {
                        mc201edu.setError("Education does not match Age.");
                        formError = true;
                    } else {
                        mc201age.setError(null);
                        formError = false;

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
                        formError = true;
                    } else {
                        mc202age.setError(null);
                        formError = false;

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
                    if (edu202 > age202 - 5) {
                        mc202edu.setError("Education does not match Age.");
                        formError = true;
                    } else {
                        mc202age.setError(null);
                        formError = false;

                    }
                }
            }
        });


        // Checking Total number of HH members against 203M+203F
        mc203m.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int m203 = 0;
            int f203 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    m203 = Integer.valueOf(mc203m.getText().toString());
                    if (!mc203f.getText().toString().isEmpty()) {
                        f203 = Integer.valueOf(mc203f.getText().toString());
                    }
                    mc203tot.setError("Total do not match!");
                }
            }
        });

        mc203f.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int m203 = 0;
            int f203 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc203m.getText().toString().isEmpty()) {
                        m203 = Integer.valueOf(mc203m.getText().toString());
                    }
                    if (!mc203f.getText().toString().isEmpty()) {
                        f203 = Integer.valueOf(mc203f.getText().toString());
                    }
                    mc203tot.setError("Total do not match!");
                }
            }
        });

        // Checking Total number of HH members against 203M+203F
        mc204m.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int m204 = 0;
            int f204 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int m204 = 0;
                int f204 = 0;
                if (!hasFocus) {
                    if (!mc204m.getText().toString().isEmpty()) {
                        m204 = Integer.valueOf(mc204m.getText().toString());
                    }
                    if (!mc204m.getText().toString().isEmpty()) {
                        f204 = Integer.valueOf(mc204m.getText().toString());
                    }
                    mc204t.setError("Total do not match!");
                }
            }
        });

        mc204f.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            int m204 = 0;
            int f204 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc204m.getText().toString().isEmpty()) {
                        m204 = Integer.valueOf(mc204m.getText().toString());
                    }
                    if (!mc204f.getText().toString().isEmpty()) {
                        f204 = Integer.valueOf(mc204f.getText().toString());
                    }
                    mc204t.setError("Total do not match!");
                }
            }
        });

        mc206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc206_yes.getId()) {
                    mc207.setVisibility(View.VISIBLE);
                } else {
                    mc207.setVisibility(View.INVISIBLE);
                }
            }
        });


    }

    public void onCheckboxClicked(View view) {

    }

    public void startFormS3(View view) {

        mc201typeSelected = getResources().getStringArray(R.array.MC_201TYPE_list)[mc201type.getSelectedItemPosition()];
        mc201ocuSelected = getResources().getStringArray(R.array.MC_OCU_value)[mc201ocu.getSelectedItemPosition()];
        mc202ocuSelected = getResources().getStringArray(R.array.MC_OCU_value)[mc202ocu.getSelectedItemPosition()];

        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();

            Intent s2_form_intent = new Intent(getApplicationContext(), FillFormS3Activity.class);
            s2_form_intent.putExtra("formId", formId);
            s2_form_intent.putExtra("boyCount", mc204m.getText().toString());
            s2_form_intent.putExtra("girlCount", mc204f.getText().toString());
            startActivity(s2_form_intent);
        } else {


        }

    }

    private void StoreTempValues() {

        Toast.makeText(getApplicationContext(), "Storing Temporary Form Values...", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences(FORM_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Value Selection for Spinners


        // Selected value of RadioGroups
        mc206selected = mc206.getCheckedRadioButtonId();


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

        // Switch for RadioGroups
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

        JSONObject s2 = new JSONObject();
        long newFormId = 0;
        try {
            s2.put("mc201nm", sharedPref.getString("sp201nm", "00"));
            s2.put("mc201gndr", sharedPref.getString("sp201gndr", "00"));
            s2.put("mc201type", sharedPref.getString("sp201type", "00"));
            s2.put("mc201age", sharedPref.getString("sp201age", "00"));
            s2.put("mc201edu", sharedPref.getString("sp201edu", "00"));
            s2.put("mc201ocu", sharedPref.getString("sp201ocu", "00"));
            s2.put("mc202nm", sharedPref.getString("sp202nm", "00"));
            s2.put("mc202gndr", sharedPref.getString("sp202gndr", "00"));
            s2.put("mc202age", sharedPref.getString("sp202age", "00"));
            s2.put("mc202edu", sharedPref.getString("sp202edu", "00"));
            s2.put("mc202ocu", sharedPref.getString("sp202ocu", "00"));
            s2.put("mc203tot", sharedPref.getString("sp203tot", "00"));
            s2.put("mc203m", sharedPref.getString("sp203m", "00"));
            s2.put("mc203f", sharedPref.getString("sp203f", "00"));
            s2.put("mc204t", sharedPref.getString("sp204t", "00"));
            s2.put("mc204m", sharedPref.getString("sp204m", "00"));
            s2.put("mc204f", sharedPref.getString("sp204f", "00"));
            s2.put("mc205mm", sharedPref.getString("sp205mm", "00"));
            s2.put("mc205yy", sharedPref.getString("sp205yy", "00"));
            s2.put("mc206", sharedPref.getString("sp206", "00"));
            s2.put("mc2071w", sharedPref.getString("sp2071w", "00"));
            s2.put("mc2071m", sharedPref.getString("sp2071m", "00"));
            s2.put("mc2072w", sharedPref.getString("sp2072w", "00"));
            s2.put("mc2072m", sharedPref.getString("sp2072m", "00"));
            s2.put("mc2073w", sharedPref.getString("sp2073w", "00"));
            s2.put("mc2073m", sharedPref.getString("sp2073m", "00"));

            Log.d(TAG, s2.toString());
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

        String gndr201 = mc201gndr.getSelectedItem().toString();

        if (mc201gndr.getSelectedItem().toString() == "Male" && mc201type.getSelectedItem().toString() == "Mother") {
            mc201type_error.setVisibility(View.VISIBLE);

            Log.d(TAG, "Error Type: 201type mismatch");
            return false;
        }

        mc206selected = mc206.getCheckedRadioButtonId();

        if (mc201nm.getText().toString().isEmpty() || mc201nm.getText().toString() == null) {
            mc201nm.setError("Name not Given!");

            Log.d(TAG, "Error Type: 201nm Empty");
            return false;
        }

        if (mc201age.getText().toString().isEmpty() || mc201age.getText().toString() == null) {
            mc201age.setError("Age not Given!");
            Log.d(TAG, "Error Type: 201age Empty");
            return false;
        }

        if (mc201edu.getText().toString().isEmpty() || mc201edu.getText().toString() == null) {
            mc201edu.setError("Education not Given!");

            Log.d(TAG, "Error Type: 201edu Empty");
            return false;
        }

        if (mc202nm.getText().toString().isEmpty() || mc202nm.getText().toString() == null) {
            mc202nm.setError("Name not Given!");
            Log.d(TAG, "Error Type: 202nm Empty");
            return false;
        }

        if (mc202age.getText().toString().isEmpty() || mc202age.getText().toString() == null) {
            mc202age.setError("Age not Given!");
            Log.d(TAG, "Error Type: 202age Empty");
            return false;
        }

        if (mc202edu.getText().toString().isEmpty() || mc202edu.getText().toString() == null) {
            mc202edu.setError("Education not Given!");
            Log.d(TAG, "Error Type: 202edu Empty");
            return false;
        }

        if (mc203tot.getText().toString().isEmpty() || mc203tot.getText().toString() == null) {
            mc203tot.setError("Total members not Given!");
            Log.d(TAG, "Error Type: 203tot Empty");
            return false;
        }

        if (mc203m.getText().toString().isEmpty() || mc203m.getText().toString() == null) {
            mc203m.setError("Male count not Given!");
            Log.d(TAG, "Error Type: 203m Empty");
            return false;
        }

        if (mc203f.getText().toString().isEmpty() || mc203f.getText().toString() == null) {
            mc203f.setError("Female count not Given!");
            Log.d(TAG, "Error Type: 203f Empty");
            return false;
        }


        if (mc204f.getText().toString().isEmpty() || mc204f.getText().toString() == null) {
            mc204f.setError("Girl count not Given!");
            Log.d(TAG, "Error Type: 204f Empty");
            return false;
        }

        if (mc204m.getText().toString().isEmpty() || mc204m.getText().toString() == null) {
            mc204m.setError("Boy count not Given!");
            Log.d(TAG, "Error Type: 204m Empty");
            return false;
        }

        if (mc204t.getText().toString().isEmpty() || mc204t.getText().toString() == null) {
            mc204t.setError("Total Children not Given!");
            Log.d(TAG, "Error Type: 204t Empty");
            return false;
        }

        if ((mc205mm.getText().toString().isEmpty() || mc205mm.getText().toString() == null) && (mc205yy.getText().toString().isEmpty() || mc205yy.getText().toString() == null)) {
            mc205mm.setError("Living duration not Given!");
            Log.d(TAG, "Error Type: 205mm && 205yy Both Empty");
            return false;
        }

        if (mc206selected == -1) {
            mc206_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 206 not selected");
            return false;
        }

        // Return from fromValidation()
        return true;
    }
}
