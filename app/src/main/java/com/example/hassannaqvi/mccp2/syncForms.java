package com.example.hassannaqvi.mccp2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by hassan.naqvi on 5/5/2016.
 */
public class syncForms extends AsyncTask<Void, Void, String> {

    private static final String TAG = "syncForms";
    private Context mContext;
    private ProgressDialog pd;


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
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Please wait... Processing MCs");
        pd.show();

    }

    @Override
    protected String doInBackground(Void... params) {

        String line = "No Response";

        HttpURLConnection connection = null;
        try {
            String request = MCCP2App.HOST_URL + "appdata/syncdb.php";
            //String request = "http://10.1.42.86/appdata/syncdb.php";

            URL url = new URL(request);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setUseCaches(false);
            connection.connect();


            JSONArray jsonSync = new JSONArray();

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            FormsDbHelper db = new FormsDbHelper(mContext);
            List<FormsContract> forms = db.getAllFormstoSync();
            for (FormsContract fc : forms) {

                JSONObject jsonParam = new JSONObject();

                jsonParam.put("ID", fc.getId() + fc.getDeviceId());
                jsonParam.put("PN", fc.getPN());
                jsonParam.put("ST", fc.getST());
                jsonParam.put("mcFrmno", fc.getFrmNo());
                jsonParam.put("mc101", fc.get101());
                jsonParam.put("mc101time", fc.get101Time());
                jsonParam.put("mc102", fc.get102());
                jsonParam.put("mc103", fc.get103());
                jsonParam.put("mc104", fc.get104());
                jsonParam.put("mc105", fc.get105());
                jsonParam.put("mc106", fc.get106());
                jsonParam.put("mcAdd", fc.getAdd());
                jsonParam.put("mc107", fc.get107());
                jsonParam.put("mc108", fc.get108());
                jsonParam.put("mcRem1", fc.getRem1());
                jsonParam.put("mc109", fc.get109());
                jsonParam.put("mcGPSLat", fc.getGPSLat());
                jsonParam.put("mcGPSLng", fc.getGPSLng());
                jsonParam.put("mcGPSAcc", fc.getGPSAcc());
                jsonParam.put("mcGPSTime", DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(fc.getGPSTime())));
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

                String Comment = "Removed SECTION 6 For Pre-Camp Survey";

                /*if (fc.getS6() != null) {
                    jsonParam.put("s6", fc.getS6());
                } else {
                    jsonParam.put("s6", "");
                }*/
                if (fc.getEnding() != null) {
                    jsonParam.put("ending", fc.getEnding());
                } else {
                    jsonParam.put("ending", "");
                }
                jsonParam.put("Hassan", "Hello!");
                jsonSync.put(jsonParam);
            }
            wr.writeBytes(jsonSync.toString().replace("\uFEFF", "") + "\n");
            longInfo(jsonSync.toString());
            wr.flush();
            int HttpResult = connection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(), "utf-8"));
                StringBuffer sb = new StringBuffer();

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println("" + sb.toString());
                return sb.toString();
            } else {
                System.out.println(connection.getResponseMessage());
                return connection.getResponseMessage();
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return line;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        pd.setMessage("Server Response: " + result);
        pd.setTitle("Please wait... Done MCs");
        pd.show();
    }
}