package com.example.academiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.graphics.Color;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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
        tetapellido = findViewById(R.id.tetnombre);
        tetcorreo = findViewById(R.id.tetnombre);
        tetusername = findViewById(R.id.tetnombre);
        tetpassword = findViewById(R.id.tetpassword);
        txtnombre = findViewById(R.id.txtnombre);
        txtapellido = findViewById(R.id.txtapellido);
        txtcorreo = findViewById(R.id.txtcorreo);
        txtusername = findViewById(R.id.txtusername);


        RLcc.animate().translationY(-900).setDuration(2000).setStartDelay(0);

        tetcorreo.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                tetusername.requestFocus();
                return true;
            }
            return false;
        });



    }

    public void cuentacreada(View view){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

}