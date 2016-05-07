package com.example.hassannaqvi.mccp2;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hassan.naqvi on 5/5/2016.
 */
public class syncForms extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL("http://10.1.42.106/appdata/function.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("town_id", "2")
                    .appendQueryParameter("ucid", "4")
                    .appendQueryParameter("uc_name", "Muhammad Nagar");


            String query = builder.build().getEncodedQuery();
            Log.d("syncforms", query);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            conn.connect();
        } catch (Exception e) {
            Log.d("TEST: ", "Connection Failed");
            e.printStackTrace();
        }
        return null;
    }
}
