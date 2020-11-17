package com.example.incidencias;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.incidencias.db.IncidenciaDBHelper;

import java.util.ArrayList;


public class Add_Incidencia extends Fragment implements AdapterView.OnItemSelectedListener {

    public Add_Incidencia() {
        // Required empty public constructor
    }

    ArrayList<Incidencia> incidencias = new ArrayList<Incidencia>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fAnadir = inflater.inflate(R.layout.fragment_add_incidencias, container, false);

        final EditText editTextTitulo = fAnadir.findViewById(R.id.EdtTitulo);
        final EditText lista = fAnadir.findViewById(R.id.txtLista);

        final Spinner spinner = fAnadir.findViewById(R.id.spinnerUrgencia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.urgencia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        final Button btnAnadir = fAnadir.findViewById(R.id.btnAnadir);
        btnAnadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String EdtTitulo = editTextTitulo.getText().toString();
                String SpinnerUrgencia = spinner.getSelectedItem().toString();

                if(EdtTitulo.equals("") || (SpinnerUrgencia.equals(""))){
                    Toast toast = Toast.makeText(getActivity(),"ERROR, campo vacio.",Toast.LENGTH_SHORT);
                    toast.setMargin(1000,500);
                    toast.show();
                }else{
                    Incidencia nuevaIncidencia = new Incidencia(EdtTitulo, SpinnerUrgencia);
                    incidencias.add(nuevaIncidencia);

                    IncidenciaDBHelper dbHelper = ((Menu)getActivity()).dbHelper;
                    SQLiteDatabase db = ((Menu)getActivity()).db;
                    dbHelper.insertIncidencia(db, nuevaIncidencia);

                    Log.i("Click!!!", EdtTitulo+"--"+SpinnerUrgencia);

                    String resultados = "";
                    for (int i = 0; i < incidencias.size(); i++)
                        if(i + 1 < incidencias.size())
                            resultados += incidencias.get(i) + " | ";
                        else
                            resultados += incidencias.get(i);

                    lista.setText(resultados);
                }


            }

        });

        return fAnadir;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}