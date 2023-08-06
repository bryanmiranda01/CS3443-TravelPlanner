package edu.utsa.travelplanner.data.tripdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TripData extends SQLiteOpenHelper {

    public static TripData instance;

    public TripData(Context context) {
        super(context, "tripdetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE details(tripid INTEGER PRIMARY KEY, ans_dest TEXT,ans_hotel TEXT," +
                "ans_cc TEXT, ans_start TEXT,ans_end TEXT,ans_transp TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists details");
        onCreate(db);
    }

    //Get all information
    public List<Trip> getDetails() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("details", null, null, null, null, null, null);
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

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ans_dest", ans_dest);
        contentValues.put("ans_hotel", ans_hotel);
        contentValues.put("ans_cc", ans_cc);
        contentValues.put("ans_start", ans_start);
        contentValues.put("ans_end", ans_end);
        contentValues.put("ans_transp", ans_transp);

        db.insert("details", null, contentValues);
    }


    //Updating trip information
    public void updateTripData(int tripid, String ans_dest, String ans_hotel, String ans_cc, String ans_start,
                               String ans_end, String ans_transp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = db.query("details", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int up_tripid = cursor.getInt(cursor.getColumnIndexOrThrow("trip_id"));
            String up_ans_dest = cursor.getString(cursor.getColumnIndexOrThrow("destination"));
            String up_ans_hotel = cursor.getString(cursor.getColumnIndexOrThrow("address"));
            String up_ans_cc = cursor.getString(cursor.getColumnIndexOrThrow("city/country"));
            String up_ans_start = cursor.getString(cursor.getColumnIndexOrThrow("start"));
            String up_ans_end = cursor.getString(cursor.getColumnIndexOrThrow("end"));
            String up_ans_transp = cursor.getString(cursor.getColumnIndexOrThrow("transportation"));

            db.update("details", contentValues, "tripid=?", new String[]{String.valueOf(up_tripid)});
        }
    }


    //Deleting trip information
    public void deleteTripData(int tripid) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("details", "tripid = ?", new String[]{String.valueOf(tripid)});
    }

    //Fetching information

    public void fetch(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("Select ans_dest from" + "details" + "", null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(1));
        }
    }


}