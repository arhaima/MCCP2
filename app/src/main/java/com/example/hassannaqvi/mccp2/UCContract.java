package com.example.hassannaqvi.mccp2;

/**
 * Created by hassan.naqvi on 4/29/2016.
 */

import android.provider.BaseColumns;

public class UCContract {

    private static final String TAG = "UC_Contract";
    Long _ID;
    String ROW_UC_ID;
    String ROW_TOWN_ID;
    String ROW_UC_NAME;


    public UCContract() {
        // Default Constructor
    }

    public UCContract(String UC, String id, String ucid, String tid, String ucname) {
        this.ROW_UC_ID = ucid;
        this.ROW_UC_NAME = ucname;
        this.ROW_TOWN_ID = tid;
    }


    public Long getID() {
        return this._ID;
    }


    public void setId(int id) {
        this._ID = Long.valueOf(id);
    }

    public String getUCId() {
        return this.ROW_UC_ID;
    }

    public void setUCId(String id) {
        this.ROW_UC_ID = id;
    }

    public String getUCName() {
        return this.ROW_UC_NAME;
    }

    public void setUCName(String ucname) {
        this.ROW_UC_NAME = ucname;
    }

    public String getTownId() {
        return this.ROW_UC_NAME;
    }

    public void setTownId(String townId) {
        this.ROW_TOWN_ID = townId;
    }

    public static abstract class singleUC implements BaseColumns {

        public static final String TABLE_NAME = "UC";
        public static final String _ID = "_ID";
        public static final String ROW_UC_ID = "UC_ID";
        public static final String ROW_UC_NAME = "UC_NAME";
        public static final String ROW_TOWN_ID = "TOWN_ID";

    }
}
