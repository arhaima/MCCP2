package com.example.hassannaqvi.mccp2;

import android.provider.BaseColumns;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 4/15/2016.
 */
public class FormsContract {
    private static final String TAG = "FORM_CONTRACT";
    private static final String PROJECT_NAME = "MCCP2-Census";
    private static final String SURVEY_TYPE = "1";
    //private static FormsContract fcInstance = null;
    private Long _ID;
    private String DEVICE_ID;
    private String ROW_MC_FrmNo;
    private String ROW_MC_101;
    private String ROW_MC_101TIME;
    private String ROW_MC_102;
    private String ROW_MC_103;
    private String ROW_MC_104;
    private String ROW_MC_105;
    private String ROW_MC_106;
    private String ROW_MC_ADD;
    private String ROW_MC_107;
    private String ROW_MC_108;
    private String ROW_MC_REM1;
    private String ROW_MC_109;
    private String ROW_GPS_LAT;
    private String ROW_GPS_LNG;
    private String ROW_GPS_ACC;
    private String ROW_GPS_TIME;
    private String ROW_SYNC;
    private String ROW_S_2;
    private String ROW_S_3;
    private String ROW_S_4;
    private String ROW_S_5;
    private String ROW_S_6;
    private String ROW_Ending;

    public FormsContract() {
        // Default Constructor
    }

    public FormsContract(String id, String rowId, String ss) {
        Log.d(TAG, "Constructor: String+String");

        this.ROW_MC_FrmNo = id;
        this._ID = Long.valueOf(rowId);
        this.ROW_S_2 = ss;
        Log.d(TAG, ss);

    }

    public FormsContract(JSONObject mc1) throws JSONException {
        Log.d(TAG, "Constructor: String+JSON");
        this.ROW_MC_FrmNo = mc1.getString("mcFrmNo");
        this.DEVICE_ID = mc1.getString("mcDeviceId");
        this.ROW_MC_101 = mc1.getString("mc101");
        this.ROW_MC_101TIME = mc1.getString("mc101Time");
        this.ROW_MC_102 = mc1.getString("mc102");
        this.ROW_MC_103 = mc1.getString("mc103");
        this.ROW_MC_104 = mc1.getString("mc104");
        this.ROW_MC_105 = mc1.getString("mc105");
        this.ROW_MC_106 = mc1.getString("mc106");
        this.ROW_MC_ADD = mc1.getString("mcAdd");
        this.ROW_MC_107 = mc1.getString("mc107");
        this.ROW_MC_108 = mc1.getString("mc108");
        this.ROW_MC_REM1 = mc1.getString("mcRem1");
        this.ROW_MC_109 = mc1.getString("mc109");
        this.ROW_GPS_LAT = mc1.getString("mcGPSLat");
        this.ROW_GPS_LNG = mc1.getString("mcGPSLng");
        this.ROW_GPS_ACC = mc1.getString("mcGPSAcc");
        this.ROW_GPS_TIME = mc1.getString("mcGPSTime");
        this.DEVICE_ID = mc1.getString("mcDeviceID");
        this.ROW_SYNC = "1";

    }

    public Long getId() {
        return this._ID;
    }

    public void setId(String id) {
        this._ID = Long.valueOf(id);
    }

    public String getPN() {
        return PROJECT_NAME;
    }

    public String getST() {
        return SURVEY_TYPE;
    }

    public String getFrmNo() {
        return this.ROW_MC_FrmNo;
    }

    public void setFrmNo(String mcFrmNo) {
        this.ROW_MC_FrmNo = mcFrmNo;
    }

    public String get101() {
        return this.ROW_MC_101;
    }

    public void set101(String mc101) {
        Log.d(TAG + "-Set101: ", mc101);
        this.ROW_MC_101 = mc101;
        Log.d(TAG + "-Get101: ", get101());

    }

    public String get101Time() {
        return this.ROW_MC_101TIME;
    }

    public void set101Time(String mc101Time) {
        this.ROW_MC_101TIME = mc101Time;
    }

    public String get102() {
        return this.ROW_MC_102;
    }

    public void set102(String mc102) {
        this.ROW_MC_102 = mc102;
    }

    public String getDeviceId() {
        return this.DEVICE_ID;
    }

    public void setDeviceId(String deviceId) {
        this.DEVICE_ID = deviceId;
    }

    public String getGPSLat() {
        return this.ROW_GPS_LAT;
    }

    public void setGPSLat(String GPSLat) {
        this.ROW_GPS_LAT = GPSLat;
    }

    public String getGPSLng() {
        return this.ROW_GPS_LNG;
    }

    public void setGPSLng(String GPSLng) {
        this.ROW_GPS_LNG = GPSLng;
    }

    public String getGPSAcc() {
        return this.ROW_GPS_ACC;
    }

    public void setGPSAcc(String GPSAcc) {
        this.ROW_GPS_ACC = GPSAcc;
    }

    public String getGPSTime() {
        return this.ROW_GPS_TIME;
    }

    public void setGPSTime(String GPSTime) {
        this.ROW_GPS_TIME = GPSTime;
    }

    public String getSync() {
        return this.ROW_SYNC;
    }

