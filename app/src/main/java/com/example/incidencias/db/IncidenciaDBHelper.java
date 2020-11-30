package com.example.incidencias.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.incidencias.Incidencia;
import com.example.incidencias.db.IncidenciaContract.*;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class IncidenciaDBHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME + "(" +
            IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT," + IncidenciaEntry.COLUMN_NAME_PRIORITY + " TEXT)";

    public IncidenciaDBHelper(@Nullable Context context) {
        super(context,"incidencias.db", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static ArrayList<Incidencia> getAllIssues(SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT * FROM " + IncidenciaEntry.TABLE_NAME, null);
        ArrayList<Incidencia> issueArrayList = new ArrayList<>();
        Incidencia issue;
        Log.i("prova", "sdf" + cursor.getCount());

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                issue = new Incidencia(cursor.getString(cursor.getColumnIndex(IncidenciaEntry.COLUMN_NAME_TITLE)), cursor.getString(cursor.getColumnIndex(IncidenciaEntry.COLUMN_NAME_PRIORITY)), cursor.getInt(cursor.getColumnIndex(IncidenciaEntry.ID)));
                issueArrayList.add(issue);
            } while(cursor.moveToNext());
        }
        cursor.close();
        return issueArrayList;
    }

    public void insertIncidencia(SQLiteDatabase db, Incidencia nuevaIncidencia) {
        //Check the bd is open
        if (db.isOpen()){
    //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE, nuevaIncidencia.getTitulo());
            values.put(IncidenciaEntry.COLUMN_NAME_PRIORITY, nuevaIncidencia.getUrgencia());

            try{
                db.insert(IncidenciaEntry.TABLE_NAME, null, values);
            }catch (SQLException e){
                Log.i("prueba", "insert ko");
            }

        }else{
            Log.d("sql","Database is closed");
        }

    }

    public void dropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + IncidenciaEntry.TABLE_NAME);
    }
}
