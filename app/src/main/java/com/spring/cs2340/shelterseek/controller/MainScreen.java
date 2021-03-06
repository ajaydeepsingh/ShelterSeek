package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Main Screen of app, shows shelters
 * @version 1.0
 */
public class MainScreen extends AppCompatActivity {
    private static ArrayList<Shelter> shelterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button searchButton = findViewById(R.id.Search);
        ListView shelters = findViewById(R.id.shelterList);
        shelterList = new ArrayList<>();
        Button mapView = findViewById(R.id.mapView);
        parseData();
        ArrayAdapter<Shelter> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, shelterList);
        shelters.setAdapter(adapter);
        shelters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), ShelterDetail.class);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SearchScreen.class);
                startActivity(intent);
            }
        });
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getBaseContext(), mapView.class);
                startActivity(newIntent);
            }
        });
    }

    /**
     * gets the shelter list from the screen
     * @return the shelters
     */
    public static ArrayList<Shelter> getShelters() {
        return shelterList;
    }

    private void parseData() {
        InputStream shelterStream = getResources().openRawResource(R.raw.homelessdatabase);
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (shelterStream, Charset.forName("UTF-8")));
        String readLine;
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
                newShelter.setVacancies(tokens[2]);
                shelterList.add(newShelter);
                readLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}