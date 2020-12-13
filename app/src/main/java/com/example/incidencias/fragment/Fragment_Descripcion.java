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
    private String estado;


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



        final int id = getArguments().getInt("id_incidencia");
        String titulo = getArguments().getString("titulo_incidencia");
        String fecha = getArguments().getString("fecha_incidencia");
        String urgencia = getArguments().getString("urgencia_incidencia");
        estado = getArguments().getString("estado_incidencia");
        String descripcion = getArguments().getString("desc_incidencia");

        if("Pendiente".equals(estado)) {
            btnEstado.setText(R.string.status_pen);
        } else if("Asignada".equals(estado)) {
            btnEstado.setText(R.string.status_assigned);
            btnEstado.setBackgroundResource(R.drawable.status_orange);
        } else if("Resuelta".equals(estado)) {
            btnEstado.setText(R.string.status_resolved);
            btnEstado.setBackgroundResource(R.drawable.status_green);
        }


        txtTitulo.setText(titulo);
        txtFecha.setText(fecha);
        txtUrgencia.setText(urgencia);
        txtDescripcion.setText(descripcion);

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               updateStatus(id);
            }
        });




        return fDescripcion;
    }

    private void updateStatus(int id) {
        if(estado.equals("Pendiente")){
            estado="Asignada";
            dbHelper.updateStatusIncidence(db, estado, id);
            btnEstado.setBackgroundResource(R.drawable.status_orange);
            btnEstado.setText(getString(R.string.status_assigned));
        }else if(estado.equals("Asignada")){
            estado="Resuelta";
            dbHelper.updateStatusIncidence(db, estado, id);
            btnEstado.setText(getString(R.string.status_resolved));
            btnEstado.setBackgroundResource(R.drawable.status_green);
        }else if(estado.equals("Resuelta")){
            estado="Pendiente";
            dbHelper.updateStatusIncidence(db, estado, id);
            btnEstado.setText(getString(R.string.status_pen));
            btnEstado.setBackgroundResource(R.drawable.status_red);
        }
    }
}