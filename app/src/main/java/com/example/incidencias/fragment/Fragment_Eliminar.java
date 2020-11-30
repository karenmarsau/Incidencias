package com.example.incidencias.fragment;

import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.incidencias.Menu;
import com.example.incidencias.R;
import com.example.incidencias.db.IncidenciaDBHelper;

public class Fragment_Eliminar extends Fragment {


    public Fragment_Eliminar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fEliminar = inflater.inflate(R.layout.fragment_eliminar, container, false);


        final ImageButton btnEliminar = fEliminar.findViewById(R.id.imageButtonEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("¿Estas seguro que deseas eliminar todo?").setTitle("ALERTA");
                AlertDialog dialog = builder.create();
                builder.setPositiveButton("Aceptar", null);
                dialog.show();
            }
        });

        return fEliminar;
    }
}