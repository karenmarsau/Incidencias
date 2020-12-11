package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Login extends AppCompatActivity {
    EditText txtUserName;
    EditText txtPassword;
    Button btnLogin;
    TextView resultado;


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUserName = (EditText)findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);
        resultado = findViewById(R.id.txtResultado);

        sharedPreferences = getSharedPreferences("userPreferences", Context.MODE_PRIVATE);

        Configuration configuration = new Configuration(getResources().getConfiguration());
        configuration.locale = new Locale(sharedPreferences.getString("Language", "es"));
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        if (sharedPreferences.getBoolean("save_user", false)) {
            goToMenu();
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("Click!!!", "Clickado!!!!!");

                String txtUser = txtUserName.getText().toString();
                String txtPass = txtPassword.getText().toString();

                if(txtUser.equals("admin") && txtPass.equals("admin")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("user_name", txtUser);
                    editor.putString("user_password", txtPass);
                    editor.putBoolean("save_user", true);
                    editor.commit();

                    resultado.setText("Login OK");
                    goToMenu();
                }else{
                    resultado.setText("Login KO");
                }
            }
        });
    }

    public void goToMenu(){
        Intent intentMenu = new Intent(this, Menu.class);
        startActivity(intentMenu);
    }
}