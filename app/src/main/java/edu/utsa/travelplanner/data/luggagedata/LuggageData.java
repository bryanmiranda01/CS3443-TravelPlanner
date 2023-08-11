package edu.utsa.travelplanner.data.luggagedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class LuggageData extends SQLiteOpenHelper {

    public static LuggageData instance;
    public static final String TABLE_NAME = "luggage";
    public static final String ID = "luggageid";
    public static final String OWNER = "owner";
    public static final String BRAND = "brand";
    public static final String WEIGHT = "weight";
    public static final String DIMENSIONS = "dimensions";
    public static final String COLOR = "color";

    public LuggageData(Context context) {
        super(context, "luggagedetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OWNER + " TEXT," + BRAND + " TEXT," + WEIGHT
                + " TEXT," + DIMENSIONS + " TEXT, " + COLOR + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists luggage");
        onCreate(db);
    }

    //Get all information
    public ArrayList getLuggage() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM luggage";
        Cursor cursor = db.rawQuery(query, null);
        ArrayList luggage = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                String owner = cursor.getString(1);
                String brand = cursor.getString(2);
                String weight = cursor.getString(3);
                String dimensions = cursor.getString(4);
                String color = cursor.getString(5);

                Luggage lug = new Luggage();
                lug.setOwner(owner);
                lug.setBrand(brand);
                lug.setWeight(weight);
                lug.setDimensions(dimensions);
                lug.setColor(color);

                luggage.add(luggage);
            } while (cursor.moveToNext());
        }
        return luggage;
    }

    public static LuggageData getInstance(Context context) {
        if (instance == null) {
            instance = new LuggageData(context);
        }
        return instance;
    }


    //Adding luggage information
    public void addLuggageData(String owner, String brand, String weight, String dimensions,
                            String color) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("owner", owner);
        contentValues.put("brand", brand);
        contentValues.put("weight", weight);
        contentValues.put("dimensions", dimensions);
        contentValues.put("color", color);

        db.insert("luggage", null, contentValues);
    }

    //Updating luggage information
    public void updateLuggageData(int luggageid, String owner, String brand, String weight, String dimensions,
                                String color) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = db.query("luggage", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int up_luggageid = cursor.getInt(cursor.getColumnIndexOrThrow("luggageid"));
            String up_owner = cursor.getString(cursor.getColumnIndexOrThrow("owner"));
            String up_brand = cursor.getString(cursor.getColumnIndexOrThrow("brand"));
            String up_weight = cursor.getString(cursor.getColumnIndexOrThrow("weight"));
            String up_dimen = cursor.getString(cursor.getColumnIndexOrThrow("dimensions"));
            String up_color = cursor.getString(cursor.getColumnIndexOrThrow("color"));

            db.update("luggage", contentValues, "luggageid=?", new String[]{String.valueOf(up_luggageid)});
        }
    }

    //Delete luggage information
    public void deleteLuggageData(int luggageid) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("luggage", "luggageid = ?", new String[]{String.valueOf(luggageid)});
    }

    //Fetch specific strings
    public Cursor fetchLuggage1() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE luggageid = 1 ", new String[] {});
        return cursor;
    }
    public Cursor fetchLuggage2() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE luggageid = 2 ", new String[] {});
        return cursor;
    }
    public Cursor fetchLuggage3() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE luggageid = 3 ", new String[] {});
        return cursor;
    }
}