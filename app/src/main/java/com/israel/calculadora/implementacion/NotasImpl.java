package com.israel.calculadora.implementacion;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.israel.calculadora.Interface.NotasInterface;
import com.israel.calculadora.db.BaseDatos;

import java.util.Vector;

public class NotasImpl implements NotasInterface {
    //crear contexto
    private Context context;
    //variable estatica
    private static String NOTAS = "notas";

    //constructor
    public NotasImpl(Context context) {
        this.context = context;
    }

    @Override
    public void guardarNotas(Float nota, String detalle) {
        //todas las validaciones del negocio
        if (nota >= 1.0){
            //guardar nota PREFERENCIAS
            SharedPreferences preferencias = context.getSharedPreferences(NOTAS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= preferencias.edit();
            editor.putString("notas", nota +" "+detalle);
            editor.commit();

        }else{
            //Toast
        }
        //instancia de la clase
        BaseDatos adminbd = new BaseDatos(context,"twk",null,1);
        SQLiteDatabase sqldb = adminbd.getWritableDatabase();



    }

    @Override
    public Vector<String> consultarNotas(int iTotal) {
        return null;
    }
}
