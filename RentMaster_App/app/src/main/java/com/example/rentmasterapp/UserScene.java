package com.example.rentmasterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class UserScene extends AppCompatActivity {
    ImageButton btnHome, btnMenu;
    Button btnEdit, btnSave;
    EditText tvName, tvBirth, tvPhone, tvEmail;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<EditText> editTexts = new ArrayList<>();
        setContentView(R.layout.activity_user_infor);
        btnHome = (ImageButton) findViewById(R.id.btn_home);
        btnMenu = (ImageButton) findViewById(R.id.btn_menu);
        btnEdit = (Button) findViewById(R.id.btn_editInfo);
        btnSave = (Button) findViewById(R.id.saveInfo);
        tvName = (EditText) findViewById(R.id.userNameLabel);
        tvBirth = (EditText) findViewById(R.id.userBirthLabel);
        tvPhone =(EditText) findViewById(R.id.userPhoneNumber);
        tvEmail = (EditText) findViewById(R.id.userEmail);
        editTexts.add(tvName);
        editTexts.add(tvBirth);
        editTexts.add(tvPhone);
        editTexts.add(tvEmail);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserScene.this, HomeScene.class);
                startActivity(intent);
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserScene.this, MenuScene.class);
                startActivity(intent);
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (EditText editText : editTexts) {
                    if (editText.isEnabled()) {
                        editText.setEnabled(true);
                    } else {
                        editText.setEnabled(true);
                        tvName.findFocus();
                    }
                }
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (EditText editText: editTexts) {
                    if (editText.isEnabled()) {
                        editText.setEnabled(false);
                    } else {
                        editText.setEnabled(false);
                    }
                }
            }
        });
    }
}
