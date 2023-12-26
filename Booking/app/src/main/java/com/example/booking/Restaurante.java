package com.example.booking;

public class Restaurante {
    private String nombre;
    private int imagen;
    private String paginaWeb;


    public Restaurante(String nombre, int imagen, String paginaWeb) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
    }
   //TODO: este metodo es provisional para testeo, borrar despues
    public Restaurante(String nombre) {

        this.nombre = nombre;

    }
    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
}
