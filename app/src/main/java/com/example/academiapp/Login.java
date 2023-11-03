package com.example.academiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    CardView cvlogin;
    Button btninicio;
    EditText txtusuario;
    EditText txtcontraseña;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cvlogin = findViewById(R.id.cvlogin);
        btninicio = findViewById(R.id.btninicio);
        txtusuario = findViewById(R.id.txtusuario);
        txtcontraseña = findViewById(R.id.txtcontraseña);

        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtusuario.getText().toString();
                String password = txtcontraseña.getText().toString();

                //metodo para validar usuario y contraseña e iniciar sesion
                if (username.equals("Catrin69") && password.equals("Maiz69dr")) {

                    Intent i = new Intent(Login.this, inicio.class);
                    startActivity(i);


                }else {
                    Toast.makeText(getApplicationContext(), "El usuario o la contraseña ingresados son incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cvlogin.animate().translationY(-1090).setDuration(2000).setStartDelay(0);

    }
    public void crearcuenta(View view){
        Intent i = new Intent(this, crear_cuenta.class);
        startActivity(i);
    }




}