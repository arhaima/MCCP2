package com.example.hassannaqvi.mccp2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MAIN_ACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fillSurveyForm(View view) {

        Intent fill_form_intent = new Intent(getApplicationContext(), FillFormActivity.class);
        startActivity(fill_form_intent);
    }

    public void editStoredForm(View view) {

        Log.d("Hassan1", "Hassan1" + FillFormActivity.FORM_ID);
        if (FillFormActivity.FORM_ID != null) {
            SharedPreferences sharedPref = getSharedPreferences(FillFormActivity.FORM_ID, Context.MODE_PRIVATE);
            Boolean openForm = sharedPref.getBoolean("formOpen", false);
            Log.d("MainActivity", openForm.toString());
        } else {
            Log.d("Null", "True");
        }
        /*Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        }*/

        insertForm(FillFormActivity.FORM_ID);
    }
    public void insertForm(String formId){

        String formValue = formId;

        SharedPreferences sharedPref = getSharedPreferences(formValue, Context.MODE_PRIVATE);

        Boolean openForm = sharedPref.getBoolean("formOpen", false);

        if (openForm) { //TODO: on final version set this to !openForm
            Log.d(TAG, "Instantiating DB Helper...!");
            FormsDbHelper mDbHelper = new FormsDbHelper(getApplicationContext());

            Log.d(TAG, "Initializing DB Helper...!");
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            Log.d(TAG, "Putting values to Class Variables...!");
            values.put(FormsContract.singleForm.ROW_ID, sharedPref.getString("spFrmNo", "false"));
            values.put(FormsContract.singleForm.ROW_MC_101, sharedPref.getString("sp101", "false"));
            values.put(FormsContract.singleForm.ROW_MC_101TIME, sharedPref.getString("sp101Time", "false"));
            values.put(FormsContract.singleForm.ROW_MC_102, sharedPref.getString("sp102", "false"));
            values.put(FormsContract.singleForm.ROW_MC_103, sharedPref.getString("sp103", "false"));
            values.put(FormsContract.singleForm.ROW_MC_104, sharedPref.getString("sp104", "false"));
            values.put(FormsContract.singleForm.ROW_MC_105, sharedPref.getString("sp105", "false"));
            values.put(FormsContract.singleForm.ROW_MC_106, sharedPref.getString("sp106", "false"));
            values.put(FormsContract.singleForm.ROW_MC_EXT, sharedPref.getString("spExt", "false"));
            values.put(FormsContract.singleForm.ROW_MC_107, sharedPref.getString("sp107", "false"));
            values.put(FormsContract.singleForm.ROW_MC_108, sharedPref.getString("sp108", "false"));
            values.put(FormsContract.singleForm.ROW_MC_109, sharedPref.getString("sp109", "false"));
            values.put(FormsContract.singleForm.ROW_MC_110, sharedPref.getString("sp110", "false"));
            values.put(FormsContract.singleForm.ROW_MC_110X, sharedPref.getString("sp110x", "false"));

            Log.d(TAG, "Class variables initialized...! " + FormsContract.singleForm.ROW_ID);

            long newRowId;

            Log.d(TAG, FormsDbHelper.SQL_CREATE_FORMS);
            newRowId = db.insert("Forms", FormsContract.singleForm.COLUMN_NAME_NULLABLE, values);
            Log.d(TAG, "Form Record Inserted.. ID:" + String.valueOf(newRowId) + " Total Records: " + getFormsCount());

        }



    }

    public int getFormsCount() {

        FormsDbHelper mDbHelper = new FormsDbHelper(getApplicationContext());


        String countQuery = "SELECT  * FROM " + FormsContract.singleForm.TABLE_NAME;
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();

    }
}
