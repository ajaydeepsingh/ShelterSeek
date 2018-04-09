package com.spring.cs2340.shelterseek.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.spring.cs2340.shelterseek.model.Shelter;

/**
 * Database in use to store data
 */
public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shelters.db";
    public static final String TABLE_SHELTERS = "shelters";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_SHELTERNAME = "sheltername";
    public static final String COLUMN_CAPACITY = "sheltercapacity";
    public static final String COLUMN_LONGITUDE = "shelterlongitude";
    public static final String COLUMN_LATITUDE = "shelterLatitude";
    public static final String COLUMN_PHONE = "shelterPhone";

    /**
     * creates a new database
     * @param context context
     * @param name name of database
     * @param factory factory
     * @param version version num
     */
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_SHELTERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COLUMN_SHELTERNAME + " TEXT " +
                COLUMN_CAPACITY + " TEXT " +
                COLUMN_LONGITUDE + " TEXT " +
                COLUMN_LATITUDE + " TEXT " +
                COLUMN_PHONE + " TEXT " +
                ")" ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHELTERS);
        onCreate(db);
    }

    /**
     * adds shelter to database
     * @param shelter the shelter to add
     */
    public void addShelter(Shelter shelter) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SHELTERNAME, shelter.getName());
        values.put(COLUMN_CAPACITY, shelter.getCapacity());
        values.put(COLUMN_LONGITUDE, shelter.getLongitude());
        values.put(COLUMN_LATITUDE, shelter.getLatitude());
        values.put(COLUMN_PHONE, shelter.getContactInfo());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_SHELTERS, null, values);
        db.close();
    }

    /**
     * deletes a shelter from the database
     * @param shelterName sheltername to search for
     */
    public void deleteShelter(String shelterName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SHELTERS + "WHERE " + COLUMN_SHELTERNAME +
                "-\"" + shelterName + "\";");
    }
}
