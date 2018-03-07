package com.spring.cs2340.shelterseek.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Shelter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class SearchScreen extends AppCompatActivity {
    private ListView shelterSearch;
    private static ArrayList<Shelter> shelterSearchList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        shelterSearch = findViewById(R.id.shelterSearchList);
        Button searchList = (Button) findViewById(R.id.SearchTheList);
        EditText searchCond = (EditText) findViewById(R.id.SearchTerm);
        shelterSearchList = new ArrayList<>();
        searchList.setOnClickListener(view -> {
            shelterSearchList = new ArrayList<>();
            String s = searchCond.getText().toString();
            parseData(s);
            ArrayAdapter<Shelter> adapter = new ArrayAdapter<Shelter>(this,
                    android.R.layout.simple_list_item_1, shelterSearchList);
            shelterSearch.setAdapter(adapter);
        });
    }

    private void parseData(String s) {
        InputStream shelterStream = getResources().openRawResource(R.raw.homelessdatabase);
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (shelterStream, Charset.forName("UTF-8")));
        String readLine = "";
        try {
            reader.readLine();
            readLine = reader.readLine();
            while (readLine != null) {
                String[] tokens = readLine.split(",");
                if (tokens[0].contains(s) || tokens[1].contains(s) || tokens[2].contains(s) ||
                        tokens[3].contains(s) || tokens[4].contains(s) || tokens[5].contains(s) ||
                        tokens[6].contains(s) || tokens[7].contains(s) || tokens[8].contains(s)) {
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
                    shelterSearchList.add(newShelter);
                }
                readLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
