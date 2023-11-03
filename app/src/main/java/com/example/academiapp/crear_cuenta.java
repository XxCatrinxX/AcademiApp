package com.example.academiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.graphics.Color;

public class crear_cuenta extends AppCompatActivity {

    CardView RLcc;
    Button button;
    private boolean isButtonColorChanged = false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        RLcc = findViewById(R.id.RLcc);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonColorChanged) {
                    // Cambiar el color a su estado original
                    button.setBackgroundColor(Color.parseColor("#b944ea")); // Puedes cambiar el color a tu gusto
                    isButtonColorChanged = false;
                } else {
                    // Cambiar el color a otro color cuando hagas clic
                    button.setBackgroundColor(Color.parseColor("#FF5733")); // Puedes cambiar el color a tu gusto
                    isButtonColorChanged = true;
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
                }
            }
        });

        RLcc.animate().translationY(-1800).setDuration(2000).setStartDelay(0);

    }


}