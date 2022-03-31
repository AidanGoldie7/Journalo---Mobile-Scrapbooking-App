package com.example.dissapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class JournalsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journals);

        //assign button variable to buttons
        Button buttonHome = (Button)findViewById(R.id.btn_home);
        Button buttonClear = (Button)findViewById(R.id.btn_clear);
        Button buttonupload = (Button)findViewById(R.id.btnUpload);
        Button buttonAdd = (Button)findViewById(R.id.btn_journals2);
        Button buttonSubmit = (Button)findViewById(R.id.btn_submit);
        Button buttonJournals = (Button)findViewById(R.id.btn_journals);
        final ImageView imagePreview = (ImageView)findViewById(R.id.imageThumb);
        final TextView title = (TextView)findViewById(R.id.txt_title);
        final TextView description = (TextView)findViewById(R.id.txt_des);
        final TextView journalTitle = (TextView)findViewById(R.id.addNew);
        final TextView journalDate = (TextView)findViewById(R.id.txtDate);



        //home button click
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                openActivityHome();
            }
        });

        //journals button click
        buttonJournals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                openActivityJournals();
            }
        });

        buttonupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                clickUpload();
            }
        });

        //clear button click
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                title.setText("");
                description.setText("");
                journalDate.setText("");
                imagePreview.setImageResource(R.drawable.noimage);
                clickCLear();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                openActivityAddJournal();
            }
        });



        //home button click
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                if (TextUtils.isEmpty(title.getText()) || TextUtils.isEmpty(description.getText()) || TextUtils.isEmpty(journalTitle.getText()) || TextUtils.isEmpty((journalDate.getText())))
                {
                    submitFail();
                }
                else{
                    submitSuccess();
                }
            }
        });


        //SPINNER CODE
        Spinner spinner = (Spinner) findViewById(R.id.spinner_Journals);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Places, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }




    public void openActivityHome(){
        //intent to navigate to journals page
        Intent intent = new Intent(JournalsActivity.this, HomeActivity.class);
        startActivity(intent);

        //display toast message to inform of relocation to journals page
        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
    }


    public void openActivityJournals(){
        //intent to navigate to journals page
        Intent intent = new Intent(JournalsActivity.this, DisplayActivity.class);
        startActivity(intent);

        //display toast message to inform of relocation to journals page
        Toast.makeText(this, "My Journals", Toast.LENGTH_SHORT).show();
    }

    public void clickUpload(){
        //display toast message
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 1010);

        Toast.makeText(this, "Opening Photos", Toast.LENGTH_SHORT).show();
    }

    public void clickCLear(){
        //display toast message
        Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();
    }

    public void submitSuccess(){
        //display toast message
        Toast.makeText(this, "Saving to cloud...", Toast.LENGTH_SHORT).show();
    }

    public void submitFail(){
        //display toast message
        Toast.makeText(this, "Please ensure all text fields are filled in!", Toast.LENGTH_SHORT).show();
    }

    public void openActivityAddJournal(){
        //display toast message
        Toast.makeText(this, "Add Journal Entry", Toast.LENGTH_SHORT).show();
    }





    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1010) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            ImageView imageview = (ImageView) findViewById(R.id.imageThumb); //sets imageview as the bitmap
            imageview.setImageBitmap(image);
        }
    }






    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//display toast message based on what item is selected
        String text = adapterView.getItemAtPosition(i).toString();
        EditText addNewJournal = (EditText)findViewById(R.id.addNew);

        if (text.equals(""))
        {
            addNewJournal.setVisibility(TextView.VISIBLE);
            addNewJournal.setText(text);
        }
        else
            {
            addNewJournal.setVisibility(TextView.VISIBLE);
            addNewJournal.setText(text);
            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
