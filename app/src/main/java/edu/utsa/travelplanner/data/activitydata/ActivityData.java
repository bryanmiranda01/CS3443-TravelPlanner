package edu.utsa.travelplanner.data.activitydata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ActivityData extends SQLiteOpenHelper {

    public static ActivityData instance;
    public static final String TABLE_NAME = "activities";
    public static final String ID = "activityId";
    public static final String NAME = "name";
    public static final String LOCATION = "location";
    public static final String STARTDATE = "startdate";
    public static final String STARTTIME = "starttime";
    public static final String ENDDATE = "enddate";
    public static final String ENDTIME = "endtime";

    public ActivityData(Context context) {
        super(context, "activitydetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT," + LOCATION + " TEXT," + STARTDATE
                + " TEXT," + STARTTIME + " TEXT, " + ENDDATE + " TEXT," + ENDTIME + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists activities");
        onCreate(db);
    }

    //Get all information
    public ArrayList getActivities() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM activities";
        Cursor cursor = db.rawQuery(query, null);
        ArrayList activity = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                String actName = cursor.getString(1);
                String actLocation = cursor.getString(2);
                String actStartDate = cursor.getString(3);
                String actStartTime = cursor.getString(4);
                String actEndDate = cursor.getString(5);
                String actEndTime = cursor.getString(5);

                Activity act = new Activity();
                act.setActName(actName);
                act.setActLocation(actLocation);
                act.setActStartDate(actStartDate);
                act.setActStartTime(actStartTime);
                act.setActEndDate(actEndTime);
                act.setActEndTime(actEndDate);

                activity.add(activity);
            } while (cursor.moveToNext());
        }
        return activity;
    }

    public static ActivityData getInstance(Context context) {
        if (instance == null) {
            instance = new ActivityData(context);
        }
        return instance;
    }


    //Adding activity information
    public void addActivityData(String name, String location, String startdate, String starttime,
                               String enddate, String endtime) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("location", location);
        contentValues.put("startdate", startdate);
        contentValues.put("starttime", starttime);
        contentValues.put("enddate", enddate);
        contentValues.put("endtime", endtime);

        db.insert("activities", null, contentValues);
    }

    //Updating activity information
    public void updateActivityData(int activityid, String name, String location, String startdate, String starttime,
                               String enddate, String endtime) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = db.query("activities", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int up_activityid = cursor.getInt(cursor.getColumnIndexOrThrow("activityid"));
            String up_name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String up_loc = cursor.getString(cursor.getColumnIndexOrThrow("location"));
            String up_startd = cursor.getString(cursor.getColumnIndexOrThrow("startdate"));
            String up_startt = cursor.getString(cursor.getColumnIndexOrThrow("starttime"));
            String up_endd = cursor.getString(cursor.getColumnIndexOrThrow("enddate"));
            String up_endt = cursor.getString(cursor.getColumnIndexOrThrow("endtime"));

            db.update("activities", contentValues, "activityid=?", new String[]{String.valueOf(up_activityid)});
        }
    }

    //Delete activity information
    public void deleteActivityData(int activityid) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("activities", "activityid = ?", new String[]{String.valueOf(activityid)});
    }

    //Fetch specific strings
    public Cursor fetchActivity() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }
}