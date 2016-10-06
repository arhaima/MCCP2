package com.example.hassannaqvi.mccp2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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
public class SyncFilesData extends AsyncTask<Void, Void, Boolean> {

    private static final String TAG = "syncFiles";
    private Context mContext;
    private String mText;

    public SyncFilesData(Context context) {
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
    protected Boolean doInBackground(Void... params) {
        try {
            String request = "http://192.168.1.10/appdata/census/syncFiles.php";

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
            //connection.setConnectTimeout(60000);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            ShareDBHelper db = new ShareDBHelper(mContext);
            List<String> forms = db.getAllForms();
            for (String fc : forms) {
                Log.d(TAG, fc);
                String[] Fcs = fc.split("::");
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("ID", Fcs[0]);
                jsonParam.put("FormNo", Fcs[1]);
                jsonParam.put("Data", Fcs[2]);
                jsonParam.put("DeviceID", Fcs[3]);

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
        } catch (IllegalArgumentException e) { //Replace this with the more specific exception
            return false;
        } catch (Exception e) {
            mText = e.getLocalizedMessage();
            e.printStackTrace();
            return false;
        }
        return null;
    }

    protected void onPostExecute(Long result) {
        Toast.makeText(mContext, mText, Toast.LENGTH_SHORT).show();
    }
}