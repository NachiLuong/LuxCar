package com.luxcar.activities.login;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.luxcar.R;
import com.luxcar.models.entities.User;
import com.luxcar.models.types.Gender;
import com.luxcar.models.types.Role;
import com.luxcar.models.types.Status;
import com.luxcar.services.UserService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class LoginSignUpActivity extends AppCompatActivity {
    TextView tvSignupLogin;
    EditText etSignupEmail, etSignupPassword, etSignupRepeatPassword,etSignupName, etSignupPhone, etSignupAddress, etSignupDob;
    Button btnSignup;
    ImageView ivCancel, ivCalendar;
    RadioButton rbMale, rbFemale, rbOrder;

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sigup);

        createComponents();
        createEvents();


    }

    private void createEvents(){
        System.out.println("aaaa");
        tvSignupLogin.setOnClickListener(v -> {
            Intent intent = new Intent(context, LoginActivity.class);
            startActivity(intent);
        });

        ivCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int thisYear = calendar.get(Calendar.YEAR);
                int thisMonth = calendar.get(Calendar.MONTH);
                int thisDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year,month,dayOfMonth);
                        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                        etSignupDob.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                },thisYear,thisMonth,thisDay);
                datePickerDialog.show();
            }
        });
        btnSignup.setOnClickListener(v -> {
            String email = etSignupEmail.getText().toString();
            String password = etSignupPassword.getText().toString();
            String repeatPass = etSignupRepeatPassword.getText().toString();
            String name = etSignupName.getText().toString();
            String phone = etSignupPhone.getText().toString();
            String dob = etSignupDob.getText().toString();
            String address = etSignupAddress.getText().toString();

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            // you can change format of date
            Date date = null;
            try {
                date = formatter.parse(dob);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Timestamp timeStampDate = new Timestamp(date.getTime());


            // kiểm tra email tồn tại chưa
            if (!UserService.instance().isEmailExist(email)){ //chưa tồn tại
                if (password.equals(repeatPass)){ // kiểm tra nhập lại mk có đúng k
                        Integer a= UserService.instance().addUser(User.builder()
                                        .email(email)
                                        .password(password)
                                        .name(name)
                                        .gender(Gender.FEMALE)
                                        .dob(timeStampDate)
                                        .role(Role.CUSTOMER)
                                        .status(Status.ACTIVE)
                                        .address(address)
                                        .phone(phone)
                                        .build());
                }else {
                    Toast.makeText(this, "Repeat PassWord not same password", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            else { // đã tồn tại
                Toast.makeText(this, "Email is exist", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Sign Uop success", Toast.LENGTH_SHORT).show();

        });
    }
    private void chechTextBoxEmpty(EditText editText){
        if (TextUtils.isEmpty(editText.getText().toString())){
            Toast.makeText(this, "Not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    private void createComponents() {
        tvSignupLogin = findViewById(R.id.tvSignupLogin);

        etSignupEmail = findViewById(R.id.etSignupEmail);
        etSignupPassword = findViewById(R.id.etSignupPassword);
        etSignupRepeatPassword = findViewById(R.id.etSignupRepeatPassword);
        etSignupName = findViewById(R.id.etSignupName);
        etSignupPhone = findViewById(R.id.etSignupPhone);
        etSignupAddress = findViewById(R.id.etSignupAddress);
        etSignupDob = findViewById(R.id.etSignupDob);

        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOrder = findViewById(R.id.rbOrder);

        btnSignup = findViewById(R.id.btnSignup);
        ivCancel = findViewById(R.id.ivCancel3);
        ivCalendar= findViewById(R.id.ivCalendar);

        context= this;
    }
}