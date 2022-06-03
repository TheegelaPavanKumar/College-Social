package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Petition extends AppCompatActivity {
    private Button Btnmovefilepetition;
    private Button Btnmovemypetition;
    private Button Btnmovesignp;

    private void startMyActivitypet(Intent intent){

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition);

        Btnmovefilepetition=findViewById(R.id.button6);
        Btnmovemypetition=findViewById(R.id.button7);
        Btnmovesignp=findViewById(R.id.button8);

        Btnmovefilepetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntentpet = new Intent(Petition.this, petition_filepetition.class);
                startMyActivitypet(myIntentpet);
            }
        });
        Btnmovemypetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntentpet = new Intent(Petition.this, petition_mypetitions.class);
                startMyActivitypet(myIntentpet);
            }
        });
        Btnmovesignp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntentpet = new Intent(Petition.this, petition_signpetition.class);
                startMyActivitypet(myIntentpet);
            }
        });
    }
    }

