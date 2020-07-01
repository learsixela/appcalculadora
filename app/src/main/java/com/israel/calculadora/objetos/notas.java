package com.israel.calculadora.objetos;

public class notas {
        String sNota = "";
        String sDetalle= "";


    public String getsNota() {
        return sNota;
    }

    public void setsNota(String sNota) {
        this.sNota = sNota;
    }

    public String getsDetalle() {
        return sDetalle;
    }

    public void setsDetalle(String sDetalle) {
        this.sDetalle = sDetalle;
    }

    public notas(String sNota, String sDetalle) {
        this.sNota = sNota;
        this.sDetalle = sDetalle;
    }
    public notas() {

    }
}
