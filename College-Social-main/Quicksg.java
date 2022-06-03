package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Quicksg extends AppCompatActivity {
    public ImageButton imgbtn;
    public Button homebtn;
    private void startqsgactivity(Intent intent){ startActivity(intent); }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quicksg);

        imgbtn=(ImageButton)findViewById(R.id.imageButton);
        homebtn=(Button)findViewById(R.id.button11);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(Quicksg.this, MainActivity.class);
                startqsgactivity(activity);
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qsgIntent= new Intent(Quicksg.this, Quicksg_profile.class);
                startqsgactivity(qsgIntent);


            }
        });
    }
}
