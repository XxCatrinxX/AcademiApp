package com.example.academiapp.ui.tareas;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academiapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.Contract;

public class TareasFragment extends Fragment {

    private View formularioView;
    private boolean formularioVisible =false; // Variable para rastrear la visibilidad del formulario

    public static TareasFragment newInstance() {
        return new TareasFragment();
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tareas, container, false);

        formularioView = view.findViewById(R.id.formulario);

        FloatingActionButton fab = view.findViewById(R.id.fab5);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formularioVisible){
                    formularioView.setVisibility(View.GONE);
                    formularioVisible = false;
                }else {
                    formularioView.setVisibility(View.VISIBLE);
                    formularioVisible = true;
                }
            }
        });

        return view;

    }


}