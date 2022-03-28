package com.example.dissapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class DisplayActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //initialisation
    RecyclerView recyclerView;
    RecyclerView.Adapter placesAdapter;
    RecyclerView.LayoutManager layoutManager;
    Spinner spinner;



    //DATA TO DISPLAY DEPENDING ON DROP DOWN LIST
    //NO SELECTION DATA
    String[] noNameList = {"No Journal Selected"};
    String[] noDateList = {""};
    String[] noDescriptionList = {"Please select a journal"};
    int[] noImages = {R.drawable.whitebackground};

    //PARIS DATA
    String[] parisNameList = {"Eiffel Tower", "City","Louvre","Arc De Triomphe", "Hotel Room View"};
    String[] parisDateList = {"04/05/2016","04/05/2016","04/05/2016","04/05/2016","04/05/2016"};
    String[] parisDescriptionList = {"pic of eiffel tower", "pic of city","We vistited the louvre today it was lovely", "great view from the top", "The hotel room we stayed in was excellent, amazing view from the balcony and the staff were very accomodating"};
    int[] parisImages = {R.drawable.paris, R.drawable.paris1, R.drawable.louvre, R.drawable.arc, R.drawable.balcony};

    //NEW YORK DATA
    String[] newyorkNameList = {"Statue of Liberty", "Empire State Building"};
    String[] newyorkDateList = {"04/05/2016","04/05/2016"};
    String[] newyorkDescriptionList = {"pic of statue of liberty", "Amazing view"};
    int[] newyorkImages = {R.drawable.statueoflib, R.drawable.empire};

    //TOKYO DATA
    String [] tokyoNameList = {"Mount Fuji", "Street Culture","Squid Market"};
    String[] tokyoDateList = {"04/05/2016","04/05/2016","04/05/2016"};
    String [] tokyoDescriptionList = {"Insane view from Yokohama", "Busy street in central tokyo", "Went to the Squid market today to try new things"};
    int[] tokyoImages = {R.drawable.mtfuji, R.drawable.tokyostreet, R.drawable.squid};


    //CRAIG & KIMS WEDDING
    String [] weddingNameList = {"Groom waiting for his bride", "Happy couple at the alter", "Grandkids at the alter!", "Cutting the cake!", "Rob stole the grooms seat!"};
    String[] weddingDateList = {"18/04/2022","18/04/2022","18/04/2022","18/04/2022","18/04/2022"};
    String [] weddingDescriptionList = {"Craig and his best man Chris waiting nervously for kim to come down the Aisle. Such a happy day for the whole family!", "Craig and Kim at the alter! the view was spectacular from the Bowfield Hotel and Country Club!", "Aidan, Rebecca and Hannah stealing the alter once the professional photos had been taken! It's so lovely to see them all dressed up together","Craig and Kim cutting their wedding cake together at the evening event of their special day", "Rob sitting on the Grooms seat after the evening meal! we had a lovely roast chicken meal!"};
    int[] weddingImages = {R.drawable.craigwaiting, R.drawable.craigandkim, R.drawable.kidsatalter, R.drawable.cuttingcake, R.drawable.robonchair};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //BUTTON CODE
        Button buttonHome = (Button)findViewById(R.id.btn_home);
        Button buttonAdd = (Button)findViewById(R.id.btn_add);
        Button buttonClear = (Button)findViewById(R.id.btn_clear);
        spinner = (Spinner) findViewById(R.id.selector);


        //when clicked
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                openActivityHome();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                openActivityJournals();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                spinner.setSelection(0);
                clickClear();
            }
        });



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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Places, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        //display toast message based on what item is selected
        String text = parent.getItemAtPosition(i).toString();


        if (text.equals(""))
        {
            //adapter
            placesAdapter = new PlacesAdapter(this, noNameList, noDateList, noDescriptionList, noImages);
            recyclerView.setAdapter(placesAdapter);
        }
        else if (text.equals("Paris"))
        {
            //adapter
            placesAdapter = new PlacesAdapter(this, parisNameList, parisDateList, parisDescriptionList, parisImages);
            recyclerView.setAdapter(placesAdapter);

            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }
        else if (text.equals("New York"))
        {
            //adapter
            placesAdapter = new PlacesAdapter(this, newyorkNameList, newyorkDateList, newyorkDescriptionList, newyorkImages);
            recyclerView.setAdapter(placesAdapter);

            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }
        else if (text.equals("Tokyo"))
        {
            //adapter
            placesAdapter = new PlacesAdapter(this, tokyoNameList, tokyoDateList, tokyoDescriptionList, tokyoImages);
            recyclerView.setAdapter(placesAdapter);

            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }
        else if (text.equals("Craig and Kims Wedding"))
        {
            //adapter
            placesAdapter = new PlacesAdapter(this, weddingNameList, weddingDateList, weddingDescriptionList, weddingImages);
            recyclerView.setAdapter(placesAdapter);

            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }








    public void openActivityHome(){
        //intent to navigate to journals page
        Intent intent = new Intent(DisplayActivity.this, HomeActivity.class);
        startActivity(intent);

        //display toast message to inform of relocation to journals page
        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
    }

    public void openActivityJournals(){
        //intent to navigate to journals page
        Intent intent = new Intent(DisplayActivity.this, JournalsActivity.class);
        startActivity(intent);

        //display toast message to inform of relocation to journals page
        Toast.makeText(this, "Add Journal Entry", Toast.LENGTH_SHORT).show();
    }


    public void clickClear(){
        //display toast message to inform of relocation to journals page
        Toast.makeText(this, "Page Cleared", Toast.LENGTH_SHORT).show();
    }
}
