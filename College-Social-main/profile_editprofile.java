package com.app.collegesocial2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.proto.TargetGlobal;

import java.util.HashMap;
import java.util.Map;

public class profile_editprofile extends AppCompatActivity {

    public static final String TAG = "TAG";
    private FirebaseFirestore test;
    private String userID;
    private FirebaseAuth fAuth;
    private EditText username;
    private String Title,Title1,Title2,Title3;
    private Button editBtn;
    private EditText interest1;
    private EditText interest2;
    private EditText wtl;
    private Button int1btn;
    private Button int2btn;
    private Button wtl2btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_editprofile);
        username=(EditText) findViewById(R.id.username);
        editBtn= (Button) findViewById(R.id.editButton);
        int1btn= (Button) findViewById(R.id.interest1btn);
        int2btn= (Button) findViewById(R.id.interest2btn);
        wtl2btn= (Button) findViewById(R.id.wtl2btn);
        interest1= (EditText) findViewById(R.id.editText3);
        interest2= (EditText) findViewById(R.id.editText4);
        wtl=(EditText) findViewById(R.id.editText5);


        fAuth= FirebaseAuth.getInstance();

        test= FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        DocumentReference documentReference= test.collection("BennettUniversity").document(userID);



        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = username.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("username", Title);
                test.collection("BennettUniversity").document(userID).set(user, SetOptions.merge());


            }
        });
        int1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title1 = interest1.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("interest 1", Title1);
                test.collection("BennettUniversity").document(userID).set(user, SetOptions.merge());



            }
        });
        int2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title2 = interest2.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("interest 2", Title2);
                test.collection("BennettUniversity").document(userID).set(user, SetOptions.merge());


            }
        });
        wtl2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title3 = wtl.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("want to learn", Title3);
                test.collection("BennettUniversity").document(userID).set(user, SetOptions.merge());

            }
        });











    }
}
