package com.example.tecsup.alerts;

public class Producto {
    public String nombre;
    public Double precio;
    public String imagen;

    public Producto(String nombre, Double precio, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
