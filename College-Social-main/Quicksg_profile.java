package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Quicksg_profile extends AppCompatActivity {
    private ImageButton leftprofile;
    private ImageButton rightprofile;

    private void startqsgactivity1(Intent intent){ startActivity(intent); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quicksg_profile);

        leftprofile=findViewById(R.id.profileLeft);
        rightprofile=findViewById(R.id.profileRight);

        leftprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leftpro = new Intent(Quicksg_profile.this, Quicksg.class);
                startqsgactivity1(leftpro);

            }
        });

        rightprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rightpro = new Intent(Quicksg_profile.this, Quicksg_petition.class);
                startqsgactivity1(rightpro);
            }
        });
    }
}
