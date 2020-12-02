package com.example.incidencias.fragment;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.content.res.Resources;

import com.example.incidencias.R;

import java.util.Locale;

public class Fragment_Ajustes extends Fragment {
    private Locale myLocale;


    public Fragment_Ajustes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fAjustes = inflater.inflate(R.layout.fragment_ajustes, container, false);

        ImageButton imageButtonEspanol = fAjustes.findViewById(R.id.imageButtonAnadir);
        imageButtonEspanol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeLanguage("es",this.getRessources());
            }
        });

        return fAjustes;
    }

    public void changeLanguage(String language, Resources res){
        Configuration config = new Configuration(res.getConfiguration());

        switch (language) {
            case "es":
                config.language = new Locale("es");
            case "en":
                config.language = Locale.ENGLISH;
            case "fr":
                config.language = Locale.FRENCH;
                break;
        }
        res.updateConfiguration(config, res.getDisplayMetrics());
    }
}