package com.itla.calculadoracompleta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //final TextView tv1 = findViewById(R.id.pantalla);

    String mostrar ="";
    String operador="";
    String anterior="";
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnsuma;
    Button btnresta;
    Button btndivide;
    Button btnmultiplica;
    Button btnpunto;
    Button btnporciento;
    Button btniguala;
    Button btnclear;

    TextView tvresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btn0 = findViewById(R.id.btn0);
        final Button btn1 = findViewById(R.id.btn1);
        final Button btn2 = findViewById(R.id.btn2);
        final Button btn3 = findViewById(R.id.btn3);
        final Button btn4 = findViewById(R.id.btn4);
        final Button btn5 = findViewById(R.id.btn5);
        final Button btn6 = findViewById(R.id.btn6);
        final Button btn7 = findViewById(R.id.btn7);
        final Button btn8 = findViewById(R.id.btn8);
        final Button btn9 = findViewById(R.id.btn9);
        final Button btnsuma = findViewById(R.id.btnsuma);
        final Button btnresta = findViewById(R.id.btnresta);
        final Button btnmultiplica = findViewById(R.id.btnmultiplica);
        final Button btndivide = findViewById(R.id.btndivide);
        final Button btnporciento = findViewById(R.id.btnporciento);
        final Button btnpunto = findViewById(R.id.btnpunto);
        final Button btnclear = findViewById(R.id.btnclear);
        final Button btniguala = findViewById(R.id.btnigual);

        tvresultado=findViewById(R.id.pantalla);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnsuma.setOnClickListener(this);
        btnresta.setOnClickListener(this);
        btnmultiplica.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btnpunto.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnporciento.setOnClickListener(this);
        btniguala.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button btnpresionado = (Button) v;
        String valorPresionado = btnpresionado.getText().toString().trim();
        boolean limpiar = false;

        switch (valorPresionado){
            case "+":
                operador = valorPresionado;
                limpiar = true;
                break;

            case "-":
                operador = valorPresionado;
                limpiar = true;
                break;
            case "X":
                operador = valorPresionado;
                limpiar = true;
                break;
            case "/":
                operador = valorPresionado;
                limpiar = true;
                break;
            case "=":
                double valor1 = Double.parseDouble(anterior);
                double valor2 = Double.parseDouble(mostrar);
                double resultado = 0;

                switch (operador){
                    case "+":
                        resultado = valor1 + valor2;
                        break;
                    case "-":
                        resultado = valor1-valor2;
                        break;
                    case "X":
                        resultado = valor1*valor2;
                        break;
                    case "/":
                        if(valor2==0){
                            valor2=1;
                        }
                        resultado = valor1 / valor2;
                        break;
                }
                mostrar=String.valueOf(resultado);
                int indexOfDecimal = mostrar.indexOf(".");
                if(Double.parseDouble(mostrar.substring(indexOfDecimal))==0){
                    mostrar=mostrar.substring(0,indexOfDecimal);
                }
                operador = "";
                break;
            case "clear":
                mostrar = "";
                operador = "";
                anterior = "";
                break;
            case "%":
                mostrar = String.valueOf(Double.parseDouble(mostrar)/100);
                break;
            default:
                mostrar+=valorPresionado;
                break;
        }

        if(limpiar){
            anterior=mostrar;
            mostrar="";
        }

        tvresultado.setText(mostrar);
    }
}