package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hassannaqvi.mccp2.FormsContract.singleForm;

public class FormsDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mccp2.db";
    public static final String SQL_CREATE_FORMS = "CREATE TABLE Forms" + "("
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
            + singleForm.ROW_MC_110X + " TEXT" + " );";
    private static final String TAG = "FORM_DB_HELPER_CLASS";
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS Forms";

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
