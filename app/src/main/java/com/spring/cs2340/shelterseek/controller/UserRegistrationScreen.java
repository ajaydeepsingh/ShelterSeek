package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.spring.cs2340.shelterseek.R;

import java.util.ArrayList;
import java.util.List;

public class UserRegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistration_screen);
        final EditText username = (EditText) findViewById(R.id.UsernameSeeker);
        final EditText password = (EditText) findViewById(R.id.PasswordSeeker);
        final EditText realName = (EditText) findViewById(R.id.realName);
        final EditText contactInfo = (EditText) findViewById(R.id.phoneNumSeeker);
        final EditText dob = (EditText) findViewById(R.id.dateOfBirth);
        CheckBox isVet = (CheckBox) findViewById(R.id.veteranBox);
        Button registerAsUser = (Button) findViewById(R.id.userRegister);
        registerAsUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // if isVet is checked, change boolean to true
                // add new user to arraylist

                Intent newIntent = new Intent(getBaseContext(), WelcomeScreen.class);
                startActivity(newIntent);
            }
        });
    }
}
