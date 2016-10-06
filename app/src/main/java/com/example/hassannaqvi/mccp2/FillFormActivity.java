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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FillFormActivity extends AppCompatActivity {

    private static final String TAG = "FILL_FORM_ACTIVITY";
    public static JSONObject s1;
    public static String Cluster;
    public static String ClusterTVI;
    public static String FORM_ID;
    public static long rowId = 0;
    public static String mcFrmNo;
    static FillFormActivity fillformactivity;
    public FormsDbHelper db;
    public ArrayList<ClustersContract> clusterList;
    private DatePicker mc101date;
    private String spDateT;
    private String spTimeT;
    private TimePicker mc101time;
    /*private Spinner mc103town;
    private EditText mc104uc;
    private TextView mc104ucNm;*/
    private EditText mc105cluster;
    private TextView mc105clusterNm;
    private EditText mc106hhno;
    private EditText mcAdd;
    private Spinner mcExt;
    private RadioGroup mc107epimark;
    private RadioButton mc107epimark_yes;
    private RadioButton mc107epimark_no;
    private RadioButton mc107epimark_unclear;
    private int mc107Selected;
    private RadioGroup mc108permission;
    private RadioButton mc108permission_yes;
    private RadioButton mc108permission_no;
    private RadioButton mc108permission_close;
    private int mc108Selected;
    private EditText mcrem1;
    private TextView formErrorTxt;
    private Boolean formError;
    private String deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form);

        db = new FormsDbHelper(getApplicationContext());
        fillformactivity = this;
        if (!FillFormS3Activity.chids.isEmpty()) {
            FillFormS3Activity.chids.clear();
        }
        if (!FillFormS6CFActivity.CF_chids.isEmpty()) {
            FillFormS6CFActivity.CF_chids.clear();
        }
        formError = false;
        deviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

        mcFrmNo = "";
        mc101date = (DatePicker) findViewById(R.id.MC_101DATE);
        mc101time = (TimePicker) findViewById(R.id.MC_101TIME);
//        mc103town = (Spinner) findViewById(R.id.MC_103);
//        mc104uc = (EditText) findViewById(R.id.MC_104);
/*
        mc104ucNm = (TextView) findViewById(R.id.MC_104UCName);
*/
        mc105cluster = (EditText) findViewById(R.id.MC_105);
   /*     if (Cluster != null) {
            mc105cluster.setText(Cluster);
            mc105cluster.setEnabled(false);
        }
        if (ClusterTVI != null) {
            mc105clusterTVI.setText(ClusterTVI);
            mc105clusterTVI.setEnabled(false);
        }*/
        mc105clusterNm = (TextView) findViewById(R.id.MC_105Name);
        mc106hhno = (EditText) findViewById(R.id.MC_106);
        mcAdd = (EditText) findViewById(R.id.MC_ADD);

        mcExt = (Spinner) findViewById(R.id.MC_Ext);

        mc107epimark = (RadioGroup) findViewById(R.id.MC_107);
            mc107epimark_no = (RadioButton) findViewById(R.id.MC_107_No);
        mc107epimark_yes = (RadioButton) findViewById(R.id.MC_107_Yes);
            mc107epimark_unclear = (RadioButton) findViewById(R.id.MC_107_Unclear);


        mc108permission = (RadioGroup) findViewById(R.id.MC_108);
            mc108permission_yes = (RadioButton) findViewById(R.id.MC_108_Yes);
            mc108permission_no = (RadioButton) findViewById(R.id.MC_108_No);
            mc108permission_close = (RadioButton) findViewById(R.id.MC_108_Close);

        formErrorTxt = (TextView) findViewById(R.id.fromError);
        mcrem1 = (EditText) findViewById(R.id.MC_REM1);

        mc101date.setMaxDate(new Date().getTime());
        // mc101date.setMinDate(new Date().getTime()-TimeUnit.DAYS.toMillis(1));



        // Cluster Number (mc105cluster) Validation onFocusChange
        /*mc105cluster.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {


                    String clusterNo = mc105cluster.getText().toString();
                    Log.v(TAG, "index=" + clusterNo);
                    if (clusterNo.equals("407069")) {
                        mc105clusterNm.setText("Stylish Garden");
                        mc105clusterNm.setVisibility(View.VISIBLE);
                    } else {
                        mc105clusterNm.setText("Invalid Cluster Number!");
                        mc105clusterNm.setVisibility(View.VISIBLE);
                        mc105cluster.setError("Invalid Cluster Number!");
                        formError = true;

                    }
                }
            }
        });*/

        // Union Council (mc104uc) Validation onFocusChange
