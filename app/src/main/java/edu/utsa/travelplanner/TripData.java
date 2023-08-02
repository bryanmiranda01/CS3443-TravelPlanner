package edu.utsa.travelplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.utsa.travelplanner.ui.home.Trip;

public class TripData extends SQLiteOpenHelper {

    public static TripData instance;

    public TripData(Context context) {
        super(context, "TripDetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table details(id INTEGER PRIMARY KEY, ans_dest TEXT,ans_hotel TEXT," +
                "ans_cc TEXT, ans_start TEXT,ans_end TEXT,ans_transp TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists Tripdetails");
        onCreate(DB);
    }

    public List<Trip> getDetails() {
        SQLiteDatabase DB = getWritableDatabase();
        Cursor cursor = DB.query("details", null, null, null, null, null, null);
        List<Trip> details = new ArrayList<>();
        while (cursor.moveToNext()) {
            int tripid = cursor.getInt(cursor.getColumnIndexOrThrow("trip_id"));
            String ans_dest = cursor.getString(cursor.getColumnIndexOrThrow("destination"));
            String ans_hotel = cursor.getString(cursor.getColumnIndexOrThrow("address"));
            String ans_cc = cursor.getString(cursor.getColumnIndexOrThrow("city/country"));
            String ans_start = cursor.getString(cursor.getColumnIndexOrThrow("start"));
            String ans_end = cursor.getString(cursor.getColumnIndexOrThrow("end"));
            String ans_transp = cursor.getString(cursor.getColumnIndexOrThrow("transportation"));
            details.add(new Trip(tripid, ans_dest, ans_hotel, ans_cc, ans_start, ans_end, ans_transp));
        }
        return details;
    }

    public static TripData getInstance(Context context) {
        if (instance == null) {
            instance = new TripData(context);
        }
        return instance;
    }

    //Adding trip information
    public void insertTripData(String ans_dest, String ans_hotel, String ans_cc, String ans_start,
                               String ans_end, String ans_transp) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ans_dest", ans_dest);
        contentValues.put("ans_hotel", ans_hotel);
        contentValues.put("ans_cc", ans_cc);
        contentValues.put("ans_start", ans_start);
        contentValues.put("ans_end", ans_end);
        contentValues.put("ans_transp", ans_transp);

        DB.insert("details", null, contentValues);
    }


    //Updating trip information
    public void updateTripData(int tripid, String ans_dest, String ans_hotel, String ans_cc, String ans_start,
                               String ans_end, String ans_transp) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ans_dest", ans_dest);
        contentValues.put("ans_hotel", ans_hotel);
        contentValues.put("ans_cc", ans_cc);
        contentValues.put("ans_start", ans_start);
        contentValues.put("ans_end", ans_end);
        contentValues.put("ans_transp", ans_transp);

        DB.update("details", contentValues, "tripid = ?", new String[]{String.valueOf(tripid)});

    }

    //Deleting trip information
    public void deleteTripData(int tripid) {

        SQLiteDatabase DB = this.getWritableDatabase();

        DB.delete("details", "tripid = ?", new String[]{String.valueOf(tripid)});
    }

}

/*

    // Display function
        WIP

}

 */