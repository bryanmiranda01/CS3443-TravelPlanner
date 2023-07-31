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
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table if it exists.
        db.execSQL("DROP TABLE IF EXISTS users");

        // Create the new table.
        onCreate(db);
    }

    public static AppData getInstance(Context context) {
        if (instance == null) {
            instance = new AppData(context);
        }
        return instance;
    }

    public void addUser(String email, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        db.insert("users", null, values);
    }

    public List<User_Model> getUsers() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("users", null, null, null, null, null, null);
        List<User_Model> users = new ArrayList<>();
        while(cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));
            users.add(new User_Model(id, email, password));
        }
        return users;
    }

    public void updateUser(int id, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        db.update("users", values, "id = ?", new String[]{String.valueOf(id)});
    }

    public void deleteUser(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("users", "id = ?", new String[]{String.valueOf(id)});
    }
}

