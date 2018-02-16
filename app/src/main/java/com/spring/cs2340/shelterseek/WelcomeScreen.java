package com.spring.cs2340.shelterseek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        final TextView incorrect = (TextView) findViewById(R.id.Incorrect);
        final EditText username = (EditText) findViewById(R.id.UserField);
        final EditText password = (EditText) findViewById(R.id.PasswordField);
        Button loginButton = (Button) findViewById(R.id.Login);
        Button registerUser = (Button) findViewById(R.id.RegisterUser);
        Button registerShelter = (Button) findViewById(R.id.registerShelter);
        Button registerAdmin = (Button) findViewById(R.id.registerAdmin);
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
                Intent newIntent = new Intent(getBaseContext(), USERRegistrationScreen.class);
                startActivity(newIntent);
            }
        });
        registerShelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getBaseContext(), SHELTERRegistrationSceen.class);
                startActivity(newIntent);
            }
        });
        registerAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getBaseContext(), ADMINRegistrationScreen.class);
                startActivity(newIntent);
            }
        });
    }
}
