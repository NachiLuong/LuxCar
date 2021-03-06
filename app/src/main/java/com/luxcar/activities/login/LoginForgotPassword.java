package com.luxcar.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.luxcar.R;
import com.luxcar.utils.JavaMail;

public class LoginForgotPassword extends AppCompatActivity {
    EditText etForgotEmail;
    Button btnSend;
    ImageView ivCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        createComponents();
        createEvents();
    }

    private void createComponents() {
        etForgotEmail = findViewById(R.id.etForgotEmail);
        btnSend = findViewById(R.id.btnSend);
        ivCancel = findViewById(R.id.ivCancel2);
    }
    private void createEvents(){
        btnSend.setOnClickListener(v -> {
            String mail = etForgotEmail.getText().toString();
            String message = "hahahaha";
            String subject = "Trung Dep Trai";

            //Send Mail
            JavaMail javaMailAPI = new JavaMail(this,mail,subject,message);

            javaMailAPI.execute();

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, " We was send your password to you email", Toast.LENGTH_SHORT).show();
        });
    }
}
