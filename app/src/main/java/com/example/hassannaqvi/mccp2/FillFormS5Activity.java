package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

public class FillFormS5Activity extends AppCompatActivity {

    private static final String TAG = "FILL_FORM_S5_ACTIVITY";
    private String formId;
    private Spinner mc501;
    private EditText mc501_88;
    private RadioGroup mc502;
    private RadioButton mc502_yes;
    private RadioButton mc502_no;
    private CheckBox mc503Alhw;
    private CheckBox mc503Afcv;
    private CheckBox mc503Alhs;
    private CheckBox mc503Ango;
    private EditText mc503Ax;
    private CheckBox mc503Blhw;
    private CheckBox mc503Bfcv;
    private CheckBox mc503Blhs;
    private CheckBox mc503Bngo;
    private EditText mc503Bx;
    private CheckBox mc503Clhw;
    private CheckBox mc503Cfcv;
    private CheckBox mc503Clhs;
    private CheckBox mc503Cngo;
    private EditText mc503Cx;
    private CheckBox mc503Dlhw;
    private CheckBox mc503Dfcv;
    private CheckBox mc503Dlhs;
    private CheckBox mc503Dngo;
    private EditText mc503Dx;
    private CheckBox mc503Elhw;
    private CheckBox mc503Efcv;
    private CheckBox mc503Elhs;
    private CheckBox mc503Engo;
    private EditText mc503Ex;
    private CheckBox mc503Flhw;
    private CheckBox mc503Ffcv;
    private CheckBox mc503Flhs;
    private CheckBox mc503Fngo;
    private EditText mc503Fx;
    private CheckBox mc503Glhw;
    private CheckBox mc503Gfcv;
    private CheckBox mc503Glhs;
    private CheckBox mc503Gngo;
    private EditText mc503Gx;
    private CheckBox mc503Xlhw;
    private CheckBox mc503Xfcv;
    private CheckBox mc503Xlhs;
    private CheckBox mc503Xngo;
    private EditText mc503Xx;
    private Spinner mc504W;
    private EditText mc504Wx;
    private Spinner mc504R;
    private EditText mc504Rx;
    private Spinner mc504F;
    private EditText mc504Fx;
    private Spinner mc505;
    private EditText mc506;
    private Spinner mc507;
    private Spinner mc508;
    private EditText mc508x;
    private Spinner mc509;
    private EditText mc509x;
    private Spinner mc510;
    private EditText mc510x;
    private RadioGroup mc511;
    private RadioButton mc511_yes;
    private RadioButton mc511_no;
    private CheckBox mc512_1;
    private CheckBox mc512_2;
    private CheckBox mc512_3;
    private CheckBox mc512_4;
    private CheckBox mc512_5;
    private CheckBox mc512_6;
    private CheckBox mc512_7;
    private CheckBox mc512_8;
    private CheckBox mc512_88;
    private EditText mc512x;
    private RadioGroup mc513;
    private RadioButton mc513_1;
    private RadioButton mc513_2;
    private RadioButton mc513_3;
    private RadioButton mc513_4;
    private RadioButton mc513_5;
    private RadioButton mc513_6;
    private RadioButton mc513_7;
    private RadioButton mc513_88;
    private EditText mc513x;
    private RadioGroup mc514;
    private RadioButton mc514_yes;
    private RadioButton mc514_no;
    private EditText mc515;
    private Spinner mc516;
    private RadioGroup mc517;
    private RadioButton mc517_1;
    private RadioButton mc517_2;
    private RadioButton mc517_3;
    private Spinner mc518;
    private RadioGroup mc519;
    private RadioButton mc519_1;
    private RadioButton mc519_2;
    private RadioButton mc519_3;
    private RadioButton mc519_4;
    private RadioButton mc519_5;
    private RadioGroup mc520;
    private RadioButton mc520_yes;
    private RadioButton mc520_no;
    private Spinner mc521;
    private RadioButton mc521_1;
    private RadioButton mc521_2;
    private RadioButton mc521_3;
    private RadioButton mc521_4;
    private RadioButton mc521_5;
    private RadioGroup mc522;
    private CheckBox mc522_1;
    private CheckBox mc522_2;
    private CheckBox mc522_3;
    private CheckBox mc522_4;
    private CheckBox mc522_5;
    private CheckBox mc522_6;
    private CheckBox mc522_7;
    private CheckBox mc522_8;
    private CheckBox mc522_9;
    private CheckBox mc522_88;
    private EditText mc522X;
    private RadioGroup mc523;
    private RadioButton mc523_yes;
    private RadioButton mc523_no;
    private EditText mc524ACR;
    private EditText mc524CAN;
    private CheckBox mc524_99;

