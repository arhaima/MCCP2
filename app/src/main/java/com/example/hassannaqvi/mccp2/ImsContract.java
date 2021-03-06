package com.example.hassannaqvi.mccp2;

import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ImsContract {

    private static final String TAG = "IM_CONTRACT";

    private Long _ID;
    private String row_FrmNo;
    private String row_chid;
    private String row_im;

    public ImsContract() {
    }

    public ImsContract(JSONObject S3) throws JSONException {
        this.row_chid = S3.getString("imchid");
        this.row_FrmNo = S3.getString("FrmNo");
        this.row_im = S3.getString("im");


    }

    public Long getId() {
        return this._ID;
    }

    public void setId(String id) {
        this._ID = Long.valueOf(id);
    }

    public String getIM() {
        return this.row_im;
    }

    public void setIM(String im) {
        this.row_im = im;
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


    public static abstract class singleIms implements BaseColumns {

        public static final String TABLE_NAME = "Ims";
        public static final String _ID = "_ID";
        public static final String ROW_CHID = "CHID";
        public static final String ROW_FrmNo = "FRMNO";
        public static final String ROW_IM = "IM";

    }

}