    public void setSync(String Sync) {
        this.ROW_SYNC = Sync;
    }

    public String get103() {
        return this.ROW_MC_103;
    }

    public void set103(String mc103) {
        this.ROW_MC_103 = mc103;
    }

    public String get104() {
        return this.ROW_MC_104;
    }

    public void set104(String mc104) {
        this.ROW_MC_104 = mc104;
    }

    public String get105() {
        return this.ROW_MC_105;
    }

    public void set105(String mc105) {
        this.ROW_MC_105 = mc105;
    }

    public String get106() {
        return this.ROW_MC_106;
    }

    public void set106(String mc106) {
        this.ROW_MC_106 = mc106;
    }

    public String getAdd() {
        return this.ROW_MC_ADD;
    }

    public void setAdd(String mcAdd) {
        this.ROW_MC_ADD = mcAdd;
    }

    public String get107() {
        return this.ROW_MC_107;
    }

    public void set107(String mc107) {
        this.ROW_MC_107 = mc107;
    }

    public String get108() {
        return this.ROW_MC_108;
    }

    public void set108(String mc108) {
        this.ROW_MC_108 = mc108;
    }


    public String getRem1() {
        return this.ROW_MC_REM1;
    }

    public void setRem1(String mcRem1) {
        this.ROW_MC_REM1 = mcRem1;
    }


    public String get109() {
        return this.ROW_MC_109;
    }

    public void set109(String mc109) {
        this.ROW_MC_109 = mc109;
    }


    //====================================================
    public String getS2() {
        return this.ROW_S_2;
    }

    public void setS2(String s2) {
        this.ROW_S_2 = s2;
    }

    public String getS3() {
        return this.ROW_S_3;
    }

    public void setS3(String s3) {
        this.ROW_S_3 = s3;
    }

    public String getS4() {
        return this.ROW_S_4;
    }

    public void setS4(String s4) {
        this.ROW_S_4 = s4;
    }

    public String getS5() {
        return this.ROW_S_5;
    }

    public void setS5(String s5) {
        this.ROW_S_5 = s5;
    }

    public String getS6() {
        return this.ROW_S_6;
    }

    public void setS6(String s6) {
        this.ROW_S_6 = s6;
    }

    public String getEnding() {
//        Log.d(TAG+" getEnding", this.ROW_Ending);
        return this.ROW_Ending;
    }

    public void setEnding(String ending) {
        this.ROW_Ending = ending;
        try {
            JSONObject JSONending = new JSONObject(ending);
            this.ROW_MC_109 = String.valueOf(JSONending.getJSONObject("mc109"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        Log.d(TAG+" setEnding", this.ROW_Ending);
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("id", this._ID);
        json.put("deviceId", this.DEVICE_ID);
        json.put("mc_FrmNo", this.ROW_MC_FrmNo);
        json.put("mc_101", this.ROW_MC_101);
        json.put("mc_101time", this.ROW_MC_101TIME);
        json.put("mc_102", this.ROW_MC_102);
        json.put("mc_103", this.ROW_MC_103);
        json.put("mc_104", this.ROW_MC_104);
        json.put("mc_105", this.ROW_MC_105);
        json.put("mc_106", this.ROW_MC_106);
        json.put("mc_ADD", this.ROW_MC_ADD);
        json.put("mc_107", this.ROW_MC_107);
        json.put("mc_108", this.ROW_MC_108);
        json.put("mc_108", this.ROW_MC_REM1);


        return json;
    }


    public static abstract class singleForm implements BaseColumns {

        public static final String TABLE_NAME = "Forms";
        public static final String _ID = "_ID";
        public static final String PROJECT_NAME = "PROJECT_NAME";
        public static final String SURVEY_TYPE = "SURVEY_TYPE";
        public static final String DEVICE_ID = "DEVICE_ID";
        public static final String ROW_GPS_LAT = "GPS_LAT";
        public static final String ROW_GPS_LNG = "GPS_LNG";
        public static final String ROW_GPS_ACC = "GPS_ACC";
        public static final String ROW_GPS_TIME = "GPS_TIME";
        public static final String ROW_SYNC = "SYNC";
        public static final String ROW_MC_FrmNo = "MC_FRMNO";
        public static final String ROW_MC_101 = "MC_101";
        public static final String ROW_MC_101TIME = "MC_101TIME";
        public static final String ROW_MC_102 = "MC_102";
        public static final String ROW_MC_103 = "MC_103";
        public static final String ROW_MC_104 = "MC_104";
        public static final String ROW_MC_105 = "MC_105";
        public static final String ROW_MC_106 = "MC_106";
        public static final String ROW_MC_ADD = "MC_ADD";
        public static final String ROW_MC_107 = "MC_107";
        public static final String ROW_MC_108 = "MC_108";
        public static final String ROW_MC_REM1 = "MC_REM1";
        public static final String ROW_MC_109 = "MC_109";
        public static final String ROW_S_2 = "MC_S2";
        public static final String ROW_S_4 = "MC_S4";
        public static final String ROW_S_5 = "MC_S5";
        public static final String ROW_S_6 = "MC_S6";
        public static final String ROW_Ending = "MC_End";
    }

}
