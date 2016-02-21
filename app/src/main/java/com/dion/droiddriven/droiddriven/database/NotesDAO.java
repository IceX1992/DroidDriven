package com.dion.droiddriven.droiddriven.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dion.droiddriven.droiddriven.entities.Notes;

/**
 * Created by Dion on 2/21/2016.
 */
public class NotesDAO extends SQLiteOpenHelper {

    public static final String NOTES_TABLE = "notes";
    public static final String NOTES_TITEL = "titel";
    public static final String NOTES_INHOUD = "inhoud";
    private static final String DB_NOTES = "notes.db";
    private static final int DB_VERSION = 1;
    private static final String SQL_NOTES_TABLE_QUERY = "create table notes(id INTEGER PRIMARY KEY,titel STRING NOT NULL, inhoud VARCHAR() NOT NULL))";


    public NotesDAO(Context context) {
        super(context, DB_NOTES, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_NOTES_TABLE_QUERY);
        insertDefaultData();
    }

    private void insertDefaultData() {

        ContentValues notesValues = new ContentValues();
        notesValues.put(NOTES_TITEL, "Boodschappenlijst");
        notesValues.put(NOTES_INHOUD, "Melk, ei, brood");
        insertNote(NOTES_TABLE, notesValues);

        ContentValues notesValues2 = new ContentValues();
        notesValues2.put(NOTES_TITEL, "Dag agenda");
        notesValues2.put(NOTES_INHOUD, "Werk, school,TBL");
        insertNote(NOTES_TABLE, notesValues2);
    }

    public long insertNote(String titel, ContentValues notes) {
        SQLiteDatabase db = getWritableDatabase();
        long rowId = db.insert(NOTES_TABLE, null, notes);
        db.close();
        return rowId;
    }

    public Notes findNotes() {
        Notes note = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select * from %s", NOTES_TABLE);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()) {
            note = new Notes(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
        }
        db.close();
        return note;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
