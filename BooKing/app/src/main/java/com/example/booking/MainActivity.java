package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentContainerView contenedor=findViewById(R.id.contenedor);
        TiposComidaFragment frag=new TiposComidaFragment();
        FragmentManager fm =getSupportFragmentManager();


        fm.beginTransaction().replace(contenedor.getId(),frag).commit();
    }

}