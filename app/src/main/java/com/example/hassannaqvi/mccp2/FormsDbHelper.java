package com.example.hassannaqvi.mccp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.hassannaqvi.mccp2.FormsContract.singleForm;

import java.util.List;

/**
 * Created by hassan.naqvi on 4/15/2016.
 */

public class FormsDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mccp2.db";
    private static final String SQL_CREATE_FORMS = "CREATE TABLE " + singleForm.TABLE_NAME + "("
            + singleForm.ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleForm.ROW_MC_101 + " TEXT,"
            + singleForm.ROW_MC_101TIME + " TEXT,"
            + singleForm.ROW_MC_102 + " TEXT,"
            + singleForm.ROW_MC_103 + " TEXT,"
            + singleForm.ROW_MC_104 + " TEXT,"
            + singleForm.ROW_MC_105 + " TEXT,"
            + singleForm.ROW_MC_106 + " TEXT,"
            + singleForm.ROW_MC_EXT + " TEXT,"
            + singleForm.ROW_MC_107 + " TEXT,"
            + singleForm.ROW_MC_108 + " TEXT,"
            + singleForm.ROW_MC_109 + " TEXT,"
            + singleForm.ROW_MC_110 + " TEXT,"
            + singleForm.ROW_MC_110X + " TEXT )";

    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + singleForm.TABLE_NAME;

    public FormsDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(SQL_CREATE_FORMS);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL(SQL_DELETE_FORMS);
        onCreate(db);
    }

}
