package com.mobile.thais.calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSomar, btnDividir, btnMultiplicar, btnSubtrair,
            btnPonto, btnResultado, btnLimparTudo;
    private TextView equacao, resultado;
    String operadores;
    private double operador1, operador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
        listners();
    }

    private void inicializar(){
        equacao = (TextView) findViewById(R.id.viewEquacao);
        resultado = (TextView) findViewById(R.id.viewResultado);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnSubtrair = (Button) findViewById(R.id.btnDiminuir);
        btnLimparTudo = (Button) findViewById(R.id.btnLimparCampo);
        btnPonto = (Button) findViewById(R.id.btnPonto);
        btnResultado = (Button) findViewById(R.id.btnResultado);
    }

    private void listners(){
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
        btnDividir.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnSomar.setOnClickListener(this);
        btnSubtrair.setOnClickListener(this);
        btnLimparTudo.setOnClickListener(this);
        btnPonto.setOnClickListener(this);
        btnResultado.setOnClickListener(this);

    }

    private void tecladoNumerico(int lerNum){
        if(equacao.getText().toString().toString().equals("0.0")){
            limparVisor();
            equacao.setText(equacao.getText().toString() + String.valueOf(lerNum));
        } else {
            equacao.setText(equacao.getText().toString() + String.valueOf(lerNum));
        }
    }

    private void ponto(String ponto){
        String textoVisor = equacao.getText().toString();
        equacao.setText(textoVisor + ponto);
    }

    private void operacoes(String operadores){
        this.operadores = operadores;

        if(operadores == "+"){
            operador1 = Double.parseDouble(equacao.getText().toString().trim());
            limparVisor();
        } else if(operadores == "-"){
            operador1 = Double.parseDouble(equacao.getText().toString().trim());
            limparVisor();
        } else if(operadores == "*"){
            operador1 = Double.parseDouble(equacao.getText().toString().trim());
            limparVisor();
        } else if(operadores == "/"){
            operador1 = Double.parseDouble(equacao.getText().toString().trim());
            limparVisor();
        }
    }

    private void igual(){
        if(operadores == "+"){
            operador2 = operador1 + Double.parseDouble(equacao.getText().toString().trim());
        } else if(operadores == "-"){
            operador2 = operador1 - Double.parseDouble(equacao.getText().toString().trim());
        } else if(operadores == "*"){
            operador2 = operador1 * Double.parseDouble(equacao.getText().toString().trim());
        } else if(operadores == "/"){
            if(operador1 == 0){
                operador2 = 0;
            } else {
                operador2 = operador1 / Double.parseDouble(equacao.getText().toString().trim());
            }
        } else {
            operador2 = 0;
        }

        resultado.setText(String.valueOf(operador2));
    }

    private void limparVisor() {
        equacao.setText("");
        resultado.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                tecladoNumerico(0);
                break;

            case R.id.btn1:
                tecladoNumerico(1);
                break;

            case R.id.btn2:
                tecladoNumerico(2);
                break;

            case R.id.btn3:
                tecladoNumerico(3);
                break;

            case R.id.btn4:
                tecladoNumerico(4);
                break;

            case R.id.btn5:
                tecladoNumerico(5);
                break;

            case R.id.btn6:
                tecladoNumerico(6);
                break;

            case R.id.btn7:
                tecladoNumerico(7);
                break;

            case R.id.btn8:
                tecladoNumerico(8);
                break;

            case R.id.btn9:
                tecladoNumerico(9);
                break;

            case R.id.btnPonto:
                ponto(".");
                break;

            case R.id.btnLimparCampo:
                limparVisor();
                break;

            case R.id.btnDiminuir:
                operacoes("-");
                break;

            case R.id.btnDividir:
                operacoes("/");
                break;

            case R.id.btnSomar:
                operacoes("+");
                break;

            case R.id.btnMultiplicar:
                operacoes("*");
                break;

            case R.id.btnResultado:
                igual();
                break;
        }
    }
}
