package com.example.dissapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class JournalsActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journals);


        //assign button variable to buttons
        Button button = (Button)findViewById(R.id.btn_home);
        Button button1 = (Button)findViewById(R.id.btn_clear);
        Button buttonupload = (Button)findViewById(R.id.btnUpload);
        Button buttonJournals = (Button)findViewById(R.id.btn_journals);
        final TextView title = (TextView)findViewById(R.id.txt_title);
        final TextView description = (TextView)findViewById(R.id.txt_des);



        //home button click
        button.setOnClickListener(new View.OnClickListener() {
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
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                title.setText("");
                description.setText("");
                clickCLear();
            }
        });
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
        Toast.makeText(this, "Opening Photos", Toast.LENGTH_SHORT).show();
    }

    public void clickCLear(){
        //display toast message
        Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();
    }
}
