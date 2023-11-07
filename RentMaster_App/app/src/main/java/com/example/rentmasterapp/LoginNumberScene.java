package com.example.rentmasterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class LoginNumberScene extends AppCompatActivity {
    //CountryCodePicker countryCodePicker;
    EditText phoneInput;
    Button sendlogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_number_scene);
        sendlogin = findViewById(R.id.signin_btn);
        progressBar = findViewById(R.id.login_progress_bar);

        sendlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginNumberScene.this, HomeScene.class);
                startActivity(intent);
            }
        });
    }
}