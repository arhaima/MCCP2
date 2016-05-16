package com.example.hassannaqvi.mccp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hassannaqvi.mccp2.CfContract.singleCfs;
import com.example.hassannaqvi.mccp2.ClustersContract.singleCluster;
import com.example.hassannaqvi.mccp2.FormsContract.singleForm;
import com.example.hassannaqvi.mccp2.ImsContract.singleIms;
import com.example.hassannaqvi.mccp2.TownsContract.singleTown;
import com.example.hassannaqvi.mccp2.UCContract.singleUC;
import com.example.hassannaqvi.mccp2.UsersContract.singleUser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FormsDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 5;
    //public String todayDate = DateFormat.getDateInstance().format(Calendar.getInstance());
    public static final String DATABASE_NAME = "mccp2";
    public static final String SQL_CREATE_FORMS = "CREATE TABLE " + singleForm.TABLE_NAME + "("
            + singleForm._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleForm.DEVICE_ID + " TEXT,"
            + singleForm.ROW_MC_FrmNo + " TEXT,"
            + singleForm.ROW_MC_101 + " TEXT,"
            + singleForm.ROW_MC_101TIME + " TEXT,"
            + singleForm.ROW_MC_102 + " TEXT,"
            + singleForm.ROW_MC_103 + " TEXT,"
            + singleForm.ROW_MC_104 + " TEXT,"
            + singleForm.ROW_MC_105 + " TEXT,"
            + singleForm.ROW_MC_106 + " TEXT,"
            + singleForm.ROW_MC_107 + " TEXT,"
            + singleForm.ROW_MC_108 + " TEXT,"
            + singleForm.ROW_GPS_LAT + " TEXT,"
            + singleForm.ROW_GPS_LNG + " TEXT,"
            + singleForm.ROW_SYNC + " TEXT,"
            + singleForm.ROW_S_2 + " TEXT,"
            + singleForm.ROW_S_4 + " TEXT,"
            + singleForm.ROW_S_5 + " TEXT,"
            + singleForm.ROW_S_6 + " TEXT,"
            + singleForm.ROW_Ending + " TEXT" + " );";
    public static final String SQL_CREATE_USERS = "CREATE TABLE " + singleUser.TABLE_NAME + "("
            + singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleUser.ROW_USERNAME + " TEXT,"
            + singleUser.ROW_PASSWORD + " TEXT );";
    public static final String SQL_CREATE_IMS = "CREATE TABLE " + singleIms.TABLE_NAME + "("
            + singleIms._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleIms.ROW_CHID + " TEXT,"
            + singleIms.ROW_FrmNo + " TEXT,"
            + singleIms.ROW_IM + " TEXT );";

    public static final String SQL_CREATE_CFS = "CREATE TABLE " + singleCfs.TABLE_NAME + "("
            + singleCfs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleCfs.ROW_CHID + " TEXT,"
            + singleCfs.ROW_FrmNo + " TEXT,"
            + singleCfs.ROW_CF + " TEXT );";

    public static final String SQL_CREATE_TOWNS = "CREATE TABLE " + singleTown.TABLE_NAME + "("
            + singleTown._ID + " INTEGER PRIMARY KEY,"
            + singleTown.ROW_TOWN + " TEXT );";
    public static final String SQL_CREATE_CLUSTETRS = "CREATE TABLE " + singleCluster.TABLE_NAME + "("
            + singleCluster._ID + " INTEGER PRIMARY KEY,"
            + singleCluster.ROW_CLUSTERS_CODE + " TEXT,"
            + singleCluster.ROW_UC_ID + " TEXT,"
            + singleCluster.ROW_TOWN_ID + " TEXT,"
            + singleCluster.ROW_CLUSTERS_NAME + " TEXT"
            + " );";
    public static final String SQL_CREATE_UC = "CREATE TABLE " + singleUC.TABLE_NAME + "("
            + singleUC._ID + " INTEGER PRIMARY KEY,"
            + singleUC.ROW_UC_ID + " TEXT,"
            + singleUC.ROW_UC_NAME + " TEXT,"
            + singleUC.ROW_TOWN_ID + " TEXT"
            + ");";
    private static final String TAG = "DB_HELPER_CLASS";
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + singleForm.TABLE_NAME;
    private static final String SQL_DELETE_IMS =
            "DROP TABLE IF EXISTS " + singleIms.TABLE_NAME;
    private static final String SQL_DELETE_CFS =
            "DROP TABLE IF EXISTS " + singleCfs.TABLE_NAME;
    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + singleUser.TABLE_NAME;
    private static final String SQL_DELETE_TOWNS =
            "DROP TABLE IF EXISTS " + singleTown.TABLE_NAME;
    private static final String SQL_DELETE_CLUSTER =
            "DROP TABLE IF EXISTS " + singleCluster.TABLE_NAME;
    private static final String SQL_DELETE_UC =
            "DROP TABLE IF EXISTS " + singleUC.TABLE_NAME;

    public FormsDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_IMS);
        db.execSQL(SQL_CREATE_CFS);
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_TOWNS);
        db.execSQL(SQL_CREATE_CLUSTETRS);
        db.execSQL(SQL_CREATE_UC);


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_IMS);
        db.execSQL(SQL_DELETE_CFS);
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_TOWNS);
        db.execSQL(SQL_DELETE_CLUSTER);
        db.execSQL(SQL_DELETE_UC);
        onCreate(db);
    }

    public long addForm(FormsContract formscontract) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        Log.d(TAG, "Add Form ROW_ID: " + formscontract.getId()); // TODO: Check why form ID is 'null'
        values.put(singleForm.ROW_MC_FrmNo, formscontract.getFrmNo());
        values.put(singleForm.DEVICE_ID, formscontract.getFrmNo());
        values.put(singleForm.ROW_GPS_LAT, formscontract.getGPSLat());
        values.put(singleForm.ROW_GPS_LNG, formscontract.getGPSLng());
        values.put(singleForm.ROW_SYNC, formscontract.getSync());
        values.put(singleForm.ROW_MC_101, formscontract.get101());
        values.put(singleForm.ROW_MC_101TIME, formscontract.get101Time());
        values.put(singleForm.ROW_MC_102, formscontract.get102());
        values.put(singleForm.ROW_MC_103, formscontract.get103());
        values.put(singleForm.ROW_MC_104, formscontract.get104());
        values.put(singleForm.ROW_MC_105, formscontract.get105());
        values.put(singleForm.ROW_MC_106, formscontract.get106());
        values.put(singleForm.ROW_MC_107, formscontract.get107());
        values.put(singleForm.ROW_MC_108, formscontract.get108());
        values.put(singleForm.ROW_S_2, formscontract.getS2());
        values.put(singleForm.ROW_S_4, formscontract.getS4());
        values.put(singleForm.ROW_S_5, formscontract.getS5());
        values.put(singleForm.ROW_S_6, formscontract.getS6());


        // Inserting Row
        long rowId = db.insert(singleForm.TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return rowId;
    }

    public long addIM(ImsContract imscontract) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        Log.d(TAG, "Add Form ROW_ID: " + imscontract.getId()); // TODO: Check why form ID is 'null'
        values.put(singleIms.ROW_FrmNo, imscontract.getFrmNo());
        values.put(singleIms.ROW_CHID, imscontract.getChid());
        values.put(singleIms.ROW_IM, imscontract.getIM());


        // Inserting Row
        long rowId = db.insert(singleIms.TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return rowId;
    }

    public long addCF(CfContract cfscontract) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        Log.d(TAG, "Add Form ROW_ID: " + cfscontract.getId()); // TODO: Check why form ID is 'null'
        values.put(singleCfs.ROW_FrmNo, cfscontract.getFrmNo());
        values.put(singleCfs.ROW_CHID, cfscontract.getChid());
        values.put(singleCfs.ROW_CF, cfscontract.getCf());


        // Inserting Row
        long rowId = db.insert(singleCfs.TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return rowId;
    }

    public long updateForm(FormsContract formscontract) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(singleForm.ROW_SYNC, formscontract.getSync());


        // Inserting Row
        long rowId = db.update(singleForm.TABLE_NAME, values, singleForm._ID + " = ?", new String[]{String.valueOf(formscontract.getId())});
        db.close();
        return rowId;
    }

    public List<FormsContract> getAllFormstoSync() {
        List<FormsContract> formList = new ArrayList<FormsContract>();
        // Select All Unsynced Query
        //String selectQuery = "SELECT  * FROM " + singleForm.TABLE_NAME + "WHERE " + singleForm.ROW_SYNC + "='1'";
        String selectQuery = "SELECT  * FROM " + singleForm.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FormsContract form = new FormsContract();
                form.setId(cursor.getString(cursor.getColumnIndex(singleForm._ID)));
                form.setFrmNo(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_FrmNo)));
                form.setDeviceId(cursor.getString(cursor.getColumnIndex(singleForm.DEVICE_ID)));
                form.setGPSLat(cursor.getString(cursor.getColumnIndex(singleForm.ROW_GPS_LAT)));
                form.setGPSLng(cursor.getString(cursor.getColumnIndex(singleForm.ROW_GPS_LNG)));
                form.setSync(cursor.getString(cursor.getColumnIndex(singleForm.ROW_SYNC)));
                form.set101(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_101)));
                form.set101Time(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_101TIME)));
                form.set102(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_102)));
                form.set103(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_103)));
                form.set104(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_104)));
                form.set105(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_105)));
                form.set106(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_106)));
                form.set107(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_107)));
                form.set108(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_108)));
                form.setS2(cursor.getString(cursor.getColumnIndex(singleForm.ROW_S_2)));
                form.setS4(cursor.getString(cursor.getColumnIndex(singleForm.ROW_S_4)));
                form.setS5(cursor.getString(cursor.getColumnIndex(singleForm.ROW_S_5)));
                form.setS6(cursor.getString(cursor.getColumnIndex(singleForm.ROW_S_6)));
                form.setS6(cursor.getString(cursor.getColumnIndex(singleForm.ROW_Ending)));

                // Adding contact to list
                formList.add(form);
            } while (cursor.moveToNext());
        }

        // return contact list
        return formList;
    }

    public List<FormsContract> getAllForms() {
        List<FormsContract> formList = new ArrayList<FormsContract>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + singleForm.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FormsContract form = new FormsContract();
                form.setId(cursor.getString(cursor.getColumnIndex(singleForm._ID)));
                form.setFrmNo(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_FrmNo)));
                form.setDeviceId(cursor.getString(cursor.getColumnIndex(singleForm.DEVICE_ID)));
                form.setGPSLat(cursor.getString(cursor.getColumnIndex(singleForm.ROW_GPS_LAT)));
                form.setGPSLng(cursor.getString(cursor.getColumnIndex(singleForm.ROW_GPS_LNG)));
                form.setSync(cursor.getString(cursor.getColumnIndex(singleForm.ROW_SYNC)));
                form.set101(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_101)));
                form.set101Time(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_101TIME)));
                form.set102(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_102)));
                form.set103(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_103)));
                form.set104(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_104)));
                form.set105(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_105)));
                form.set106(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_106)));
                form.set107(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_107)));
                form.set108(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_108)));
                form.setS2(cursor.getString(cursor.getColumnIndex(singleForm.ROW_S_2)));
                form.setS4(cursor.getString(cursor.getColumnIndex(singleForm.ROW_S_4)));
                form.setS5(cursor.getString(cursor.getColumnIndex(singleForm.ROW_S_5)));
                form.setS6(cursor.getString(cursor.getColumnIndex(singleForm.ROW_S_6)));
                form.setS6(cursor.getString(cursor.getColumnIndex(singleForm.ROW_Ending)));

                // Adding contact to list
                formList.add(form);
            } while (cursor.moveToNext());
        }

        // return contact list
        return formList;
    }

    public List<ImsContract> getAllIms() {
        List<ImsContract> imsList = new ArrayList<ImsContract>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + singleIms.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ImsContract ims = new ImsContract();
                ims.setId(cursor.getString(cursor.getColumnIndex(singleForm._ID)));
                ims.setFrmNo(cursor.getString(cursor.getColumnIndex(singleIms.ROW_FrmNo)));
                ims.setChid(cursor.getString(cursor.getColumnIndex(singleIms.ROW_CHID)));
                ims.setIM(cursor.getString(cursor.getColumnIndex(singleIms.ROW_IM)));


                // Adding contact to list
                imsList.add(ims);
            } while (cursor.moveToNext());
        }

        // return contact list
        return imsList;
    }


    public void addUser(UsersContract userscontract) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(singleUser.ROW_USERNAME, userscontract.getUserName());
            values.put(singleUser.ROW_PASSWORD, userscontract.getPassword());
            db.insert(singleUser.TABLE_NAME, null, values);
            db.close();

        } catch (Exception e) {
        }
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String userName = jsonObjectUser.getString("username");
                String password = jsonObjectUser.getString("password");



                ContentValues values = new ContentValues();

                values.put(singleUser.ROW_USERNAME, userName);
                values.put(singleUser.ROW_PASSWORD, password);
                db.insert(singleUser.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public void syncClusters(JSONArray Clusterslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ClustersContract.singleCluster.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = Clusterslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCluster = jsonArray.getJSONObject(i);
                String id = jsonObjectCluster.getString("ClusterID");
                String ClusterCode = jsonObjectCluster.getString("cluster");
                String UCId = jsonObjectCluster.getString("ids");
                String TownId = jsonObjectCluster.getString("town_id");
                String ClusterName = jsonObjectCluster.getString("cl_name");


                ContentValues values = new ContentValues();

                values.put(singleCluster._ID, id);
                values.put(singleCluster.ROW_CLUSTERS_NAME, ClusterName);
                values.put(singleCluster.ROW_CLUSTERS_CODE, ClusterCode);
                values.put(singleCluster.ROW_TOWN_ID, TownId);
                values.put(singleCluster.ROW_UC_ID, UCId);
                db.insert(singleCluster.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public void syncTowns(JSONArray townlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleTown.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = townlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectTown = jsonArray.getJSONObject(i);
                String id = jsonObjectTown.getString("town id");
                String town = jsonObjectTown.getString("town name");



                ContentValues values = new ContentValues();

                values.put(singleTown._ID, id);
                values.put(singleTown.ROW_TOWN, town);
                db.insert(singleTown.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public void syncUC(JSONArray uclist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleUC.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = uclist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectTown = jsonArray.getJSONObject(i);
                String ids = jsonObjectTown.getString("ids");
                String uc_id = jsonObjectTown.getString("uc_id");
                String town_id = jsonObjectTown.getString("town_id");
                String uc_name = jsonObjectTown.getString("uc_name");

                ContentValues values = new ContentValues();

                values.put(singleUC._ID, ids);
                values.put(singleUC.ROW_UC_ID, uc_id);
                values.put(singleUC.ROW_UC_NAME, uc_name);
                values.put(singleUC.ROW_TOWN_ID, town_id);
                db.insert(singleUC.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public ArrayList<UsersContract> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UsersContract> userList = null;
        try {
            userList = new ArrayList<UsersContract>();
            String QUERY = "SELECT * FROM " + singleUser.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    UsersContract user = new UsersContract();
                    user.setId(cursor.getInt(0));
                    user.setUserName(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    userList.add(user);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }

    public ArrayList<ClustersContract> getAllClusters() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ClustersContract> ClusterList = null;
        try {
            ClusterList = new ArrayList<ClustersContract>();
            String QUERY = "SELECT * FROM " + singleCluster.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    ClustersContract Cluster = new ClustersContract();
                    Cluster.setId(cursor.getString(0));
                    Cluster.setClusterCode(cursor.getString(1));
                    Cluster.setUCId(cursor.getString(2));

                    Cluster.setTownId(cursor.getString(3));
                    Cluster.setClusterName(cursor.getString(4));
                    ClusterList.add(Cluster);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return ClusterList;
    }

    public ArrayList<ClustersContract> getClustersByUC(String uc) {
        SQLiteDatabase db = this.getReadableDatabase();
        String ucId = uc;
        ArrayList<ClustersContract> ClusterList = null;
        try {
            ClusterList = new ArrayList<ClustersContract>();
            String QUERY = "SELECT " + singleCluster.ROW_CLUSTERS_CODE + ", " + singleCluster.ROW_CLUSTERS_NAME + " FROM " + singleCluster.TABLE_NAME + " WHERE " + singleCluster.ROW_UC_ID + "=" + ucId;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    ClustersContract Cluster = new ClustersContract();
                    Cluster.setClusterCode(cursor.getString(0));
                    Cluster.setClusterName(cursor.getString(1));
                    ClusterList.add(Cluster);
                }
            }
            db.close();
        } catch (Exception e) {

        }
        return ClusterList;
    }

    public ArrayList<TownsContract> getAllTowns() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<TownsContract> townList = null;
        try {
            townList = new ArrayList<TownsContract>();
            String QUERY = "SELECT * FROM " + singleTown.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    TownsContract town = new TownsContract();
                    town.setId(cursor.getInt(0));
                    town.setTown(cursor.getString(1));
                    townList.add(town);
                }
            }
            db.close();
            db.close();
        } catch (Exception e) {
        }
        return townList;
    }

    public ArrayList<UCContract> getAllUC() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UCContract> ucList = null;
        try {
            ucList = new ArrayList<UCContract>();
            String QUERY = "SELECT * FROM " + singleUC.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    UCContract uc = new UCContract();
                    uc.setId(cursor.getInt(0));
                    uc.setUCId(cursor.getString(1));
                    uc.setTownId(cursor.getString(3));
                    uc.setUCName(cursor.getString(2));
                    ucList.add(uc);
                }
            }
            db.close();
            db.close();
        } catch (Exception e) {
        }
        return ucList;
    }

    public int getUserCount() {
        int num = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String QUERY = "SELECT * FROM " + singleUser.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            num = cursor.getCount();
            db.close();
            return num;
        } catch (Exception e) {
        }
        return 0;
    }

    public int getFormCount() {
        int num = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String QUERY = "SELECT * FROM " + singleForm.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            num = cursor.getCount();
            db.close();
            return num;
        } catch (Exception e) {
        }
        return 0;
    }

    public int getImsCount() {
        int num = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String QUERY = "SELECT * FROM " + singleIms.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            num = cursor.getCount();
            db.close();
            return num;
        } catch (Exception e) {
        }
        return 0;
    }

    public int getDailyFormCount() {
        int num = 0;
        //spDateT = DateFormat.getDateInstance().format(mc101date.getCalendarView().getDate());
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String QUERY = "SELECT * FROM " + singleForm.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            num = cursor.getCount();
            db.close();
            return num;
        } catch (Exception e) {
        }
        return 0;
    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + singleUser.TABLE_NAME + " WHERE " + singleUser.ROW_USERNAME + "=? AND " + singleUser.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }
}
