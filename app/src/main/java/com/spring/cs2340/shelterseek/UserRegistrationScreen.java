package com.spring.cs2340.shelterseek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserRegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistration_screen);
        final EditText username = (EditText) findViewById(R.id.UsernameSeeker);
        final EditText password = (EditText) findViewById(R.id.PasswordSeeker);
        final EditText realName = (EditText) findViewById(R.id.realName);
        Button registerAsUser = (Button) findViewById(R.id.userRegister);

        registerAsUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // add new user to arraylist

                Intent newIntent = new Intent(getBaseContext(), WelcomeScreen.class);
                startActivity(newIntent);
            }
        });
    }
}
