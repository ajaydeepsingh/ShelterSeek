package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.spring.cs2340.shelterseek.R;

public class ShelterRegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelterregistration_sceen);
        final EditText shelterID = (EditText) findViewById(R.id.ShelterName);
        final EditText employeeName = (EditText) findViewById(R.id.NameShelterEmpl);
        final EditText password = (EditText) findViewById(R.id.PasswordShelter);
        final EditText contactinfo = (EditText) findViewById(R.id.ContactInfoEmp);
        Button registerAsShelter = (Button) findViewById(R.id.shelterRegistration);

        registerAsShelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // add new shelter to arraylist

                Intent newIntent = new Intent(getBaseContext(), WelcomeScreen.class);
                startActivity(newIntent);
            }
        });
    }
}
