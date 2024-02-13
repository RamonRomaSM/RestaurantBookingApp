package com.example.booking;

public class Restaurante {
    private String nombre;
    private int logo;
    private String paginaWeb;

    private String descripcion;
    

    public Restaurante(String nombre, int logo, String paginaWeb, String descripcion) {
        this.logo = logo;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.descripcion=descripcion;
    }
   //TODO: este metodo es provisional para testeo, borrar despues
    public Restaurante(String nombre) {
        this.paginaWeb="https://github.com/RamonRomaSM";
        this.nombre = nombre;
        this.descripcion="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam accumsan faucibus massa sed vehicula. Vivamus vel tincidunt turpis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum lacinia neque non malesuada facilisis. Suspendisse eget eros ac elit luctus sagittis. Integer scelerisque congue rutrum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus efficitur lorem nec faucibus tincidunt. Nullam iaculis justo quis egestas pharetra. Mauris eu mollis tellus";
        this.logo=R.drawable.ic_launcher_foreground;
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
