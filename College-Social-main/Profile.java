package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {
    private Button Btnmoveviewprofile;
    private Button Btnmoveeditprofile;

    private void startMyActivityprofile(Intent intent){
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Btnmoveviewprofile=findViewById(R.id.button9);
        Btnmoveeditprofile=findViewById(R.id.button10);

        Btnmoveviewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntentpro = new Intent(Profile.this, profile_viewprofile.class);
                startMyActivityprofile(myIntentpro);
            }
        });
        Btnmoveeditprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntentpro = new Intent(Profile.this, profile_editprofile.class);
                startMyActivityprofile(myIntentpro);
            }
        });
    }
}
