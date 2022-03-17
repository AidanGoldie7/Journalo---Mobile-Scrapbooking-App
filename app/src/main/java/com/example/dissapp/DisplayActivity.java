package com.example.dissapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter placesAdapter;
    RecyclerView.LayoutManager layoutManager;

    String[] placesNameList = {"Eiffel Tower", "City"};
    String[] placesDescriptionList = {"pic of eiffel tower", "pic of city"};

    int[] placesImages = {R.drawable.paris, R.drawable.paris1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //name can be changed later
        recyclerView = findViewById(R.id.rvPlaces);

        //use this if changes in the content do not change the recycler view
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        placesAdapter = new PlacesAdapter(this, placesNameList, placesDescriptionList, placesImages);
        recyclerView.setAdapter(placesAdapter);

    }
}
