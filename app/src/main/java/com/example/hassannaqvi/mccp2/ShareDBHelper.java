package com.example.hassannaqvi.mccp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hassan.naqvi on 5/23/2016.
 */
public class ShareDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    //public String todayDate = DateFormat.getDateInstance().format(Calendar.getInstance());
    public static final String DATABASE_NAME = "mccp2-dump";
    public static final String SQL_CREATE_FORMS = "CREATE TABLE forms ("
            + "_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " FormID TEXT,"
            + " Data TEXT,"
            + " DeviceID TEXT"
            + " );";
    public static final String SQL_CREATE_IMS = "CREATE TABLE ims ("
            + "_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "ImsID TEXT,"
            + "Data TEXT );";
    public static final String SQL_CREATE_CFS = "CREATE TABLE cfs ("
            + "_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "CfsID TEXT,"
            + "Data TEXT );";
    private static final String TAG = "Shared_DB_HELPER_CLASS";
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS forms";
    private static final String SQL_DELETE_IMS =
            "DROP TABLE IF EXISTS ims";
    private static final String SQL_DELETE_CFS =
            "DROP TABLE IF EXISTS cfs";


    public ShareDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_IMS);
        db.execSQL(SQL_CREATE_CFS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_IMS);
        db.execSQL(SQL_DELETE_CFS);

        onCreate(db);
    }

    public void addForm(String id, String json, String deviceid) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("FormID", id);
        values.put("Data", json);
        values.put("DeviceID", deviceid);
        Log.d(TAG+" "+ id,json);
        db.insert("forms", null, values);
        db.close(); // Closing database connection

    }
    public void addIm(String id, String json) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("ImsID", id);
        values.put("Data", json);

        db.insert("ims", null, values);
        db.close(); // Closing database connection

    }
    public void addCf(String id, String json) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("CfsID", id);
        values.put("Data", json);

        db.insert("cfs", null, values);
        db.close(); // Closing database connection

    }

    public void deleteAllForms(){
        SQLiteDatabase db = this.getWritableDatabase();

        String deleteQuery = "DELETE FROM forms";
        int dCount = db.delete("forms", "1", null);


    }

    public List<String> getAllForms() {
        List<String> formList = new ArrayList<String>();
        // Select All Unsynced Query
        //String selectQuery = "SELECT  * FROM " + singleForm.TABLE_NAME + "WHERE " + singleForm.ROW_SYNC + "='1'";
        String selectQuery = "SELECT * FROM forms";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String numC = String.valueOf(cursor.getCount());

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String form1 = "";
                form1 = cursor.getString(0);
                form1 += "::";
                form1 += cursor.getString(1);
                form1 += "::";
                form1 += cursor.getString(2);
                form1 += "::";
                form1 += cursor.getString(3);



                // Adding contact to list
                formList.add(form1);
            } while (cursor.moveToNext());
            cursor.close();
        }

        // return contact list
        return formList;

    }


}
