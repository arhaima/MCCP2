package com.example.hassannaqvi.mccp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hassannaqvi.mccp2.FormsContract.singleForm;

import java.util.ArrayList;
import java.util.List;

public class FormsDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mccp2-test.db";
    public static final String SQL_CREATE_FORMS = "CREATE TABLE Forms" + "("
            + singleForm._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleForm.DEVICE_ID + " TEXT,"
            + singleForm.ROW_MC_FrmNo + " TEXT,"
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
            + singleForm.ROW_S_2 + " TEXT,"
            + singleForm.ROW_S_3 + " TEXT,"
            + singleForm.ROW_S_4 + " TEXT,"
            + singleForm.ROW_S_5 + " TEXT,"
            + singleForm.ROW_S_6 + " TEXT,"
            + singleForm.ROW_Ending + " TEXT" + " );";
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


    public long addForm(FormsContract formscontract) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        Log.d(TAG, "Get Form ROW_ID: " + formscontract.getId()); // TODO: Check why form ID is 'null'
        values.put(singleForm.ROW_MC_FrmNo, formscontract.getFrmNo());
        values.put(singleForm.DEVICE_ID, formscontract.getFrmNo());
        values.put(singleForm.ROW_MC_101, formscontract.get101());
        values.put(singleForm.ROW_MC_101TIME, formscontract.get101Time());
        values.put(singleForm.ROW_MC_102, formscontract.get102());
        values.put(singleForm.ROW_MC_103, formscontract.get103());
        values.put(singleForm.ROW_MC_104, formscontract.get104());
        values.put(singleForm.ROW_MC_105, formscontract.get105());
        values.put(singleForm.ROW_MC_106, formscontract.get106());
        values.put(singleForm.ROW_MC_EXT, formscontract.getExt());
        values.put(singleForm.ROW_MC_107, formscontract.get107());
        values.put(singleForm.ROW_MC_108, formscontract.get108());


        // Inserting Row
        long rowId = db.insert(singleForm.TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return rowId;
    }

    public long updateForm(FormsContract formscontract) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        Log.d(TAG, "Get Form _ID: " + formscontract.getId());
        Log.d(TAG, "Get Form ROW_MC_FrmNo: " + formscontract.getFrmNo());
        values.put(singleForm.ROW_S_2, formscontract.getS2());


        // Inserting Row
        long rowId = db.update(singleForm.TABLE_NAME, values, singleForm._ID + " = ?", new String[]{String.valueOf(formscontract.getId())});
        db.close();
        return rowId;
    }

    public List<FormsContract> getAllForms() {
        List<FormsContract> formList = new ArrayList<FormsContract>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + singleForm.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FormsContract form = new FormsContract();
                form.setId(cursor.getString(cursor.getColumnIndex(singleForm._ID)));
                form.setFrmNo(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_FrmNo)));
                form.setDeviceId(cursor.getString(cursor.getColumnIndex(singleForm.DEVICE_ID)));
                form.set101(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_101)));
                form.set101Time(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_101TIME)));
                form.set102(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_102)));
                form.set103(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_103)));
                form.set104(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_104)));
                form.set105(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_105)));
                form.set106(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_106)));
                form.setExt(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_EXT)));
                form.set107(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_107)));
                form.set108(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_108)));

                // Adding contact to list
                formList.add(form);
            } while (cursor.moveToNext());
        }

        // return contact list
        return formList;
    }
}
