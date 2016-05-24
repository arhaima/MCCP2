package com.example.hassannaqvi.mccp2;

import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class FilesContract {

    private static final String TAG = "FILES_CONTRACT";

    private Long _ID;
    private String ROW_FORMID;
    private String ROW_DATA;


    public FilesContract() {
    }

    public FilesContract(JSONObject cf) throws JSONException {
        this._ID = Long.valueOf(cf.getString("ID"));
        this.ROW_FORMID = cf.getString("FormNo");
        this.ROW_DATA = cf.getString("Data");


    }

    public Long getId() {
        return this._ID;
    }

    public void setId(String id) {
        this._ID = Long.valueOf(id);
    }

    public String getFormId() {
        return this.ROW_FORMID;
    }

    public void setFormId(String frmId) {
        this.ROW_FORMID = frmId;
    }

    public String getData() {
        return this.ROW_DATA;
    }

    public void setData(String data) {
        this.ROW_DATA = data;
    }


    public static abstract class singleFile implements BaseColumns {

        public static final String TABLE_NAME = "files";
        public static final String _ID = "_ID";
        public static final String ROW_FORMID = "FormID";
        public static final String ROW_DATA = "Data";

    }

}