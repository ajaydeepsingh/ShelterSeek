package com.spring.cs2340.shelterseek.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Shelter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends AppCompatActivity {
    private ListView shelters;
    private static ArrayList<Shelter> shelterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        shelters = findViewById(R.id.shelterList);
        Button searchButton = (Button) findViewById(R.id.Search);
        shelterList = new ArrayList<>();
        parseData();
        ArrayAdapter<Shelter> adapter = new ArrayAdapter<Shelter>(this,
                android.R.layout.simple_list_item_1, shelterList);
        shelters.setAdapter(adapter);
        shelters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), ShelterDetail.class);
                intent.putExtra("position", i);
                System.out.println("About to open ShelterPage");
                startActivity(intent);
                System.out.println("Started new intent");
            }
        });
        searchButton.setOnClickListener((view) -> {
            Intent newIntent = new Intent(getBaseContext(), SearchScreen.class);
            startActivity(newIntent);
        });
    }

    public static ArrayList<Shelter> getShelters() {
        return shelterList;
    }

    private void parseData() {
        InputStream shelterStream = getResources().openRawResource(R.raw.homelessdatabase);
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (shelterStream, Charset.forName("UTF-8")));
        String readLine = "";
        try {
            reader.readLine();
            readLine = reader.readLine();
            while (readLine != null) {
                String[] tokens = readLine.split(",");
                Shelter newShelter = new Shelter();
                newShelter.setUniqueKey(tokens[0]);
                newShelter.setName(tokens[1]);
                newShelter.setCapacity(tokens[2]);
                newShelter.setRestrictions(tokens[3]);
                double longitude = Double.parseDouble(tokens[4]);
                newShelter.setLongitude(longitude);
                double latitude = Double.parseDouble(tokens[5]);
                newShelter.setLatitude(latitude);
                newShelter.setAddress(tokens[6]);
                newShelter.setSpecialNotes(tokens[7]);
                newShelter.setContactInfo(tokens[8]);
                shelterList.add(newShelter);
                readLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
