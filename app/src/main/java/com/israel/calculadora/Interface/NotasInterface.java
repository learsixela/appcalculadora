package com.israel.calculadora.Interface;

import java.util.Vector;

public interface NotasInterface {

    public void guardarNotas(Float nota ,String detalle);
    public Vector<String> consultarNotas(int iTotal);
}
