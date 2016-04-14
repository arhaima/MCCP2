package com.example.hassannaqvi.mccp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class EndFormActivity extends AppCompatActivity {

    private static final String TAG = "End Form";
    private RadioGroup mc109;
    private RadioButton mc109_complete;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_form);

        formError = false;

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


        mc109.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != mc109_complete.getId()){
                    mc110_txt.setVisibility(View.VISIBLE);
                    mc110.setVisibility(View.VISIBLE);
                }else{
                    mc110_txt.setVisibility(View.INVISIBLE);
                    mc110.setVisibility(View.INVISIBLE);
                }
            }
        });

        mc110.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == mc110_88.getId()){
                    mc110x_txt.setVisibility(View.VISIBLE);
                    mc110x.setVisibility(View.VISIBLE);
                }else{
                    mc110x_txt.setVisibility(View.INVISIBLE);
                    mc110x.setVisibility(View.INVISIBLE);
                }
            }
        });



    }

    public void noInterview(View view){

        // Form Validation
        if (mc110x.getText().toString().isEmpty() || mc110x.getText().toString() == null) {
            mc110x.setError("Specify other reason !");
            Log.d(TAG, "Error Type: 110x");
            formError = true;
        } else {
            formError = false;
        }
    }
}
