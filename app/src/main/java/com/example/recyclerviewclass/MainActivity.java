package com.example.recyclerviewclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> listHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listHeroes = new ArrayList<>();
        rvHeroes = findViewById(R.id.rvHeroes);

        listHeroes.add(new Hero("Rajesh Hamal", R.drawable.rajesh, "9808046576", 9));
        listHeroes.add(new Hero("Bhuwan KC", R.drawable.bhuwan, "9804087659", 0));
        listHeroes.add(new Hero("Dayahang Lama", R.drawable.dahayang, "9811346657", 3));
        listHeroes.add(new Hero("Saugat Malla", R.drawable.saugat, "9845685264", 8));

        HeroAdapter adapter = new HeroAdapter(this, listHeroes);
        rvHeroes.setAdapter(adapter);
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
    }
}