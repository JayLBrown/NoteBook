package com.example.notebookresearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new RecyclerViewAdapter(this, getMyList());
        mRecyclerView.setAdapter(recyclerViewAdapter);

    }

    private ArrayList<PostModel> getMyList() {

        ArrayList<PostModel> models = new ArrayList<>();

        PostModel m = new PostModel();
        m.setTitle("Feed");
        m.setDecription("This is the description");
        m.setImg(R.drawable.m);
        models.add(m);

        PostModel a = new PostModel();
        a.setTitle("Feed");
        a.setDecription("This dff is the description");
        a.setImg(R.drawable.m);
        models.add(a);

        PostModel b = new PostModel();
        b.setTitle("Feeddf d ");
        b.setDecription("This fdf is the description");
        b.setImg(R.drawable.harvard);
        models.add(b);

        return models;

    }
}
