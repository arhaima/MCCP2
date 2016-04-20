package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MAIN_ACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FormsDbHelper db = new FormsDbHelper(this);

    }

    public void fillSurveyForm(View view) {
        Toast.makeText(getApplicationContext(), "Fill Survey Form", Toast.LENGTH_SHORT).show();

        Intent fill_form_intent = new Intent(getApplicationContext(), FillFormActivity.class);
        startActivity(fill_form_intent);
    }

    public void editStoredForm(View view) {
        Toast.makeText(getApplicationContext(), "Edit Stored From.", Toast.LENGTH_SHORT).show();

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

    }

    public void syncForms(View view) {

        FormsDbHelper db = new FormsDbHelper(this);
        List<FormsContract> forms = db.getAllForms();

        for (FormsContract fc : forms) {
            Log.d(TAG, "Id: " + fc.getId()
                    + ", MC_101: " + fc.get101()
                    + ", MC_101TIME: " + fc.get101Time()
                    + ", MC_102: " + fc.get102()
                    + ", MC_103: " + fc.get103()
                    + ", MC_104: " + fc.get104()
                    + ", MC_105: " + fc.get105()
                    + ", MC_106: " + fc.get106()
                    + ", MC_EXT: " + fc.getExt()
                    + ", MC_107: " + fc.get107()
                    + ", MC_108: " + fc.get108());
            // Writing Contacts to log
        }



    }

    public void deleteForms(View view) {
        Intent s2_form_intent = new Intent(getApplicationContext(), FillFormS3Activity.class);

        startActivity(s2_form_intent);

    }



}
