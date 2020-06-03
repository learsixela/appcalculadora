package com.israel.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private Button btnRegistro;
    private EditText eNombre, eApellido, eCorreo, ePassword;
    private RadioButton rbProfesor, rbAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eNombre = findViewById(R.id.eNombre);
        eApellido = findViewById(R.id.eApellido);
        eCorreo = findViewById(R.id.eCorreo);
        ePassword = findViewById(R.id.ePassword);
        rbProfesor = findViewById(R.id.rbProfesor);
        rbAlumno = findViewById(R.id.rbAlumno);


    }

    public void registrar (View vista){
        String sMensaje= "";
         String sNombre = eNombre.getText().toString();
         String sApellido = eApellido.getText().toString();
         String sCorreo = eCorreo.getText().toString();
         String sPassword = ePassword.getText().toString();


        if(sNombre.isEmpty() && sApellido.isEmpty() && sCorreo.isEmpty() && sPassword.isEmpty()){ // V^V=V
            if(!rbAlumno.isChecked() && !rbProfesor.isChecked() ){
                sMensaje =  "Debe seleccionar perfil";
                mensajes(sMensaje);
            }else {
                sMensaje = String.valueOf(R.string.string_msg_datos);
                mensajes(sMensaje);
            }
        }else if(sNombre.isEmpty()){
            sMensaje =  "Debe ingresar nombre";
            mensajes(sMensaje);
        }else if(sApellido.isEmpty()){
            sMensaje =  "Debe ingresar Apellido";
            mensajes(sMensaje);
        }else if(sCorreo.isEmpty()){
            sMensaje =  "Debe ingresar Correo";
            mensajes(sMensaje);
        }else if(sPassword.isEmpty()){
            sMensaje =  "Debe ingresar Pasword";
            mensajes(sMensaje);
        }else{
            //almacenar la información
            sMensaje =  "Registro completo";
            mensajes(sMensaje);

        }

    }

    public void mensajes(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
