package pe.cibertec.movierxjava.models;

import com.google.gson.annotations.SerializedName;

public class Pelicula {

    @SerializedName("title")
    private String titulo;

    @SerializedName("overview")
    private String descripcion;

    public Pelicula(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
