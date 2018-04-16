package com.spring.cs2340.shelterseek.controller;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.spring.cs2340.shelterseek.R;
import com.spring.cs2340.shelterseek.model.Shelter;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Map Screen
 * @version 1.0
 */
public class mapView extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ArrayList<LatLng> latLngs = new ArrayList<>();
    private static ArrayList<Shelter> shelterSearchList = new ArrayList<>();
    private MarkerOptions options = new MarkerOptions();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map_view);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Map Search
     * @param view the view passed in
     */
    public void onMapSearch(View view) {
        mMap.clear();
        EditText searchCond = (EditText) findViewById(R.id.searchTerm);
        shelterSearchList = new ArrayList<>();
        latLngs = new ArrayList<>();
        String s = searchCond.getText().toString();
        if ("male".equalsIgnoreCase(s)) {
            s = "Men";
        }
        if ("female".equalsIgnoreCase(s)) {
            s = "Women";
        }
        parseDataSearch(s);
        int shelterIndex = 0;
        for (LatLng point : latLngs) {
            Shelter currentShelter = shelterSearchList.get(shelterIndex);
            options.position(point);
            options.title(currentShelter.getName());
            options.snippet(currentShelter.getContactInfo());
            mMap.addMarker(options);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngs.get(0),12));
            shelterIndex++;
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void parseDataSearch(String s) {
        InputStream shelterStream = getResources().openRawResource(R.raw.homelessdatabase);
        String[] words = s.split(" ");
        for (String word : words) {
            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (shelterStream, Charset.forName("UTF-8")));
            String readLine;
            try {
                reader.readLine();
                readLine = reader.readLine();
                while (readLine != null) {
                    String[] tokens = readLine.split(",");
                    if (tokens[0].contains(word) || tokens[1].contains(word) || tokens[2]
                            .contains(word) || tokens[3].contains(word) || tokens[4].contains(word)
                            || tokens[5].contains(word) || tokens[6].contains(word) || tokens[7]
                            .contains(word) || tokens[8].contains(word)) {
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
                        latLngs.add(new LatLng(newShelter.getLatitude(),
                                newShelter.getLongitude()));
                    }
                    readLine = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}