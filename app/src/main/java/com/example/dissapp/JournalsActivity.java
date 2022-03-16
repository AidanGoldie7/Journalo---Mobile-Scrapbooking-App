package com.example.dissapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JournalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journals);


        //assign button variable to created button
        Button button = (Button)findViewById(R.id.btn_home);


        //on button click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click handling code
                openActivityHome();
            }
        });
    }

    public void openActivityHome(){
        //intent to navigate to journals page
        Intent intent = new Intent(JournalsActivity.this, HomeActivity.class);
        startActivity(intent);

        //display toast message to inform of relocation to journals page
        Toast.makeText(this, "Home Page", Toast.LENGTH_SHORT).show();
    }
}
