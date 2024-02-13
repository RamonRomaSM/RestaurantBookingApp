package com.example.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class RestauranteUnicoFragment extends Fragment {


    String nombre;
    Restaurante restaurante;

    public RestauranteUnicoFragment(Restaurante act) {
        restaurante=act;

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurante_unico, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView logo=getView().findViewById(R.id.logo);
        TextView nombre=getView().findViewById(R.id.nombre);


        logo.setImageResource(restaurante.getLogo());
        nombre.setText(restaurante.getNombre());

        TextView texto=getView().findViewById(R.id.descripcion);
        texto.setText(restaurante.getDescripcion());


        ImageView imagen1=getView().findViewById(R.id.sampleRestaurante1);
        imagen1.setImageResource(R.drawable.restauranteimageasset);

        ImageView imagen2=getView().findViewById(R.id.sampleRestaurante2);
        imagen2.setImageResource(R.drawable.comidaargentina);

        ImageView imagen3=getView().findViewById(R.id.sampleRestaurante3);
        imagen3.setImageResource(R.drawable.restauranteimageasset);

        ImageView imagen4=getView().findViewById(R.id.sampleRestaurante4);
        imagen4.setImageResource(R.drawable.restauranteimageasset);


        Button iraweb=getView().findViewById(R.id.iraweb);
        iraweb.setOnClickListener(v -> {
            PaginaWebFragment frag=new PaginaWebFragment(restaurante.getPaginaWeb());
            ((MainActivity) getActivity()).hacerTransaccion(frag);
        });

        Button reservar=getView().findViewById(R.id.reservar);
        reservar.setOnClickListener(v -> {
            HacerReservaFragment frag= new HacerReservaFragment();
            frag.setAct(restaurante);
            ((MainActivity)getActivity()).hacerTransaccion(frag);
        });


    }



}