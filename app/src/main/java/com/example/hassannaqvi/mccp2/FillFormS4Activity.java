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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class FillFormS4Activity extends AppCompatActivity {

    private static final String TAG = "FILL_FORM_S3_ACTIVITY";

    public static String FORM_ID;
    private String formId;
    private Integer girlCount;
    private Integer boyCount;

    private RadioGroup mc401;
    private int mc401selected;
    private RadioButton mc401_dontknow;
    private RadioButton mc401_no;
    private RadioButton mc401_yes;
    private CheckBox mc402_1;
    private CheckBox mc402_2;
    private CheckBox mc402_3;
    private CheckBox mc402_4;
    private CheckBox mc402_5;
    private CheckBox mc402_6;
    private CheckBox mc402_7;
    private CheckBox mc402_8;
    private CheckBox mc402_88;
    private CheckBox mc402_9;
    private CheckBox mc402_10;
    private boolean mc402_rsp_1;
    private boolean mc402_rsp_2;
    private boolean mc402_rsp_3;
    private boolean mc402_rsp_4;
    private boolean mc402_rsp_5;
    private boolean mc402_rsp_6;
    private boolean mc402_rsp_7;
    private boolean mc402_rsp_8;
    private boolean mc402_rsp_88;
    private boolean mc402_rsp_9;
    private boolean mc402_rsp_10;
    private EditText mc402x;
    private Spinner mc403;
    private CheckBox mc404_1;
    private CheckBox mc404_2;
    private CheckBox mc404_3;
    private CheckBox mc404_4;
    private CheckBox mc404_5;
    private CheckBox mc404_6;
    private CheckBox mc404_7;
    private CheckBox mc404_8;
    private CheckBox mc404_88;
    private CheckBox mc404_9;
    private CheckBox mc404_99;
    private boolean mc404_rsp_1;
    private boolean mc404_rsp_2;
    private boolean mc404_rsp_3;
    private boolean mc404_rsp_4;
    private boolean mc404_rsp_5;
    private boolean mc404_rsp_6;
    private boolean mc404_rsp_7;
    private boolean mc404_rsp_8;
    private boolean mc404_rsp_88;
    private boolean mc404_rsp_9;
    private boolean mc404_rsp_99;
    private EditText mc404x_1;
    private EditText mc404x_2;
    private EditText mc404x_3;
    private CheckBox mc405_1;
    private CheckBox mc405_2;
    private CheckBox mc405_3;
    private CheckBox mc405_4;
    private CheckBox mc405_5;
    private CheckBox mc405_88;
    private CheckBox mc405_99;
    private CheckBox mc405a1;
    private CheckBox mc405a2;
    private CheckBox mc405a3;
    private CheckBox mc405a4;
    private CheckBox mc405a88;
    private CheckBox mc405a99;
    private boolean mc405_rsp_1;
    private boolean mc405_rsp_2;
    private boolean mc405_rsp_3;
    private boolean mc405_rsp_4;
    private boolean mc405_rsp_5;
    private boolean mc405_rsp_88;
    private boolean mc405_rsp_99;
    private boolean mc405_rspa1;
    private boolean mc405_rspa2;
    private boolean mc405_rspa3;
    private boolean mc405_rspa4;
    private boolean mc405_rspa88;
    private boolean mc405_rspa99;
    private EditText mc405x;
    private RadioGroup mc406;
    private int mc406selected;
    private RadioButton mc406_no;
    private RadioButton mc406_yes;
    private CheckBox mc407_1;
    private CheckBox mc407_2;
    private CheckBox mc407_3;
    private CheckBox mc407_4;
    private CheckBox mc407_5;
    private CheckBox mc407_6;
    private CheckBox mc407_88;
    private boolean mc407_rsp_1;
    private boolean mc407_rsp_2;
    private boolean mc407_rsp_3;
    private boolean mc407_rsp_4;
    private boolean mc407_rsp_5;
    private boolean mc407_rsp_6;
    private boolean mc407_rsp_88;
    private EditText mc407x;
    private RadioGroup mc408;
    private int mc408selected;
    private RadioButton mc408_no;
    private RadioButton mc408_yes;
    private Spinner mc409;
    private EditText mc409x;
    private Spinner mc410;
    private EditText mc410x;
    private RadioGroup mc410A;
    private int mc410Aselected;
    private RadioButton mc410A_1;
    private RadioButton mc410A_2;
    private RadioButton mc410A_3;
    private RadioButton mc410A_4;
    private RadioButton mc410A_5;
    private RadioButton mc410A_99;
    private CheckBox mc410B_1;
    private CheckBox mc410B_2;
    private CheckBox mc410B_3;
    private CheckBox mc410B_4;
    private CheckBox mc410B_5;
    private CheckBox mc410B_88;
    private CheckBox mc410B_99;
    private boolean mc410B_rsp_1;
    private boolean mc410B_rsp_2;
    private boolean mc410B_rsp_3;
    private boolean mc410B_rsp_4;
    private boolean mc410B_rsp_5;
    private boolean mc410B_rsp_88;
    private boolean mc410B_rsp_99;
    private EditText mc410Bx;
    private Spinner mc411;
    private RadioGroup mc412;
    private int mc412selected;
    private RadioButton mc412_yes;
    private RadioButton mc412_no;
    private CheckBox mc413_1;
    private CheckBox mc413_2;
    private CheckBox mc413_3;
    private CheckBox mc413_4;
    private CheckBox mc413_5;
    private CheckBox mc413_6;
    private CheckBox mc413_7;
    private CheckBox mc413_88;
    private boolean mc413_rsp_1;
    private boolean mc413_rsp_2;
    private boolean mc413_rsp_3;
    private boolean mc413_rsp_4;
    private boolean mc413_rsp_5;
    private boolean mc413_rsp_6;
    private boolean mc413_rsp_7;
    private boolean mc413_rsp_88;
    private EditText mc413x;
    private RadioGroup mc414;
    private int mc414selected;
    private RadioButton mc414_yes;
    private RadioButton mc414_no;
    private RadioButton mc414_dontknow;
    private Spinner mc415;
    private EditText mc415x;
    private EditText mc405ax;

    private String mc403Selected;
    private String mc409Selected;
    private String mc410Selected;
    private String mc411Selected;
    private String mc415Selected;


    private LinearLayout fldGrp401;
    private LinearLayout fldGrp406;
    private LinearLayout fldGrp408;
    private LinearLayout fldGrp410A;
    private LinearLayout fldGrp412;
    private LinearLayout fldGrp414;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form_s4);

        formId = getIntent().getStringExtra("formId");

        mc401 = (RadioGroup) findViewById(R.id.MC_401);
        mc401selected = mc401.getCheckedRadioButtonId();
        mc401_dontknow = (RadioButton) findViewById(R.id.MC_401_Dontknow);
        mc401_yes = (RadioButton) findViewById(R.id.MC_401_Yes);
        mc401_no = (RadioButton) findViewById(R.id.MC_401_No);
        mc402_1 = (CheckBox) findViewById(R.id.MC_402_1);
        mc402_2 = (CheckBox) findViewById(R.id.MC_402_2);
        mc402_3 = (CheckBox) findViewById(R.id.MC_402_3);
        mc402_4 = (CheckBox) findViewById(R.id.MC_402_4);
        mc402_5 = (CheckBox) findViewById(R.id.MC_402_5);
        mc402_6 = (CheckBox) findViewById(R.id.MC_402_6);
        mc402_7 = (CheckBox) findViewById(R.id.MC_402_7);
        mc402_8 = (CheckBox) findViewById(R.id.MC_402_8);
        mc402_88 = (CheckBox) findViewById(R.id.MC_402_88);
        mc402x = (EditText) findViewById(R.id.MC_402x);
        mc402_9 = (CheckBox) findViewById(R.id.MC_402_9);
        mc402_10 = (CheckBox) findViewById(R.id.MC_402_10);
        mc403 = (Spinner) findViewById(R.id.MC_403);
        mc404_1 = (CheckBox) findViewById(R.id.MC_404_1);
        mc404_2 = (CheckBox) findViewById(R.id.MC_404_2);
        mc404_3 = (CheckBox) findViewById(R.id.MC_404_3);
        mc404_4 = (CheckBox) findViewById(R.id.MC_404_4);
        mc404_5 = (CheckBox) findViewById(R.id.MC_404_5);
        mc404_6 = (CheckBox) findViewById(R.id.MC_404_6);
        mc404_7 = (CheckBox) findViewById(R.id.MC_404_7);
        mc404_8 = (CheckBox) findViewById(R.id.MC_404_8);
        mc404_88 = (CheckBox) findViewById(R.id.MC_404_88);
        mc404x_1 = (EditText) findViewById(R.id.MC_404_X1);
        mc404x_2 = (EditText) findViewById(R.id.MC_404_X2);
        mc404x_3 = (EditText) findViewById(R.id.MC_404_X3);
        mc404_9 = (CheckBox) findViewById(R.id.MC_404_9);
        mc404_99 = (CheckBox) findViewById(R.id.MC_404_99);
        mc405_1 = (CheckBox) findViewById(R.id.MC_405_1);
        mc405_2 = (CheckBox) findViewById(R.id.MC_405_2);
        mc405_3 = (CheckBox) findViewById(R.id.MC_405_3);
        mc405_4 = (CheckBox) findViewById(R.id.MC_405_4);
        mc405_5 = (CheckBox) findViewById(R.id.MC_405_5);
        mc405_88 = (CheckBox) findViewById(R.id.MC_405_88);
        mc405x = (EditText) findViewById(R.id.MC_405X);
        mc405_99 = (CheckBox) findViewById(R.id.MC_405_99);
        mc405a1 = (CheckBox) findViewById(R.id.MC_405A1);
        mc405a2 = (CheckBox) findViewById(R.id.MC_405A2);
        mc405a3 = (CheckBox) findViewById(R.id.MC_405A3);
        mc405a4 = (CheckBox) findViewById(R.id.MC_405A4);
        mc405a88 = (CheckBox) findViewById(R.id.MC_405A88);
        mc405ax = (EditText) findViewById(R.id.MC_405AX);
        mc406 = (RadioGroup) findViewById(R.id.MC_406);
        mc406selected = mc406.getCheckedRadioButtonId();
        mc406_no = (RadioButton) findViewById(R.id.MC_406_No);
        mc406_yes = (RadioButton) findViewById(R.id.MC_406_Yes);
        mc407_1 = (CheckBox) findViewById(R.id.MC_407_1);
        mc407_2 = (CheckBox) findViewById(R.id.MC_407_2);
        mc407_3 = (CheckBox) findViewById(R.id.MC_407_3);
        mc407_4 = (CheckBox) findViewById(R.id.MC_407_4);
        mc407_5 = (CheckBox) findViewById(R.id.MC_407_5);
        mc407_6 = (CheckBox) findViewById(R.id.MC_407_6);
        mc407_88 = (CheckBox) findViewById(R.id.MC_407_88);
        mc407x = (EditText) findViewById(R.id.MC_407X);
        mc405a99 = (CheckBox) findViewById(R.id.MC_405A1);
        mc408 = (RadioGroup) findViewById(R.id.MC_408);
        mc408selected = mc408.getCheckedRadioButtonId();
        mc408_no = (RadioButton) findViewById(R.id.MC_408_No);
        mc408_yes = (RadioButton) findViewById(R.id.MC_408_Yes);
        mc409 = (Spinner) findViewById(R.id.MC_409);
        mc409x = (EditText) findViewById(R.id.MC_409_88);
        mc410 = (Spinner) findViewById(R.id.MC_410);
        mc410x = (EditText) findViewById(R.id.MC_410_88);
        mc410A = (RadioGroup) findViewById(R.id.MC_410A);
        mc410Aselected = mc410A.getCheckedRadioButtonId();
        mc410A_1 = (RadioButton) findViewById(R.id.MC_410A_1);
        mc410A_2 = (RadioButton) findViewById(R.id.MC_410A_2);
        mc410A_3 = (RadioButton) findViewById(R.id.MC_410A_3);
        mc410A_4 = (RadioButton) findViewById(R.id.MC_410A_4);
        mc410A_5 = (RadioButton) findViewById(R.id.MC_410A_5);
        mc410A_99 = (RadioButton) findViewById(R.id.MC_410A_99);
        mc410B_1 = (CheckBox) findViewById(R.id.MC_410B1);
        mc410B_2 = (CheckBox) findViewById(R.id.MC_410B2);
        mc410B_3 = (CheckBox) findViewById(R.id.MC_410B3);
        mc410B_4 = (CheckBox) findViewById(R.id.MC_410B4);
        mc410B_5 = (CheckBox) findViewById(R.id.MC_410B5);
        mc410B_88 = (CheckBox) findViewById(R.id.MC_410B88);
        mc410B_99 = (CheckBox) findViewById(R.id.MC_410B99);
        mc410Bx = (EditText) findViewById(R.id.MC_410BX);
        mc411 = (Spinner) findViewById(R.id.MC_411);
        mc412 = (RadioGroup) findViewById(R.id.MC_412);
        mc412selected = mc412.getCheckedRadioButtonId();
        mc412_no = (RadioButton) findViewById(R.id.MC_412_No);
        mc412_yes = (RadioButton) findViewById(R.id.MC_412_Yes);
        mc413_1 = (CheckBox) findViewById(R.id.MC_413_1);
        mc413_2 = (CheckBox) findViewById(R.id.MC_413_2);
        mc413_3 = (CheckBox) findViewById(R.id.MC_413_3);
        mc413_4 = (CheckBox) findViewById(R.id.MC_413_4);
        mc413_5 = (CheckBox) findViewById(R.id.MC_413_5);
        mc413_6 = (CheckBox) findViewById(R.id.MC_413_6);
        mc413_88 = (CheckBox) findViewById(R.id.MC_413_88);
        mc413x = (EditText) findViewById(R.id.MC_413X);
        mc414 = (RadioGroup) findViewById(R.id.MC_414);
        mc414selected = mc414.getCheckedRadioButtonId();
        mc414_no = (RadioButton) findViewById(R.id.MC_414_No);
        mc414_yes = (RadioButton) findViewById(R.id.MC_414_Yes);
        mc415 = (Spinner) findViewById(R.id.MC_415);
        mc415x = (EditText) findViewById(R.id.MC_415X);

        fldGrp401 = (LinearLayout) findViewById(R.id.fldGrp401);
        fldGrp406 = (LinearLayout) findViewById(R.id.fldGrp406);
        fldGrp408 = (LinearLayout) findViewById(R.id.fldGrp408);
        fldGrp410A = (LinearLayout) findViewById(R.id.fldGrp410A);
        fldGrp412 = (LinearLayout) findViewById(R.id.fldGrp412);
        fldGrp414 = (LinearLayout) findViewById(R.id.fldGrp414);


       /* mc401.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc401_no.getId()) {
                    fldGrp401.setVisibility(View.GONE);
                } else {
                    fldGrp401.setVisibility(View.VISIBLE);
                }
            }
        });*/
        mc402_88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                    if (!mc402_88.isChecked()) {
                                                        mc402x.setVisibility(View.GONE);
                                                    } else {
                                                        mc402x.setVisibility(View.VISIBLE);

                                                    }
                                                }
                                            }
        );

        mc404_88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                    if (mc404_88.isChecked()) {
                                                        mc404x_1.setVisibility(View.VISIBLE);
                                                        mc404x_2.setVisibility(View.VISIBLE);
                                                        mc404x_3.setVisibility(View.VISIBLE);
                                                    } else {
                                                        mc404x_1.setVisibility(View.GONE);
                                                        mc404x_1.setText("");
                                                        mc404x_2.setVisibility(View.GONE);
                                                        mc404x_2.setText("");
                                                        mc404x_3.setVisibility(View.GONE);
                                                        mc404x_3.setText("");

                                                    }
                                                }
                                            }
        );

        mc405_88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                    if (mc405_88.isChecked()) {
                                                        mc405x.setVisibility(View.VISIBLE);
                                                    } else {
                                                        mc405x.setVisibility(View.GONE);
                                                        mc405x.setText("");

                                                    }
                                                }
                                            }
        );
        mc405a88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                    if (mc405a88.isChecked()) {
                                                        mc405ax.setVisibility(View.VISIBLE);
                                                    } else {
                                                        mc405ax.setVisibility(View.GONE);
                                                        mc405ax.setText("");

                                                    }
                                                }
                                            }
        );
        mc407_88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                    if (mc407_88.isChecked()) {
                                                        mc407x.setVisibility(View.VISIBLE);
                                                    } else {
                                                        mc407x.setVisibility(View.GONE);
                                                        mc407x.setText("");

                                                    }
                                                }
                                            }
        );
        mc409.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if (mc409.getSelectedItemPosition() == 5) {
                    mc409x.setVisibility(View.VISIBLE);
                } else {
                    mc409x.setVisibility(View.GONE);
                    mc409x.setText("");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        mc410.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if (mc410.getSelectedItemPosition() == 8) {
                    mc410x.setVisibility(View.VISIBLE);
                } else {
                    mc410x.setVisibility(View.GONE);
                    mc410x.setText("");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        mc410B_88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                     if (mc410B_88.isChecked()) {
                                                         mc410Bx.setVisibility(View.VISIBLE);
                                                     } else {
                                                         mc410Bx.setVisibility(View.GONE);
                                                         mc410Bx.setText("");

                                                     }
                                                 }
                                             }
        );
        mc413_88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                    if (mc413_88.isChecked()) {
                                                        mc413x.setVisibility(View.VISIBLE);
                                                    } else {
                                                        mc413x.setVisibility(View.GONE);
                                                        mc413x.setText("");

                                                    }
                                                }
                                            }
        );



        mc406.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc406_no.getId()) {
                    fldGrp406.setVisibility(View.VISIBLE);
                } else {
                    fldGrp406.setVisibility(View.GONE);
                }
            }
        });

        mc408.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc408_yes.getId()) {
                    fldGrp408.setVisibility(View.VISIBLE);
                } else {
                    fldGrp408.setVisibility(View.GONE);
                }
            }
        });

        mc410A.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc410A_1.getId()) {
                    fldGrp410A.setVisibility(View.GONE);
                } else {
                    fldGrp410A.setVisibility(View.VISIBLE);
                }
            }
        });

        mc412.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc412_no.getId()) {
                    fldGrp412.setVisibility(View.VISIBLE);
                } else {
                    fldGrp412.setVisibility(View.GONE);
                }
            }
        });

        mc415.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if (mc415.getSelectedItemPosition() == 3) {
                    mc415x.setVisibility(View.VISIBLE);
                } else {
                    mc415x.setVisibility(View.GONE);
                    mc415x.setText("");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        mc414.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mc414_no.getId()) {
                    fldGrp414.setVisibility(View.VISIBLE);
                } else {
                    fldGrp414.setVisibility(View.GONE);
                }
            }
        });

    }

    public void startFormS5(View view) {

       /* mc201typeSelected = getResources().getStringArray(R.array.MC_201TYPE_list)[mc201type.getSelectedItemPosition()];
        mc201ocuSelected = getResources().getStringArray(R.array.MC_OCU_value)[mc201ocu.getSelectedItemPosition()];
        mc202ocuSelected = getResources().getStringArray(R.array.MC_OCU_value)[mc202ocu.getSelectedItemPosition()];

*/
        mc401selected = mc401.getCheckedRadioButtonId();
        Log.d(TAG, "Selected:" + mc401selected);
        mc406selected = mc406.getCheckedRadioButtonId();
        mc408selected = mc408.getCheckedRadioButtonId();
        mc410Aselected = mc410A.getCheckedRadioButtonId();
        mc412selected = mc412.getCheckedRadioButtonId();
        mc414selected = mc414.getCheckedRadioButtonId();

        //Spinner getting value of selected for putString()
        mc403Selected = getResources().getStringArray(R.array.MC_YN_value)[mc403.getSelectedItemPosition()];
        mc411Selected = getResources().getStringArray(R.array.MC_YN_value)[mc411.getSelectedItemPosition()];
        mc409Selected = getResources().getStringArray(R.array.MC_409_value)[mc409.getSelectedItemPosition()];
        mc410Selected = getResources().getStringArray(R.array.MC_410_value)[mc410.getSelectedItemPosition()];
        mc415Selected = getResources().getStringArray(R.array.MC_415_value)[mc415.getSelectedItemPosition()];


        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();

            Intent s5_form_intent = new Intent(getApplicationContext(), FillFormS5Activity.class);
            s5_form_intent.putExtra("formId", formId);
//            s2_form_intent.putExtra("boyCount", mc204m.getText().toString());
//            s2_form_intent.putExtra("girlCount", mc204f.getText().toString());
            startActivity(s5_form_intent);
        } else {


        }

    }

    private void StoreTempValues() {
        Toast.makeText(getApplicationContext(), "Storing Temporary Form Values...", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences(FillFormActivity.FORM_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        //RadioButton Selected for switches in putString()
        mc401selected = mc401.getCheckedRadioButtonId();
        Log.d(TAG, "Selected:" + mc401selected);
        mc406selected = mc406.getCheckedRadioButtonId();
        mc408selected = mc408.getCheckedRadioButtonId();
        mc410Aselected = mc410A.getCheckedRadioButtonId();
        mc412selected = mc412.getCheckedRadioButtonId();
        mc414selected = mc414.getCheckedRadioButtonId();

        //Spinner getting value of selected for putString()
        mc403Selected = getResources().getStringArray(R.array.MC_YN_value)[mc403.getSelectedItemPosition()];
        mc411Selected = getResources().getStringArray(R.array.MC_YN_value)[mc411.getSelectedItemPosition()];
        mc409Selected = getResources().getStringArray(R.array.MC_409_value)[mc409.getSelectedItemPosition()];
        mc410Selected = getResources().getStringArray(R.array.MC_410_value)[mc410.getSelectedItemPosition()];
        mc415Selected = getResources().getStringArray(R.array.MC_415_value)[mc415.getSelectedItemPosition()];


       /* mc402_rsp_1 = mc402_1.isChecked();
        mc402_rsp_2 = mc402_2.isChecked();
        mc402_rsp_3 = mc402_3.isChecked();
        mc402_rsp_4 = mc402_4.isChecked();
        mc402_rsp_5 = mc402_5.isChecked();
        mc402_rsp_6 = mc402_6.isChecked();
        mc402_rsp_7 = mc402_7.isChecked();
        mc402_rsp_8 = mc402_8.isChecked();
        mc402_rsp_88 = mc402_88.isChecked();
        mc402_rsp_9 = mc402_9.isChecked();
        mc404_rsp_1 = mc404_1.isChecked();
        mc404_rsp_2 = mc404_2.isChecked();
        mc404_rsp_3 = mc404_3.isChecked();
        mc404_rsp_4 = mc404_4.isChecked();
        mc404_rsp_5 = mc404_5.isChecked();
        mc404_rsp_6 = mc404_6.isChecked();
        mc404_rsp_7 = mc404_7.isChecked();
        mc404_rsp_8 = mc404_8.isChecked();
        mc404_rsp_9 = mc404_9.isChecked();
        mc404_rsp_88 = mc404_88.isChecked();
        mc404_rsp_99 = mc404_99.isChecked();
        mc405_rsp_1 = mc405_1.isChecked();
        mc405_rsp_2 = mc405_2.isChecked();
        mc405_rsp_3 = mc405_3.isChecked();
        mc405_rsp_4 = mc405_4.isChecked();
        mc405_rsp_5 = mc405_5.isChecked();
        mc405_rsp_88 = mc405_88.isChecked();
        mc405_rsp_99 = mc405_99.isChecked();
        mc405_rspa1 = mc405a1.isChecked();
        mc405_rspa2 = mc405a2.isChecked();
        mc405_rspa3 = mc405a3.isChecked();
        mc405_rspa4 = mc405a4.isChecked();
        mc405_rspa88 = mc405a88.isChecked();
        mc405_rspa99 = mc405a99.isChecked();
        mc407_rsp_1 = mc407_1.isChecked();
        mc407_rsp_2 = mc407_2.isChecked();
        mc407_rsp_3 = mc407_3.isChecked();
        mc407_rsp_4 = mc407_4.isChecked();
        mc407_rsp_5 = mc407_5.isChecked();
        mc407_rsp_6 = mc407_6.isChecked();
        mc407_rsp_88 = mc407_88.isChecked();
        mc410B_rsp_1 = mc410B_1.isChecked();
        mc410B_rsp_2 = mc410B_2.isChecked();
        mc410B_rsp_3 = mc410B_3.isChecked();
        mc410B_rsp_4 = mc410B_4.isChecked();
        mc410B_rsp_5 = mc410B_5.isChecked();
        mc410B_rsp_88 = mc410B_88.isChecked();
        mc410B_rsp_99 = mc410B_99.isChecked();
        mc413_rsp_1 = mc413_1.isChecked();
        mc413_rsp_2 = mc413_2.isChecked();
        mc413_rsp_3 = mc413_3.isChecked();
        mc413_rsp_4 = mc413_4.isChecked();
        mc413_rsp_5 = mc413_5.isChecked();
        mc413_rsp_88 = mc413_88.isChecked();*/


        // Putting values of CheckBoxes
        editor.putString("sp402_1", (mc402_1.isChecked() ? "1" : "00"));
        editor.putString("sp402_2", (mc402_2.isChecked() ? "2" : "00"));
        editor.putString("sp402_3", (mc402_3.isChecked() ? "3" : "00"));
        editor.putString("sp402_4", (mc402_4.isChecked() ? "4" : "00"));
        editor.putString("sp402_5", (mc402_5.isChecked() ? "5" : "00"));
        editor.putString("sp402_6", (mc402_6.isChecked() ? "6" : "00"));
        editor.putString("sp402_7", (mc402_7.isChecked() ? "7" : "00"));
        editor.putString("sp402_8", (mc402_8.isChecked() ? "8" : "00"));
        editor.putString("sp402_9", (mc402_9.isChecked() ? "9" : "00"));
        editor.putString("sp402_10", (mc402_10.isChecked() ? "10" : "00"));
        editor.putString("sp402_88", (mc402_88.isChecked() ? "88" : "00"));
        editor.putString("sp404_1", (mc404_1.isChecked() ? "1" : "00"));
        editor.putString("sp404_2", (mc404_2.isChecked() ? "2" : "00"));
        editor.putString("sp404_3", (mc404_3.isChecked() ? "3" : "00"));
        editor.putString("sp404_4", (mc404_4.isChecked() ? "4" : "00"));
        editor.putString("sp404_5", (mc404_5.isChecked() ? "5" : "00"));
        editor.putString("sp404_6", (mc404_6.isChecked() ? "6" : "00"));
        editor.putString("sp404_7", (mc404_7.isChecked() ? "7" : "00"));
        editor.putString("sp404_8", (mc404_8.isChecked() ? "8" : "00"));
        editor.putString("sp404_9", (mc404_9.isChecked() ? "9" : "00"));
        editor.putString("sp404_88", (mc404_88.isChecked() ? "88" : "00"));
        editor.putString("sp404_99", (mc404_99.isChecked() ? "99" : "00"));
        editor.putString("sp405_1", (mc405_1.isChecked() ? "1" : "00"));
        editor.putString("sp405_2", (mc405_2.isChecked() ? "2" : "00"));
        editor.putString("sp405_3", (mc405_3.isChecked() ? "3" : "00"));
        editor.putString("sp405_4", (mc405_4.isChecked() ? "4" : "00"));
        editor.putString("sp405_5", (mc405_5.isChecked() ? "5" : "00"));
        editor.putString("sp405_88", (mc405_88.isChecked() ? "88" : "00"));
        editor.putString("sp405_99", (mc405_99.isChecked() ? "99" : "00"));
        editor.putString("sp405a1", (mc405a1.isChecked() ? "1" : "00"));
        editor.putString("sp405a2", (mc405a2.isChecked() ? "2" : "00"));
        editor.putString("sp405a3", (mc405a3.isChecked() ? "3" : "00"));
        editor.putString("sp405a4", (mc405a4.isChecked() ? "4" : "00"));
        editor.putString("sp405a88", (mc405a88.isChecked() ? "88" : "00"));
        editor.putString("sp405a99", (mc405a99.isChecked() ? "99" : "00"));
        editor.putString("sp407_1", (mc407_1.isChecked() ? "1" : "00"));
        editor.putString("sp407_2", (mc407_2.isChecked() ? "2" : "00"));
        editor.putString("sp407_3", (mc407_3.isChecked() ? "3" : "00"));
        editor.putString("sp407_4", (mc407_4.isChecked() ? "4" : "00"));
        editor.putString("sp407_5", (mc407_5.isChecked() ? "5" : "00"));
        editor.putString("sp407_6", (mc407_6.isChecked() ? "6" : "00"));
        editor.putString("sp407_88", (mc407_88.isChecked() ? "88" : "00"));
        editor.putString("sp410B_1", (mc410B_1.isChecked() ? "1" : "00"));
        editor.putString("sp410B_2", (mc410B_2.isChecked() ? "2" : "00"));
        editor.putString("sp410B_3", (mc410B_3.isChecked() ? "3" : "00"));
        editor.putString("sp410B_4", (mc410B_4.isChecked() ? "4" : "00"));
        editor.putString("sp410B_5", (mc410B_5.isChecked() ? "5" : "00"));
        editor.putString("sp410B_88", (mc410B_88.isChecked() ? "88" : "00"));
        editor.putString("sp410B_99", (mc410B_99.isChecked() ? "99" : "00"));
        editor.putString("sp413_1", (mc413_1.isChecked() ? "1" : "00"));
        editor.putString("sp413_2", (mc413_2.isChecked() ? "2" : "00"));
        editor.putString("sp413_3", (mc413_3.isChecked() ? "3" : "00"));
        editor.putString("sp413_4", (mc413_4.isChecked() ? "4" : "00"));
        editor.putString("sp413_5", (mc413_5.isChecked() ? "5" : "00"));
        editor.putString("sp413_6", (mc413_6.isChecked() ? "6" : "00"));
        editor.putString("sp413_7", (mc413_7.isChecked() ? "7" : "00"));
        editor.putString("sp413_88", (mc413_88.isChecked() ? "88" : "00"));


        // Putting values of Radiobuttons
        switch (mc401selected) {
            case R.id.MC_401_Dontknow:
                editor.putString("sp401", "99");
                break;
            case R.id.MC_401_No:
                editor.putString("sp401", "2");
                break;
            case R.id.MC_401_Yes:
                editor.putString("sp401", "1");
                break;
            default:
                editor.putString("sp401", "00");
                break;
        }

        switch (mc406selected) {
            case R.id.MC_406_No:
                editor.putString("sp406", "2");
                break;
            case R.id.MC_406_Yes:
                editor.putString("sp406", "1");
                break;
            default:
                editor.putString("sp406", "00");
                break;
        }

        switch (mc408selected) {
            case R.id.MC_408_No:
                editor.putString("sp408", "2");
                break;
            case R.id.MC_408_Yes:
                editor.putString("sp408", "1");
                break;
            default:
                editor.putString("sp408", "00");
                break;
        }
        switch (mc410Aselected) {
            case R.id.MC_410A_1:
                editor.putString("sp410A", "1");
                break;
            case R.id.MC_410A_2:
                editor.putString("sp410A", "2");
                break;
            case R.id.MC_410A_3:
                editor.putString("sp410A", "3");
                break;
            case R.id.MC_410A_4:
                editor.putString("sp410A", "4");
                break;
            case R.id.MC_410A_5:
                editor.putString("sp410A", "5");
                break;
            case R.id.MC_410A_99:
                editor.putString("sp410A", "99");
                break;

            default:
                editor.putString("sp410A", "00");
                break;
        }
        switch (mc412selected) {
            case R.id.MC_412_No:
                editor.putString("sp412", "2");
                break;
            case R.id.MC_412_Yes:
                editor.putString("sp412", "1");
                break;
            default:
                editor.putString("sp412", "00");
                break;
        }
        switch (mc414selected) {
            case R.id.MC_414_Dontknow:
                editor.putString("sp414", "99");
                break;
            case R.id.MC_414_No:
                editor.putString("sp414", "2");
                break;
            case R.id.MC_414_Yes:
                editor.putString("sp414", "1");
                break;
            default:
                editor.putString("sp414", "00");
                break;
        }

        //Putting values for Spinners
        editor.putString("sp403", mc403Selected.toString());
        editor.putString("sp409", mc409Selected.toString());
        editor.putString("sp410", mc410Selected.toString());
        editor.putString("sp411", mc411Selected.toString());
        editor.putString("sp415", mc415Selected.toString());

        //Putting values for EditText
        editor.putString("sp402x", mc402x.getText().toString());
        editor.putString("sp404x_1", mc404x_1.getText().toString());
        editor.putString("sp404x_2", mc404x_2.getText().toString());
        editor.putString("sp404x_3", mc404x_3.getText().toString());
        editor.putString("sp405x", mc405x.getText().toString());
        editor.putString("sp405ax", mc405ax.getText().toString());
        editor.putString("sp407x", mc407x.getText().toString());
        editor.putString("sp409x", mc409x.getText().toString());
        editor.putString("sp410x", mc410x.getText().toString());
        editor.putString("sp410Bx", mc410Bx.getText().toString());
        editor.putString("sp415x", mc415x.getText().toString());


        editor.commit();
        Log.d(TAG, "Stored sharedValues.");


        JSONObject S4 = new JSONObject();
        long newFormId = 0;
        try {
            S4.put("mc401", sharedPref.getString("sp401", "00"));
            S4.put("mc402_1", sharedPref.getString("sp402_1", "00"));
            S4.put("mc402_2", sharedPref.getString("sp402_2", "00"));
            S4.put("mc402_3", sharedPref.getString("sp402_3", "00"));
            S4.put("mc402_4", sharedPref.getString("sp402_4", "00"));
            S4.put("mc402_5", sharedPref.getString("sp402_5", "00"));
            S4.put("mc402_6", sharedPref.getString("sp402_6", "00"));
            S4.put("mc402_7", sharedPref.getString("sp402_7", "00"));
            S4.put("mc402_8", sharedPref.getString("sp402_8", "00"));
            S4.put("mc402_9", sharedPref.getString("sp402_9", "00"));
            S4.put("mc402_10", sharedPref.getString("sp402_10", "00"));
            S4.put("mc402_88", sharedPref.getString("sp402_88", "00"));
            S4.put("mc402x", sharedPref.getString("sp402x", "00"));
            S4.put("mc403", sharedPref.getString("sp403", "00"));
            S4.put("mc404_1", sharedPref.getString("sp404_1", "00"));
            S4.put("mc404_2", sharedPref.getString("sp404_2", "00"));
            S4.put("mc404_3", sharedPref.getString("sp404_3", "00"));
            S4.put("mc404_4", sharedPref.getString("sp404_4", "00"));
            S4.put("mc404_5", sharedPref.getString("sp404_5", "00"));
            S4.put("mc404_6", sharedPref.getString("sp404_6", "00"));
            S4.put("mc404_7", sharedPref.getString("sp404_7", "00"));
            S4.put("mc404_8", sharedPref.getString("sp404_8", "00"));
            S4.put("mc404_9", sharedPref.getString("sp404_9", "00"));
            S4.put("mc404_99", sharedPref.getString("sp404_99", "00"));
            S4.put("mc404_88", sharedPref.getString("sp404_88", "00"));
            S4.put("mc404x", sharedPref.getString("sp404x", "00"));
            S4.put("mc404x_1", sharedPref.getString("sp404x_1", "00"));
            S4.put("mc404x_2", sharedPref.getString("sp404x_2", "00"));
            S4.put("mc404x_3", sharedPref.getString("sp404x_3", "00"));
            S4.put("mc405_1", sharedPref.getString("sp405_1", "00"));
            S4.put("mc405_2", sharedPref.getString("sp405_2", "00"));
            S4.put("mc405_3", sharedPref.getString("sp405_3", "00"));
            S4.put("mc405_4", sharedPref.getString("sp405_4", "00"));
            S4.put("mc405_5", sharedPref.getString("sp405_5", "00"));
            S4.put("mc405_88", sharedPref.getString("sp405_88", "00"));
            S4.put("mc405x", sharedPref.getString("sp405x", "00"));
            S4.put("mc405_99", sharedPref.getString("sp405_99", "00"));
            S4.put("mc405a1", sharedPref.getString("sp405a1", "00"));
            S4.put("mc405a2", sharedPref.getString("sp405a2", "00"));
            S4.put("mc405a3", sharedPref.getString("sp405a3", "00"));
            S4.put("mc405a4", sharedPref.getString("sp405a4", "00"));
            S4.put("mc405a88", sharedPref.getString("sp405a88", "00"));
            S4.put("mc405a99", sharedPref.getString("sp405a99", "00"));
            S4.put("mc405ax", sharedPref.getString("sp405ax", "00"));
            S4.put("mc406", sharedPref.getString("sp406", "00"));
            S4.put("mc407_1", sharedPref.getString("sp407_1", "00"));
            S4.put("mc407_2", sharedPref.getString("sp407_2", "00"));
            S4.put("mc407_3", sharedPref.getString("sp407_3", "00"));
            S4.put("mc407_4", sharedPref.getString("sp407_4", "00"));
            S4.put("mc407_5", sharedPref.getString("sp407_5", "00"));
            S4.put("mc407_6", sharedPref.getString("sp407_6", "00"));
            S4.put("mc407_88", sharedPref.getString("sp407_88", "00"));
            S4.put("mc407x", sharedPref.getString("sp407x", "00"));
            S4.put("mc408", sharedPref.getString("sp408", "00"));
            S4.put("mc409", sharedPref.getString("sp409", "00"));
            S4.put("mc409x", sharedPref.getString("sp409x", "00"));
            S4.put("mc410", sharedPref.getString("sp410", "00"));
            S4.put("mc410x", sharedPref.getString("sp410x", "00"));
            S4.put("mc410a_1", sharedPref.getString("sp410a_1", "00"));
            S4.put("mc410a_2", sharedPref.getString("sp410a_2", "00"));
            S4.put("mc410a_3", sharedPref.getString("sp410a_3", "00"));
            S4.put("mc410a_4", sharedPref.getString("sp410a_4", "00"));
            S4.put("mc410a_5", sharedPref.getString("sp410a_5", "00"));
            S4.put("mc410a_99", sharedPref.getString("sp410a_99", "00"));
            S4.put("mc410B_1", sharedPref.getString("sp410B_1", "00"));
            S4.put("mc410B_2", sharedPref.getString("sp410B_2", "00"));
            S4.put("mc410B_3", sharedPref.getString("sp410B_3", "00"));
            S4.put("mc410B_4", sharedPref.getString("sp410B_4", "00"));
            S4.put("mc410B_5", sharedPref.getString("sp410B_5", "00"));
            S4.put("mc410B_88", sharedPref.getString("sp410B_88", "00"));
            S4.put("mc410B_99", sharedPref.getString("sp410B_99", "00"));
            S4.put("mc410B_x", sharedPref.getString("sp410Bx", "00"));
            S4.put("mc411", sharedPref.getString("sp411", "00"));
            S4.put("mc412", sharedPref.getString("sp412", "00"));
            S4.put("mc413_1", sharedPref.getString("sp413_1", "00"));
            S4.put("mc413_2", sharedPref.getString("sp413_2", "00"));
            S4.put("mc413_3", sharedPref.getString("sp413_3", "00"));
            S4.put("mc413_4", sharedPref.getString("sp413_4", "00"));
            S4.put("mc413_5", sharedPref.getString("sp413_5", "00"));
            S4.put("mc413_6", sharedPref.getString("sp413_6", "00"));
            S4.put("mc413_7", sharedPref.getString("sp413_7", "00"));
            S4.put("mc413_88", sharedPref.getString("sp413_88", "00"));
            S4.put("mc413x", sharedPref.getString("sp413x", "00"));
            S4.put("mc414", sharedPref.getString("sp414", "00"));
            S4.put("mc415", sharedPref.getString("sp415", "00"));
            S4.put("mc415x", sharedPref.getString("sp415x", "00"));


            Log.d(TAG, S4.toString());

            FormsContract.getInstance().setS4(S4.toString());

            /*FormsContract formContractS4 = new FormsContract(sharedPref.getString("spFrmNo", "00"), rowId, S4.toString());
            FormsDbHelper db = new FormsDbHelper(this);

            try {
                Log.d(TAG, "Updating Section 2 of the Form to DB...");
                newFormId = db.updateForm(formContractS4);
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

        if (mc401selected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc401_dontknow.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 401 not selected");
            return false;
        }
        if (mc403.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc403.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an Answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 403 Empty");
            return false;
        }

        if (mc406_no.isChecked() && !(mc407_1.isChecked()
                || mc407_2.isChecked()
                || mc407_5.isChecked()
                || mc407_3.isChecked()
                || mc407_4.isChecked()
                || mc407_6.isChecked()
                || mc407_88.isChecked()
        )
                ) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc407_6.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 401 not selected");
            return false;
        }

        if (mc408selected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc408_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 408 not selected");
            return false;
        }
        if (mc408selected == 0 && mc410Aselected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc410A_99.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 410A not selected");
            return false;
        }
        if (mc408_yes.isChecked() && mc409.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc409.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an Answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 409 Empty");
            return false;
        }

        if (mc410.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc410.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an Answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 410 Empty");
            return false;
        }
        if (mc411.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc411.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an Answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 411 Empty");
            return false;
        }
        if (mc412selected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc412_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 412 not selected");
            return false;
        }

        if (mc414selected == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            mc414_no.setError("Please select an answer!");
            Log.d(TAG, "Error Type: 414 not selected");
            return false;
        }
        if (mc414_no.isChecked() && mc415.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mc415.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an Answer");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select an Answer.", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 415 Empty");
            return false;
        }

//        return false;
        return true;
    }

   /* @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Button NOT Allowed!", Toast.LENGTH_SHORT).show();

    }*/
}
