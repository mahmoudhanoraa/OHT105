package com.hanora.mahmoud.oht105.java;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad on 6/11/2016.
 */
public class DBManager extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.Figuers.TABLE_NAME + " (" +
                    DBContract.Figuers._ID + " INTEGER PRIMARY KEY," +
                    DBContract.Figuers.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    DBContract.Figuers.COLUMN_NAME_BRIEF + TEXT_TYPE + COMMA_SEP +
                    DBContract.Figuers.COLUMN_NAME_DATE_FROM + TEXT_TYPE + COMMA_SEP +
                    DBContract.Figuers.COLUMN_NAME_DATE_TO + TEXT_TYPE + COMMA_SEP +
                    DBContract.Figuers.COLUMN_NAME_CONTENT + TEXT_TYPE + COMMA_SEP +
                    DBContract.Figuers.COLUMN_NAME_IMAGE + TEXT_TYPE + COMMA_SEP +
                    DBContract.Figuers.COLUMN_NAME_FRONTNOTE + TEXT_TYPE + COMMA_SEP +
                    " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DBContract.Figuers.TABLE_NAME;

    public void insert(Figure figure) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DBContract.Figuers._ID, figure.getId());
        values.put(DBContract.Figuers.COLUMN_NAME_NAME, figure.getName());
        values.put(DBContract.Figuers.COLUMN_NAME_BRIEF, figure.getBrief());
        values.put(DBContract.Figuers.COLUMN_NAME_DATE_FROM, figure.getFromDate());
        values.put(DBContract.Figuers.COLUMN_NAME_DATE_TO, figure.getToDate());
        values.put(DBContract.Figuers.COLUMN_NAME_CONTENT, figure.getContent());
        values.put(DBContract.Figuers.COLUMN_NAME_IMAGE, figure.getImage());
        values.put(DBContract.Figuers.COLUMN_NAME_FRONTNOTE, figure.getFrontNote());

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                DBContract.Figuers.TABLE_NAME,
                null,
                values);
        db.close();
    }

    //Get all figures in the database without the field Content
    public List<Figure> getAll() {
        List<Figure> figureList = new ArrayList<Figure>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + DBContract.Figuers.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Figure figure = new Figure();

                figure.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBContract.Figuers._ID))));
                figure.setName(cursor.getString(cursor.getColumnIndex(DBContract.Figuers.COLUMN_NAME_NAME)));
                figure.setBrief(cursor.getString(cursor.getColumnIndex(DBContract.Figuers.COLUMN_NAME_BRIEF)));
                figure.setFromDate(cursor.getString(cursor.getColumnIndex(DBContract.Figuers.COLUMN_NAME_DATE_FROM)));
                figure.setToDate(cursor.getString(cursor.getColumnIndex(DBContract.Figuers.COLUMN_NAME_DATE_TO)));
                figure.setImage(cursor.getString(cursor.getColumnIndex(DBContract.Figuers.COLUMN_NAME_IMAGE)));
                figure.setFrontNote(cursor.getString(cursor.getColumnIndex(DBContract.Figuers.COLUMN_NAME_FRONTNOTE)));
                figure.setContent(null);

                figureList.add(figure);
            } while (cursor.moveToNext());
        }

        return figureList;
    }

    //Get the content for the provided figure using its ID
    public Figure getContentFor(Figure figure) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                DBContract.Figuers.COLUMN_NAME_CONTENT
        };

        Cursor cursor = db.query(DBContract.Figuers.TABLE_NAME, projection, DBContract.Figuers._ID + "=?",
                new String[]{String.valueOf(figure.getId())}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        figure.setContent(cursor.getString(0));
        return figure;
    }

    public DBManager(Context context) {
        super(context, DBContract.DB_NAME, null, DBContract.VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
