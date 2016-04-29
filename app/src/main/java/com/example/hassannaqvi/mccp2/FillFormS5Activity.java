package com.example.hassannaqvi.mccp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class FillFormS5Activity extends AppCompatActivity {

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
    private CheckBox mc503Ax;
    private CheckBox mc503Blhw;
    private CheckBox mc503Bfcv;
    private CheckBox mc503Blhs;
    private CheckBox mc503Bngo;
    private CheckBox mc503Bx;
    private CheckBox mc503Clhw;
    private CheckBox mc503Cfcv;
    private CheckBox mc503Clhs;
    private CheckBox mc503Cngo;
    private CheckBox mc503Cx;
    private CheckBox mc503Dlhw;
    private CheckBox mc503Dfcv;
    private CheckBox mc503Dlhs;
    private CheckBox mc503Dngo;
    private CheckBox mc503Dx;
    private CheckBox mc503Elhw;
    private CheckBox mc503Efcv;
    private CheckBox mc503Elhs;
    private CheckBox mc503Engo;
    private CheckBox mc503Ex;
    private CheckBox mc503Flhw;
    private CheckBox mc503Ffcv;
    private CheckBox mc503Flhs;
    private CheckBox mc503Fngo;
    private CheckBox mc503Fx;
    private CheckBox mc503Glhw;
    private CheckBox mc503Gfcv;
    private CheckBox mc503Glhs;
    private CheckBox mc503Gngo;
    private CheckBox mc503Gx;
    private CheckBox mc503Xlhw;
    private CheckBox mc503Xfcv;
    private CheckBox mc503Xlhs;
    private CheckBox mc503Xngo;
    private CheckBox mc503Xx;
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
    private RadioButton mc522_88;
    private EditText mc522X;
    private RadioGroup mc523;
    private RadioButton mc523_yes;
    private RadioButton mc523_no;
    private EditText mc524ACR;
    private EditText mc524CAN;
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

    private LinearLayout fldGrp502;
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
        mc503Ax = (CheckBox) findViewById(R.id.MC_503_A_X);
        mc503Blhw = (CheckBox) findViewById(R.id.MC_503_B_LHW);
        mc503Bfcv = (CheckBox) findViewById(R.id.MC_503_B_FCV);
        mc503Blhs = (CheckBox) findViewById(R.id.MC_503_B_LHS);
        mc503Bngo = (CheckBox) findViewById(R.id.MC_503_B_NGO);
        mc503Bx = (CheckBox) findViewById(R.id.MC_503_B_X);
        mc503Clhw = (CheckBox) findViewById(R.id.MC_503_C_LHW);
        mc503Cfcv = (CheckBox) findViewById(R.id.MC_503_C_FCV);
        mc503Clhs = (CheckBox) findViewById(R.id.MC_503_C_LHS);
        mc503Cngo = (CheckBox) findViewById(R.id.MC_503_C_NGO);
        mc503Cx = (CheckBox) findViewById(R.id.MC_503_C_X);
        mc503Dlhw = (CheckBox) findViewById(R.id.MC_503_D_LHW);
        mc503Dfcv = (CheckBox) findViewById(R.id.MC_503_D_FCV);
        mc503Dlhs = (CheckBox) findViewById(R.id.MC_503_D_LHS);
        mc503Dngo = (CheckBox) findViewById(R.id.MC_503_D_NGO);
        mc503Dx = (CheckBox) findViewById(R.id.MC_503_D_X);
        mc503Elhw = (CheckBox) findViewById(R.id.MC_503_E_LHW);
        mc503Efcv = (CheckBox) findViewById(R.id.MC_503_E_FCV);
        mc503Elhs = (CheckBox) findViewById(R.id.MC_503_E_LHS);
        mc503Engo = (CheckBox) findViewById(R.id.MC_503_E_NGO);
        mc503Ex = (CheckBox) findViewById(R.id.MC_503_E_X);
        mc503Flhw = (CheckBox) findViewById(R.id.MC_503_F_LHW);
        mc503Ffcv = (CheckBox) findViewById(R.id.MC_503_F_FCV);
        mc503Flhs = (CheckBox) findViewById(R.id.MC_503_F_LHS);
        mc503Fngo = (CheckBox) findViewById(R.id.MC_503_F_NGO);
        mc503Fx = (CheckBox) findViewById(R.id.MC_503_F_X);
        mc503Glhw = (CheckBox) findViewById(R.id.MC_503_G_LHW);
        mc503Gfcv = (CheckBox) findViewById(R.id.MC_503_G_FCV);
        mc503Glhs = (CheckBox) findViewById(R.id.MC_503_G_LHS);
        mc503Gngo = (CheckBox) findViewById(R.id.MC_503_G_NGO);
        mc503Gx = (CheckBox) findViewById(R.id.MC_503_G_X);
        mc503Xlhw = (CheckBox) findViewById(R.id.MC_503_X_LHW);
        mc503Xfcv = (CheckBox) findViewById(R.id.MC_503_X_FCV);
        mc503Xlhs = (CheckBox) findViewById(R.id.MC_503_X_LHS);
        mc503Xngo = (CheckBox) findViewById(R.id.MC_503_X_NGO);
        mc503Xx = (CheckBox) findViewById(R.id.MC_503_X_X);
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
        mc522X = (EditText) findViewById(R.id.MC_522X);
        mc523 = (RadioGroup) findViewById(R.id.MC_523);
        mc523_yes = (RadioButton) findViewById(R.id.MC_523_Yes);
        mc523_no = (RadioButton) findViewById(R.id.MC_523_No);
        mc524ACR = (EditText) findViewById(R.id.MC_524ACR);
        mc525_1 = (EditText) findViewById(R.id.MC_525_1);
        mc525_2 = (EditText) findViewById(R.id.MC_525_2);
        mc525_3 = (EditText) findViewById(R.id.MC_525_3);
        mc525_4 = (EditText) findViewById(R.id.MC_525_4);
        mc525_5 = (EditText) findViewById(R.id.MC_525_5);
        mc525_6 = (EditText) findViewById(R.id.MC_525_6);
        mc525_7 = (EditText) findViewById(R.id.MC_525_7);
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

        fldGrp502 = (LinearLayout) findViewById(R.id.fldGrp502);
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

        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();

            Intent s6_form_intent = new Intent(getApplicationContext(), FillFormS6Activity.class);
            s6_form_intent.putExtra("formId", formId);
//            s2_form_intent.putExtra("boyCount", mc204m.getText().toString());
//            s2_form_intent.putExtra("girlCount", mc204f.getText().toString());
            startActivity(s6_form_intent);
        } else {


        }
    }

    private boolean formValidation() {
        return true;
    }

    private void StoreTempValues() {
    }


}
