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

public class RegistroActivity extends AppCompatActivity implements NotasInterface
{

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

            //llamado a la funcion limpiar los campos
            limpiarCampos();

            sMensaje =  "Registro completo";
            mensajes(sMensaje);
        }
    }

    //Método para consultar
    public void Buscar(View view){
        //instancia de la clase qeu hereda de SQLiteOpenHelper, llamando al constructor
        BaseDatos admin = new BaseDatos(this, "twk", null, 1);
        //intancia para poder escribir y consuiltar la base de datos
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String codigo = eCodigo.getText().toString().trim();
        String sQuery = "select nota, detalle from notas where id =" + codigo;

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    (sQuery, null);
               //solo accedo al primer y unico registro
            if(fila.moveToFirst()){
                eNota.setText(fila.getString(0));
                eDescripcion.setText(fila.getString(1));
            } else {
                String sMensaje = "No existe el registro";
                mensajes(sMensaje);
            }
            //siempre cerrar la conexion al realizar una consulta, existan datos o no
            BaseDeDatabase.close();

        } else {
            String sMensaje = "Debes introducir el código";
            mensajes(sMensaje);
        }
    }

    //imprementacion por Notas interface
    @Override
    public void guardarNotas(Float nota, String detalle) {
        //instancia de la clase
        //contexto, nombre bd, factory (null), version bd
        BaseDatos adminbd = new BaseDatos(this,"twk",null,1);

        //Poder escribir el la base de datos
        SQLiteDatabase db = adminbd.getWritableDatabase();

        //prueba de insercion directa
        String sQuery = "INSERT INTO notas VALUES("+ nota +", "+ detalle +")";
        db.execSQL(sQuery);

        //instancia de la clase que almacenara el contenido o variables
        ContentValues registrar = new ContentValues();
        registrar.put("nota",nota);
        registrar.put("detalle",detalle);

        //insercion con el contenedor
        //db.insert("notas",null,registrar);

        //utilizando el metodo de la clase Base datos
        adminbd.guardarNotas(nota,detalle);

        db.close();

    }

    @Override
    public Vector<String> consultarNotas(int iTotal) {
        BaseDatos adminbd = new BaseDatos(this,"twk",null,1);
        adminbd.consultarNotas(iTotal);
        return null;
    }

    public void Modificar(View view){

        String sMensaje= "";
        String sCodigo = eCodigo.getText().toString().trim();
        String sDescripcion = eDescripcion.getText().toString().trim();
        String sNota = eNota.getText().toString().trim();

        if(sCodigo.isEmpty() && sDescripcion.isEmpty() && sNota.isEmpty()){
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
            //modificar la información

            //convirtiendo String a Float
            Float fNota = Float.parseFloat(sNota);
            //llamado a la funcion, pasando parametros
            ModificarNota( sCodigo, fNota,  sDescripcion);
            //llamado a la funcion limpiar los campos
            limpiarCampos();

            sMensaje =  "Modificación completa";
            mensajes(sMensaje);
        }
    }

    public void ModificarNota(String sCodigo,Float fNota ,String sDetalle){
        BaseDatos admin = new BaseDatos(this, "twk", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        ContentValues contenedor = new ContentValues();
        contenedor.put("id",sCodigo);
        contenedor.put("nota",fNota);
        contenedor.put("detalle",sDetalle);

        String sQWhere = "id="+sCodigo;

        int resultado = BaseDeDatabase.update("notas",contenedor,sQWhere,null);
        //validar el resultado
        if(resultado ==1){
            String sMensaje = "La nota fue modificada correctamente";
            mensajes(sMensaje);
        }else{
            String sMensaje = "Error al realizar la modificación";
            mensajes(sMensaje);
        }

        BaseDeDatabase.close();
    }

    public void Eliminar(View view){

        String sCodigo = eCodigo.getText().toString().trim();
        if(sCodigo.isEmpty()) {
            String sMensaje = "Debe ingresar codigo";
            mensajes(sMensaje);
        }else{
            //llamado a la funcion  eliminar

            EliminarNota(sCodigo);
            limpiarCampos();

            String sMensaje =  "Eliminación completa";
            mensajes(sMensaje);
        }
    }

    private void EliminarNota(String sCodigo){
        BaseDatos admin = new BaseDatos(this, "twk", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String sQWhere = "id="+sCodigo;
        int resultado = BaseDeDatabase.delete("notas",sQWhere,null);

        //validar el resultado
        if(resultado ==1){
            String sMensaje = "La nota fue Eliminada correctamente";
            mensajes(sMensaje);
        }else{
            String sMensaje = "Error al eliminar la modificación";
            mensajes(sMensaje);
        }
        BaseDeDatabase.close();
    }

    public void mensajes(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void limpiarCampos(){
        eCodigo.setText("");
        eNota.setText("");
        eDescripcion.setText("");
    }

}
