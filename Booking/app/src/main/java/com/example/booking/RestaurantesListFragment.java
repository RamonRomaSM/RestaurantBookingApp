package com.example.booking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RestaurantesListFragment extends Fragment {
    List<Restaurante>datos;

    public RestaurantesListFragment(List<Restaurante> datos) {
        this.datos = datos;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurantes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recycler=getView().findViewById(R.id.restaurantesRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new AdapterRestaurantes(datos,getContext()));
    }

    public class AdapterRestaurantes extends RecyclerView.Adapter<AdapterRestaurantes.RestauranteViewHolder>{
        List<Restaurante>datos;
        Context context;

        public AdapterRestaurantes(List<Restaurante> datos,Context context) {
            this.datos = datos;
            this.context=context;
        }

        @NonNull
        @Override
        public RestauranteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RestauranteViewHolder(LayoutInflater.from(context).inflate(R.layout.restaurante_view,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull RestauranteViewHolder holder, int position) {
            holder.nombre.setText(datos.get(position).getNombre());

            //TODO: tambien cambiar la imagen, por ahora no lo hago porque no tengo imagenes
            holder.logo.setImageResource(R.drawable.ic_launcher_foreground);
        }

        @Override
        public int getItemCount() {
            return datos.size();
        }

        public class RestauranteViewHolder extends RecyclerView.ViewHolder{
            TextView nombre;
            ImageView logo;
            public RestauranteViewHolder(@NonNull View itemView) {
                super(itemView);
                nombre=itemView.findViewById(R.id.nombreRestaurante);
                logo=itemView.findViewById(R.id.imagenRestaurante);
                itemView.setOnClickListener(v -> {

                    RestauranteUnicoFragment frag=new RestauranteUnicoFragment(nombre.getText().toString());//TODO: aqui hay que hacer una llamada a la bdd para cojer os datos de este restaurante en especifico
                    ((MainActivity) getActivity()).hacerTransaccion(frag);

                });
            }
        }


    }
}