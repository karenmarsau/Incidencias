package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.incidencias.db.IncidenciaDBHelper;

public class Menu extends AppCompatActivity {

    public IncidenciaDBHelper dbHelper;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dbHelper = new IncidenciaDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

    }
}