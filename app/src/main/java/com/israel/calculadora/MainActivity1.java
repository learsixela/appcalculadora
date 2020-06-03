package com.israel.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {

    private EditText resultado;

    //botones
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    // botones de accion
    private Button btnMas;
    private Button btnResultado;
    private Button btnResta;
    private Button btnDivision;
    private Button btnMultiplicacion;

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

        Button btn = (Button) findViewById(R.id.btn0);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        //botones
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnMas = findViewById(R.id.btnMas);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);
        btnResultado = findViewById(R.id.btnResultado);

        resultado = findViewById(R.id.txtResultado);
    }

    public void mostrarNumero(View view){
        int opcion = view.getId();
        String captura = resultado.getText().toString();
        if(accionSumar || accionRestar || accionMultiplicar || accionDividir){
            captura = getString(R.string.string_cero);
        }
        if (captura.equals(R.string.string_cero)){
            captura = getString(R.string.string_vacio);
        }

        switch(opcion){

            case R.id.btn0:
                captura = captura + btn0.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn1:
                captura = captura + btn1.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn2:
                captura = captura + btn2.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn3:
                captura = captura + btn3.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn4:
                captura = captura + btn4.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn5:
                captura = captura + btn5.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn6:
                captura = captura + btn6.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn7:
                captura = captura + btn7.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn8:
                captura = captura + btn8.getText().toString();
                resultado.setText(captura);
                break;
            case R.id.btn9:
                captura = captura + "9";//btn9.getText().toString();
                resultado.setText(captura);
                break;
        }
    }
    public void prueba(View view){
        int valor = view.getId();
    }
    public void sumar(View view){
        String captura = resultado.getText().toString();
        setearAccion (1);
        if (!captura.equals("0")){
            intAcumulador1 = Integer.parseInt(captura);
        }

    }
    public void restar(View view){
    }
    public void multiplicar(View view){

    }
    public void dividir(View view){

    }
    public void setearAccion(int opcion){

        accionSumar = false;
        accionRestar = false;
        accionMultiplicar= false;
        accionDividir = false;

        switch(opcion) {
            //sumar 1, restar 2, multiplicar 3, dividir 4;
            case 1:
                accionSumar = true;
                break;
            case 2:
                accionRestar = true;
                break;
            case 3:
                accionMultiplicar= true;
                break;
            case 4:
                accionDividir = false;
                break;
            case 5:
                accionSumar = false;
                accionRestar = false;
                accionMultiplicar= false;
                accionDividir = false;
                break;
        }
    }
    public void mostrarResultado(View view){
        intAcumulador2 = Integer.parseInt(resultado.getText().toString());
        Integer resultadoOperacion = intAcumulador1 + intAcumulador2;

        resultado.setText(resultadoOperacion.toString());
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
}
