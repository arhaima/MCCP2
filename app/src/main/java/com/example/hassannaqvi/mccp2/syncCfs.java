package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
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
public class syncCfs extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "syncCfs";
    private Context mContext;

    public syncCfs(Context context) {
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
            String request = "http://192.168.1.10/appdata/synccf.php";

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

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            FormsDbHelper db = new FormsDbHelper(mContext);
            String android_id = Settings.Secure.getString(mContext.getContentResolver(),
                    Settings.Secure.ANDROID_ID);

            List<CfsContract> cfs = db.getAllCfs();

            for (CfsContract cf : cfs) {
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("cfFrmno", cf.getFrmNo());
                jsonParam.put("cfChid", cf.getChid());
                jsonParam.put("cf", cf.getCf());
                jsonParam.put("DeviceId", android_id);
                jsonSync.put(jsonParam);

            }
            wr.writeBytes(jsonSync.toString());
            longInfo(jsonSync.toString());
            wr.flush();

            /*jsonSync = new JSONArray();

            List<CfsContract> cfs = db.getAllCfs();

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