package com.example.booking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {

    FragmentManager fm; //TODO: este fragment manager viee de la main act a traves del constructor
                    //TODO: hay que pasarleso al viewHolder por parametro

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tipos_comida, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO: aqui declaro el rcyc y le paso el dapter
        RecyclerView tiposDeComida=getView().findViewById(R.id.tiposDeComidaRecycler);
        tiposDeComida.setLayoutManager(new GridLayoutManager(getContext(),2));
        tiposDeComida.setAdapter(new AdapterTipoComidas(setTiposDeComida(),getContext()));


    }
    public List<TipoComida> setTiposDeComida() {

        ArrayList<TipoComida> resp = new ArrayList<>();
        TipoComida arg = new TipoComida("Comida Argentina", R.drawable.comidaargentina);
        resp.add(arg);
        TipoComida ch = new TipoComida("Comida China", R.drawable.comidachina);
        resp.add(ch);
        TipoComida kr = new TipoComida("Comida Coreana", R.drawable.comidacorea);
        resp.add(kr);
        TipoComida in = new TipoComida("Comida India", R.drawable.comidaindia);
        resp.add(in);
        TipoComida jp = new TipoComida("Comida Japonesa", R.drawable.comidajapon);
        resp.add(jp);
        TipoComida pe = new TipoComida("Comida Peruana", R.drawable.comidaperu);
        resp.add(pe);
        TipoComida sp = new TipoComida("Comida Española", R.drawable.comidaspain);
        resp.add(sp);
        TipoComida ve = new TipoComida("Comida Venezolana", R.drawable.comidavenezuela);
        resp.add(ve);


        return resp;
    }



    static class AdapterTipoComidas extends RecyclerView.Adapter<AdapterTipoComidas.ViewHolderTipoComidas> {
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

            RestaurantesFragment restaurantes;



            public ViewHolderTipoComidas(@NonNull View itemView) {
                super(itemView);
                fotoComida=itemView.findViewById(R.id.imagenTipoComida);
                nombre=itemView.findViewById(R.id.nombreTipoComida);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        }
    }


}