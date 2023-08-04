package edu.utsa.travelplanner.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class AppData extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "travelplanner.db";
    private static final int DATABASE_VERSION = 1;
    private static AppData instance;

    public AppData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY, email TEXT, password TEXT, securityCode TEXT)");
        db.execSQL("CREATE TABLE userProfile (id INTEGER PRIMARY KEY, fName TEXT, lName TEXT, age TEXT, gender TEXT, address TEXT, phoneNumber TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table if it exists.
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS userProfile");

        // Create the new table.
        onCreate(db);
    }


    public static AppData getInstance(Context context) {
        if (instance == null) {
            instance = new AppData(context);
        }
        return instance;
    }

    // ------------------------------------  USER MODEL ---------------------------------------------------------------- //
    public void addUser(String email, String password, String sc) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        values.put("securityCode", sc);
        db.insert("users", null, values);

        values = new ContentValues();
        values.put("fName", "");
        values.put("lName", "");
        values.put("age", "");
        values.put("gender", "");
        values.put("address", "");
        values.put("phoneNumber", "");
        db.insert("userProfile", null, values);
    }

    public List<User_Model> getUsers() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("users", null, null, null, null, null, null);
        List<User_Model> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));
            String securityCode = cursor.getString(cursor.getColumnIndexOrThrow("securityCode"));
            users.add(new User_Model(id, email, password, securityCode));
        }
        return users;
    }

    public void updateUser(String email, String password, String securityCode) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        Cursor cursor = db.query("users", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id_DB = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String email_DB = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String password_DB = cursor.getString(cursor.getColumnIndexOrThrow("password"));
            String securityCode_DB = cursor.getString(cursor.getColumnIndexOrThrow("securityCode"));
            if (email_DB.equals(email)) {
                values.put("password", password);
                values.put("securityCode", securityCode);
                db.update("users", values, "id = ?", new String[]{String.valueOf(id_DB)});
                break;
            }
        }
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("users", "id = ?", new String[]{String.valueOf(id)});
        db.delete("userProfile", "id = ?", new String[]{String.valueOf(id)});
    }

    // ------------------------------------  USER PROFILE MODEL ---------------------------------------------------------------- //
    public UserProfile getUserProfile(int id) {
        SQLiteDatabase db = getWritableDatabase();
        UserProfile profile_of_id = new UserProfile();

        Cursor cursor = db.query("userProfile", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id_DB = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String fName_DB = cursor.getString(cursor.getColumnIndexOrThrow("fName"));
            String lName_DB = cursor.getString(cursor.getColumnIndexOrThrow("lName"));
            String age_DB = cursor.getString(cursor.getColumnIndexOrThrow("age"));
            String gender_DB = cursor.getString(cursor.getColumnIndexOrThrow("gender"));
            String address_DB = cursor.getString(cursor.getColumnIndexOrThrow("address"));
            String phoneNumber_DB = cursor.getString(cursor.getColumnIndexOrThrow("phoneNumber"));

            if (id_DB == id) {
                profile_of_id.setfName(fName_DB);
                profile_of_id.setlName(lName_DB);
                profile_of_id.setAge(age_DB);
                profile_of_id.setGender(gender_DB);
                profile_of_id.setAddress(address_DB);
                profile_of_id.setPhoneNumber(phoneNumber_DB);
                return profile_of_id;
            }
        }
        return profile_of_id;
    }
}
