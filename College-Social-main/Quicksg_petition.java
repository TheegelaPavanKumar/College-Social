package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Quicksg_petition extends AppCompatActivity {
    private ImageButton leftpet;
    private ImageButton rightpet;
    private void startqsgactivity2(Intent intent){ startActivity(intent); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quicksg_petition);

        leftpet=(ImageButton)findViewById(R.id.leftpetition);
        rightpet=(ImageButton)findViewById(R.id.rightpetition);

        leftpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leftpetition = new Intent(Quicksg_petition.this, Quicksg_profile.class);
                startqsgactivity2(leftpetition);
            }
        });
        rightpet.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rightpetition = new Intent(Quicksg_petition.this, Quicksg_findFriends.class);
                startqsgactivity2(rightpetition);
            }
        }));

    }
}
