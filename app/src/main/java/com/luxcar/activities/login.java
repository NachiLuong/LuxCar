package com.luxcar.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.luxcar.R;

public class login extends AppCompatActivity {
    EditText txtUsername, txtPassword;
    TextView tvForgotPass, tvSignup;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);

        createComponents();
    }

    private void createComponents() {
        txtUsername = findViewById(R.id.etLoginUsername);
        txtPassword = findViewById(R.id.etLoginPassword);
        tvForgotPass = findViewById(R.id.tvLoginForgotPass);
        tvSignup = findViewById(R.id.tvLoginSignup);
        btnLogin = findViewById(R.id.btnLogin);
    }
}