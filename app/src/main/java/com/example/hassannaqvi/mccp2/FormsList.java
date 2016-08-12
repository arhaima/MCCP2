package com.example.hassannaqvi.mccp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FormsList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms_list);

        String clusterno = getIntent().getStringExtra("clusterno");
        TextView cNo = (TextView) findViewById(R.id.clusterNo);
        TextView tf = (TextView) findViewById(R.id.totalForms);
        TextView cf = (TextView) findViewById(R.id.completeForms);
        int fTotal = 0;
        int fComplete = 0;
        cNo.setText("Forms for Cluster: " + clusterno);
        Log.d("TAG:Cluster", clusterno);
        FormsDbHelper db = new FormsDbHelper(getApplicationContext());
        List<FormsContract> forms = db.getFormsByCluster(clusterno);
        for (FormsContract fc : forms) {
            fTotal++;
            if (fc.get109().contains("1")) {
                fComplete++;
            }
        }
        tf.setText("Total Forms: " + fTotal);
        cf.setText("Complete Forms: " + fComplete);

        mRecyclerView = (RecyclerView) findViewById(R.id.FormsList);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);


        mAdapter = new FormsAdapter(forms, getApplication());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(5000);
        itemAnimator.setRemoveDuration(5000);
        mRecyclerView.setItemAnimator(itemAnimator);

    }

    public void toast(View v) {
        v.getId();
        Toast.makeText(FormsList.this, String.valueOf(v.getId()), Toast.LENGTH_SHORT).show();
    }
}




