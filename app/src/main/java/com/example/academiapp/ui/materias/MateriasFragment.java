package com.example.academiapp.ui.materias;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.academiapp.Conexion;
import com.example.academiapp.R;
import com.example.academiapp.ui.profesores.ProfesoresFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class MateriasFragment extends Fragment {

    EditText txtMateria, txtSalon, txtProfesorID;
    Button Guardar;
    private View formularioView;
    private boolean formularioVisible = false; // Variable para rastrear la visibilidad del formulario

    public static MateriasFragment newInstance() {
        return new MateriasFragment();
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materias, container, false);

        formularioView = view.findViewById(R.id.formulario);
        txtMateria = view.findViewById(R.id.txtMateria);
        txtSalon = view.findViewById(R.id.txtSalon);
        txtProfesorID = view.findViewById(R.id.txtProfesorID);
        Guardar = view.findViewById(R.id.Guardar);


        FloatingActionButton fab = view.findViewById(R.id.fab3);
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

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MateriasFragment.insertar objinsertar = new MateriasFragment.insertar();
                objinsertar.execute();
                try {
                    String resultado = objinsertar.get();
                    Toast.makeText(getActivity().getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();// Obtén el resultado aquí
                    // Haz algo con el resultado, por ejemplo, muestra un mensaje en un TextView o Toast.
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

    public class insertar extends AsyncTask<String, String, String> {
        String mensaje = "", NombreMateria, Salon, ProfesorID;
        boolean exito;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            NombreMateria = txtMateria.getText().toString();
            Salon = txtSalon.getText().toString();
            ProfesorID = txtProfesorID.getText().toString();
        }


        protected String doInBackground(String... strings) {
            Log.i("a", "Entro a la funcion");
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            if (con == null || NombreMateria.equals("") || Salon.equals("") || ProfesorID.equals("")) {
                exito = false;
                mensaje = "No se puedo conectar o algun campo esta vacio";
            } else {
                // String comandoSQL = "INSERT INTO usuario VALUES (?,?,?,?)";
                String comandoSQL = "INSERT INTO `materias`(`NombreMateria`, `Salon`, `ProfesorID`) VALUES (?,?,?)";
                try {
                    PreparedStatement ps = con.prepareStatement(comandoSQL);
                    ps.setString(1, NombreMateria);
                    ps.setString(2, Salon);
                    ps.setString(3, ProfesorID);
                    int nfilas = ps.executeUpdate();
                    exito = true;
                    mensaje = nfilas + "fila(s) afectada(s)";
                    //Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
                    //Toast.makeText(crear_cuenta.this,"Exito en la insercion", Toast.LENGTH_SHORT).show();
                } catch (SQLException e) {
                    mensaje = "Error en la insercion" + e.getMessage();
                }
            }

            return mensaje;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (exito) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                txtMateria.setText("");
                txtSalon.setText("");
                txtProfesorID.setText("");
            } else {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        }

    }

}



