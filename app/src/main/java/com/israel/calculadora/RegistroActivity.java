package com.israel.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.israel.calculadora.Interface.NotasInterface;
import com.israel.calculadora.db.BaseDatos;

import java.util.Vector;

public class RegistroActivity extends AppCompatActivity implements NotasInterface {

    private EditText eNota, eDescripcion, eCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eCodigo = (EditText)findViewById(R.id.txt_codigo);
        eDescripcion = (EditText)findViewById(R.id.txt_descripcion);
        eNota = (EditText)findViewById(R.id.txt_nota);

    }

    public void Registrar (View vista){
        String sMensaje= "";
         String sCodigo = eCodigo.getText().toString().trim();
         String sDescripcion = eDescripcion.getText().toString().trim();
         String sNota = eNota.getText().toString().trim();

//split(), replaceAll(), trim()
        if(sCodigo.isEmpty() && sDescripcion.isEmpty() && sNota.isEmpty()){ // V^V=V
            sMensaje =  "Debe ingresar parametros";
            mensajes(sMensaje);
        }else if(sCodigo.isEmpty()){
            sMensaje =  "Debe ingresar codigo";
            mensajes(sMensaje);
        }else if(sDescripcion.isEmpty()){
            sMensaje =  "Debe ingresar Descripcion";
            mensajes(sMensaje);
        }else if(sNota.isEmpty()){
            sMensaje =  "Debe ingresar Nota";
            mensajes(sMensaje);
        }else{
            //almacenar la información

            //convirtiendo String a Float
            Float fNota = Float.parseFloat(sNota);
            //llamado a la funcion, pasando parametros
            guardarNotas( fNota,  sDescripcion);

            sMensaje =  "Registro completo";
            mensajes(sMensaje);
        }
    }

    public void mensajes(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }


    //Método para consultar
    public void Buscar(View view){
        BaseDatos admin = new BaseDatos(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String codigo = eCodigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select descripcion from articulos where codigo =" + codigo, null);

            if(fila.moveToFirst()){
                eDescripcion.setText(fila.getString(0));
                eNota.setText(fila.getString(1));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"No existe el registro", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "Debes introducir el código", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void guardarNotas(Float nota, String detalle) {
        //instancia de la clase
        //contexto, nombre bd, factory (null), version bd
        BaseDatos adminbd = new BaseDatos(this,"twk",null,1);

        //Poder escribir el la base de datos
        SQLiteDatabase db = adminbd.getWritableDatabase();

        //instancia de la clase que almacenara el contenido o variables
        ContentValues registrar = new ContentValues();
        registrar.put("nota",nota);
        registrar.put("detalle",detalle);

        //prueba de insercion directa
        String sQuery = "INSERT INTO notas VALUES("+ nota +", "+ detalle +")";
        db.execSQL(sQuery);
        //db.close();

        //insercion con el contenedor
        db.insert("notas",null,registrar);



    }

    @Override
    public Vector<String> consultarNotas(int iTotal) {
        return null;
    }
}
