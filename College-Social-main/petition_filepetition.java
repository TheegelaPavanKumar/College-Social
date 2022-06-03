package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class petition_filepetition extends AppCompatActivity {

    private FirebaseFirestore test;
    private FirebaseAuth fAuth;
    private String userID;
    private EditText title;
    private EditText content;
    private String s1,s2;
    private Button publish;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_filepetition);

        publish=(Button)findViewById(R.id.publish_button);
        title=(EditText)findViewById(R.id.title_field);
        content=(EditText)findViewById(R.id.content_field);

        fAuth=FirebaseAuth.getInstance();
        test=FirebaseFirestore.getInstance();
        userID=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference= test.collection("BennettUniversity").document(userID);

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1= title.getText().toString();
                String s2 = content.getText().toString();
                Map<String, Object> user = new HashMap<>();
                user.put("title", s1);
                user.put("content", s2);
                test.collection("BennettUniversity").document(userID).set(user, SetOptions.merge());
                if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2)){
                    Toast.makeText(petition_filepetition.this, "Petition published", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(petition_filepetition.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
