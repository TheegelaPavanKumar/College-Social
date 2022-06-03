package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Quicksg_findFriends extends AppCompatActivity {

    private ImageButton leftbtn;
    private ImageButton rightbtn;
    private void startqsgactivity3(Intent intent){ startActivity(intent); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quicksg_find_friends);

        leftbtn=(ImageButton)findViewById(R.id.leftfriends);
        rightbtn=(ImageButton)findViewById(R.id.rightfriends);

        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leftfriends = new Intent(Quicksg_findFriends.this, Quicksg_petition.class);
                startqsgactivity3(leftfriends);
            }
        });
        rightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rightfriends = new Intent(Quicksg_findFriends.this, Quicksg_chats.class);
                startqsgactivity3(rightfriends);
            }
        });
    }
}
