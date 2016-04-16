package com.example.hassannaqvi.mccp2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public String formValue = "";
    public SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


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

        sharedPref = getSharedPreferences(FillFormActivity.FORM_ID, Context.MODE_PRIVATE);

        Boolean openForm = sharedPref.getBoolean("formOpen", false);
        Log.i("MainActivity", openForm.toString());

        /*Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        }*/

        insertForm(FillFormActivity.FORM_ID);
    }
    public void insertForm(String formId){

        formValue = formId;

        sharedPref = getSharedPreferences(formValue, Context.MODE_PRIVATE);

        Boolean openForm = sharedPref.getBoolean("formOpen", false);

        if (!openForm) {

            FormsDbHelper mDbHelper = new FormsDbHelper(getApplicationContext());

            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

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

            long newRowId;

            newRowId = db.insert(FormsContract.singleForm.TABLE_NAME, FormsContract.singleForm.COLUMN_NAME_NULLABLE, values);
            Log.d("Main Activity", "Form Record Inserted" + String.valueOf(newRowId));

        }



    }
}
