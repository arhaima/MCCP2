package com.example.hassannaqvi.mccp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FormView extends AppCompatActivity {
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_view);
        text2 = (TextView) findViewById(R.id.text2);
        text2.setText(getIntent().getStringExtra("listText"));
    }
}
