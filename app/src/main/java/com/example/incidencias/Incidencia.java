package com.example.incidencias;

import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class Incidencia extends Fragment {

    private String titulo;
    private String urgencia;

    public Incidencia(String titulo, String urgencia) {
        this.titulo = titulo;
        this.urgencia = urgencia;
    }

    public Incidencia() {

    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }
}
