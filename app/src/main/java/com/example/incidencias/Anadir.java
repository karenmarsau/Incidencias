package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Anadir extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<Incidencia>  incidencias = new ArrayList<Incidencia>();

    Button btnAnadir;
    EditText editTextTitulo;
    Spinner spIncidencia;
    TextView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir);

        btnAnadir = findViewById(R.id.btnAnadir);
        editTextTitulo = findViewById(R.id.EdtTitulo);
        spIncidencia = findViewById(R.id.spinnerUrgencia);
        lista = findViewById(R.id.txtLista);


        spIncidencia = findViewById(R.id.spinnerUrgencia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.urgencia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spIncidencia.setAdapter(adapter);
        spIncidencia.setOnItemSelectedListener(this);

        btnAnadir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                String EdtTitulo = editTextTitulo.getText().toString();
                String SpinnerUrgencia = spIncidencia.getSelectedItem().toString();

                if(EdtTitulo.equals("") || (SpinnerUrgencia.equals(""))){
                    Toast toast = Toast.makeText(getApplicationContext(),"ERROR, campo vacio.",Toast.LENGTH_SHORT);
                    toast.setMargin(1000,500);
                    toast.show();
                }else{
                    Incidencia nuevaIncidencia = new Incidencia(EdtTitulo, SpinnerUrgencia);
                    incidencias.add(nuevaIncidencia);
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