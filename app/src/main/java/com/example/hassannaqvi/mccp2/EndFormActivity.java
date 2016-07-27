package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public class EndFormActivity extends AppCompatActivity {

    private static final String TAG = "End Form";
    public static JSONObject ending;

    private String mc101E;
    private String mc101ETime;
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
    private Button btnEnd;


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
        btnEnd = (Button) findViewById(R.id.btn_End);


        mc109.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != mc109_complete.getId()) {
                    mc110_txt.setVisibility(View.VISIBLE);
                    mc110.setVisibility(View.VISIBLE);
                } else {
                    mc110_txt.setVisibility(View.GONE);
                    mc110.setVisibility(View.GONE);
                }
            }
        });

        mc110.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc110_88.getId()) {
                    mc110x_txt.setVisibility(View.VISIBLE);
                    mc110x.setVisibility(View.VISIBLE);
                } else {
                    mc110x_txt.setVisibility(View.GONE);
                    mc110x.setVisibility(View.GONE);
                    mc110x.setText(null);
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

        if ((mc109_incomplete.isChecked() || mc109_noQ.isChecked()) && mc110Selected == -1) {
            mc110_88.setError("Please select an answer!");
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();


            Log.d(TAG, "Error Type: 110");
            return false;
        }


        if (mc110_88.isChecked() && mc110x.getText().toString().isEmpty()) {
            mc110x.setError("Specify other reason!");
            Toast.makeText(getApplicationContext(), "Specify other reason!", Toast.LENGTH_SHORT).show();

            Log.d(TAG, "Error Type: 110x");
            return false;
        }
        return true;
    }

    private void StoreTempValues() throws JSONException {

        SharedPreferences sharedPref = getSharedPreferences("MC_" + FillFormActivity.mcFrmNo, Context.MODE_PRIVATE);

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
        String spEndDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(Calendar.getInstance().getTime());
        editor.putString("sp110x", mc110x.getText().toString());
        editor.putString("spEndDateTime", spEndDateTime);

        // Comit to storage
        editor.commit();

        ending = new JSONObject();
        Long newFormId;
        try {

            // Initialize JSON Object For Section 6
            ending.put("mc109", sharedPref.getString("sp109", "00"));
            ending.put("mc110", sharedPref.getString("sp110", "00"));
            ending.put("mc110x", sharedPref.getString("sp110x", "00"));
            ending.put("mcEndDateTime", sharedPref.getString("spEndDateTime", "00"));


            Log.d(TAG + " JSON:", ending.toString());

            //FormsContract.getInstance().setEnding(ending.toString());

            //FormsContract formContractS2 = new FormsContract(sharedPref.getString("spFrmNo", "00"), rowId, s2.toString());
            FormsContract fc = new FormsContract(FillFormActivity.s1);
            FillFormActivity.s1 = null;

            fc.setS2(String.valueOf(FillFormS2Activity.S2));
            FillFormS2Activity.S2 = null;

            fc.setS4(String.valueOf(FillFormS4Activity.S4));
            FillFormS4Activity.S4 = null;

            fc.setS5(String.valueOf(FillFormS5Activity.S5));
            FillFormS5Activity.S5 = null;

            fc.setS6("S6");
            //FillFormS6Activity.S6 = null;

            fc.setEnding(String.valueOf(ending));
            ending = null;

            FormsDbHelper db = new FormsDbHelper(this);

            try {
                Log.d(TAG, "Updating DataBase...");
                Toast.makeText(this, "Updating DataBase...", Toast.LENGTH_SHORT).show();
                btnEnd.setEnabled(false);
                Long TabFormId = db.addForm(fc);

                for (String imchid : FillFormS3Activity.chids) {

                    SharedPreferences imPref = getSharedPreferences("IM_" + imchid, Context.MODE_PRIVATE);
                    ImsContract imc = new ImsContract();

                    imc.setChid(imPref.getString("spimchid", "00"));
                    imc.setFrmNo(imchid);

                    JSONObject imJson = new JSONObject();
                    imJson.put("FormId", String.valueOf(TabFormId) + fc.getDeviceId());
                    imJson.put("FrmDT", fc.get101() + " " + fc.get101Time());
                    imJson.put("DataC", fc.get102());
                    imJson.put("FrmNo", imPref.getString("spFrmNo", "00"));
                    imJson.put("ima", imPref.getString("spima", "00"));
                    imJson.put("ima", imPref.getString("spima", "00"));
                    imJson.put("imaf", imPref.getString("spimaf", "00"));
                    imJson.put("imb", imPref.getString("spimb", "00"));
                    imJson.put("imc", imPref.getString("spimc", "00"));
                    imJson.put("imd", imPref.getString("spimd", "00"));
                    imJson.put("imddoc", imPref.getString("spimddoc", "00"));
                    imJson.put("imey", imPref.getString("spimey", "00"));
                    imJson.put("imem", imPref.getString("spimem", "00"));
                    imJson.put("imed", imPref.getString("spimed", "00"));
                    imJson.put("imf", imPref.getString("spimf", "00"));
                    imJson.put("img", imPref.getString("spimg", "00"));
                    imJson.put("imh", imPref.getString("spimh", "00"));
                    imJson.put("imi", imPref.getString("spimi", "00"));
                    imJson.put("imj", imPref.getString("spimj", "00"));
                    imJson.put("imjb", imPref.getString("spimjb", "00"));
                    imJson.put("imk", imPref.getString("spimk", "00"));
                    imJson.put("bcg", imPref.getString("spbcg", "00"));
                    imJson.put("bcgsrc", imPref.getString("spbcgsrc", "00"));
                    imJson.put("bcgscar", imPref.getString("spbcgscar", "00"));
                    imJson.put("opv_0", imPref.getString("spopv_0", "00"));
                    imJson.put("opv_0src", imPref.getString("spopv_0src", "00"));
                    imJson.put("opv_1", imPref.getString("spopv_1", "00"));
                    imJson.put("opv_1src", imPref.getString("spopv_1src", "00"));
                    imJson.put("opv_2", imPref.getString("spopv_2", "00"));
                    imJson.put("opv_2src", imPref.getString("spopv_2src", "00"));
                    imJson.put("opv_3", imPref.getString("spopv_3", "00"));
                    imJson.put("opv_3src", imPref.getString("spopv_3src", "00"));
                    imJson.put("p_1", imPref.getString("spp_1", "00"));
                    imJson.put("p_1src", imPref.getString("spp_1src", "00"));
                    imJson.put("p_2", imPref.getString("spp_2", "00"));
                    imJson.put("p_2src", imPref.getString("spp_2src", "00"));
                    imJson.put("p_3", imPref.getString("spp_3", "00"));
                    imJson.put("p_3src", imPref.getString("spp_3src", "00"));
                    imJson.put("pcv_3src", imPref.getString("sppcv_3src", "00"));
                    imJson.put("pcv_3", imPref.getString("sppcv_3", "00"));
                    imJson.put("pcv_2src", imPref.getString("sppcv_2src", "00"));
                    imJson.put("pcv_2", imPref.getString("sppcv_2", "00"));
                    imJson.put("pcv_1src", imPref.getString("sppcv_1src", "00"));
                    imJson.put("pcv_1", imPref.getString("sppcv_1", "00"));
                    imJson.put("m_1", imPref.getString("spm_1", "00"));
                    imJson.put("m_1src", imPref.getString("spm_1src", "00"));
                    imJson.put("m_2", imPref.getString("spm_2", "00"));
                    imJson.put("m_2src", imPref.getString("spm_2src", "00"));
                    imJson.put("immd", imPref.getString("spimmd", "00"));
                    imJson.put("imma", imPref.getString("spimma", "00"));
                    imc.setIM(imJson.toString());
                    db.addIM(imc);

                }
                FillFormS3Activity.chids.clear();

                /*for (String cfchid : FillFormS6CFActivity.CF_chids) {

                    SharedPreferences cfPref = getSharedPreferences("CF_" + cfchid, Context.MODE_PRIVATE);
                    CfsContract cf = new CfsContract();

                    cf.setChid(cfPref.getString("spcf_Chid", "00"));
                    cf.setFrmNo(cfPref.getString("spFrmNo", "00"));
                    JSONObject cfJson = new JSONObject();
                    cfJson.put("FormId", String.valueOf(TabFormId) + fc.getDeviceId());
                    cfJson.put("FrmDT", fc.get101() + " " + fc.get101Time());
                    cfJson.put("DataC", fc.get102());
                    cfJson.put("cf_Q1", cfPref.getString("spcf_Q1", "00"));
                    cfJson.put("cf_Q2", cfPref.getString("spcf_Q2", "00"));
                    cfJson.put("cf_Q2_1", cfPref.getString("spcf_Q2_1", "00"));
                    cfJson.put("cf_Q2_2", cfPref.getString("spcf_Q2_2", "00"));
                    cfJson.put("cf_Q2_3", cfPref.getString("spcf_Q2_3", "00"));
                    cfJson.put("cf_Q2_4", cfPref.getString("spcf_Q2_4", "00"));
                    cfJson.put("cf_Q2_5", cfPref.getString("spcf_Q2_5", "00"));
                    cfJson.put("cf_Q2_6", cfPref.getString("spcf_Q2_6", "00"));
                    cfJson.put("cf_Q3", cfPref.getString("spcf_Q3", "00"));
                    cfJson.put("cf_Q4", cfPref.getString("spcf_Q4", "00"));
                    cf.setCf(cfJson.toString());

                    db.addCF(cf);


                }
                FillFormS6CFActivity.CF_chids.clear();*/
            } catch (SQLiteException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d(TAG, "Updated Form with Id: " + String.valueOf(newFormId));
        //FormsContract.getInstance().Clear();


        JSONObject FormFull = new JSONObject();
        Map<String, ?> keys = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : keys.entrySet()) {

            FormFull.put(entry.getKey(), entry.getValue().toString());

        }

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Button NOT Allowed!", Toast.LENGTH_SHORT).show();


    }
}