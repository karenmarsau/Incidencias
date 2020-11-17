package com.example.incidencias;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentMenu extends Fragment {

    public FragmentMenu() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        Button btnAnadir = fMenu.findViewById(R.id.imageButtonAnadir);
        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fAnadirInicidencia = new Add_Incidencia();

                menuTransaction.replace(R.id.mainFragment, fAnadirInicidencia);

                menuTransaction.commit();

            }
        });


        return fMenu;
    }
}