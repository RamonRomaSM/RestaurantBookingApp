package com.example.app;


import android.content.Context;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ContenedorTiposDeRestaurante extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contenedor_tipos_de_restaurante, container, false);
    }




    class AdapterTipoComidas extends RecyclerView.Adapter<AdapterTipoComidas.ViewHolderTipoComidas> {
        //aqui han de estar todos los datos
        List<TipoComida> datos;
        Context context;

        public AdapterTipoComidas(List<TipoComida> datos, Context context) {
            this.datos = datos;
            this.context=context;
        }

        @NonNull
        @Override
        public AdapterTipoComidas.ViewHolderTipoComidas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new ViewHolderTipoComidas(LayoutInflater.from(context).inflate(R.layout.tipo_comida_view,parent,false));//Aun no entiendo bien los inflaters
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterTipoComidas.ViewHolderTipoComidas holder, int position) {
            holder.nombre.setText(datos.get(position).getNombre());
            holder.fotoComida.setImageResource(datos.get(position).getImagen());
        }

        @Override
        public int getItemCount() {
            //este metodo retorna el numero de elementos
            return datos.size();
        }




        public class ViewHolderTipoComidas extends RecyclerView.ViewHolder {
                //previamente he creado un view para mi tipos de comida en la carpeta de layouts
                // solo se definen elementos unicos, si todos tuvieran por ejemplo un marco este no se definiria qui
            ImageView fotoComida;
            TextView nombre;


            public ViewHolderTipoComidas(@NonNull View itemView) {
                super(itemView);
                fotoComida=itemView.findViewById(R.id.imagenTipoComida);
                nombre=itemView.findViewById(R.id.nombreTipoComida);


            }
        }
    }

}