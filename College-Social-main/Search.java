package com.app.collegesocial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class Search extends AppCompatActivity {
    private EditText search_field;
    private ImageButton searchBtn;
    private RecyclerView mResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_field= (EditText) findViewById(R.id.search_text);
        searchBtn=(ImageButton) findViewById(R.id.search_button);
        mResultList=(RecyclerView) findViewById(R.id.result_list);


    }
}
