package com.example.incidencias.fragment;

import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.incidencias.Incidencia;
import com.example.incidencias.Menu;
import com.example.incidencias.R;
import com.example.incidencias.db.IncidenciaDBHelper;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Fragment_Anadir extends Fragment implements AdapterView.OnItemSelectedListener {

    public Fragment_Anadir() {
        // Required empty public constructor
    }

    //ArrayList<Incidencia> incidencias = new ArrayList<Incidencia>();
    EditText editTextTitulo;
    EditText editTextDescripcion;
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fAnadir = inflater.inflate(R.layout.fragment_anadir, container, false);

        editTextTitulo = fAnadir.findViewById(R.id.EdtTitulo);

        spinner = fAnadir.findViewById(R.id.spinnerUrgencia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.urgencia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        final Button btnAnadir = fAnadir.findViewById(R.id.btnEliminar);
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

                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    nuevaIncidencia.setDate(sdf.format(new Date()));

                    //incidencias.add(nuevaIncidencia);

                    IncidenciaDBHelper dbHelper = ((Menu)getActivity()).dbHelper;
                    SQLiteDatabase db = ((Menu)getActivity()).db;

                    dbHelper.insertIncidencia(db, nuevaIncidencia);

                    Log.i("Click!!!", EdtTitulo+"--"+SpinnerUrgencia);

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Creación de Incidencia").setMessage("Su incidencia ha sido registrada.");
                    builder.setPositiveButton("Aceptar", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

        });

        return fAnadir;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}