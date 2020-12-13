package com.example.incidencias.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.incidencias.Login;
import com.example.incidencias.R;

import java.util.Locale;

public class Fragment_Ajustes extends Fragment {
    SharedPreferences sharedPreferences;

    public Fragment_Ajustes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fAjustes = inflater.inflate(R.layout.fragment_ajustes, container, false);

        sharedPreferences = getContext().getSharedPreferences("userPreferences", Context.MODE_PRIVATE);

        ImageButton imageButtonEspanol = fAjustes.findViewById(R.id.imageButtonEspanol);
        imageButtonEspanol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeLanguage("es");
            }
        });

        ImageButton imageButtonIngles = fAjustes.findViewById(R.id.imageButtonIngles);
        imageButtonIngles.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                changeLanguage("en");
            }
        });

        ImageButton imageButtonFrances = fAjustes.findViewById(R.id.imageButtonFrances);
        imageButtonFrances.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                changeLanguage("fr");
            }
        });

        Button deleteAll = fAjustes.findViewById(R.id.btnDeleteAll);
        deleteAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("language").remove("save_user").remove("user_name").remove("user_password").commit();
                refresh();
            }
        });

        return fAjustes;
    }

    public void changeLanguage(String language){
        Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(language);
        sharedPreferences.edit().putString("Language",language).commit();

        switch (language) {
            case "es":
                config.locale = new Locale("es");
                break;
            case "en":
                config.locale = Locale.ENGLISH;
                break;
            case "fr":
                config.locale = Locale.FRENCH;
                break;
        }


        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        refresh();
    }


    public void refresh(){
        Intent intent = new Intent(getContext(), Login.class);
        startActivity(intent);
    }

}