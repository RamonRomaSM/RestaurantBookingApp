package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ContenedorTiposDeRestaurante extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contenedor_tipos_de_restaurante, container, false);
    }




    class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {
        //aqui han de estar todos los datos

        @NonNull
        @Override
        public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //retorna
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterDatos.ViewHolderDatos holder, int position) {

        }

        @Override
        public int getItemCount() {
            //este metodo retorna el numero de elementos
            return 0;
        }




        public class ViewHolderDatos extends RecyclerView.ViewHolder {
                //ESTO ES EL CONTENIDO DE CADA ELEMENTO QUE SE ALMACENA, POR EJEMPLO PDEMOS QUERER DEFINIR QUE UN ELEMENTO SE COMPONE DE UNA FOTO Y UN TEXTO
                // solo se definen elementos unicos, si todos tuvieran por ejemplo un marco este no se definiria qui

            public ViewHolderDatos(@NonNull View itemView) {
                super(itemView);




            }
        }
    }

}