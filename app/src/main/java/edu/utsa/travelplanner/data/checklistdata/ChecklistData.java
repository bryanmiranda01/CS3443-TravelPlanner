package edu.utsa.travelplanner.data.checklistdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Might not even need this db
public class ChecklistData extends SQLiteOpenHelper {

    public static ChecklistData instance;
    public Context context;
    public SQLiteDatabase database;

    public static final String TABLE_NAME = "checklist";
    public static final String ID = "checklistid";
    public static final String CREATE = "created";
    public ChecklistData(Context context) {
        super(context, "checklistdetails.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CREATE + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS checklist");
        onCreate(db);
    }

    public static ChecklistData getInstance(Context context) {
        if (instance == null) {
            instance = new ChecklistData(context);
        }
        return instance;
    }

    public void addTripData(Boolean create) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("created", create);

        db.insert("checklist", null, contentValues);
    }

    //Deleting checklist information
    public void deleteCheckData(int checklistid) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("checklist", "checklistid = ?", new String[]{String.valueOf(checklistid)});
    }

}
