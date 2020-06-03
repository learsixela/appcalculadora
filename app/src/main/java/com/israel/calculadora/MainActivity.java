package com.israel.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText resultado;
    private EditText num1, num2;

    private EditText eUser, ePassword;
    private Button btnIngresar;

    //acumuladores
    private Integer intAcumulador1,intAcumulador2;
    private String sConcatenarString;
    private Boolean accionSumar = false;
    private Boolean accionRestar = false;
    private Boolean accionMultiplicar = false;
    private Boolean accionDividir = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        num1 = findViewById(R.id.numero1);
        num2 = findViewById(R.id.numero2);
        resultado= findViewById(R.id.txtResultado);

        eUser = findViewById(R.id.txtUser);
        ePassword = findViewById(R.id.txtPassword);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_LONG).show();
        // La actividad está punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad est· a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora est· "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad est· a punto de ser destruida.
    }

    public void msgEmergente(View view){

        int iNumero1 = 7, iNumero2 = 5, iNumero3= 6, iPromedio=0;
        Float fPromedio = 0F;
        Double dPromedio = 0D;
        Long lPromedio = 0L;

        iPromedio = (iNumero1+iNumero2+iNumero3)/3;
        fPromedio = (iNumero1+iNumero2+iNumero3)/3F;
        dPromedio = (iNumero1+iNumero2+iNumero3)/3D;
        lPromedio = (iNumero1+iNumero2+iNumero3)/3L;

        if(iPromedio >= 6){
            Toast.makeText(this, "Sobre 6", Toast.LENGTH_SHORT).show();
        }else if(iPromedio >= 5 && iPromedio < 6 ){
            Toast.makeText(this, "Rango 5", Toast.LENGTH_SHORT).show();
        }else if(iPromedio >= 4 && iPromedio < 5 ){
            Toast.makeText(this, "Rango 4", Toast.LENGTH_SHORT).show();
        } else if (iPromedio < 4){
            Toast.makeText(this, "Reprobado", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcularSuma(View view){

        int iNum1 = Integer.parseInt(num1.getText().toString());
        int iNum2 = Integer.parseInt(num2.getText().toString());

        int iSuma= iNum1 + iNum2;
        String texto = iSuma+"";//String.valueOf(iSuma);

        //Toast.makeText(this, "El resultado es: "+texto, Toast.LENGTH_SHORT).show();
        String sMensaje= "El resultado es: "+texto;
        //Llamando a la función , pasando un parametro
         mensajes(sMensaje);


        //txtResultado
        resultado.setText(texto);
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
