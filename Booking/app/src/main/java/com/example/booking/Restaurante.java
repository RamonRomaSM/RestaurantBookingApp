package com.example.booking;

public class Restaurante {
    private String nombre;
    private int logo;
    private String paginaWeb;

    private String descripcion;

    public Restaurante(String nombre, String paginaWeb, String descripcion) {
        this.logo=R.drawable.ic_launcher_foreground;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.descripcion=descripcion;
    }
    public Restaurante(String nombre, int logo, String paginaWeb, String descripcion) {
        this.logo = logo;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.descripcion=descripcion;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
