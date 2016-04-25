package com.example.hassannaqvi.mccp2;

import android.provider.BaseColumns;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 4/15/2016.
 */
public final class FormsContract {

    private static final String TAG = "FORM_CONTRACT";
    Long _ID;
    String DEVICE_ID;
    String ROW_MC_FrmNo;
    String ROW_MC_101;
    String ROW_MC_101TIME;
    String ROW_MC_102;
    String ROW_MC_103;
    String ROW_MC_104;
    String ROW_MC_105;
    String ROW_MC_106;
    String ROW_MC_EXT;
    String ROW_MC_107;
    String ROW_MC_108;
    String ROW_S_2;
    String ROW_S_3;
    String ROW_S_4;
    String ROW_S_5;
    String ROW_S_6;
    String ROW_Ending;

    public FormsContract(){
        // Default Constructor
    }

    public FormsContract(JSONObject mc1) throws JSONException {
        Log.d(TAG, "Constructor: String+JSON");
        this.ROW_MC_FrmNo = mc1.getString("mcFrmNo");
        this.DEVICE_ID = mc1.getString("deviceId");
        this.ROW_MC_101 = mc1.getString("mc101");
        this.ROW_MC_101TIME = mc1.getString("mc101Time");
        this.ROW_MC_102 = mc1.getString("mc102");
        this.ROW_MC_103 = mc1.getString("mc103");
        this.ROW_MC_104 = mc1.getString("mc104");
        this.ROW_MC_105 = mc1.getString("mc105");
        this.ROW_MC_106 = mc1.getString("mc106");
        this.ROW_MC_EXT = mc1.getString("mcExt");
        this.ROW_MC_107 = mc1.getString("mc107");
        this.ROW_MC_108 = mc1.getString("mc108");

    }

    public FormsContract(String id, String rowId, String ss) {
        Log.d(TAG, "Constructor: String+String");

        this.ROW_MC_FrmNo = id;
        this._ID = Long.valueOf(rowId);
        this.ROW_S_2 = ss;
        Log.d(TAG, ss);

    }

    public Long getId() {
        return this._ID;
    }

    public void setId(String id) {
        this._ID = Long.valueOf(id);
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
        this.ROW_MC_101 = mc101;
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

    public String getExt() {
        return this.ROW_MC_EXT;
    }

    public void setExt(String mcExt) {
        this.ROW_MC_EXT = mcExt;
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
        return this.ROW_Ending;
    }

    public void setEnding(String ending) {
        this.ROW_Ending = ending;
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
        json.put("mc_ext", this.ROW_MC_EXT);
        json.put("mc_107", this.ROW_MC_107);
        json.put("mc_108", this.ROW_MC_108);


        //TODO: working for Section 2

        //TODO: Working for Section 3

        //TODO: Working for Section 4

        //TODO: Working for Section 5

        //TODO: Working for Section 6

        //TODO: Working for Ending

        return json;
    }

    //TODO: Move GenerateFormID method here
    //TODO: Move StoreTempValues method here
    //TODO: Move formValidation method here (possibly create new Class FormValidator extends TextValidator)

    public static abstract class singleForm implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String _ID = "_ID";
        public static final String DEVICE_ID = "DEVICE_ID";
        public static final String ROW_MC_FrmNo = "MC_FRMNO";
        public static final String ROW_MC_101 = "MC_101";
        public static final String ROW_MC_101TIME = "MC_101TIME";
        public static final String ROW_MC_102 = "MC_102";
        public static final String ROW_MC_103 = "MC_103";
        public static final String ROW_MC_104 = "MC_104";
        public static final String ROW_MC_105 = "MC_105";
        public static final String ROW_MC_106 = "MC_106";
        public static final String ROW_MC_EXT = "MC_EXT";
        public static final String ROW_MC_107 = "MC_107";
        public static final String ROW_MC_108 = "MC_108";
        public static final String ROW_S_2 = "MC_S2";
        public static final String ROW_S_3 = "MC_S3";
        public static final String ROW_S_4 = "MC_S4";
        public static final String ROW_S_5 = "MC_S5";
        public static final String ROW_S_6 = "MC_S6";
        public static final String ROW_Ending = "MC_End";
    }








}