    private EditText mc525_1;
    private EditText mc525_2;
    private EditText mc525_3;
    private EditText mc525_4;
    private EditText mc525_5;
    private EditText mc525_6;
    private EditText mc525_7;
    private EditText mc525_7x;
    private EditText mc525_8;
    private EditText mc525_9;
    private EditText mc525_10;
    private EditText mc525_11;
    private EditText mc525_12;
    private EditText mc525_13;
    private EditText mc525_14;
    private EditText mc525_15;
    private EditText mc525_16;
    private EditText mc525_17;
    private EditText mc525_18;
    private EditText mc525_19;
    private EditText mc525_20;

    private String mc501selected; // Spinner option selected
    private Integer mc502selected;
    private String mc504Wselected;
    private String mc504Rselected;
    private String mc504Fselected;
    private String mc505selected;
    private String mc507selected;
    private String mc508selected;
    private String mc509selected;
    private String mc510selected;
    private Integer mc511selected;
    private Integer mc513selected;
    private Integer mc514selected;
    private String mc516selected;
    private Integer mc517selected;
    private String mc518selected;
    private Integer mc519selected;
    private Integer mc520selected;
    private String mc521selected;
    private Integer mc523selected;


    private ScrollView fldGrp502;
    private LinearLayout fldGrp511;
    private LinearLayout fldGrp513;
    private LinearLayout fldGrp514;
    private LinearLayout fldGrp517;
    private LinearLayout fldGrp519;
    private LinearLayout fldGrp520;
    private LinearLayout fldGrp523;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form_s5);

        formId = getIntent().getStringExtra("formId");

        mc501 = (Spinner) findViewById(R.id.MC_501);
        mc501_88 = (EditText) findViewById(R.id.MC_501_88);
        mc502 = (RadioGroup) findViewById(R.id.MC_502);
        mc502_yes = (RadioButton) findViewById(R.id.MC_502_Yes);
        mc502_no = (RadioButton) findViewById(R.id.MC_502_No);
        mc503Alhw = (CheckBox) findViewById(R.id.MC_503_A_LHW);
        mc503Afcv = (CheckBox) findViewById(R.id.MC_503_A_FCV);
        mc503Alhs = (CheckBox) findViewById(R.id.MC_503_A_LHS);
        mc503Ango = (CheckBox) findViewById(R.id.MC_503_A_NGO);
        mc503Ax = (EditText) findViewById(R.id.MC_503_A_X);
        mc503Blhw = (CheckBox) findViewById(R.id.MC_503_B_LHW);
        mc503Bfcv = (CheckBox) findViewById(R.id.MC_503_B_FCV);
        mc503Blhs = (CheckBox) findViewById(R.id.MC_503_B_LHS);
        mc503Bngo = (CheckBox) findViewById(R.id.MC_503_B_NGO);
        mc503Bx = (EditText) findViewById(R.id.MC_503_B_X);
        mc503Clhw = (CheckBox) findViewById(R.id.MC_503_C_LHW);
        mc503Cfcv = (CheckBox) findViewById(R.id.MC_503_C_FCV);
        mc503Clhs = (CheckBox) findViewById(R.id.MC_503_C_LHS);
        mc503Cngo = (CheckBox) findViewById(R.id.MC_503_C_NGO);
        mc503Cx = (EditText) findViewById(R.id.MC_503_C_X);
        mc503Dlhw = (CheckBox) findViewById(R.id.MC_503_D_LHW);
        mc503Dfcv = (CheckBox) findViewById(R.id.MC_503_D_FCV);
        mc503Dlhs = (CheckBox) findViewById(R.id.MC_503_D_LHS);
        mc503Dngo = (CheckBox) findViewById(R.id.MC_503_D_NGO);
        mc503Dx = (EditText) findViewById(R.id.MC_503_D_X);
        mc503Elhw = (CheckBox) findViewById(R.id.MC_503_E_LHW);
        mc503Efcv = (CheckBox) findViewById(R.id.MC_503_E_FCV);
        mc503Elhs = (CheckBox) findViewById(R.id.MC_503_E_LHS);
        mc503Engo = (CheckBox) findViewById(R.id.MC_503_E_NGO);
        mc503Ex = (EditText) findViewById(R.id.MC_503_E_X);
        mc503Flhw = (CheckBox) findViewById(R.id.MC_503_F_LHW);
        mc503Ffcv = (CheckBox) findViewById(R.id.MC_503_F_FCV);
        mc503Flhs = (CheckBox) findViewById(R.id.MC_503_F_LHS);
        mc503Fngo = (CheckBox) findViewById(R.id.MC_503_F_NGO);
        mc503Fx = (EditText) findViewById(R.id.MC_503_F_X);
        mc503Glhw = (CheckBox) findViewById(R.id.MC_503_G_LHW);
        mc503Gfcv = (CheckBox) findViewById(R.id.MC_503_G_FCV);
        mc503Glhs = (CheckBox) findViewById(R.id.MC_503_G_LHS);
        mc503Gngo = (CheckBox) findViewById(R.id.MC_503_G_NGO);
        mc503Gx = (EditText) findViewById(R.id.MC_503_G_X);
        mc503Xlhw = (CheckBox) findViewById(R.id.MC_503_X_LHW);
        mc503Xfcv = (CheckBox) findViewById(R.id.MC_503_X_FCV);
        mc503Xlhs = (CheckBox) findViewById(R.id.MC_503_X_LHS);
        mc503Xngo = (CheckBox) findViewById(R.id.MC_503_X_NGO);
        mc503Xx = (EditText) findViewById(R.id.MC_503_X_X);
        mc504W = (Spinner) findViewById(R.id.MC_504W);
        mc504Wx = (EditText) findViewById(R.id.MC_504_W88);
        mc504R = (Spinner) findViewById(R.id.MC_504R);
        mc504Rx = (EditText) findViewById(R.id.MC_504_R88);
        mc504F = (Spinner) findViewById(R.id.MC_504F);
        mc504Fx = (EditText) findViewById(R.id.MC_504_F88);
        mc505 = (Spinner) findViewById(R.id.MC_505);
        mc506 = (EditText) findViewById(R.id.MC_506);
        mc507 = (Spinner) findViewById(R.id.MC_507);
        mc508 = (Spinner) findViewById(R.id.MC_508);
        mc508x = (EditText) findViewById(R.id.MC_508_88);
        mc509 = (Spinner) findViewById(R.id.MC_509);
        mc509x = (EditText) findViewById(R.id.MC_509_88);
        mc510 = (Spinner) findViewById(R.id.MC_510);
        mc510x = (EditText) findViewById(R.id.MC_510_88);
        mc511 = (RadioGroup) findViewById(R.id.MC_511);
        mc511_yes = (RadioButton) findViewById(R.id.MC_511_Yes);
        mc511_no = (RadioButton) findViewById(R.id.MC_511_No);
        mc512_1 = (CheckBox) findViewById(R.id.MC_512_1);
        mc512_2 = (CheckBox) findViewById(R.id.MC_512_2);
        mc512_3 = (CheckBox) findViewById(R.id.MC_512_3);
        mc512_4 = (CheckBox) findViewById(R.id.MC_512_4);
        mc512_5 = (CheckBox) findViewById(R.id.MC_512_5);
        mc512_6 = (CheckBox) findViewById(R.id.MC_512_6);
        mc512_7 = (CheckBox) findViewById(R.id.MC_512_7);
        mc512_8 = (CheckBox) findViewById(R.id.MC_512_8);
        mc512_88 = (CheckBox) findViewById(R.id.MC_512_88);
        mc512x = (EditText) findViewById(R.id.MC_512X);
        mc513 = (RadioGroup) findViewById(R.id.MC_513);
        mc513_1 = (RadioButton) findViewById(R.id.MC_513_1);
        mc513_2 = (RadioButton) findViewById(R.id.MC_513_2);
        mc513_3 = (RadioButton) findViewById(R.id.MC_513_3);
        mc513_4 = (RadioButton) findViewById(R.id.MC_513_4);
        mc513_5 = (RadioButton) findViewById(R.id.MC_513_5);
        mc513_6 = (RadioButton) findViewById(R.id.MC_513_6);
        mc513_7 = (RadioButton) findViewById(R.id.MC_513_7);
        mc513_88 = (RadioButton) findViewById(R.id.MC_513_88);
        mc513x = (EditText) findViewById(R.id.MC_513X);
        mc514 = (RadioGroup) findViewById(R.id.MC_514);
        mc514_yes = (RadioButton) findViewById(R.id.MC_514_Yes);
        mc514_no = (RadioButton) findViewById(R.id.MC_514_No);
        mc515 = (EditText) findViewById(R.id.MC_515);
        mc516 = (Spinner) findViewById(R.id.MC_516);
        mc517 = (RadioGroup) findViewById(R.id.MC_517);
        mc517_1 = (RadioButton) findViewById(R.id.MC_517_1);
        mc517_2 = (RadioButton) findViewById(R.id.MC_517_2);
        mc517_3 = (RadioButton) findViewById(R.id.MC_517_3);
        mc518 = (Spinner) findViewById(R.id.MC_518);
        mc519 = (RadioGroup) findViewById(R.id.MC_519);
        mc519_1 = (RadioButton) findViewById(R.id.MC_519_1);
        mc519_2 = (RadioButton) findViewById(R.id.MC_519_2);
        mc519_3 = (RadioButton) findViewById(R.id.MC_519_3);
        mc519_3 = (RadioButton) findViewById(R.id.MC_519_4);
        mc519_3 = (RadioButton) findViewById(R.id.MC_519_5);
        mc520 = (RadioGroup) findViewById(R.id.MC_520);
        mc520_yes = (RadioButton) findViewById(R.id.MC_520_Yes);
        mc520_no = (RadioButton) findViewById(R.id.MC_520_No);
        mc521 = (Spinner) findViewById(R.id.MC_521);
        mc522_1 = (CheckBox) findViewById(R.id.MC_522_1);
        mc522_2 = (CheckBox) findViewById(R.id.MC_522_2);
        mc522_3 = (CheckBox) findViewById(R.id.MC_522_3);
        mc522_4 = (CheckBox) findViewById(R.id.MC_522_4);
        mc522_5 = (CheckBox) findViewById(R.id.MC_522_5);
        mc522_6 = (CheckBox) findViewById(R.id.MC_522_6);
        mc522_7 = (CheckBox) findViewById(R.id.MC_522_7);
        mc522_8 = (CheckBox) findViewById(R.id.MC_522_8);
        mc522_9 = (CheckBox) findViewById(R.id.MC_522_9);
        mc522_88 = (CheckBox) findViewById(R.id.MC_522_88);
        mc522X = (EditText) findViewById(R.id.MC_522X);
        mc523 = (RadioGroup) findViewById(R.id.MC_523);
        mc523_yes = (RadioButton) findViewById(R.id.MC_523_Yes);
        mc523_no = (RadioButton) findViewById(R.id.MC_523_No);
        mc524ACR = (EditText) findViewById(R.id.MC_524ACR);
        mc524CAN = (EditText) findViewById(R.id.MC_524CAN);
        mc524_99 = (CheckBox) findViewById(R.id.MC_524_99);
        mc525_1 = (EditText) findViewById(R.id.MC_525_1);
        mc525_2 = (EditText) findViewById(R.id.MC_525_2);
        mc525_3 = (EditText) findViewById(R.id.MC_525_3);
        mc525_4 = (EditText) findViewById(R.id.MC_525_4);
        mc525_5 = (EditText) findViewById(R.id.MC_525_5);
        mc525_6 = (EditText) findViewById(R.id.MC_525_6);
        mc525_7 = (EditText) findViewById(R.id.MC_525_7);
        mc525_7x = (EditText) findViewById(R.id.MC_525_7X);
        mc525_8 = (EditText) findViewById(R.id.MC_525_8);
        mc525_9 = (EditText) findViewById(R.id.MC_525_9);
        mc525_10 = (EditText) findViewById(R.id.MC_525_10);
        mc525_11 = (EditText) findViewById(R.id.MC_525_11);
        mc525_12 = (EditText) findViewById(R.id.MC_525_12);
        mc525_13 = (EditText) findViewById(R.id.MC_525_13);
        mc525_14 = (EditText) findViewById(R.id.MC_525_14);
        mc525_15 = (EditText) findViewById(R.id.MC_525_15);
        mc525_16 = (EditText) findViewById(R.id.MC_525_16);
        mc525_17 = (EditText) findViewById(R.id.MC_525_17);
        mc525_18 = (EditText) findViewById(R.id.MC_525_18);
        mc525_19 = (EditText) findViewById(R.id.MC_525_19);
        mc525_20 = (EditText) findViewById(R.id.MC_525_20);

        fldGrp502 = (ScrollView) findViewById(R.id.fldGrp502);
        fldGrp511 = (LinearLayout) findViewById(R.id.fldGrp511);
        fldGrp513 = (LinearLayout) findViewById(R.id.fldGrp513);
        fldGrp514 = (LinearLayout) findViewById(R.id.fldGrp514);
        fldGrp517 = (LinearLayout) findViewById(R.id.fldGrp517);
        fldGrp519 = (LinearLayout) findViewById(R.id.fldGrp519);
        fldGrp520 = (LinearLayout) findViewById(R.id.fldGrp520);
        fldGrp523 = (LinearLayout) findViewById(R.id.fldGrp523);


        mc502.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc502_yes.getId()) {
                    fldGrp502.setVisibility(View.VISIBLE);
                } else {
                    fldGrp502.setVisibility(View.GONE);
                }
            }
        });
        mc511.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc511_yes.getId()) {
                    fldGrp511.setVisibility(View.VISIBLE);
                } else {
                    fldGrp511.setVisibility(View.GONE);
                }
            }
        });

        mc513.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc513_7.getId()) {
                    fldGrp513.setVisibility(View.GONE);
                } else {
                    fldGrp513.setVisibility(View.VISIBLE);
                }
            }
        });
        mc514.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc514_yes.getId()) {
                    fldGrp514.setVisibility(View.VISIBLE);
                } else {
                    fldGrp514.setVisibility(View.GONE);
                }
            }
        });
        mc517.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc517_1.getId()) {
                    fldGrp517.setVisibility(View.VISIBLE);
                } else {
                    fldGrp517.setVisibility(View.GONE);
                }
            }
        });
        mc519.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc519_1.getId()) {
                    fldGrp519.setVisibility(View.VISIBLE);
                } else {
                    fldGrp519.setVisibility(View.GONE);
                }
            }
        });
        mc520.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc520_yes.getId()) {
                    fldGrp520.setVisibility(View.VISIBLE);
                } else {
                    fldGrp520.setVisibility(View.GONE);
                }
            }
        });
        mc523.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc523_yes.getId()) {
                    fldGrp523.setVisibility(View.VISIBLE);
                } else {
                    fldGrp523.setVisibility(View.GONE);
                }
            }
        });


    }

    public void openSection6(View view) {


        //RadioButton Selected for switches in putString()
        mc502selected = mc502.getCheckedRadioButtonId();
        mc511selected = mc511.getCheckedRadioButtonId();
        mc513selected = mc513.getCheckedRadioButtonId();
        mc514selected = mc514.getCheckedRadioButtonId();
        mc517selected = mc517.getCheckedRadioButtonId();
        mc519selected = mc519.getCheckedRadioButtonId();
        mc520selected = mc520.getCheckedRadioButtonId();
        mc523selected = mc523.getCheckedRadioButtonId();

        //Spinner getting value of selected for putString()

        mc501selected = getResources().getStringArray(R.array.MC_501_value)[mc501.getSelectedItemPosition()];
        mc504Wselected = getResources().getStringArray(R.array.MC_504W_value)[mc504W.getSelectedItemPosition()];
        mc504Rselected = getResources().getStringArray(R.array.MC_504R_value)[mc504R.getSelectedItemPosition()];
        mc504Fselected = getResources().getStringArray(R.array.MC_504F_value)[mc504F.getSelectedItemPosition()];

        mc505selected = getResources().getStringArray(R.array.MC_505_value)[mc505.getSelectedItemPosition()];

        mc507selected = getResources().getStringArray(R.array.MC_YN_value)[mc507.getSelectedItemPosition()];
        mc508selected = getResources().getStringArray(R.array.MC_508_value)[mc508.getSelectedItemPosition()];
        mc509selected = getResources().getStringArray(R.array.MC_509_value)[mc509.getSelectedItemPosition()];
        mc510selected = getResources().getStringArray(R.array.MC_510_value)[mc510.getSelectedItemPosition()];

        mc516selected = getResources().getStringArray(R.array.MC_YNDK_value)[mc516.getSelectedItemPosition()];
        mc518selected = getResources().getStringArray(R.array.MC_518_value)[mc518.getSelectedItemPosition()];

        mc521selected = getResources().getStringArray(R.array.MC_521_value)[mc521.getSelectedItemPosition()];


        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();

            Intent s6_form_intent = new Intent(getApplicationContext(), FillFormS6Activity.class);
            s6_form_intent.putExtra("formId", formId);
            //s2_form_intent.putExtra("boyCount", mc204m.getText().toString());
            //s2_form_intent.putExtra("girlCount", mc204f.getText().toString());
            startActivity(s6_form_intent);
        } else {


        }
    }

    private boolean formValidation() {
        if (mc502selected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc502_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 502 not selected");
            return false;
        }
        if (
                mc503Alhs.isChecked() || mc503Afcv.isChecked() || mc503Alhw.isChecked() || mc503Ango.isChecked() || !mc503Ax.getText().toString().isEmpty() ||
                        mc503Blhs.isChecked() || mc503Bfcv.isChecked() || mc503Blhw.isChecked() || mc503Bngo.isChecked() || !mc503Ax.getText().toString().isEmpty() ||
                        mc503Clhs.isChecked() || mc503Cfcv.isChecked() || mc503Clhw.isChecked() || mc503Cngo.isChecked() || !mc503Ax.getText().toString().isEmpty() ||
                        mc503Dlhs.isChecked() || mc503Dfcv.isChecked() || mc503Dlhw.isChecked() || mc503Dngo.isChecked() || !mc503Ax.getText().toString().isEmpty() ||
                        mc503Elhs.isChecked() || mc503Efcv.isChecked() || mc503Elhw.isChecked() || mc503Engo.isChecked() || !mc503Ax.getText().toString().isEmpty() ||
                        mc503Flhs.isChecked() || mc503Ffcv.isChecked() || mc503Flhw.isChecked() || mc503Fngo.isChecked() || !mc503Ax.getText().toString().isEmpty() ||
                        mc503Glhs.isChecked() || mc503Gfcv.isChecked() || mc503Glhw.isChecked() || mc503Gngo.isChecked() || !mc503Ax.getText().toString().isEmpty() ||
                        mc503Xlhs.isChecked() || mc503Xfcv.isChecked() || mc503Xlhw.isChecked() || mc503Xngo.isChecked() || !mc503Ax.getText().toString().isEmpty()

                ) {


        } else {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc503Gx.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 503 not selected");
            return false;
        }

        if (mc506.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please write an answer!", Toast.LENGTH_SHORT).show();
            mc506.setError("Please write an answer!");
            Log.d(TAG, "Error Type: 506 not selected");
            return false;
        }

        if (mc511selected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc511_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 511 not selected");
            return false;

        }
        if (mc514_yes.isChecked() && mc515.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please write an answer!", Toast.LENGTH_SHORT).show();
            mc515.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 515 not selected");
            return false;
        }
        if (mc520_yes.isChecked() && (mc521selected.equals("-1"))) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc521_5.setError("Please Select an answer!");
            Log.d(TAG, "Error Type: 515 not selected");
            return false;
        }
        if (mc523selected == -1
                && mc524ACR.getText().toString().isEmpty()
                && mc524CAN.getText().toString().isEmpty()
                && !mc524_99.isChecked()) {
            Toast.makeText(getApplicationContext(), "Please write an answer!", Toast.LENGTH_SHORT).show();
            mc524ACR.setError("Please write an answer!");
            mc524CAN.setError("Please write an answer!");
            Log.d(TAG, "Error Type: 524 not Answered");
            return false;
        }


        return true;
    }

    private void StoreTempValues() {

        Toast.makeText(getApplicationContext(), "Storing Temporary Form Values...", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences(FillFormActivity.FORM_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();


        // Putting values of CheckBoxes
        editor.putString("sp503Alhw", (mc503Alhw.isChecked() ? "1" : ""));
        editor.putString("sp503Afcv", (mc503Afcv.isChecked() ? "2" : ""));
        editor.putString("sp503Alhs", (mc503Alhs.isChecked() ? "3" : ""));
        editor.putString("sp503Ango", (mc503Ango.isChecked() ? "4" : ""));

        editor.putString("sp503Blhw", (mc503Blhw.isChecked() ? "1" : ""));
        editor.putString("sp503Bfcv", (mc503Bfcv.isChecked() ? "2" : ""));
        editor.putString("sp503Blhs", (mc503Blhs.isChecked() ? "3" : ""));
        editor.putString("sp503Bngo", (mc503Bngo.isChecked() ? "4" : ""));

        editor.putString("sp503Clhw", (mc503Clhw.isChecked() ? "1" : ""));
        editor.putString("sp503Cfcv", (mc503Cfcv.isChecked() ? "2" : ""));
        editor.putString("sp503Clhs", (mc503Clhs.isChecked() ? "3" : ""));
        editor.putString("sp503Cngo", (mc503Cngo.isChecked() ? "4" : ""));

        editor.putString("sp503Dlhw", (mc503Dlhw.isChecked() ? "1" : ""));
        editor.putString("sp503Dfcv", (mc503Dfcv.isChecked() ? "2" : ""));
        editor.putString("sp503Dlhs", (mc503Dlhs.isChecked() ? "3" : ""));
        editor.putString("sp503Dngo", (mc503Dngo.isChecked() ? "4" : ""));

        editor.putString("sp503Elhw", (mc503Elhw.isChecked() ? "1" : ""));
        editor.putString("sp503Efcv", (mc503Efcv.isChecked() ? "2" : ""));
        editor.putString("sp503Elhs", (mc503Elhs.isChecked() ? "3" : ""));
        editor.putString("sp503Engo", (mc503Engo.isChecked() ? "4" : ""));

        editor.putString("sp503Flhw", (mc503Flhw.isChecked() ? "1" : ""));
        editor.putString("sp503Ffcv", (mc503Ffcv.isChecked() ? "2" : ""));
        editor.putString("sp503lhs", (mc503Flhs.isChecked() ? "3" : ""));
        editor.putString("sp503Fngo", (mc503Fngo.isChecked() ? "4" : ""));

        editor.putString("sp503Glhw", (mc503Glhw.isChecked() ? "1" : ""));
        editor.putString("sp503Gfcv", (mc503Gfcv.isChecked() ? "2" : ""));
        editor.putString("sp503Glhs", (mc503Glhs.isChecked() ? "3" : ""));
        editor.putString("sp503Gngo", (mc503Gngo.isChecked() ? "4" : ""));

        editor.putString("sp503Xlhw", (mc503Xlhw.isChecked() ? "1" : ""));
        editor.putString("sp503Xfcv", (mc503Xfcv.isChecked() ? "2" : ""));
        editor.putString("sp503Xlhs", (mc503Xlhs.isChecked() ? "3" : ""));
        editor.putString("sp503Xngo", (mc503Xngo.isChecked() ? "4" : ""));


        editor.putString("sp512_1", (mc512_1.isChecked() ? "1" : ""));
        editor.putString("sp512_2", (mc512_2.isChecked() ? "2" : ""));
        editor.putString("sp512_3", (mc512_3.isChecked() ? "3" : ""));
        editor.putString("sp512_4", (mc512_4.isChecked() ? "4" : ""));
        editor.putString("sp512_5", (mc512_5.isChecked() ? "5" : ""));

        editor.putString("sp522_1", (mc522_1.isChecked() ? "1" : ""));
        editor.putString("sp522_2", (mc522_2.isChecked() ? "2" : ""));
        editor.putString("sp522_3", (mc522_3.isChecked() ? "3" : ""));
        editor.putString("sp522_4", (mc522_4.isChecked() ? "4" : ""));
        editor.putString("sp522_5", (mc522_5.isChecked() ? "5" : ""));
        editor.putString("sp522_6", (mc522_6.isChecked() ? "6" : ""));
        editor.putString("sp522_7", (mc522_7.isChecked() ? "7" : ""));
        editor.putString("sp522_8", (mc522_8.isChecked() ? "8" : ""));
        editor.putString("sp522_9", (mc522_9.isChecked() ? "9" : ""));
        editor.putString("sp522_88", (mc522_88.isChecked() ? "88" : ""));


        // Putting values of Radiobuttons
        switch (mc502selected) {

            case R.id.MC_502_Yes:
                editor.putString("sp502", "1");
                break;

            case R.id.MC_502_No:
                editor.putString("sp502", "2");
                break;

            default:
                editor.putString("sp502", "00");
                break;
        }

        switch (mc511selected) {

            case R.id.MC_511_Yes:
                editor.putString("sp511", "1");
                break;

            case R.id.MC_502_No:
                editor.putString("sp511", "2");
                break;

            default:
                editor.putString("sp511", "00");
                break;
        }


        switch (mc513selected) {

            case R.id.MC_513_1:
                editor.putString("sp513", "1");
                break;

            case R.id.MC_513_2:
                editor.putString("sp513", "2");
                break;

            case R.id.MC_513_3:
                editor.putString("sp513", "3");
                break;


            case R.id.MC_513_4:
                editor.putString("sp513", "4");
                break;

            case R.id.MC_513_5:
                editor.putString("sp513", "5");
                break;

            case R.id.MC_513_6:
                editor.putString("sp513", "6");
                break;

            case R.id.MC_513_7:
                editor.putString("sp513", "7");
                break;

            case R.id.MC_513_88:
                editor.putString("sp513", "88");
                break;

            default:
                editor.putString("sp513", "00");
                break;
        }


        switch (mc514selected) {

            case R.id.MC_514_Yes:
                editor.putString("sp514", "1");
                break;

            case R.id.MC_514_No:
                editor.putString("sp514", "2");
                break;

            default:
                editor.putString("sp514", "00");
                break;
        }


        switch (mc517selected) {

            case R.id.MC_517_1:
                editor.putString("sp517", "1");
                break;

            case R.id.MC_517_2:
                editor.putString("sp517", "2");
                break;
            case R.id.MC_517_3:
                editor.putString("sp517", "3");
                break;

            default:
                editor.putString("sp517", "00");
                break;
        }


        switch (mc519selected) {

            case R.id.MC_519_1:
                editor.putString("sp519", "1");
                break;

            case R.id.MC_519_2:
                editor.putString("sp519", "2");
                break;

            case R.id.MC_519_3:
                editor.putString("sp519", "3");
                break;

            case R.id.MC_519_4:
                editor.putString("sp519", "4");
                break;

            case R.id.MC_519_5:
                editor.putString("sp519", "5");
                break;


            default:
                editor.putString("sp519", "00");
                break;
        }


        switch (mc520selected) {

            case R.id.MC_520_Yes:
                editor.putString("sp520", "1");
                break;

            case R.id.MC_520_No:
                editor.putString("sp520", "2");
                break;

            default:
                editor.putString("sp520", "00");
                break;
        }


        switch (mc523selected) {

            case R.id.MC_523_Yes:
                editor.putString("sp523", "1");
                break;

            case R.id.MC_523_No:
                editor.putString("sp523", "2");
                break;

            default:
                editor.putString("sp523", "00");
                break;
        }


        //Putting values for EditText
        editor.putString("sp503Ax", mc503Ax.getText().toString());
        editor.putString("sp503Bx", mc503Bx.getText().toString());
        editor.putString("sp503Cx", mc503Cx.getText().toString());
        editor.putString("sp503Dx", mc503Dx.getText().toString());
        editor.putString("sp503Ex", mc503Ex.getText().toString());
        editor.putString("sp503Fx", mc503Fx.getText().toString());
        editor.putString("sp503Gx", mc503Gx.getText().toString());
        editor.putString("sp503Xx", mc503Xx.getText().toString());
        editor.putString("sp504Wx", mc504Wx.getText().toString());
        editor.putString("sp504Rx", mc504Rx.getText().toString());
        editor.putString("sp504Fx", mc504Fx.getText().toString());
        editor.putString("sp506", mc506.getText().toString());
        editor.putString("sp508x", mc508x.getText().toString());
        editor.putString("sp509x", mc509x.getText().toString());
        editor.putString("sp510x", mc510x.getText().toString());

        editor.putString("sp512x", mc512x.getText().toString());
        editor.putString("sp513x", mc513x.getText().toString());
        editor.putString("sp515", mc515.getText().toString());
        editor.putString("sp52acr", mc524ACR.getText().toString());
        editor.putString("sp52can", mc524CAN.getText().toString());
        editor.putString("sp525_1", mc525_1.getText().toString());
        editor.putString("sp525_2", mc525_2.getText().toString());
        editor.putString("sp525_3", mc525_3.getText().toString());
        editor.putString("sp525_4", mc525_4.getText().toString());
        editor.putString("sp525_5", mc525_5.getText().toString());
        editor.putString("sp525_6", mc525_6.getText().toString());
        editor.putString("sp525_7", mc525_7.getText().toString());
        editor.putString("sp525_7x", mc525_7x.getText().toString());
        editor.putString("sp525_8", mc525_8.getText().toString());
        editor.putString("sp525_9", mc525_9.getText().toString());
        editor.putString("sp525_10", mc525_10.getText().toString());
        editor.putString("sp525_11", mc525_11.getText().toString());
        editor.putString("sp525_12", mc525_12.getText().toString());
        editor.putString("sp525_13", mc525_13.getText().toString());
        editor.putString("sp525_14", mc525_14.getText().toString());
        editor.putString("sp525_15", mc525_15.getText().toString());
        editor.putString("sp525_16", mc525_16.getText().toString());
        editor.putString("sp525_17", mc525_17.getText().toString());
        editor.putString("sp525_18", mc525_18.getText().toString());
        editor.putString("sp525_19", mc525_19.getText().toString());
        editor.putString("sp525_20", mc525_20.getText().toString());

    }

}