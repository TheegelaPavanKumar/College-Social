package com.app.collegesocial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Toolbar mainToolbar;
    private Button BtnMove;
    private Button BtnMoveProfile;
    private Button BtnMoveChats;
    private Button BtnMoveSearch;
    private Button BtnMoveqsg;

    private void startMyActivity(Intent intent){
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mainToolbar=(Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("College Social");

        BtnMove=findViewById(R.id.button2);
        BtnMoveProfile=findViewById(R.id.button3);
        BtnMoveChats=findViewById(R.id.button);
        BtnMoveSearch=findViewById(R.id.button4);
        BtnMoveqsg=findViewById(R.id.button5);

        BtnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Petition.class);
                startMyActivity(myIntent);
            }
        });
        BtnMoveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(MainActivity.this, Profile.class);
                startMyActivity(myIntent);
            }
        });
        BtnMoveChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(MainActivity.this, Chats.class);
                startMyActivity(myIntent);
            }
        });
        BtnMoveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(MainActivity.this, Search.class);
                startMyActivity(myIntent);
            }
        });
        BtnMoveqsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(MainActivity.this, Quicksg.class);
                startMyActivity(myIntent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if(currentUser == null){
                    sendToLogin();
                }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);




        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.action_Logout_btn:
                logOut();

                return true;

            default:
                return false;

        }


    }

    private void logOut() {

        mAuth.signOut();
        sendToLogin();

    }

    private void sendToLogin() {

        Intent loginIntent= new Intent(MainActivity.this, loginpage.class);
        startActivity(loginIntent);
        finish();
    }

}


