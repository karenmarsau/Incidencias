package com.example.incidencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText txtUserName = findViewById(R.id.txtUser);
        final EditText txtPassword = findViewById(R.id.txtPass);

        final Button btnLogin = findViewById(R.id.btnLogin);

        final TextView resultado = findViewById(R.id.txtResultado);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("Click!!!", "Clickado!!!!!");

                String txtUser = txtUserName.getText().toString();
                String txtPass = txtPassword.getText().toString();

                if(txtUser.equals("") && txtPass.equals("")){
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