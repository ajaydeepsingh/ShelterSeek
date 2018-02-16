package com.spring.cs2340.shelterseek.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Model;

public class WelcomeScreen extends AppCompatActivity {
    Model model;
    Button loginButton;
    Button cancelButton;
    Button registrationButton;
    Button registerUser;
    Button registerAdmin;
    Button registerShelter;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText password;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        model = Model.getInstance();

        final TextView incorrect = (TextView) findViewById(R.id.Incorrect);
        final EditText username = (EditText) findViewById(R.id.UserField);
        final EditText password = (EditText) findViewById(R.id.PasswordField);
        loginButton = (Button) findViewById(R.id.Login);
        registerUser = (Button) findViewById(R.id.RegisterUser);
        registerShelter = (Button) findViewById(R.id.registerShelter);
        registerAdmin = (Button) findViewById(R.id.registerAdmin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("User") && pass.equals("Pass")) {
                    Intent newIntent = new Intent(getBaseContext(), MainScreen.class);
                    startActivity(newIntent);
                } else {
                    incorrect.setVisibility(View.VISIBLE);
                }
            }
        });
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getBaseContext(), UserRegistrationScreen.class);
                startActivity(newIntent);
            }
        });
        registerShelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getBaseContext(), ShelterRegistrationScreen.class);
                startActivity(newIntent);
            }
        });
        registerAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getBaseContext(), AdminRegistrationScreen.class);
                startActivity(newIntent);
            }
        });
    }
}
