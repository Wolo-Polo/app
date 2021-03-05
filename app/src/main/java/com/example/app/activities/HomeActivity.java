package com.example.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app.R;
import com.example.app.utils.Calculator;

public class HomeActivity extends AppCompatActivity {
    private Button btnCalculator;
    private Button btnPhoneBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnCalculator = (Button) findViewById(R.id.btnCalculatorAction);
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        btnPhoneBook = (Button) findViewById(R.id.btnPhoneBook);
        btnPhoneBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PhoneBookActivity.class);
                startActivity(intent);
            }
        });
    }
}