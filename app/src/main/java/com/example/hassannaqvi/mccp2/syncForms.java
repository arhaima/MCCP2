package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hassan.naqvi on 5/5/2016.
 */
public class syncForms extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "syncForms";
    private Context mContext;

    public syncForms(Context context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            String request = "http://192.168.1.10/appdata/syncdb.php";

            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setUseCaches(false);


            JSONArray jsonSync = new JSONArray();
            //int i = 1;

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            for (int i = 0; i < 10; i++) {
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("townid", "2" + i);
                jsonParam.put("ucid", i + "04033");
                jsonParam.put("ucname", "Whats in the name");
                jsonSync.put(jsonParam);
                Log.d(TAG, "writing " + i + " " + jsonSync.toString());
            }
            wr.writeBytes(jsonSync.toString());


            wr.flush();


            // wr.close();
            /*FormsDbHelper db = new FormsDbHelper(mContext);
            List<FormsContract> forms = db.getAllForms();

            for (FormsContract fc : forms) {

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("MC_FRMNO", fc.getFrmNo());
                jsonParam.put("MC_101", fc.get101());
                jsonParam.put("MC_101TIME", fc.get101Time());
                jsonParam.put("MC_102", fc.get102());
                jsonParam.put("MC_103", fc.get103());
                jsonParam.put("MC_104", fc.get104());
                jsonParam.put("MC_105", fc.get105());
                jsonParam.put("MC_106", fc.get106());
                jsonParam.put("MC_107", fc.get107());
                jsonParam.put("MC_108", fc.get108());
                jsonParam.put("MC_GPSLat", fc.getGPSLat());
                jsonParam.put("MC_GPSLng", fc.getGPSLng());
                jsonParam.put("DeviceID", fc.getDeviceId());
                jsonParam.put("MC_S2", fc.getS2());
                jsonParam.put("MC_S4", fc.getS4());
                jsonParam.put("MC_S5", fc.getS5());
                jsonParam.put("MC_S6", fc.getS6());

                wr.writeBytes(jsonParam.toString());

                wr.flush();
                wr.close();
                // Writing Forms to MySQL
            }*/


            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            Log.d("SERVER_RESPONSE", response.toString());
        } catch (Exception e) {
            Log.d("TEST: ", "Connection Failed");
            e.printStackTrace();
        }
        return null;
    }
}
