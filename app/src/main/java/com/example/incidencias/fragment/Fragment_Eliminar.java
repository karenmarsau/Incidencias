package com.example.incidencias.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.incidencias.R;

public class Fragment_Eliminar extends Fragment {


    public Fragment_Eliminar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fEliminar = inflater.inflate(R.layout.fragment_eliminar, container, false);

        final Button btnEliminar = fEliminar.findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("¿Estas seguro que deseas eliminar todo?").setTitle("ALERTA");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(getActivity(), "Eliminado correctamente.", Toast.LENGTH_SHORT);
                        toast.setMargin(1000, 500);
                        toast.show();
                    }
                });

                builder.setNegativeButton("Cancelar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return fEliminar;
    }
}