package com.example.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.utils.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
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
    private Button btnDot;
    private Button btnSummation;
    private Button btnSubtraction;
    private Button btnMultiplication;
    private Button btnDivision;
    private Button btnCalculator;
    private Button btnC;
    private Button btnAC;
    private EditText edtExpression;
    private TextView tvResutl;

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        loadComponent();
        loadAction();
        calculator = new Calculator();
    }

    private void loadComponent(){
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
        btnDot = findViewById(R.id.btnDot);
        btnSummation = findViewById(R.id.btnSummation);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnDivision = findViewById(R.id.btnDivision);
        btnC = findViewById(R.id.btnC);
        btnAC = findViewById(R.id.btnAC);
        btnCalculator = findViewById(R.id.btnCalculator);
        edtExpression = findViewById(R.id.edtExpression);
        tvResutl = findViewById(R.id.tvResult);
    }

    private void loadAction(){
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
        btnDot.setOnClickListener(this);
        btnSummation.setOnClickListener(this);
        btnSubtraction.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnCalculator.setOnClickListener(this);
    }

    private String deleteCharacter(String s){
        String result = s.substring(0, s.length()-1);
        return result;
    }

    @Override
    public void onClick(View view){
        Toast.makeText(CalculatorActivity.this, "btn:"+((Button) view).getText().toString(), Toast.LENGTH_LONG);
        switch (view.getId()){
            case R.id.btn0:
                edtExpression.append("0");
                break;
            case R.id.btn1:
                edtExpression.append("1");
                break;
            case R.id.btn2:
                edtExpression.append("2");
                break;
            case R.id.btn3:
                edtExpression.append("3");
                break;
            case R.id.btn4:
                edtExpression.append("4");
                break;
            case R.id.btn5:
                edtExpression.append("5");
                break;
            case R.id.btn6:
                edtExpression.append("6");
                break;
            case R.id.btn7:
                edtExpression.append("7");
                break;
            case R.id.btn8:
                edtExpression.append("8");
                break;
            case R.id.btn9:
                edtExpression.append("9");
                break;
            case R.id.btnDot:
                edtExpression.append(".");
                break;
            case R.id.btnSummation:
                edtExpression.append("+");
                break;
            case R.id.btnSubtraction:
                edtExpression.append("-");
                break;
            case R.id.btnMultiplication:
                edtExpression.append("*");
                break;
            case R.id.btnDivision:
                edtExpression.append("/");
                break;
            case R.id.btnC:
//                String expression = deleteCharacter(edtExpression.getText().toString());
//                edtExpression.setText(expression);
                BaseInputConnection baseInputConnection = new BaseInputConnection(edtExpression, true);
                baseInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnAC:
                edtExpression.setText("");
                break;
            case R.id.btnCalculator:
                tvResutl.setText(calculator.calculate(edtExpression.getText().toString()).toString());
                break;
        }
    }
}