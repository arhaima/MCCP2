package com.example.hassannaqvi.mccp2;

import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class CfsContract {

    private static final String TAG = "IM_CONTRACT";

    private Long _ID;
    private String row_FrmNo;
    private String row_chid;
    private String row_cf;

    public CfsContract() {
    }

    public CfsContract(JSONObject cf) throws JSONException {
        this.row_chid = cf.getString("cfchid");
        this.row_FrmNo = cf.getString("formId");
        this.row_cf = cf.getString("cf");


    }

    public Long getId() {
        return this._ID;
    }

    public void setId(String id) {
        this._ID = Long.valueOf(id);
    }

    public String getCf() {
        return this.row_cf;
    }

    public void setCf(String cf) {
        this.row_cf = cf;
    }

    public String getChid() {
        return this.row_chid;
    }

    public void setChid(String chid) {
        this.row_chid = chid;
    }

    public String getFrmNo() {
        return this.row_FrmNo;
    }

    public void setFrmNo(String frmno) {
        this.row_FrmNo = frmno;
    }


    public static abstract class singleCfs implements BaseColumns {

        public static final String TABLE_NAME = "CFS";
        public static final String _ID = "_ID";
        public static final String ROW_CHID = "CHID";
        public static final String ROW_FrmNo = "FRMNO";
        public static final String ROW_CF = "CF";

    }

}