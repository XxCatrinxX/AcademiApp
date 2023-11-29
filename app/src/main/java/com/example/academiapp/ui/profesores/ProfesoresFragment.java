package com.example.academiapp.ui.profesores;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.academiapp.Conexion;
import com.example.academiapp.R;
import com.example.academiapp.crear_cuenta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class ProfesoresFragment extends Fragment {

    Button GuardarP;
    EditText txtnombre, txtapellido, txtphone, txtcorreo, txtHA, txtmateria;
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
        txtnombre = view.findViewById(R.id.txtnombre);
        txtapellido = view.findViewById(R.id.txtapellido);
        txtphone = view.findViewById(R.id.txtphone);
        txtcorreo = view.findViewById(R.id.txtcorreo);
        txtmateria = view.findViewById(R.id.txtmateria);
        txtHA = view.findViewById(R.id.txtHA);
        GuardarP = view.findViewById(R.id.GuardarP);

        FloatingActionButton fab = view.findViewById(R.id.fab2);
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

        GuardarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar objinsertar = new insertar();
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

    public class insertar extends AsyncTask<String,String,String> {
        String mensaje = "", Nombre, Apellido, Correo, Materia, HoraAtencion, Telefono;
        boolean exito;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            Nombre = txtnombre.getText().toString();
            Apellido = txtapellido.getText().toString();
            Correo = txtcorreo.getText().toString();
            Materia = txtmateria.getText().toString();
            HoraAtencion = txtHA.getText().toString();
            Telefono = txtphone.getText().toString();
        }


        protected String doInBackground(String... strings){
            Log.i("a","Entro a la funcion");
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            if (con==null || Nombre.equals("") || Apellido.equals("") || Correo.equals("") || Materia.equals("") || Telefono.equals("") || HoraAtencion.equals("")){
                exito = false;
                mensaje = "No se puedo conectar o algun campo esta vacio";
            }else {
                // String comandoSQL = "INSERT INTO usuario VALUES (?,?,?,?)";
                String comandoSQL = "INSERT INTO `profesores`(`Nombre`, `Apellido`, `Materia`, `Telefono`, `Correo`, `HoraDeAtencion` ) VALUES (?,?,?,?,?,?)";
             try {
                    PreparedStatement ps = con.prepareStatement(comandoSQL);
                    ps.setString(1,Nombre);
                    ps.setString(2,Apellido);
                    ps.setString(3,Materia);
                    ps.setString(4,Telefono);
                    ps.setString(5,Correo);
                    ps.setString(6,HoraAtencion);
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


    }


    // Otros métodos del fragmento y lógica adicional...

}
