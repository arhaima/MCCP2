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
import java.util.List;

/**
 * Created by hassan.naqvi on 5/5/2016.
 */
public class syncFormsBK extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "syncForms";
    private Context mContext;

    public syncFormsBK(Context context) {
        mContext = context;
    }

    public static void longInfo(String str) {
        if (str.length() > 4000) {
            Log.i("TAG: ", str.substring(0, 4000));
            longInfo(str.substring(4000));
        } else
            Log.i("TAG: ", str);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            String request = "http://192.168.1.10/appdata/census/syncdb.php";

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
            /*for (int i = 0; i < 10; i++) {
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("townid", "2" + i);
                jsonParam.put("ucid", i + "04033");
                jsonParam.put("ucname", "Whats in the name");
                jsonSync.put(jsonParam);
            }
            wr.writeBytes(jsonSync.toString());
            longInfo(jsonSync.toString());


            wr.flush();*/


            // wr.close();
            FormsDbHelper db = new FormsDbHelper(mContext);
            List<FormsContract> forms = db.getAllFormstoSync();
            for (FormsContract fc : forms) {

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("mcFrmno", fc.getFrmNo().replace("\\", ""));
                jsonParam.put("mc101", fc.get101().replace("\\", ""));
                jsonParam.put("mc101time", fc.get101Time().replace("\\", ""));
                jsonParam.put("mc102", fc.get102().replace("\\", ""));
                jsonParam.put("mc103", fc.get103().replace("\\", ""));
                jsonParam.put("mc104", fc.get104().replace("\\", ""));
                jsonParam.put("mc105", fc.get105().replace("\\", ""));
                jsonParam.put("mc106", fc.get106().replace("\\", ""));
                jsonParam.put("mc107", fc.get107().replace("\\", ""));
                jsonParam.put("mc108", fc.get108().replace("\\", ""));
                jsonParam.put("mcGPSLat", fc.getGPSLat().replace("\\", ""));
                jsonParam.put("mcGPSLng", fc.getGPSLng().replace("\\", ""));
                jsonParam.put("DeviceID", fc.getDeviceId().replace("\\", ""));
                if (fc.getS2() != null) {
                    jsonParam.put("s2", fc.getS2().replace("\\", ""));
                } else {
                    jsonParam.put("s2", "");

                }
                if (fc.getS4() != null) {
                    jsonParam.put("s4", fc.getS4().replace("\\", ""));
                } else {
                    jsonParam.put("s4", "");

                }
                if (fc.getS5() != null) {
                    jsonParam.put("s5", fc.getS5().replace("\\", ""));
                } else {
                    jsonParam.put("s5", "");

                }
                if (fc.getS6() != null) {
                    jsonParam.put("s6", fc.getS6().replace("\\", ""));
                } else {
                    jsonParam.put("s6", "");
                }


                jsonSync.put(jsonParam);

                longInfo(jsonSync.toString());
                wr.writeBytes(jsonSync.toString());

                wr.flush();

                // Writing Forms to MySQL
            }
            //longInfo(str);
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
            e.printStackTrace();
        }
        return null;
    }
}
