package edu.utsa.travelplanner.data.tripdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class TripData extends SQLiteOpenHelper {

    public static TripData instance;
    public Context context;
    public SQLiteDatabase database;

    public static final String TABLE_NAME = "details";
    public static final String ID = "tripid";
    public static final String DEST = "destination";
    public static final String HOTEL = "address";
    public static final String CC = "cc";
    public static final String STARTT = "startt";
    public static final String ENDT = "endt";
    public static final String TRANSP = "transport";

    public TripData(Context context) {
        super(context, "tripdetails.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DEST + " TEXT," + HOTEL + " TEXT," + CC
                + " TEXT," + STARTT + " TEXT, " + ENDT + " TEXT, " + TRANSP + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS details");
        onCreate(db);
    }

    //Get all information  --TESTING___
    public ArrayList getDetails() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM details";
        Cursor cursor = db.rawQuery(query, null);
        ArrayList details = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                String destination = cursor.getString(1);
                String address = cursor.getString(2);
                String cc = cursor.getString(3);
                String startt = cursor.getString(4);
                String endt = cursor.getString(5);
                String transport = cursor.getString(6);

                Trip trip = new Trip();
                trip.setDestination(destination);
                trip.setAddress(address);
                trip.setCc(cc);
                trip.setStart(startt);
                trip.setEnd(endt);
                trip.setTransport(transport);

                details.add(details);
            } while (cursor.moveToNext());
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
    public void addTripData(String destination, String address, String cc, String startt,
                            String endt, String transport) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("destination", destination);
        contentValues.put("address", address);
        contentValues.put("cc", cc);
        contentValues.put("startt", startt);
        contentValues.put("endt", endt);
        contentValues.put("transport", transport);

        db.insert("details", null, contentValues);
    }


    //Updating trip information
    public void updateTripData(int tripid, String destination, String address, String cc, String startt,
                               String endt, String transport) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = db.query("details", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int up_tripid = cursor.getInt(cursor.getColumnIndexOrThrow("tripid"));
            String up_dest = cursor.getString(cursor.getColumnIndexOrThrow("destination"));
            String up_address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
            String up_cc = cursor.getString(cursor.getColumnIndexOrThrow("city/country"));
            String up_start = cursor.getString(cursor.getColumnIndexOrThrow("start"));
            String up_endt = cursor.getString(cursor.getColumnIndexOrThrow("end"));
            String up_transp = cursor.getString(cursor.getColumnIndexOrThrow("transportation"));

            db.update("details", contentValues, "tripid=?", new String[]{String.valueOf(up_tripid)});
        }
    }


    //Deleting trip information
    public void deleteTripData(int tripid) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("details", "tripid = ?", new String[]{String.valueOf(tripid)});
    }

    //Fetch specific strings
    public Cursor fetchDetails() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }
}
