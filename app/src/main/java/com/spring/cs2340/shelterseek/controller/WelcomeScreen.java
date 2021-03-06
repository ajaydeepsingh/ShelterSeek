package com.spring.cs2340.shelterseek.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Admin;
import com.spring.cs2340.shelterseek.model.Model;
import com.spring.cs2340.shelterseek.model.Account;

import java.util.ArrayList;

/**
 * login screen
 * @version 1.0
 */
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
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome_screen);
        model = Model.getInstance();

        final TextView incorrect = (TextView) findViewById(R.id.Incorrect);
        final TextView lockout = (TextView) findViewById(R.id.lockout);
        final EditText username = (EditText) findViewById(R.id.UserField);
        final EditText password = (EditText) findViewById(R.id.PasswordField);
//        final EditText password = (EditText) findViewById(R.id.PasswordField);
//        password.setTransformationMethod(new PasswordTransformationMethod());
        loginButton = (Button) findViewById(R.id.Login);
        registerUser = (Button) findViewById(R.id.RegisterUser);
        registerShelter = (Button) findViewById(R.id.registerShelter);
        registerAdmin = (Button) findViewById(R.id.registerAdmin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                Model m = Model.getInstance();
                ArrayList<Account> accounts = m.getAccounts();
                boolean login = false;
                boolean admin = false;
                boolean lockoutCheck = false;
                for (Account a: accounts) {
                    if (user.equals(a.getUserName()) && pass.equals(a.getPassword())) {
                        model.setCurrentUser(a);
                        login = true;
                        if (model.getCurrentUser().isAdmin()) {
                            admin = true;
                        }
                    }
                }
                if (!login) {
                    model.setLoginCounter();
                }
                if (model.getLoginCounter() >= 5) {
                    lockoutCheck = true;
                }
                if (!lockoutCheck && login && admin) {
                    Intent newIntent = new Intent(getBaseContext(), AdminScreen.class);
                    startActivity(newIntent);
                } else if (!lockoutCheck && login) {
                    Intent newIntent = new Intent(getBaseContext(), MainScreen.class);
                    startActivity(newIntent);
                } else if (!lockoutCheck){
                    incorrect.setVisibility(View.VISIBLE);
                } else if (lockoutCheck){
                    lockout.setVisibility(View.VISIBLE);
                    incorrect.setVisibility(View.INVISIBLE);
                } else {
                    //do nothing
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
