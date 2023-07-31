package edu.utsa.travelplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "TripDetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Tripsdetails(ans_dest TEXT primary key,ans_hotel TEXT," +
                "ans_cc TEXT, ans_start TEXT,ans_end TEXT,ans_transp TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists Tripdetails");
    }


    //Adding trip information
    public Boolean insertuserdata(String ans_dest, String ans_hotel, String ans_cc, String ans_start,
                                  String ans_end, String ans_transp) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ans_dest", ans_dest);
        contentValues.put("ans_hotel", ans_hotel);
        contentValues.put("ans_cc", ans_cc);
        contentValues.put("ans_start", ans_start);
        contentValues.put("ans_end", ans_end);
        contentValues.put("ans_transp", ans_transp);

        long result = DB.insert("TripDetails", null, contentValues);
            if (result == -1) {
                return false;
        } else {
                return true;
        }
    }

    //Updating trip information
    public Boolean updateuserdata(String ans_dest, String ans_hotel, String ans_cc, String ans_start,
                                  String ans_end, String ans_transp) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ans_dest", ans_dest);
        contentValues.put("ans_hotel", ans_hotel);
        contentValues.put("ans_cc", ans_cc);
        contentValues.put("ans_start", ans_start);
        contentValues.put("ans_end", ans_end);
        contentValues.put("ans_transp", ans_transp);

        Cursor cursor = DB.rawQuery("Select * from Tripdetails where name = ?",
                new String[]{ans_dest});

        if (cursor.getCount() > 0) {
            long result = DB.update("TripDetails", contentValues, "name=?",
                    new String[]{ans_dest});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    //Deleting trip information
    public Boolean deletedata(String ans_dest) {

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Tripdetails where name= ?",
                new String[]{ans_dest});

        if (cursor.getCount() > 0) {
            long result = DB.delete("TripDetails", "name=?", new String[]{ans_dest});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    //    Cursor
    public Cursor getdata() {

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Tripdetails", null);
        return cursor;

    }
}

