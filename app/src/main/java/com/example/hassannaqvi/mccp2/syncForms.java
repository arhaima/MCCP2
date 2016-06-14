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
public class syncForms extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "syncForms";
    private Context mContext;

    public syncForms(Context context) {
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
            String request = "http://192.168.1.10/appdata/syncdb.php";
            //String request = "http://10.1.42.25/appdata/syncdb.php";

            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");


            JSONArray jsonSync = new JSONArray();

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            FormsDbHelper db = new FormsDbHelper(mContext);
            List<FormsContract> forms = db.getAllFormstoSync();
            for (FormsContract fc : forms) {

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("mcFrmno", fc.getFrmNo());
                jsonParam.put("mc101", fc.get101());
                jsonParam.put("mc101time", fc.get101Time());
                jsonParam.put("mc102", fc.get102());
                jsonParam.put("mc103", fc.get103());
                jsonParam.put("mc104", fc.get104());
                jsonParam.put("mc105", fc.get105());
                jsonParam.put("mc106", fc.get106());
                jsonParam.put("mc107", fc.get107());
                jsonParam.put("mc108", fc.get108());
                jsonParam.put("mcGPSLat", fc.getGPSLat());
                jsonParam.put("mcGPSLng", fc.getGPSLng());
                jsonParam.put("DeviceID", fc.getDeviceId());

                if (fc.getS2() != null) {
                    jsonParam.put("s2", fc.getS2());
                } else {
                    jsonParam.put("s2", "");

                }
                if (fc.getS4() != null) {
                    jsonParam.put("s4", fc.getS4());
                } else {
                    jsonParam.put("s4", "");

                }
                if (fc.getS5() != null) {
                    jsonParam.put("s5", fc.getS5());
                } else {
                    jsonParam.put("s5", "");

                }
                if (fc.getS6() != null) {
                    jsonParam.put("s6", fc.getS6());
                } else {
                    jsonParam.put("s6", "");
                }
                if (fc.getEnding() != null) {
                    jsonParam.put("ending", fc.getEnding());
                } else {
                    jsonParam.put("ending", "");
                }

                jsonSync.put(jsonParam);
            }
            wr.writeBytes(jsonSync.toString());
            longInfo(jsonSync.toString());
            wr.flush();
            /*jsonSync = new JSONArray();

            List<ImsContract> ims = db.getAllIms();

            for (ImsContract im : ims) {
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("imFrmno", im.getFrmNo().replace("\\", ""));
                jsonParam.put("imChid", im.getChid().replace("\\", ""));
                jsonParam.put("im", im.getIM().replace("\\", ""));
                jsonSync.put(jsonParam);

            }
            wr.writeBytes(jsonSync.toString());
            longInfo(jsonSync.toString());
            wr.flush();

            jsonSync = new JSONArray();*/

            /*List<CfsContract> cfs = db.getAllCfs();

            for (ImsContract im : ims) {
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("imFrmno", im.getFrmNo().replace("\\", ""));
                jsonParam.put("imChid", im.getChid().replace("\\", ""));
                jsonParam.put("im", im.getIM().replace("\\", ""));
                jsonSync.put(jsonParam);

            }
            wr.writeBytes(jsonSync.toString());
            longInfo(jsonSync.toString());
            wr.flush();
*/


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