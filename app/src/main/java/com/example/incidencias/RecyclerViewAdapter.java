package com.example.incidencias;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private  ArrayList<Incidencia>  lista_incidencias;

    public RecyclerViewAdapter( ArrayList<Incidencia> inci){
        lista_incidencias = inci ;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(lista_incidencias.get(position).getIdIncidencia()));
        holder.titulo.setText(lista_incidencias.get(position).getTitulo());
        holder.urgencia.setText(lista_incidencias.get(position).getUrgencia());

    }

    @Override
    public int getItemCount() {
        return lista_incidencias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView titulo;
        TextView urgencia;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtId);
            titulo = itemView.findViewById(R.id.txtTitulo);
            urgencia = itemView.findViewById(R.id.txtUrgencia);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
