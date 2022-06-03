package com.app.collegesocial2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import org.w3c.dom.Text;

public class profile_viewprofile extends AppCompatActivity {

    private FirebaseFirestore test;
    private FirebaseAuth fAuth;
    private TextView username, interest1, interest2, wtl;
    private String userID;
    public TextView blind_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_viewprofile);

        username=(TextView) findViewById(R.id.username_database);
        interest1=(TextView) findViewById(R.id.int1_database);
        interest2=(TextView) findViewById(R.id.int2_database);
        wtl= (TextView) findViewById(R.id.wtl_database);
        blind_data= (TextView) findViewById(R.id.blind);

        FirebaseFirestore test= FirebaseFirestore.getInstance();
        FirebaseAuth fAuth= FirebaseAuth.getInstance();

        userID=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = test.collection("BennettUniversity").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {



                username.setText(documentSnapshot.getString("username"));
                interest1.setText(documentSnapshot.getString("interest 1"));
                interest2.setText(documentSnapshot.getString("interest 2"));
                wtl.setText(documentSnapshot.getString("want to learn"));
            }
        });
    }
}
