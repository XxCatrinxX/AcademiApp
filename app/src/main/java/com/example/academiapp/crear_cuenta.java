package com.example.academiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.graphics.Color;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class crear_cuenta extends AppCompatActivity {

    CardView RLcc;
    Button btncuentacreada;
    TextInputLayout txtnombre, txtapellido, txtcorreo, txtusername;
    TextInputEditText tetnombre, tetapellido, tetcorreo, tetusername, tetpassword;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        RLcc = findViewById(R.id.RLcc);
        btncuentacreada = findViewById(R.id.btncuentacreada);
        tetnombre = findViewById(R.id.tetnombre);
        tetapellido = findViewById(R.id.tetapellido);
        tetcorreo = findViewById(R.id.tetcorreo);
        tetusername = findViewById(R.id.tetusername);
        tetpassword = findViewById(R.id.tetpassword);
        txtnombre = findViewById(R.id.txtnombre);
        txtapellido = findViewById(R.id.txtapellido);
        txtcorreo = findViewById(R.id.txtcorreo);
        txtusername = findViewById(R.id.txtusername);


        RLcc.animate().translationY(-900).setDuration(2000).setStartDelay(0);


        btncuentacreada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insertar objInsertar = new Insertar();
                objInsertar.execute();
                try {
                    String resultado = objInsertar.get();
                    Toast.makeText(crear_cuenta.this, resultado, Toast.LENGTH_SHORT).show();// Obtén el resultado aquí
                    // Haz algo con el resultado, por ejemplo, muestra un mensaje en un TextView o Toast.
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public class Insertar extends AsyncTask <String,String,String>{
        String mensaje = "", Nombre, Apellido, Correo, UserName, password;
        boolean exito;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            Nombre = tetnombre.getText().toString();
            Apellido = tetapellido.getText().toString();
            Correo = tetcorreo.getText().toString();
            UserName = tetusername.getText().toString();
            password = tetpassword.getText().toString();
        }


        protected String doInBackground(String... strings){
            Log.i("a","Entro a la funcion");
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            if (con==null || Nombre.equals("") || Apellido.equals("") || Correo.equals("") || UserName.equals("") || password.equals("")){
                exito = false;
                mensaje = "No se puedo conectar o algun campo esta vacio";
            }else {
               // String comandoSQL = "INSERT INTO usuario VALUES (?,?,?,?)";
                String comandoSQL = "INSERT INTO `usuario`(`Nombre`, `Apellido`, `CorreoElectronico`, `UserName`, `password`) VALUES (?,?,?,?,?)";
                try {
                    PreparedStatement ps = con.prepareStatement(comandoSQL);
                    ps.setString(1,Nombre);
                    ps.setString(2,Apellido);
                    ps.setString(3,Correo);
                    ps.setString(4,UserName);
                    ps.setString(5,password);
                    int nfilas = ps.executeUpdate();
                    exito = true;
                    mensaje = nfilas + "fila(s) afectada(s)";
                    //Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
                    //Toast.makeText(crear_cuenta.this,"Exito en la insercion", Toast.LENGTH_SHORT).show();
                }catch (SQLException e){
                    mensaje = "Error en la insercion" + e.getMessage();
                }
            }

            return mensaje;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (exito){
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                tetnombre.setText("");
                tetapellido.setText("");
                tetcorreo.setText("");
                tetusername.setText("");
                tetpassword.setText("");
            }else{
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        }


    }

}