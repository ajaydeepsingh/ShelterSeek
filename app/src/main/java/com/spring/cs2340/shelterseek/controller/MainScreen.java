package com.spring.cs2340.shelterseek.controller;
import com.google.firebase.FirebaseApp;
import com.spring.cs2340.shelterseek.model.Model;
import com.spring.cs2340.shelterseek.model.Shelter;
import com.spring.cs2340.shelterseek.R;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import com.opencsv.CSVReader;
import java.util.List;

public class MainScreen extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_screen);

//        mAuth = FirebaseAuth.getInstance();
//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.hsd)));
            CSVReader cr = new CSVReader(br);

            String record[] = cr.readNext();

            Shelter shelter;

            while ((record = cr.readNext()) != null) {
                shelter = new Shelter(record[0], record[1], record[2], record[3],
                        Double.parseDouble(record[4]), Double.parseDouble(record[5]),
                        record[6], record[7], record[8],
                        0);
                myRef.child("shelters").child(shelter.getUniqueKey()).setValue(shelter);
            }

        } catch (Exception e) {
            // Probably some IOException, but for this script, who cares.
            Log.d("ERROR", e.getMessage());
            e.printStackTrace();
        }
    }
}




//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        mAuth = FirebaseAuth.getInstance();
//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference();
//
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.hsd)));
//            CSVReader cr = new CSVReader(br);
//
//            String record[] = cr.readNext();
//
//            Shelter shelter;
//
//            while ((record = cr.readNext()) != null) {
//                shelter = new Shelter(record[0], record[1], record[2], record[3],
//                        Double.parseDouble(record[4]), Double.parseDouble(record[5]),
//                        record[6], record[7], record[8],
//                        0);
//                myRef.child("shelters").child(shelter.getUniqueKey()).setValue(shelter);
//            }
//
//        } catch (Exception e) {
//            // Probably some IOException, but for this script, who cares.
//            Log.d("ERROR", e.getMessage());
//            e.printStackTrace();
//        }
//
//
//        setContentView(R.layout.activity_main_screen);
//
//
//    }