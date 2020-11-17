package com.example.incidencias;

import android.content.Context;
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
    private Context context;

    public RecyclerViewAdapter(Context con, ArrayList<Incidencia> inci){
        lista_incidencias = inci ;
        context = con;
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
        holder.titulo.setText(lista_incidencias.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return lista_incidencias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView urgencia;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            urgencia = itemView.findViewById(R.id.urgencia);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
