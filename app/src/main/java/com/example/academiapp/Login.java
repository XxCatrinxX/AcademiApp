package com.example.academiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    CardView cvlogin;
    Button btninicio;

    TextInputLayout txtusuario, txtcontraseña;
    TextInputEditText tetusuario, tetcontraseña;

    //usuario y contraseña predefinidos
    private static final String USUARIO_CORRECTO = "Catrin69";
    private static final String CONTRASEÑA_CORRECTA = "12345";




    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cvlogin = findViewById(R.id.cvlogin);
        btninicio = findViewById(R.id.btninicio);
        txtusuario = findViewById(R.id.txtusuario);
        txtcontraseña = findViewById(R.id.txtcontraseña);
        tetusuario = findViewById(R.id.tetusuario);
        tetcontraseña = findViewById(R.id.tetcontraseña);


        //metodo para animar el apartado de iniciar sesion
        cvlogin.animate().translationY(-1090).setDuration(2000).setStartDelay(0);

        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obten el usuario y la contraseña ingresados
                String usuario = tetusuario.getText().toString().trim();
                String contraseña = tetcontraseña.getText().toString().trim();

                //Compara con los valores predefinidos
                if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(contraseña)) {
                    //muestra un mensaje de error si uno o ambos campos estan vacios
                    Toast.makeText(Login.this, "Ingresa un usuario y una contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    if (usuario.equals(USUARIO_CORRECTO) && contraseña.equals(CONTRASEÑA_CORRECTA)) {
                        //muestra un mensaje de inisio de sesion exitoso y te redirecciona a la activity de inicio
                        Toast.makeText(Login.this,"Inicio de sesion exitoso", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, inicio.class));
                    } else {
                        //muestra un mensaje de error si las credenciales ingresadas son incorrectas
                        Toast.makeText(Login.this,"El usuario y/o contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void crearcuenta(View view){
        Intent i = new Intent(this, crear_cuenta.class);
        startActivity(i);
    }




}