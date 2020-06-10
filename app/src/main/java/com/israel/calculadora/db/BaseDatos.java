package com.israel.calculadora.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Vector;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos la(s) tabla(s)
        String sQuery= "CREATE TABLE notas (id INTEGER PRIMARY KEY AUTOINCREMENT, nota FLOAT, detalle TEXT)";
        db.execSQL(sQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Metodos de inserción

    public void guardarNotas(Float nota ,String detalle){
        SQLiteDatabase db = getWritableDatabase();

        String sQuery = "INSERT INTO notas VALUES("+ nota +", "+ detalle +")";
        db.execSQL(sQuery);
        db.close();
    }

    //Metodos de Consultas

    public Vector<String> consultarNotas(int iTotal){
        //almacena el resultado de la query
        Vector<String> resultado = new Vector<String>();

        //crear variable para ejecutar query
        SQLiteDatabase db = getReadableDatabase();
        String sQuery = "SELECT nota, detalle FROM notas ORDER BY nota desc LIMIT " +iTotal;
        //almacenamos el resultado de la query
        Cursor cursor = db.rawQuery(sQuery,null);
        //[{7,"nota 1"},{4, "nota 2"}]
        //recorrer el resultado de la query
        while(cursor.moveToNext()){
            //agregar al Vector
            resultado.add(cursor.getFloat(0)+ ", "+cursor.getString(1));
        }

        //[{ "7 nota 1"},{"4 nota 2"}]
        //cerramos el cursor y la conexion
        cursor.close();
        db.close();

        //retornando los resultados
        return resultado;
    }

}
