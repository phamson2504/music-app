package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Item> items;
    IteamAdapter adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy);
        items = new ArrayList<>();
        items.add(new Item("Electric Feel","MGMT",R.drawable.n1));
        items.add(new Item("Electric Feel","MGMT",R.drawable.n1));
        items.add(new Item("Willow","Taylor Swift",R.drawable.n3));
        items.add(new Item("Pumped up kicks","Foster the people",R.drawable.n2));
        adt = new IteamAdapter(MainActivity.this,items);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adt);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}