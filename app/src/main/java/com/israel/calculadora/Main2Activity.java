package com.israel.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText eUser, ePassword;
    private Button btnIngresar;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        eUser = findViewById(R.id.txtUser);
        ePassword = findViewById(R.id.txtPassword);
        btnIngresar = findViewById(R.id.btnLogin);
        btnRegistro = findViewById(R.id.btnRegistro);
    }

    public void login(View viex){
        String sUser = eUser.getText().toString();
        String sPass = ePassword.getText().toString();
        String sMensaje= "";

        //validar ingreso datos
        if(sUser.isEmpty() && sPass.isEmpty()){ // V^V=V
            sMensaje = String.valueOf(R.string.string_msg_datos);
            mensajes(sMensaje);
        }else if(sUser.isEmpty()){
            Toast.makeText(this, R.string.string_msg_user, Toast.LENGTH_SHORT).show();
        }else if(sPass.isEmpty()){
            Toast.makeText(this, R.string.string_msg_pass, Toast.LENGTH_SHORT).show();
        }else{
            //validar datos correctos
            if(!sUser.toLowerCase().equals(R.string.string_usuario)){
                Toast.makeText(this, "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
            }else if(!sPass.equals(R.string.string_password)){
                Toast.makeText(this, "Password Incorrecto", Toast.LENGTH_SHORT).show();
            }else{
                sMensaje = "Login correcto";
                //Llamando a la función , pasando un parametro
                mensajes(sMensaje);
                // https://codeshare.io/218e1j
                Intent pantalla2 = new Intent(this, MainActivity1.class);
                startActivity(pantalla2);
            }
        }

    }

    //recibir y mostrar todos los mensajes
    public void mensajes(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void registro(View vista){
        Intent pntRegistro = new Intent(this, RegistroActivity.class);
        startActivity(pntRegistro);
    }
}
