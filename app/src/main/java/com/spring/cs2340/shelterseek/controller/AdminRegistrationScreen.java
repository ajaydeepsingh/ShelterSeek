package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Admin;
import com.spring.cs2340.shelterseek.model.Model;

/**
 * Admin Registration Screen
 * @version 1.0
 */
public class AdminRegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminregistration_screen);
        final TextView invalid = (TextView) findViewById(R.id.Invalid);
        final EditText username = (EditText) findViewById(R.id.Username);
        final EditText password = (EditText) findViewById(R.id.Password);
        final EditText contactInfo = (EditText) findViewById(R.id.phoneNumAdmin);
        final EditText realName = (EditText) findViewById(R.id.AdminRealName);
        final EditText adminCode = (EditText) findViewById(R.id.adminCode);
        Button registerAsAdmin = (Button) findViewById(R.id.adminRegister);

        registerAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adminText = adminCode.getText().toString();
                if ("A".equals(adminText)) {

                    //Add a new admin to the arrayList
                    String uName = username.getText().toString();
                    String pWord = password.getText().toString();
                    String cInfo = contactInfo.getText().toString();
                    String rName = realName.getText().toString();
                    Admin newAdmin = new Admin(rName, uName, pWord, cInfo);
                    Model m = Model.getInstance();
                    m.addNewAccount(newAdmin);
                    Intent newIntent = new Intent(getBaseContext(), WelcomeScreen.class);
                    startActivity(newIntent);
                } else {
                    invalid.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}