package com.example.hassannaqvi.mccp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hassannaqvi.mccp2.FormsContract.singleForm;
import com.example.hassannaqvi.mccp2.TownsContract.singleTown;
import com.example.hassannaqvi.mccp2.UsersContract.singleUser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FormsDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "mccp2-test.db";
    public static final String SQL_CREATE_FORMS = "CREATE TABLE" + singleForm.TABLE_NAME + "("
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
            + singleForm.ROW_MC_EXT + " TEXT,"
            + singleForm.ROW_MC_107 + " TEXT,"
            + singleForm.ROW_MC_108 + " TEXT,"
            + singleForm.ROW_S_2 + " TEXT,"
            + singleForm.ROW_S_3 + " TEXT,"
            + singleForm.ROW_S_4 + " TEXT,"
            + singleForm.ROW_S_5 + " TEXT,"
            + singleForm.ROW_S_6 + " TEXT,"
            + singleForm.ROW_Ending + " TEXT" + " );";
    public static final String SQL_CREATE_USERS = "CREATE TABLE " + singleUser.TABLE_NAME + "("
            + singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleUser.ROW_USERNAME + " TEXT,"
            + singleUser.ROW_PASSWORD + " TEXT );";
    public static final String SQL_CREATE_TOWNS = "CREATE TABLE " + singleTown.TABLE_NAME + "("
            + singleTown._ID + " INTEGER PRIMARY KEY,"
            + singleTown.ROW_TOWN + " TEXT );";
    private static final String TAG = "DB_HELPER_CLASS";
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + singleForm.TABLE_NAME;
    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + singleUser.TABLE_NAME;
    private static final String SQL_DELETE_TOWNS =
            "DROP TABLE IF EXISTS " + singleTown.TABLE_NAME;

    public FormsDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_TOWNS);


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_TOWNS);
        onCreate(db);
    }

    public long addForm(FormsContract formscontract) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        Log.d(TAG, "Add Form ROW_ID: " + formscontract.getId()); // TODO: Check why form ID is 'null'
        values.put(singleForm.ROW_MC_FrmNo, formscontract.getFrmNo());
        values.put(singleForm.DEVICE_ID, formscontract.getFrmNo());
        values.put(singleForm.ROW_MC_101, formscontract.get101());
        values.put(singleForm.ROW_MC_101TIME, formscontract.get101Time());
        values.put(singleForm.ROW_MC_102, formscontract.get102());
        values.put(singleForm.ROW_MC_103, formscontract.get103());
        values.put(singleForm.ROW_MC_104, formscontract.get104());
        values.put(singleForm.ROW_MC_105, formscontract.get105());
        values.put(singleForm.ROW_MC_106, formscontract.get106());
        values.put(singleForm.ROW_MC_EXT, formscontract.getExt());
        values.put(singleForm.ROW_MC_107, formscontract.get107());
        values.put(singleForm.ROW_MC_108, formscontract.get108());


        // Inserting Row
        long rowId = db.insert(singleForm.TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return rowId;
    }

    public long updateForm(FormsContract formscontract) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        Log.d(TAG, "Get Form _ID: " + formscontract.getId());
        Log.d(TAG, "Get Form ROW_MC_FrmNo: " + formscontract.getFrmNo());
        values.put(singleForm.ROW_S_2, formscontract.getS2());


        // Inserting Row
        long rowId = db.update(singleForm.TABLE_NAME, values, singleForm._ID + " = ?", new String[]{String.valueOf(formscontract.getId())});
        db.close();
        return rowId;
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
                form.set101(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_101)));
                form.set101Time(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_101TIME)));
                form.set102(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_102)));
                form.set103(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_103)));
                form.set104(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_104)));
                form.set105(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_105)));
                form.set106(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_106)));
                form.setExt(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_EXT)));
                form.set107(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_107)));
                form.set108(cursor.getString(cursor.getColumnIndex(singleForm.ROW_MC_108)));

                // Adding contact to list
                formList.add(form);
            } while (cursor.moveToNext());
        }

        // return contact list
        return formList;
    }


    public void addUser(UsersContract userscontract) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            Log.d(TAG, "Add Users: " + userscontract.getUserName() + "(" + userscontract.getPassword() + ")");

            values.put(singleUser.ROW_USERNAME, userscontract.getUserName());
            values.put(singleUser.ROW_PASSWORD, userscontract.getPassword());
            db.insert(singleUser.TABLE_NAME, null, values);
            db.close();

        } catch (Exception e) {
            Log.e("problem", e + "");
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

                Log.i(TAG, "User: " + userName + "(" + password + ")");


                ContentValues values = new ContentValues();
                Log.d(TAG, "Add Users: " + userName + "(" + password + ")");

                values.put(singleUser.ROW_USERNAME, userName);
                values.put(singleUser.ROW_PASSWORD, password);
                db.insert(singleUser.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
            Log.e("problem", e + "");
        }
    }

    public void syncTowns(JSONArray townlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TownsContract.singleTown.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = townlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String town = jsonObjectUser.getString("town id");
                String id = jsonObjectUser.getString("town name");

                Log.i(TAG, "User: " + town + "(" + id + ")");


                ContentValues values = new ContentValues();
                Log.d(TAG, "Add Users: " + town + "(" + id + ")");

                values.put(singleUser.ROW_USERNAME, town);
                values.put(singleUser.ROW_PASSWORD, id);
                db.insert(singleUser.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
            Log.e("problem", e + "");
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
                    Log.i(TAG, "username:" + num + " " + cursor.getString(1) + "(" + cursor.getString(2) + ")");
                    UsersContract user = new UsersContract();
                    user.setId(cursor.getInt(0));
                    user.setUserName(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    userList.add(user);
                }
            }
            db.close();
        } catch (Exception e) {
            Log.e("error", e + "");
        }
        return userList;
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
                    Log.i(TAG, "TownName:(" + num + ") " + cursor.getString(1) + "(" + cursor.getString(0) + ")");
                    TownsContract town = new TownsContract();
                    town.setId(cursor.getInt(0));
                    town.setTown(cursor.getString(1));
                    townList.add(town);
                }
            }
            db.close();
            db.close();
        } catch (Exception e) {
            Log.e("error", e + "");
        }
        return townList;
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
            Log.e("error", e + "");
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
