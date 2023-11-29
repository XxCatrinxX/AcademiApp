package com.example.academiapp.ui.calendario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.academiapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CalendarioFragment extends Fragment {

    private View BotonView;
    private boolean BotonVisible =false; // Variable para rastrear la visibilidad del boton


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calendario, container, false);

        BotonView = view.findViewById(R.id.fab7);


        FloatingActionButton fab = view.findViewById(R.id.fab6);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muestra u oculta el formulario al hacer clic en el FAB
                if (BotonVisible) {
                    BotonView.setVisibility(View.GONE);
                    BotonVisible = false;
                } else {
                    BotonView.setVisibility(View.VISIBLE);
                    BotonVisible = true;
                }
            }
        });

        return view;


    }
}