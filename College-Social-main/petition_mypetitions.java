package com.app.collegesocial2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SnapshotMetadata;

import java.util.HashMap;
import java.util.Map;

public class petition_mypetitions extends AppCompatActivity {
    private TextView title;
    private TextView number;
    private Button remove_pet;
    private FirebaseAuth fAuth;
    private FirebaseFirestore test;
    private String userID;
    private TextView vote;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_mypetitions);

        title=(TextView)findViewById(R.id.yourpet_title);
        number=(TextView)findViewById(R.id.number_yes);
        remove_pet=(Button)findViewById(R.id.remove_pet_btn);
        vote=(TextView)findViewById(R.id.number_yes);

        test=FirebaseFirestore.getInstance();
        fAuth=FirebaseAuth.getInstance();

        userID=fAuth.getCurrentUser().getUid();
        final DocumentReference documentReference=test.collection("BennettUniversity").document(userID);

        remove_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> user = new HashMap<>();
                user.put("title", FieldValue.delete());
                user.put("content", FieldValue.delete());

                documentReference.update(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) { }

                });
                //(end)


            }
        });
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                title.setText(documentSnapshot.getString("title"));

            }
        });









    }
}
