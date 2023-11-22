package com.example.academiapp.ui.profesores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.academiapp.R;
import com.example.academiapp.conexion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesoresFragment extends Fragment {

    Button GuardarP;
    EditText txtnombre, txtapellido, txtphone, txtcorreo, txtHA;
    private View formularioView;
    private boolean formularioVisible =false; // Variable para rastrear la visibilidad del formulario
    public static ProfesoresFragment newInstance() {
        return new ProfesoresFragment();
    }


    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profesores, container, false);

        // Asigna el ID del contenedor del formulario en el XML
        formularioView = view.findViewById(R.id.formularioContainer);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muestra u oculta el formulario al hacer clic en el FAB
                if (formularioVisible) {
                    formularioView.setVisibility(View.GONE);
                    formularioVisible = false;
                } else {
                    formularioView.setVisibility(View.VISIBLE);
                    formularioVisible = true;
                }
            }
        });

        return view;
    }

    // Otros métodos del fragmento y lógica adicional...

}
