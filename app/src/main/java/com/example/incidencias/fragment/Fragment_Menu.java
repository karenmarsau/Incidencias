package com.example.incidencias.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.incidencias.R;
import com.example.incidencias.db.IncidenciaDBHelper;

public class Fragment_Menu extends Fragment {

    public IncidenciaDBHelper dbHelper;
    public SQLiteDatabase db;

    public Fragment_Menu() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fMenu = inflater.inflate(R.layout.fragment_menu, container, false);


      ImageButton imageButtonAnadir = fMenu.findViewById(R.id.imageButtonAnadir);
      imageButtonAnadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment fAnadirInicidencia = new Fragment_Anadir();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.mainFragment, fAnadirInicidencia);

                menuTransaction.commit();

            }
        });

        ImageButton imageButtonListar = fMenu.findViewById(R.id.imageButtonListar);
        imageButtonListar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment fListarIncidencias = new Fragment_Lista();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.mainFragment, fListarIncidencias);

                menuTransaction.commit();

            }
        });

        ImageButton imageButtonEliminar = fMenu.findViewById(R.id.imageButtonEliminar);
        imageButtonEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment fEliminarIncidencias = new Fragment_Eliminar();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.mainFragment, fEliminarIncidencias);
                menuTransaction.commit();
            }
        });

        ImageButton imageButtonAjustes = fMenu.findViewById(R.id.imageButtonAjustes);
        imageButtonAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fAjustes = new Fragment_Ajustes();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.mainFragment, fAjustes);
                menuTransaction.commit();

            }
        });

        return fMenu;
    }
}