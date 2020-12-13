package com.example.incidencias.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.incidencias.R;
import com.example.incidencias.RecyclerViewAdapter;
import com.example.incidencias.db.IncidenciaDBHelper;

public class Fragment_Lista extends Fragment {

    public Fragment_Lista() {
        // Required empty public constructor
    }

    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fListar = inflater.inflate(R.layout.fragment_lista, container, false);

        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = fListar.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(IncidenciaDBHelper.getAllIncidents(db));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((fListar.getContext())));

        return fListar;
    }
}