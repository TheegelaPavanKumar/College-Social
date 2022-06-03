package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Quicksg_chats extends AppCompatActivity {
    private ImageButton leftBtn;
    private void startqsgactivity4(Intent intent){ startActivity(intent); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quicksg_chats);

        leftBtn=(ImageButton)findViewById(R.id.leftchats);

        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leftchats = new Intent(Quicksg_chats.this, Quicksg_findFriends.class);
                startqsgactivity4(leftchats);
            }
        });
    }
}
