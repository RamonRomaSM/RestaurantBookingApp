package com.example.booking;

import androidx.fragment.app.Fragment;

public class TipoComida {
    private String nombre;
    private int imagen;





    public TipoComida(String nombre,int imagen) {
        this.nombre = nombre;
        this.imagen=imagen;

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
