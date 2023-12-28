package com.example.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RestauranteUnicoFragment extends Fragment {


    String nombre;
    Restaurante restaurante;

    public RestauranteUnicoFragment(String nombre) {
        this.nombre = nombre;

    }


    public Restaurante getDatos(String nombre) { //TODO: este metodo hace una query que recoge los datos WHERE nombreRrestaurante=nombre
        Restaurante resp = new Restaurante(nombre,R.drawable.ic_launcher_foreground,"www.PaginaWeb.com");
        return resp;
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
        restaurante=getDatos(nombre);
        ImageView logo=getView().findViewById(R.id.logo);
        TextView nombre=getView().findViewById(R.id.nombre);
        TextView pagina=getView().findViewById(R.id.paginaWeb);
        logo.setImageResource(restaurante.getImagen());
        nombre.setText(restaurante.getNombre());
        pagina.setText(restaurante.getPaginaWeb());



    }
}