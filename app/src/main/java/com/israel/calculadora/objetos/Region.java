package com.israel.calculadora.objetos;

public class Region {
    int id;
    String nombre;
    String contagiados;

    public String getContagiados() {
        return contagiados;
    }

    public void setContagiados(String contagiados) {
        this.contagiados = contagiados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
