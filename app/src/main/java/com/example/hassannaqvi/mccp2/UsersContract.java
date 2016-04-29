package com.example.hassannaqvi.mccp2;

import android.provider.BaseColumns;

/**
 * Created by hassan.naqvi on 4/27/2016.
 */
public final class UsersContract {
    private static final String TAG = "Users_CONTRACT";
    Long _ID;
    String ROW_USERNAME;
    String ROW_PASSWORD;

    public UsersContract() {
        // Default Constructor
    }

    public UsersContract(String username, String password) {
        this.ROW_PASSWORD = password;
        this.ROW_USERNAME = username;
    }

    public Long getUserID() {
        return this._ID;
    }

    public void setId(int id) {
        this._ID = Long.valueOf(id);
    }

    public String getUserName() {
        return this.ROW_USERNAME;
    }

    public void setUserName(String username) {
        this.ROW_USERNAME = username;
    }

    public String getPassword() {
        return this.ROW_PASSWORD;
    }

    public void setPassword(String password) {
        this.ROW_PASSWORD = password;
    }

    public static abstract class singleUser implements BaseColumns {

        public static final String TABLE_NAME = "Users";
        public static final String _ID = "_ID";
        public static final String ROW_USERNAME = "USERNAME";
        public static final String ROW_PASSWORD = "PASSWORD";


    }
}
