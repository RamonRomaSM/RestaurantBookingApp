package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.channels.Channel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final DatabaseReference dbref= FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRestaurantes("Cocina Venezolana"); //te vas a reir con esto, peor tiene una explicacion
                                                    /*
                                                    * pero basicamente, la primera vez que llamaba a este metodo, no me devolvia nada, salia y entrava del fragment y ya funcionaba
                                                    * buscando por internet habia gente con el mismo problema, pero sin soluciones definitivas, bug de firebase supongo
                                                    *
                                                    * lo mas parecido a una respuesta que encontre fue
                                                    * https://stackoverflow.com/questions/56182213/unity-android-app-crashes-when-run-first-time-but-from-second-time-it-works-fine
                                                    *
                                                    * para no liarla mas con las librerias mejor dejo este apaño aqui
                                                    *
                                                    *
                                                    * puedes borrar esta linea de codigo y ver el bug
                                                    * */
    }
     public void hacerTransaccion(Fragment frag){
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,frag).addToBackStack(null).commit();
    }

    public static DatabaseReference getDbref() {
        return dbref;
    }
    public ArrayList<Restaurante> getRestaurantes(String nacionalidad) {
        DatabaseReference dbref= MainActivity.getDbref();
        ArrayList<Restaurante> resp = new ArrayList<>();

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot restaurantes : snapshot.child("restaurantes").child(nacionalidad).getChildren()){


                    String nombre=restaurantes.child("nombre").getValue(String.class);
                    String web=restaurantes.child("paginaWeb").getValue(String.class);
                    String descripcion=restaurantes.child("descripcion").getValue(String.class);
                    Restaurante a = new Restaurante(nombre,web,descripcion);
                    resp.add(a);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w( "Failed to read value.", error.toException());
            }
        });

        return resp;
    }
}