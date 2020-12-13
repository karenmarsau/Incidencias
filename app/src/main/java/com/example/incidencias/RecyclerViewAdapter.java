package com.example.incidencias;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.incidencias.db.IncidenciaDBHelper;
import com.example.incidencias.fragment.Fragment_Descripcion;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private  ArrayList<Incidencia>  lista_incidencias;

    int count = 0;
    public RecyclerViewAdapter( ArrayList<Incidencia> inci){
        lista_incidencias = inci ;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        ViewHolder holder = new ViewHolder(view, lista_incidencias);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.id.setText(String.valueOf(lista_incidencias.get(position).getIdIncidencia()));
        holder.titulo.setText(lista_incidencias.get(position).getTitulo());
        holder.urgencia.setText(lista_incidencias.get(position).getUrgencia());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                Fragment_Descripcion descripcion = new Fragment_Descripcion();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutList, descripcion).addToBackStack(null).commit();

                Bundle bundle = new Bundle();
                bundle.putInt("id_incidencia", lista_incidencias.get(position).getIdIncidencia());
                bundle.putString("titulo_incidencia", lista_incidencias.get(position).getTitulo());
                bundle.putString("urgencia_incidencia", lista_incidencias.get(position).getUrgencia());
                bundle.putString("fecha_incidencia", lista_incidencias.get(position).getDate());
                bundle.putString("estado_incidencia", lista_incidencias.get(position).getEstado());
                bundle.putString("desc_incidencia", lista_incidencias.get(position).getDescripcion());

                descripcion.setArguments(bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista_incidencias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView titulo;
        TextView urgencia;
        ConstraintLayout layout;
        Button button;
        ImageView imageEstado;
        IncidenciaDBHelper dbHelper;
        SQLiteDatabase db;
        int idDel;
        String status;

        public ViewHolder(@NonNull final View itemView, ArrayList<Incidencia> lista_incidencias) {
            super(itemView);
            id = itemView.findViewById(R.id.txtId);
            titulo = itemView.findViewById(R.id.txtTitulo);
            urgencia = itemView.findViewById(R.id.txtUrgencia);
            layout = itemView.findViewById(R.id.layout);
            button = itemView.findViewById(R.id.btnEliminarRec);
            imageEstado = itemView.findViewById(R.id.imageStatus);

            status = lista_incidencias.get(count).getEstado();
            if("Asignada".equals(status)) {
                imageEstado.setImageResource(R.drawable.orange_dot);
            } else if("Resuelta".equals(status)) {
                imageEstado.setImageResource(R.drawable.green_dot);
            }

            idDel = lista_incidencias.get(count).getIdIncidencia();


            dbHelper = new IncidenciaDBHelper(itemView.getContext());
            db = dbHelper.getWritableDatabase();

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                    builder.setMessage("¿Estas seguro que deseas eliminar todo?").setTitle("ALERTA");
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dbHelper.dropIncidence(db, idDel);
                        }
                    });

                    builder.setNegativeButton("Cancelar", null);

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            });

            count++;
        }

    }
}
