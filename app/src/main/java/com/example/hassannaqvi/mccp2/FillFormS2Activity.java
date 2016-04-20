package com.example.hassannaqvi.mccp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class FillFormS2Activity extends AppCompatActivity {

    private static final String TAG = "FILL_FORM_ACTIVITY";
    private static final Integer AGE_LIMIT = 18;
    public static String FORM_ID;
    private String mcFrmNo;
    private EditText mc201nm;
    private Spinner mc201gndr;
    private Spinner mc201type;
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
    private EditText mc2071w;
    private EditText mc2071m;
    private EditText mc2072w;
    private EditText mc2072m;
    private EditText mc2073w;
    private EditText mc2073m;
    private LinearLayout mc207;
    private TextView formErrorTxt;
    private Boolean formError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form_s2);

        formError = false;

        mc201nm = (EditText) findViewById(R.id.MC_201NM);
        mc201gndr = (Spinner) findViewById(R.id.MC_201GNDR);
        mc201type = (Spinner) findViewById(R.id.MC_201TYPE);
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
                    int tot203 = m203 + f203;
                    mc203tot.setText(String.valueOf(tot203));
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
                    int tot203 = m203 + f203;
                    mc203tot.setText(String.valueOf(tot203));
                }
            }
        });

        // Checking Total number of HH members against 203M+203F
        mc204m.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            int m204 = 0;
            int f204 = 0;

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mc204m.getText().toString().isEmpty()) {
                        m204 = Integer.valueOf(mc204m.getText().toString());
                    }
                    if (!mc204m.getText().toString().isEmpty()) {
                        f204 = Integer.valueOf(mc204m.getText().toString());
                    }
                    int tot204 = m204 + f204;
                    mc204t.setText(tot204);
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
                    int tot204 = m204 + f204;
                    mc204t.setText(tot204);
                }
            }
        });

        mc206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != mc206_yes.getId()) {
                    mc207.setVisibility(View.VISIBLE);
                } else {
                    mc207.setVisibility(View.INVISIBLE);
                }
            }
        });


    }


    public void startFormS3() {

        Intent s2_form_intent = new Intent(getApplicationContext(), FillFormS3Activity.class);

        startActivity(s2_form_intent);
    }
}
