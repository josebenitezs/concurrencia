
package com.iudigital.concurrency.domain;


public class Producto {
    
    /**
     * Atributo que determina el nombre del producto
     */
    
    private String nombre;
    
    
    /**
     * Atributo que determina el precio del producto
     */
    
    private float precio;
    
    
    /**
     * Atributo que determina la cantidad del producto
     */
    
    private int cantidad; 

    public Producto(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + precio + cantidad;
    }
    
    
    
    
}
