package com.example.incidencias;

import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Incidencia extends Fragment {

    private String titulo;
    private String urgencia;
    private String descripcion;
    private int id;
    private String estado;
    private String date;

    public Incidencia(String titulo, String urgencia) {
        this.titulo = titulo;
        this.urgencia = urgencia;
    }

    public Incidencia(String titulo, String urgencia, int id) {
        this.titulo = titulo;
        this.urgencia = urgencia;
        this.id = id;
    }

    public Incidencia(String title, String priority, int id, String status, String date, String description) {
        this.titulo = title;
        this.urgencia = priority;
        this.id = id;
        this.estado = status;
        this.date = date;
        this.descripcion = description;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public int getIdIncidencia() {
        return id;
    }

    public void setIdIncidencia(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