//        mc104uc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    String UCNo = mc104uc.getText().toString();
//
//                    if (UCNo.equals("07")) {
//                        mc104ucNm.setText(
//                                "Yusuf Goth");
//                        mc104ucNm.setVisibility(View.VISIBLE);
//                    } else {
//                        mc104ucNm.setText("Invalid Union Council Number!");
//                        mc104ucNm.setVisibility(View.VISIBLE);
//                        mc104uc.setError("Invalid Union Council Number!");
//                        formError = true;
//
//                    }
//                }
//            }
//        });

        mc105cluster.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    mc105cluster.setText(mc105cluster.getText().toString().toUpperCase());
                    clusterList = db.getClustersByUC(LoginActivity.UC_ID);
                    for (ClustersContract UC : clusterList) {
                        Log.i(TAG, UC.getClusterName());
                        if (UC.getClusterCode().equals(mc105cluster.getText().toString())) {
                            Log.i(TAG, "Match:" + UC.getClusterName());

                            mc105clusterNm.setText(UC.getClusterName());
                            mc105cluster.setError(null);
                            break;
                        } else {
                            mc105clusterNm.setText("Invalid Cluster Number!");
                            mc105cluster.setError("Invalid Cluster Number!");
                        }
                    }
                    mc105clusterNm.setVisibility(View.VISIBLE);

                }
            }
        });

        mc108permission.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Button btnContinue = (Button) findViewById(R.id.btn_Continue);
                Log.d(TAG, "Button Id " +checkedId);
                if(checkedId != mc108permission_yes.getId()){
                        btnContinue.setEnabled(false);
                    Toast.makeText(FillFormActivity.this, "Continue Button OFF", Toast.LENGTH_SHORT).show();
                } else {
                    btnContinue.setEnabled(true);
                    Toast.makeText(FillFormActivity.this, "Continue Button ON", Toast.LENGTH_SHORT).show();
                }
             }
        });


    }

    // Start Interview Form 1 - Section 1
    public void startInterview(View view) {
        rowId = 0;

        Toast.makeText(getApplicationContext(), "Starting Interview...", Toast.LENGTH_SHORT).show();
        FORM_ID = mc106hhno.getText().toString() + "-" + mcExt.getSelectedItem().toString();

        spDateT = new SimpleDateFormat("dd-MM-yy").format(mc101date.getCalendarView().getDate());
        spTimeT = mc101time.getCurrentHour() + ":" + mc101time.getCurrentMinute();
        // Form Validation - Section 1


        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation... Successful!", Toast.LENGTH_SHORT).show();

            StoreTempValues();

            Intent fill_form_S2_intent = new Intent(getApplicationContext(), FillFormS2Activity.class);
            fill_form_S2_intent.putExtra("formId", GenerateFormId());

            startActivity(fill_form_S2_intent);

        } else {
            Toast.makeText(getApplicationContext(), "Form Validation... Failed!", Toast.LENGTH_SHORT).show();

            formError = false;
            formErrorTxt.setText("Please remove all errors to continue!");
            formErrorTxt.setVisibility(View.VISIBLE);

        }
    }

    // End Interview Form 1 - Section 1
    public void endInterview(View view) {
        Log.d(TAG, "endInterview");
        Toast.makeText(getApplicationContext(), "Starting End of Form Section... ", Toast.LENGTH_SHORT).show();

        FORM_ID = mc106hhno.getText().toString() + "-" + mcExt.getSelectedItem().toString();
        spDateT = new SimpleDateFormat("dd-MM-yy").format(mc101date.getCalendarView().getDate());
        spTimeT = mc101time.getCurrentHour() + ":" + mc101time.getCurrentMinute();

        // Form Validation - Section 1

        if (formValidation()) {
            Toast.makeText(getApplicationContext(), "Form Validation...Successful!", Toast.LENGTH_SHORT).show();
            StoreTempValues();
            Intent end_form_intent = new Intent(getApplicationContext(), EndFormActivity.class);
            end_form_intent.putExtra("frmNoId", GenerateFormId());
            startActivity(end_form_intent);

        } else {
            Toast.makeText(getApplicationContext(), "Form Validation...Failed!", Toast.LENGTH_SHORT).show();

            formError = false;
            formErrorTxt.setText("Please remove all errors to continue!");
            formErrorTxt.setVisibility(View.VISIBLE);

        }

    }

    // Raw formValidation
    private boolean formValidation() {
        Toast.makeText(getApplicationContext(), "Validating Form Values...", Toast.LENGTH_SHORT).show();

        //Todo: Issue with fromError status and field level validation (104 & 105)

        mc107Selected = mc107epimark.getCheckedRadioButtonId();
        mc108Selected = mc108permission.getCheckedRadioButtonId();


        /*if (mc104uc.getText().toString().isEmpty() || mc104uc.getText().toString() == null) {
            mc104uc.setError("Union Council Number not given!");
            Log.d(TAG, "Error Type: 104");
            return false;
        }*/


        if (mc105cluster.getText().toString().isEmpty() || mc105cluster.getText().toString() == null) {
            mc105cluster.setError("Cluster Number not given!");
            Toast.makeText(getApplicationContext(), "Please enter Cluster Numner\r\n" + getString(R.string.MC_105), Toast.LENGTH_LONG).show();

            Log.d(TAG, "Error Type: 105");
            return false;
        } else

        {
            if (mc105cluster.getError() != null) {
                return false;
        }
        }

        if (mcExt.getSelectedItemPosition() == 0) {
            TextView errorText = (TextView) mcExt.getSelectedView();
            errorText.setError("anything here, just to add the icon");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("Please select an option");//changes the selected item text to this
            Toast.makeText(getApplicationContext(), "Please select HouseHold Type.\r\n" + getString(R.string.MC_106), Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 106Ext mismatch");
            return false;
        }
        if (mc106hhno.getText().toString().isEmpty() || mc106hhno.getText().toString() == null) {
            mc106hhno.setError("Household Number not given!");
            Toast.makeText(getApplicationContext(), "Please enter HouseHold Number.\r\n" + getString(R.string.MC_106), Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 106");
            return false;
        }

        if (mcAdd.getText().toString().isEmpty()) {
            mcAdd.setError("Address not given!");
            Toast.makeText(getApplicationContext(), "Please enter Address.\r\n" + getString(R.string.MC_ADD), Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: Address");
            return false;
        }

        if (mc107Selected == -1) {
            mc107epimark_unclear.setError("Please select an answer!");
            Toast.makeText(getApplicationContext(), "Please select \r\n" + getString(R.string.MC_107), Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 107");
            return false;
        }
        if (mc108Selected == -1) {
            mc108permission_close.setError("Please select an answer!");
            Toast.makeText(getApplicationContext(), "Please select permission.\r\n" + getString(R.string.MC_108), Toast.LENGTH_LONG).show();
            Log.d(TAG, "Error Type: 108 "+ mc108Selected );
            return false;
        }
        // Return from fromValidation()
        return true;
    }

    // Generating 11 digit ID ( ClusterNo + 3digit(106hhno) + convertLetterToNumber(106Ext) )
    private String GenerateFormId() {
        Toast.makeText(getApplicationContext(), "Generating Form ID...", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "mcFrmNo starting");

        String strExt = mcExt.getSelectedItem().toString();
        strExt = strExt.trim();
        Log.d(TAG, "mcFrmNo Jlen: " + String.valueOf(strExt.length()));
        char ch = strExt.charAt(0);
        int pos = ch - 'A' + 1;
        int len = mc106hhno.getText().toString().length();


        String hhCode = "";

        if (len < 3){
            Integer stCode = Integer.valueOf(mc106hhno.getText().toString());
            hhCode = String.format("%03d", stCode);
        } else {
            hhCode = mc106hhno.getText().toString();
        }
        String posS = String.format("%02d", pos);
        Log.d(TAG, "mcFrmNo hhCode: " + hhCode);
        Log.d(TAG, "mcFrmNo pos: " + posS);
        mcFrmNo = mc105cluster.getText().toString() + hhCode + posS;
        Toast.makeText(getApplicationContext(), "Form ID... " + mcFrmNo, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "mcFrmNo: " + mcFrmNo);
        FORM_ID = mcFrmNo;
        return mcFrmNo;

    }

    private void StoreTempValues(){

        Toast.makeText(getApplicationContext(), "Storing Temporary Form Values...", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("MC_" + GenerateFormId(), Context.MODE_PRIVATE);
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();



        editor.putBoolean("formOpen", true);
        editor.putString("spFrmNo", GenerateFormId());
        editor.putString("sp101", String.valueOf(spDateT));
        editor.putString("sp101Time", String.valueOf(spTimeT));
        editor.putString("sp102", LoginActivity.MC_102);
        editor.putString("spCity", "Karachi");
        editor.putString("sp103", mc105cluster.getText().toString().substring(0, 1));
        editor.putString("sp104", mc105cluster.getText().toString().substring(1, 3));
        editor.putString("spAdd", mcAdd.getText().toString());
        editor.putString("spGPSLat", GPSPref.getString("Latitude", "0"));
        editor.putString("spGPSLng", GPSPref.getString("Longitude", "0"));
        editor.putString("spGPSTime", GPSPref.getString("Time", "0"));
        editor.putString("spGPSAcc", GPSPref.getString("Accuracy", "0"));
        editor.putString("spRem1", mcrem1.getText().toString());

        //To Retrieve: double latitude = Double.longBitsToDouble(prefs.getLong("Latitude", 0);


/*
        editor.putString("sp104", mc104uc.getText().toString());
*/
        editor.putString("sp105", mc105cluster.getText().toString());
        Cluster = mc105cluster.getText().toString();
        editor.putString("sp106", mc106hhno.getText().toString() + "-" + mcExt.getSelectedItem().toString());
        editor.putString("spDeviceID", Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        Toast.makeText(getApplicationContext(), "DEVICE IS: " + Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID), Toast.LENGTH_SHORT).show();


        switch (mc107Selected) {
            case R.id.MC_107_No:
                editor.putString("sp107", "2");
                break;
            case R.id.MC_107_Unclear:
                editor.putString("sp107", "3");
                break;
            case R.id.MC_107_Yes:
                editor.putString("sp107", "1");
                break;
            default:
                editor.putString("sp107", "0");
                break;
        }

        switch (mc108Selected) {
            case R.id.MC_108_No:
                editor.putString("sp108", "2");
                break;
            case R.id.MC_108_Close:
                editor.putString("sp108", "3");
                break;
            case R.id.MC_108_Yes:
                editor.putString("sp108", "1");

                break;
            default:
                editor.putString("sp108", "0");
                break;

        }

        editor.commit();
        Log.d(TAG, "Stored sharedValues.");

        s1 = new JSONObject();

        try {

            s1.put("mcFrmNo", sharedPref.getString("spFrmNo", "00"));
            s1.put("mcDeviceId", Settings.Secure.getString(getApplicationContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID));
            s1.put("mc101", sharedPref.getString("sp101", "00"));
            if (s1.get("mc101") == null) {
                Log.d(TAG, "MC is null");
            } else {
                Log.d(TAG, s1.getString("mc101"));
            }


            s1.put("mc101Time", sharedPref.getString("sp101Time", "00"));
            s1.put("mcCity", sharedPref.getString("spCity", "00"));
            s1.put("mc102", sharedPref.getString("sp102", "00"));
            s1.put("mc103", sharedPref.getString("sp103", "00"));
            s1.put("mc104", sharedPref.getString("sp104", "00"));
            s1.put("mc105", sharedPref.getString("sp105", "00"));
            s1.put("mc106", sharedPref.getString("sp106", "00"));
            s1.put("mcAdd", sharedPref.getString("spAdd", "00"));
            s1.put("mc107", sharedPref.getString("sp107", "00"));
            s1.put("mc108", sharedPref.getString("sp108", "00"));
            s1.put("mcRem1", sharedPref.getString("spRem1", "00"));
            s1.put("mcGPSLat", sharedPref.getString("spGPSLat", "0"));
            s1.put("mcGPSLng", sharedPref.getString("spGPSLng", "0"));
            s1.put("mcGPSTime", sharedPref.getString("spGPSTime", "0"));
            s1.put("mcGPSAcc", sharedPref.getString("spGPSAcc", "0"));
            s1.put("mcDeviceID", sharedPref.getString("spDeviceID", "0"));

            Log.d(TAG, "JSON for Section 1: " + s1.toString());

            //FormsContract.getInstance().setS1(s1);
            /*FormsDbHelper db = new FormsDbHelper(this);
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
        Log.d(TAG, "Added Form with Id: " + String.valueOf(rowId));
    }
}