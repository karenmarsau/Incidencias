package com.example.incidencias.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.incidencias.Incidencia;
import com.example.incidencias.R;


public class Fragment_Descripcion extends Fragment {

    Incidencia incidencia;

    TextView titulo;
    TextView fecha;
    TextView descripcion;
    TextView urgencia;


    public Fragment_Descripcion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fDescripcion = inflater.inflate(R.layout.fragment_descripcion, container, false);

        titulo = fDescripcion.findViewById(R.id.txtTituloD);
        fecha = fDescripcion.findViewById(R.id.txtFechaD);
        urgencia = fDescripcion.findViewById(R.id.txtUrgenciaD);
        descripcion = fDescripcion.findViewById(R.id.txtDescD);

        //String txtTitulo = titulo.setText(incidencia.getTitulo());


        return fDescripcion;
    }
}