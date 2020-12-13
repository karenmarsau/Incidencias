package com.example.incidencias.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.incidencias.Incidencia;
import com.example.incidencias.R;
import com.example.incidencias.db.IncidenciaDBHelper;


public class Fragment_Descripcion extends Fragment {
    private Incidencia incidencia;
    private TextView txtTitulo;
    private TextView txtFecha;
    private TextView txtDescripcion;
    private TextView txtUrgencia;
    private Button btnEstado;
    public IncidenciaDBHelper dbHelper;
    public SQLiteDatabase db;



    public Fragment_Descripcion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fDescripcion = inflater.inflate(R.layout.fragment_descripcion, container, false);

        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        txtTitulo = fDescripcion.findViewById(R.id.txtTituloD);
        txtFecha = fDescripcion.findViewById(R.id.txtFechaD);
        txtUrgencia = fDescripcion.findViewById(R.id.txtUrgenciaD);
        txtDescripcion = fDescripcion.findViewById(R.id.txtDescD);
        btnEstado = fDescripcion.findViewById(R.id.btnEstado);

        final int id = Integer.parseInt(getArguments().getString("id_incidencia"));
        String titulo = getArguments().getString("titulo_incidencia");
        String fecha = getArguments().getString("fecha_incidencia");
        String urgencia = getArguments().getString("urgencia_incidencia");
        String estado = getArguments().getString("estado_incidencia");
        String descripcion = getArguments().getString("desc_incidencia");

        txtTitulo.setText(titulo);
        txtFecha.setText(fecha);
        txtUrgencia.setText(urgencia);
        txtDescripcion.setText(descripcion);

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = "Pendiente";

                if(status.equals("Pendiente")){
                    status="Asignada";
                    dbHelper.updateStatusIncidence(db, "Pendiente", id);
                    btnEstado.setText(status);
                    btnEstado.setBackgroundColor(Color.parseColor("#990808"));
                }else if(status.equals("Asignada")){
                    dbHelper.updateStatusIncidence(db, "Asignada", id);
                    status="Resuelta";
                }else if(status.equals("Resuelta")){
                    dbHelper.updateStatusIncidence(db, "Resuelta", id);
                    status="Pendiente";
                }
            }
        });




        return fDescripcion;
    }
}