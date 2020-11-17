package com.example.incidencias.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.incidencias.Incidencia;
import com.example.incidencias.db.IncidenciaContract.*;
import androidx.annotation.Nullable;

public class IncidenciaDBHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME + "(" +
            IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT)";

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

    public void insertIncidencia(SQLiteDatabase db, Incidencia nuevaIncidencia) {
        //Check the bd is open
        if (db.isOpen()){
    //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE, nuevaIncidencia.getTitulo());

            try{
                db.insert(IncidenciaEntry.TABLE_NAME, null, values);
            }catch (SQLException e){
                Log.i("prueba", "insert ko");
            }

        }else{
            Log.d("sql","Database is closed");
        }

    }
}
