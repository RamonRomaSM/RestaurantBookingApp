package com.example.booking;

import androidx.fragment.app.Fragment;

public class TipoComida {
    private String nombre;
    private int imagen;


    private RestaurantesFragment restaurantes;


    public TipoComida(String nombre,int imagen,RestaurantesFragment fragment) {
        this.nombre = nombre;
        this.imagen=imagen;
        restaurantes=fragment;
    }
    public Fragment getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(RestaurantesFragment restaurantes) {
        this.restaurantes = restaurantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
