package com.luxcar.activities.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.luxcar.R;
import com.luxcar.activities.admin.AdminActivity;
import com.luxcar.configurations.ApplicationProperties;
import com.luxcar.models.entities.User;
import com.luxcar.services.UserService;

public class LoginActivity extends AppCompatActivity {

    private LayoutInflater layoutInflater;

    private EditText etEmail;
    private EditText etPassword;

    private Button btnLogin;

    private TextView tvForgotPassword;
    private TextView tvSignUp;
    ImageView ivCancel;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createComponents();
        createEvents();
    }

    private void createComponents() {

        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);

        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvSignUp = findViewById(R.id.tvSignUp);
        ivCancel = findViewById(R.id.ivLoginCancel);
    }

    private void createEvents() {
        btnLogin.setOnClickListener(view -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            if(email.equals("admin@gmail.com") && password.equals("12345679")){
                Intent intentForgotPassword = new Intent(LoginActivity.this, AdminActivity.class);
                startActivity(intentForgotPassword);
            }
          /*  validate();
            if(awesomeValidation.validate()){
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                User user = UserService.instance().isExist(email, password);
                if (user != null) {
                    SharedPreferences.Editor edit = ApplicationProperties.SHARED_PREFERENCES.edit();
                    edit.putInt("user_id", user.getId());
                    edit.apply();
                    Log.i("Login", "Success!");
                }
            }*/

        });

        tvForgotPassword.setOnClickListener(view -> {
            Intent intentForgotPassword = new Intent(LoginActivity.this, LoginForgotPassword.class);
            startActivity(intentForgotPassword);
        });

        tvSignUp.setOnClickListener(view -> {
            Intent intentSignUp = new Intent(LoginActivity.this, LoginSignUpActivity.class);
            startActivity(intentSignUp);
        });
    }
    private void validate(){
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.etEmail, Patterns.EMAIL_ADDRESS, R.string.validateEmail);

    }
}