package com.example.dissapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class DisplayActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //initialisation
    RecyclerView recyclerView;
    RecyclerView.Adapter placesAdapter;
    RecyclerView.LayoutManager layoutManager;
    Spinner spinner;


    //data for no journal selection on spinner
    String[] noNameList = {"No Journal Selected"};
    String[] noDescriptionList = {"Please select a journal"};
    int[] noImages = {R.drawable.whitebackground};



    //PARIS DATA
    String[] parisNameList = {"Eiffel Tower", "City","Louvre","Arc De Triomphe"};
    String[] parisDescriptionList = {"pic of eiffel tower", "pic of city","We vistited the louvre today it was lovely", "great view from the top"};
    int[] parisImages = {R.drawable.paris, R.drawable.paris1, R.drawable.louvre, R.drawable.arc};

    //BERLIN DATA
    int[] berlinImages = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //RECYCLER VIEW CODE
        //name can be changed later
        recyclerView = findViewById(R.id.rvPlaces);
        //use this if changes in the content do not change the recycler view
        recyclerView.setHasFixedSize(true);
        //layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //adapter
        /*placesAdapter = new PlacesAdapter(this, placesNameList, placesDescriptionList, parisImages);
        recyclerView.setAdapter(placesAdapter);*/


        //SPINNER CODE
        spinner = (Spinner) findViewById(R.id.selector);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Places, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        //display toast message based on what item is selected
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();


        if (text.equals("--Select Journal--"))
        {
            //adapter
            placesAdapter = new PlacesAdapter(this, noNameList, noDescriptionList, noImages);
            recyclerView.setAdapter(placesAdapter);
        }
        else if (text.equals("Paris"))
        {
            //adapter
            placesAdapter = new PlacesAdapter(this, parisNameList, parisDescriptionList, parisImages);
            recyclerView.setAdapter(placesAdapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
