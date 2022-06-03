package com.app.collegesocial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class createaccount extends AppCompatActivity {

    private EditText reg_email_field;
    private EditText reg_pass_field;
    private EditText reg_confirm_pass_field;
    private Button reg_btn;
    private Button reg_login_btn;
    private void startMyActivitycreate(Intent intent){
        startActivity(intent);
    }
    private ProgressBar pBar2;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        pBar2=(ProgressBar)findViewById(R.id.progressBar2);

        mAuth=FirebaseAuth.getInstance();


        reg_email_field=(EditText) findViewById(R.id.reg_email);
        reg_pass_field=(EditText) findViewById(R.id.reg_password);
        reg_confirm_pass_field=(EditText) findViewById(R.id.reg_confirm_pass);
        reg_btn=(Button) findViewById(R.id.reg_btn);
        reg_login_btn=(Button) findViewById(R.id.reg_Login_btn);



        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= reg_email_field.getText().toString();
                String pass = reg_pass_field.getText().toString();
                String confirm_pass = reg_confirm_pass_field.getText().toString();


                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) &  !TextUtils.isEmpty(confirm_pass)){

                    if(pass.equals(confirm_pass)){
                        pBar2.setVisibility(View. VISIBLE);

                        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    pBar2.setVisibility(View. INVISIBLE);

                                    sendToMain();
                                } else{

                                    String errorMessage = task.getException().getMessage();
                                    Toast.makeText(createaccount.this, "Error : "+ errorMessage, Toast.LENGTH_SHORT).show();



                                }

                            }
                        });


                    }else{

                        Toast.makeText(createaccount.this, "Confirm password and Set password fields don't match", Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });
        reg_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(createaccount.this, loginpage.class);
                startActivity(loginIntent);
                finish();
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser= mAuth.getCurrentUser();
        if(currentUser != null){

            sendToMain();


        }
    }

    private void sendToMain() {

        Intent mainIntent= new Intent(createaccount.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
        Toast.makeText(createaccount.this, "finish setting up account in profile settings", Toast.LENGTH_LONG).show();

    }


}
