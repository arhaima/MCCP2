package com.example.hassannaqvi.mccp2;

import android.provider.BaseColumns;

/**
 * Created by hassan.naqvi on 4/29/2016.
 */
public class TownsContract {

    private static final String TAG = "Towns_Contract";
    Long _ID;
    String ROW_TOWN;


    public TownsContract() {
        // Default Constructor
    }

    public TownsContract(String town, String id) {
        this._ID = Long.valueOf(id);
        this.ROW_TOWN = town;
    }

    public Long geTownID() {
        return this._ID;
    }

    public void setId(int id) {
        this._ID = Long.valueOf(id);
    }

    public String getTown() {
        return this.ROW_TOWN;
    }

    public void setTown(String username) {
        this.ROW_TOWN = username;
    }

    public static abstract class singleTown implements BaseColumns {

        public static final String TABLE_NAME = "Towns";
        public static final String _ID = "_ID";
        public static final String ROW_TOWN = "TOWNS";
    }
}
