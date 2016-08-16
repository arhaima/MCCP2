package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class FillFormS3Activity extends AppCompatActivity {

    private static final String TAG = "FILL_FORM_S3_ACTIVITY";
    public static JSONObject S3;
    public static JSONObject imJson;
    public static String FORM_ID;
    public static List<String> chids = new ArrayList<String>();
    private static boolean revMode;
    private String formId;
    private Integer girlCount;
    private Integer boyCount;
    private TextView childName;
    private TextView childCount;
    private String imfrmno;
    private String imchid;
    private EditText ima;
    private EditText imaf;
    private CheckBox imresp;
    private Spinner imb;
    private Spinner imc;
    private RadioGroup image;
    private RadioButton imagey;
    private RadioButton imagen;

    private DatePicker imd;
    private CheckBox imddoc;
    private EditText imey;
    private EditText imem;
    private EditText imed;
    private EditText imRem;
    private Spinner imf;
    private Spinner img;
    private Spinner imh;
    private Spinner imi;
    private Spinner imk;
    private Spinner imjb;
    private RadioGroup imj;
    private RadioButton imj_yes;
    private RadioButton imj_no;
    private Spinner bcg;
    private Spinner bcgsrc;
    private Spinner bcgscar;
    private Spinner opv_0;
    private Spinner opv_0src;
    private Spinner opv_1;
    private Spinner opv_1src;
    private Spinner opv_2;
    private Spinner opv_2src;
    private Spinner opv_3;
    private Spinner opv_3src;
    private Spinner p_1;
    private Spinner p_1src;
    private Spinner p_2;
    private Spinner p_2src;
    private Spinner p_3;
    private Spinner p_3src;
    private Spinner pcv_1;
    private Spinner pcv_1src;
    private Spinner pcv_2;
    private Spinner pcv_2src;
    private Spinner pcv_3;
    private Spinner pcv_3src;
    private Spinner m_1;
    private Spinner m_1src;
    private Spinner m_2;
    private Spinner m_2src;
    private Spinner immd;
    private Spinner imma;
    private String imbselected;
    private String imcselected;
    private String imfselected;
    private String imgselected;
    private String imhselected;
    private String imiselected;
    private int imjselected;
    private String imjbselected;
    private String imkselected;
    private String bcgselected;
    private String bcgsrcselected;
    private String bcgscarselected;
    private String opv_0selected;
    private String opv_0srcselected;
    private String opv_1selected;
    private String opv_1srcselected;
    private String opv_2selected;
    private String opv_2srcselected;
    private String opv_3selected;
    private String opv_3srcselected;
    private String p_1selected;
    private String p_1srcselected;
    private String p_2selected;
    private String p_2srcselected;
    private String p_3selected;
    private String p_3srcselected;
    private String pcv_1selected;
    private String pcv_1srcselected;
    private String pcv_2selected;
    private String pcv_2srcselected;
    private String pcv_3selected;
    private String pcv_3srcselected;
    private String m_1selected;
    private String m_1srcselected;
    private String m_2selected;
    private String m_2srcselected;
    private String immdselected;
    private String immaselected;
    private Boolean formError;

    private LinearLayout fldGrpIM_D;
    private LinearLayout fldGrpIM_E;
    private LinearLayout fldGrpIM_JA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form_s3);

        formId = getIntent().getStringExtra("formId");

        girlCount = Integer.valueOf(getIntent().getStringExtra("girlCount"));
        boyCount = Integer.valueOf(getIntent().getStringExtra("boyCount"));
        if (FillFormS2Activity.gndrChk == true) {
            FillFormS2Activity.gndrChk = false;
        } else if (FillFormS2Activity.gndrChk == false) {
            FillFormS2Activity.gndrChk = true;
        }

        ima = (EditText) findViewById(R.id.IM_A);
        imaf = (EditText) findViewById(R.id.IM_AF);
        imresp = (CheckBox) findViewById(R.id.IM_RESP);
        imb = (Spinner) findViewById(R.id.IM_B);
        imc = (Spinner) findViewById(R.id.IM_C);
        image = (RadioGroup) findViewById(R.id.IM_AGE);
        imagey = (RadioButton) findViewById(R.id.IM_AGE_YES);
        imagen = (RadioButton) findViewById(R.id.IM_AGE_NO);
        imd = (DatePicker) findViewById(R.id.IM_D);
        imddoc = (CheckBox) findViewById(R.id.IM_D_Doc);
        imey = (EditText) findViewById(R.id.IM_EY);
        imem = (EditText) findViewById(R.id.IM_EM);
        imed = (EditText) findViewById(R.id.IM_ED);
        imRem = (EditText) findViewById(R.id.IM_ED);
        imf = (Spinner) findViewById(R.id.IM_F);
        img = (Spinner) findViewById(R.id.IM_G);
        imh = (Spinner) findViewById(R.id.IM_H);
        imi = (Spinner) findViewById(R.id.IM_I);
        imk = (Spinner) findViewById(R.id.IM_K);
        imjb = (Spinner) findViewById(R.id.IM_JB);
        imj = (RadioGroup) findViewById(R.id.IM_JA);
        imj_yes = (RadioButton) findViewById(R.id.IM_J_Yes);
        imj_no = (RadioButton) findViewById(R.id.IM_J_No);
        bcg = (Spinner) findViewById(R.id.BCG);
        bcgsrc = (Spinner) findViewById(R.id.BCG_SRC);
        bcgscar = (Spinner) findViewById(R.id.BCG_SCAR);
        opv_0 = (Spinner) findViewById(R.id.OPV0);
        opv_0src = (Spinner) findViewById(R.id.OPV0_SRC);
        opv_1 = (Spinner) findViewById(R.id.OPV1);
        opv_1src = (Spinner) findViewById(R.id.OPV1_SRC);
        opv_2 = (Spinner) findViewById(R.id.OPV2);
        opv_2src = (Spinner) findViewById(R.id.OPV2_SRC);
        opv_3 = (Spinner) findViewById(R.id.OPV3);
        opv_3src = (Spinner) findViewById(R.id.OPV3_SRC);
        p_1 = (Spinner) findViewById(R.id.P1);
        p_1src = (Spinner) findViewById(R.id.P1_SRC);
        p_2 = (Spinner) findViewById(R.id.P2);
        p_2src = (Spinner) findViewById(R.id.P2_SRC);
        p_3 = (Spinner) findViewById(R.id.P3);
        p_3src = (Spinner) findViewById(R.id.P3_SRC);
        pcv_1 = (Spinner) findViewById(R.id.PCV1);
        pcv_1src = (Spinner) findViewById(R.id.PCV1_SRC);
        pcv_2 = (Spinner) findViewById(R.id.PCV2);
        pcv_2src = (Spinner) findViewById(R.id.PCV2_SRC);
        pcv_3 = (Spinner) findViewById(R.id.PCV3);
        pcv_3src = (Spinner) findViewById(R.id.PCV3_SRC);
        m_1 = (Spinner) findViewById(R.id.M1);
        m_1src = (Spinner) findViewById(R.id.M1_SRC);
        m_2 = (Spinner) findViewById(R.id.M2);
        m_2src = (Spinner) findViewById(R.id.M2_SRC);
        imma = (Spinner) findViewById(R.id.IM_M_A);
        immd = (Spinner) findViewById(R.id.IM_M_D);

        fldGrpIM_D = (LinearLayout) findViewById(R.id.fldGrpIM_D);
        fldGrpIM_E = (LinearLayout) findViewById(R.id.fldGrpIM_E);
        fldGrpIM_JA = (LinearLayout) findViewById(R.id.fldGrpIM_JA);

        childName = (TextView) findViewById(R.id.child_name);
        childCount = (TextView) findViewById(R.id.child_count);

        childCount.setText("Remaining: Boy - " + boyCount + "|| Girl - " + girlCount);


        ima.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!ima.getText().toString().isEmpty()) {
                        childName.setText(ima.getText().toString());
                    }
                }
            }
        });

        imb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                imbselected = getResources().getStringArray(R.array.IM_B_value)[imb.getSelectedItemPosition()];
                if (Integer.valueOf(imbselected) == 1 && boyCount < 0) {
                    findViewById(R.id.imb_b).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.imb_b).setVisibility(View.GONE);
                }
                if (Integer.valueOf(imbselected) == 2 && girlCount < 0) {
                    findViewById(R.id.imb_g).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        image.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == imagen.getId()) {
                    fldGrpIM_D.setVisibility(View.VISIBLE);
                } else {
                    fldGrpIM_D.setVisibility(View.GONE);
                }
                if (checkedId == imagey.getId()) {
                    fldGrpIM_E.setVisibility(View.VISIBLE);
                } else {
                    fldGrpIM_E.setVisibility(View.GONE);
                    imed.setText("");
                    imem.setText("");
                    imey.setText("");
                }
            }
        });
        imj.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == imj_yes.getId()) {
                    fldGrpIM_JA.setVisibility(View.VISIBLE);
                } else {
                    fldGrpIM_JA.setVisibility(View.GONE);
                }
            }
        });

    }

    public void processChild(View view) {

        imbselected = getResources().getStringArray(R.array.IM_B_value)[imb.getSelectedItemPosition()];
        imcselected = getResources().getStringArray(R.array.MC_YN_value)[imc.getSelectedItemPosition()];
        imfselected = getResources().getStringArray(R.array.MC_YN_value)[imf.getSelectedItemPosition()];
        imgselected = getResources().getStringArray(R.array.MC_YN_value)[img.getSelectedItemPosition()];
        imhselected = getResources().getStringArray(R.array.IM_H_value)[imh.getSelectedItemPosition()];
        imiselected = getResources().getStringArray(R.array.MC_YN_value)[imi.getSelectedItemPosition()];
        imkselected = getResources().getStringArray(R.array.IM_K_value)[imk.getSelectedItemPosition()];
        imjbselected = getResources().getStringArray(R.array.IM_JB_value)[imjb.getSelectedItemPosition()];
        imjselected = imj.getCheckedRadioButtonId();
        bcgselected = getResources().getStringArray(R.array.MC_YN_value)[bcg.getSelectedItemPosition()];
        bcgscarselected = getResources().getStringArray(R.array.IM_I_Scar_value)[bcgscar.getSelectedItemPosition()];
        bcgsrcselected = getResources().getStringArray(R.array.IM_I_Source_value)[bcgsrc.getSelectedItemPosition()];
        opv_0selected = getResources().getStringArray(R.array.MC_YN_value)[opv_0.getSelectedItemPosition()];
        opv_0srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[opv_0src.getSelectedItemPosition()];
        opv_1selected = getResources().getStringArray(R.array.MC_YN_value)[opv_1.getSelectedItemPosition()];
        opv_1srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[opv_1src.getSelectedItemPosition()];
        opv_2selected = getResources().getStringArray(R.array.MC_YN_value)[opv_2.getSelectedItemPosition()];
        opv_2srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[opv_2src.getSelectedItemPosition()];
        opv_3selected = getResources().getStringArray(R.array.MC_YN_value)[opv_3.getSelectedItemPosition()];
        opv_3srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[opv_3src.getSelectedItemPosition()];
        p_1selected = getResources().getStringArray(R.array.MC_YN_value)[p_1.getSelectedItemPosition()];
        p_1srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[p_1src.getSelectedItemPosition()];
        p_2selected = getResources().getStringArray(R.array.MC_YN_value)[p_2.getSelectedItemPosition()];
        p_2srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[p_2src.getSelectedItemPosition()];
        p_3selected = getResources().getStringArray(R.array.MC_YN_value)[p_3.getSelectedItemPosition()];
        p_3srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[p_3src.getSelectedItemPosition()];
        pcv_1selected = getResources().getStringArray(R.array.MC_YN_value)[pcv_1.getSelectedItemPosition()];
        pcv_1srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[pcv_1src.getSelectedItemPosition()];
        pcv_2selected = getResources().getStringArray(R.array.MC_YN_value)[pcv_2.getSelectedItemPosition()];
        pcv_2srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[pcv_2src.getSelectedItemPosition()];
        pcv_3selected = getResources().getStringArray(R.array.MC_YN_value)[pcv_3.getSelectedItemPosition()];
        pcv_3srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[pcv_3src.getSelectedItemPosition()];
        m_1selected = getResources().getStringArray(R.array.MC_YN_value)[m_1.getSelectedItemPosition()];
        m_1srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[m_1src.getSelectedItemPosition()];
        m_2selected = getResources().getStringArray(R.array.MC_YN_value)[m_2.getSelectedItemPosition()];
        m_2srcselected = getResources().getStringArray(R.array.IM_I_Source_value)[m_2src.getSelectedItemPosition()];
        immaselected = getResources().getStringArray(R.array.MC_YN_value)[imma.getSelectedItemPosition()];
        immdselected = getResources().getStringArray(R.array.MC_YN_value)[immd.getSelectedItemPosition()];


        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();
            Log.d(TAG, "BCount: " + boyCount + " GCount: " + girlCount);
            if (Integer.valueOf(boyCount) >= 1 || Integer.valueOf(girlCount) >= 1) {
                Intent s3_form_intent = new Intent(getApplicationContext(), FillFormS3Activity.class);
                s3_form_intent.putExtra("formId", formId);
                s3_form_intent.putExtra("boyCount", String.valueOf(boyCount));
                s3_form_intent.putExtra("girlCount", String.valueOf(girlCount));
                FillFormS2Activity.gndrChk = false;
                startActivity(s3_form_intent);
            } else {
                Intent s4_form_intent = new Intent(getApplicationContext(), FillFormS4Activity.class);
                s4_form_intent.putExtra("formId", formId);
                Log.d(TAG, "All Child Ids : " + chids.toString());
                FillFormS2Activity.gndrChk = true;

                startActivity(s4_form_intent);

            }
        } else {
            Toast.makeText(getApplicationContext(), "Form Validation... Failed!", Toast.LENGTH_SHORT).show();


        }


    }

    private void StoreTempValues() {
        Toast.makeText(getApplicationContext(), "Storing Temporary Form Values...", Toast.LENGTH_SHORT).show();
        Integer chid = boyCount + girlCount;
        imchid = formId + String.format("%02d", chid);
        chids.add(imchid);
        SharedPreferences sharedPref = getSharedPreferences("IM_" + imchid, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        if (FillFormS2Activity.gndrChk == true) {

            switch (imbselected.toString()) {
                case "1":
                    boyCount--;
                    break;
                case "2":
                    girlCount--;
                    break;

            }
            Log.d(TAG, "boyCount: " + boyCount + " girlCount: " + girlCount);
        }


        Log.d(TAG, "Child Id: " + imchid);
        String spDateOB = "";
        if (imagen.isChecked()) {
            spDateOB = DateFormat.getDateInstance().format(imd.getCalendarView().getDate());

        }
        Log.d(TAG, spDateOB);
        editor.putString("spFrmNo", FillFormActivity.mcFrmNo);
        editor.putString("spimchid", imchid);
        editor.putString("spima", ima.getText().toString());
        editor.putString("spimaf", imaf.getText().toString());
        editor.putString("spimb", imbselected.toString());
        editor.putString("spimc", imcselected.toString());
        editor.putString("spimd", String.valueOf(spDateOB));
        editor.putString("spimddoc", (imddoc.isChecked() ? "1" : ""));
        editor.putString("spimey", imey.getText().toString());
        editor.putString("spimem", imem.getText().toString());
        editor.putString("spimed", imed.getText().toString());
        editor.putString("spimRem", imRem.getText().toString());
        editor.putString("spimf", imfselected.toString());
        editor.putString("spimg", imgselected.toString());
        editor.putString("spimh", imhselected.toString());
        editor.putString("spimi", imiselected.toString());
        editor.putString("spimk", imkselected.toString());
        editor.putString("spimjb", imjbselected.toString());

        editor.putString("spbcg", bcgselected.toString());
        editor.putString("spbcgsrc", bcgsrcselected.toString());
        editor.putString("spbcgscar", bcgscarselected.toString());
        editor.putString("spopv_0", opv_0selected.toString());
        editor.putString("spopv_0src", opv_0srcselected.toString());
        editor.putString("spopv_1", opv_1selected.toString());
        editor.putString("spopv_1src", opv_1srcselected.toString());
        editor.putString("spopv_2", opv_2selected.toString());
        editor.putString("spopv_2src", opv_2srcselected.toString());
        editor.putString("spopv_3", opv_3selected.toString());
        editor.putString("spopv_3src", opv_3srcselected.toString());
        editor.putString("spp_1", p_1selected.toString());
        editor.putString("spp_1src", p_1srcselected.toString());
        editor.putString("spp_2", p_2selected.toString());
        editor.putString("spp_2src", p_2srcselected.toString());
        editor.putString("spp_3", p_3selected.toString());
        editor.putString("spp_3src", p_3srcselected.toString());
        editor.putString("sppcv_1", pcv_1selected.toString());
        editor.putString("sppcv_1src", pcv_1srcselected.toString());
        editor.putString("sppcv_2", pcv_2selected.toString());
        editor.putString("sppcv_2src", pcv_2srcselected.toString());
        editor.putString("sppcv_3", pcv_3selected.toString());
        editor.putString("sppcv_3src", pcv_3srcselected.toString());
        editor.putString("spm_1", m_1selected.toString());
        editor.putString("spm_1src", m_1srcselected.toString());
        editor.putString("spm_2", m_2selected.toString());
        editor.putString("spm_2src", m_2srcselected.toString());
        editor.putString("spimma", immaselected.toString());
        editor.putString("spimmd", immdselected.toString());
        editor.putString("spimDeviceID", Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));

        switch (imjselected) {

            case R.id.IM_J_Yes:
                editor.putString("spimj", "1");
                break;

            case R.id.IM_J_No:
                editor.putString("spimj", "2");
                break;

            default:
                editor.putString("spimj", "00");
                break;
        }

        editor.commit();
        Log.d(TAG, "Stored sharedValues!");

        S3 = new JSONObject();

        try {

            S3.put("imchid", imchid);
            S3.put("FrmNo", formId);
            imJson = new JSONObject();
            imJson.put("mcFrmNo", sharedPref.getString("spFrmNo", "00"));
            imJson.put("ima", sharedPref.getString("spima", "00"));
            imJson.put("imaf", sharedPref.getString("spimaf", "00"));
            imJson.put("imb", sharedPref.getString("spimb", "00"));
            imJson.put("imc", sharedPref.getString("spimc", "00"));
            imJson.put("imd", sharedPref.getString("spimd", "00"));
            imJson.put("imddoc", sharedPref.getString("spimddoc", "00"));
            imJson.put("imey", sharedPref.getString("spimey", "00"));
            imJson.put("imem", sharedPref.getString("spimem", "00"));
            imJson.put("imed", sharedPref.getString("spimed", "00"));
            imJson.put("imRem", sharedPref.getString("spimRem", "00"));
            imJson.put("imf", sharedPref.getString("spimf", "00"));
            imJson.put("img", sharedPref.getString("spimg", "00"));
            imJson.put("imh", sharedPref.getString("spimh", "00"));
            imJson.put("imi", sharedPref.getString("spimi", "00"));
            imJson.put("imj", sharedPref.getString("spimj", "00"));
            imJson.put("imjb", sharedPref.getString("spimjb", "00"));
            imJson.put("imk", sharedPref.getString("spimk", "00"));
            imJson.put("bcg", sharedPref.getString("spbcg", "00"));
            imJson.put("bcgsrc", sharedPref.getString("spbcgsrc", "00"));
            imJson.put("bcgscar", sharedPref.getString("spbcgscar", "00"));
            imJson.put("opv_0", sharedPref.getString("spopv_0", "00"));
            imJson.put("opv_0src", sharedPref.getString("spopv_0src", "00"));
            imJson.put("opv_1", sharedPref.getString("spopv_1", "00"));
            imJson.put("opv_1src", sharedPref.getString("spopv_1src", "00"));
            imJson.put("opv_2", sharedPref.getString("spopv_2", "00"));
            imJson.put("opv_2src", sharedPref.getString("spopv_2src", "00"));
            imJson.put("opv_3", sharedPref.getString("spopv_3", "00"));
            imJson.put("opv_3src", sharedPref.getString("spopv_3src", "00"));
            imJson.put("p_1", sharedPref.getString("spp_1", "00"));
            imJson.put("p_1src", sharedPref.getString("spp_1src", "00"));
            imJson.put("p_2", sharedPref.getString("spp_2", "00"));
            imJson.put("p_2src", sharedPref.getString("spp_2src", "00"));
            imJson.put("p_3", sharedPref.getString("spp_3", "00"));
            imJson.put("p_3src", sharedPref.getString("spp_3src", "00"));
            imJson.put("pcv_3src", sharedPref.getString("sppcv_3src", "00"));
            imJson.put("pcv_3", sharedPref.getString("sppcv_3", "00"));
            imJson.put("pcv_2src", sharedPref.getString("sppcv_2src", "00"));
            imJson.put("pcv_2", sharedPref.getString("sppcv_2", "00"));
            imJson.put("pcv_1src", sharedPref.getString("sppcv_1src", "00"));
            imJson.put("pcv_1", sharedPref.getString("sppcv_1", "00"));
            imJson.put("m_1", sharedPref.getString("spm_1", "00"));
            imJson.put("m_1src", sharedPref.getString("spm_1src", "00"));
            imJson.put("m_2", sharedPref.getString("spm_2", "00"));
            imJson.put("m_2src", sharedPref.getString("spm_2src", "00"));
            imJson.put("immd", sharedPref.getString("spimmd", "00"));
            imJson.put("imma", sharedPref.getString("spimma", "00"));
            imJson.put("imDeviceID", sharedPref.getString("spimDeviceID", "00"));
            S3.put("im", imJson);


            Log.d(TAG, "JSON for Section 1: " + S3.toString());
            //FormsContract.getInstance().setS3(S3.toString());

            /*FormsContract formContract = new FormsContract(s1);
            FormsDbHelper db = new FormsDbHelper(this);
            try {
                Log.d(TAG, "Adding Form to DB...");
                rowId = db.addForm(formContract);
            } catch (SQLiteException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "Added Form with Id: " + String.valueOf(chid));

    }

    private boolean formValidation() {
        Toast.makeText(getApplicationContext(), "Validating Form Values...", Toast.LENGTH_SHORT).show();

        if (ima.getText().toString().isEmpty() || ima.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Name not Given!", Toast.LENGTH_SHORT).show();

            ima.setError("Name not Given!");
            Log.d(TAG, "Error Type: ima Empty");
            return false;
        }

        if (imaf.getText().toString().isEmpty() || imaf.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Father's Name not Given!", Toast.LENGTH_SHORT).show();
            imaf.setError("Father's Name not Given!");
            Log.d(TAG, "Error Type: imaf Empty");
            return false;
        } else {
            imaf.setError(null);
        }

        if (imb.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) imb.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select a Child's Gender");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Gender.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: imb empty");
            return false;
        }

        if (imb.getSelectedItemPosition() == 1 && boyCount < 1) {
            Toast.makeText(getApplicationContext(), "Boy Count Completed!", Toast.LENGTH_SHORT).show();
            TextView errorText = (TextView) imb.getSelectedView();
            errorText.setError(" ");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Boy Count Completed!");//changes the selected item text to this
            Log.d(TAG, "Error Type: imb - Boy Count: " + boyCount);
            return false;
        }

        if (imb.getSelectedItemPosition() == 2 && girlCount < 1) {
            Toast.makeText(getApplicationContext(), "Girl Count Completed!", Toast.LENGTH_SHORT).show();
            TextView errorText = (TextView) imb.getSelectedView();
            errorText.setError(" ");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Girl Count Completed!");//changes the selected item text to this
            Log.d(TAG, "Error Type: imb - Girl Count: " + girlCount);
            return false;
        }

        if (imc.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) imc.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: imc empty");
            return false;
        }

        if (image.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please Select Age Type", Toast.LENGTH_SHORT).show();
            imagen.setError("Please Select Age Type");
            Log.d(TAG, "Please Select Age Type");
            return false;
        }

        if (!imed.getText().toString().isEmpty() && Integer.valueOf(imed.getText().toString()) > 30) {
            Toast.makeText(getApplicationContext(), "AGE: Days cannot be more than 30", Toast.LENGTH_LONG).show();
            imed.setError("AGE: Days cannot be more than 30");
            Log.d(TAG, "Error Type: imed 30");
            return false;
        }

        if (!imem.getText().toString().isEmpty() && Integer.valueOf(imem.getText().toString()) > 11) {
            Toast.makeText(getApplicationContext(), "AGE: Months cannot be more than 11", Toast.LENGTH_LONG).show();
            imem.setError("AGE: Months cannot be more than 11");
            Log.d(TAG, "Error Type: imem 11");
            return false;
        }

        if (!imey.getText().toString().isEmpty() && Integer.valueOf(imey.getText().toString()) > 4) {
            Toast.makeText(getApplicationContext(), "AGE: Year cannot be more than 4", Toast.LENGTH_LONG).show();
            imey.setError("AGE: Year cannot be more than 4");
            Log.d(TAG, "Error Type: imem 4");
            return false;
        }

        if (imf.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) imf.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Answer");//changes the selected item text to this
            return false;
        }

        if (img.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) img.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: img empty");
            return false;
        }
        
        /*if (imgselected.toString().equals("2") && girlCount < 1) {
            Toast.makeText(getApplicationContext(), "Girl Count Completed!", Toast.LENGTH_SHORT).show();
            TextView errorText = (TextView) imb.getSelectedView();
            errorText.setError(" ");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Girl Count Completed!");//changes the selected item text to this
            Log.d(TAG, "Error Type: imb - Girl Count: " + girlCount);
            return false;
        }*/

        if (imh.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) imh.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: imh empty");
            return false;
        }
        if (imi.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) imi.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: imi empty");
            return false;
        }

        if (imj.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please Select an answer", Toast.LENGTH_SHORT).show();
            imj_no.setError("Please Select an answer");
            Log.d(TAG, "Error Type: imj empty");
            return false;
        }
        
        if (imjb.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) imjb.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: imjb empty");
            return false;
        }
        if (imj.getCheckedRadioButtonId() == 0 && imk.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) imk.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: imk empty");
            return false;
        }
        if (bcg.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) bcg.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select BCG.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: bcg empty");
            return false;
        }
        if (bcgsrc.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) bcgsrc.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select BCG-Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: BCGscr empty");
            return false;
        }

        if (bcgscar.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) bcgscar.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select BCG0Scar.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: BCGScar empty");
            return false;

        }
        if (opv_0.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) opv_0.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select OPV.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: OPV empty");
            return false;
        }
        if (opv_0src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) opv_0src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select OPV Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: OPVsrc empty");
            return false;
        }
        if (opv_1.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) opv_1.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select OPV1.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: OPV1 empty");
            return false;
        }
        if (opv_1src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) opv_1src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an OPV1 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: OPVScr empty");
            return false;
        }
        if (opv_2.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) opv_2.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an OPV2.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: OPV2 empty");
            return false;
        }
        if (opv_2src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) opv_2src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select OPV2 Src.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: OPV2 Src empty");
            return false;
        }
        if (opv_3.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) opv_3.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select OPV3.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: OPV3 empty");
            return false;
        }
        if (opv_3src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) opv_3src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an OPV3 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: OPV3_src empty");
            return false;
        }
        if (p_1.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) p_1.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Penta 1.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: P1 empty");
            return false;
        }
        if (p_1src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) p_1src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Penta 1 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: P1Src empty");
            return false;
        }
        if (p_2.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) p_2.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Penta 2.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: P2 empty");
            return false;
        }
        if (p_2src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) p_2src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Penta 2 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: P2 empty");
            return false;
        }
        if (p_3.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) p_3.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Penta 3.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: P3 empty");
            return false;
        }
        if (p_3src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) p_3src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Penta 3 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: P3src empty");
            return false;
        }
        if (pcv_1.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) pcv_1.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select PCV 1.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: pvc1 empty");
            return false;
        }
        if (pcv_1src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) pcv_1src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select PVC1 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: PVC1src empty");
            return false;
        }
        if (pcv_2.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) pcv_2.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: imc empty");
            return false;
        }
        if (pcv_2src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) pcv_2src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select PCV2 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: PCV2src empty");
            return false;
        }
        if (pcv_3.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) pcv_3.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select PCV 3.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: pcv3src empty");
            return false;
        }
        if (pcv_3src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) pcv_3src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select PCV3 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: pcv3src empty");
            return false;
        }
        if (m_1.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) m_1.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Measles 1.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: m_1 empty");
            return false;
        }
        if (m_1src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) m_1src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Measles 1 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: m_1src empty");
            return false;
        }
        if (m_2.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) m_2.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Measles 2.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: m_2 empty");
            return false;
        }
        if (m_2src.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) m_2src.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Measles 2 Source.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: m_2src empty");
            return false;
        }
        if (immd.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) immd.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select Diarrhea.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: immd empty");
            return false;
        }
        if (imma.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) imma.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select ARI.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: imma empty");
            return false;
        }

        
        
        /*if (!imey.toString().isEmpty() && !imey.toString().isEmpty()) {

            Calendar today = Calendar.getInstance();
            Calendar dob = Calendar.getInstance();

            dob.set(imd.getYear(), imd.getMonth(), imd.getDayOfMonth());
            int ageA = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

            if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                ageA--;
            }
            if (ageA < Integer.valueOf(imey.getText().toString()) || ageA > Integer.valueOf(imey.getText().toString())) {

                Toast.makeText(getApplicationContext(), "Age does not match Date of Birth", Toast.LENGTH_SHORT).show();
                imey.setError("Age does not match Date of Birth");
                Log.d(TAG, "Error Type: imey mismatch");
                return false;
            }


        }



        if (imey.getText().toString().isEmpty() || imey.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Year of Birth not Given!", Toast.LENGTH_SHORT).show();
            imey.setError("Year of Birth not Given!");
            Log.d(TAG, "Error Type: imey Empty");
            return false;
        }

        if (imem.getText().toString().isEmpty() || imem.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Month of Birth not Given!", Toast.LENGTH_SHORT).show();
            imem.setError("Month of Birth not Given!");
            Log.d(TAG, "Error Type: imem Empty");
            return false;
        }

        if (imed.getText().toString().isEmpty() || imed.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Day of Birth not Given!", Toast.LENGTH_SHORT).show();
            imed.setError("Day of Birth not Given!");
            Log.d(TAG, "Error Type: imem Empty");
            return false;
        }

        if (!imed.getText().toString().isEmpty() && !imem.getText().toString().isEmpty() && !imey.getText().toString().isEmpty()) {
            if (imem.getText().toString().equals(imd.getMonth())
                    || imed.getText().toString().equals(imd.getDayOfMonth())
                    || imey.getText().toString().equals(imd.getYear())
                    ) {
                Toast.makeText(getApplicationContext(), "Date of Birth do not match!", Toast.LENGTH_SHORT).show();
                imed.setError("Date of Birth do not match!");
                Log.d(TAG, "Error Type: DOB Do Not Match");
                return false;
            }
        }*/
        if (imcselected.equals("2")) {

            if (bcgsrc.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card BCG Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) bcgsrc.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card BCG Source");//changes the selected item text to this
                return false;
            }
            if (opv_0src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card OPV 0 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) opv_0src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (opv_1src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card OPV 1 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) opv_1src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (opv_2src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card OPV 2 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) opv_2src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (opv_3src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card OPV 3 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) opv_3src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (p_1src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card Penta 1 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) p_1src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (p_2src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card Penta 2 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) p_2src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (p_3src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card Penta 3 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) p_3src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (pcv_1src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card PCV 1 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) pcv_1src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (pcv_2src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card PCV 2 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) pcv_2src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (pcv_3src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card PCV 3 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) pcv_3src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (m_1src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card Measles 1 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) m_1src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }
            if (m_2src.getSelectedItemPosition() == 0) {
                Toast.makeText(getApplicationContext(), "Invalid Card Measles 2 Source", Toast.LENGTH_SHORT).show();
                TextView errorText = (TextView) m_2src.getSelectedView();
                errorText.setError(" ");
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("Invalid Card Source");//changes the selected item text to this
                return false;
            }

        }

        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Button NOT Allowed!", Toast.LENGTH_SHORT).show();


    }

}
