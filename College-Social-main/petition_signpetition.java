package com.app.collegesocial2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class petition_signpetition extends AppCompatActivity implements FirestoreAdapter.OnListItemClick {

    private RecyclerView mFirestoreList;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth fAuth;
    private String userID;

    private FirestoreAdapter adapter;
    private TextView blind;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_signpetition);

        mFirestoreList = findViewById(R.id.firestore_list);
        blind=findViewById(R.id.blind);

        firebaseFirestore = FirebaseFirestore.getInstance();
        fAuth= FirebaseAuth.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        DocumentReference documentReference= firebaseFirestore.collection("BennettUniversity").document(userID);

        //Query
        Query query = firebaseFirestore.collection("BennettUniversity");
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(3)
                .build();
        //Recycler Options
        FirestorePagingOptions<PetitionModel> options = new FirestorePagingOptions.Builder<PetitionModel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, PetitionModel.class)
                .build();

        adapter = new FirestoreAdapter(options, this);

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);


    }

    @Override
    public void onItemClick() {


        Log.d("Item clicked", "clicked an item");
        Toast.makeText(this, "voted", Toast.LENGTH_SHORT).show();
    }
}
