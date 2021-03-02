package com.example.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;

public class LogInActivity extends AppCompatActivity{
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        full screen
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        no title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvForgotPassword.setText(Html.fromHtml("<u>Forgot password?</u>"));

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(username.equals("TruongDzai") && password.equals("1234")){
                    Intent intent = new Intent(LogInActivity.this, CalculatorActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LogInActivity.this, "Login fail!" + password, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}