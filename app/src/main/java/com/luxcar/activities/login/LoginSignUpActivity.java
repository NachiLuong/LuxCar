package com.luxcar.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.luxcar.R;
import com.luxcar.activities.admin.admin;


public class LoginSignUpActivity extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    TextView tvForgotPass, tvSignup;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);

        createComponents();
        event();


    }
    private void event(){
        btnLogin.setOnClickListener(view -> {
            String email = txtEmail.getText().toString();
            String password = txtPassword.getText().toString();
            if(email.equals("admin") && password.equals("123456")){
                Intent intent = new Intent(this, admin.class);
                startActivity(intent);
            }
        });
    }
    private void createComponents() {
        txtEmail = findViewById(R.id.etEmail);
        txtPassword = findViewById(R.id.etPassword);
        tvForgotPass = findViewById(R.id.tvForgotPassword);
        tvSignup = findViewById(R.id.tvSignUp);
        btnLogin = findViewById(R.id.btnLogin);
    }
}