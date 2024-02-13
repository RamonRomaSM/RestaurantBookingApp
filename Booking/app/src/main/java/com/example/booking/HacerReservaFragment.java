package com.example.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;


public class HacerReservaFragment extends Fragment {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hacer_reserva, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO: aqui poner el contenido de los spinners, hacer metodo reservar
        Button volver=getView().findViewById(R.id.volver);
        volver.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });


        List<String> list = new ArrayList<String>();


        Spinner horainicial=getView().findViewById(R.id.horaInicial);
        Spinner horafinal=getView().findViewById(R.id.horaFinal);
        for(int i=12;i<22;i++){
            for(int j=0;i<4;j++){
                list.add(i+":"+(15*j));
            }

        }
        ArrayAdapter<String> adp1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        horafinal.setAdapter(adp1);


    }
}