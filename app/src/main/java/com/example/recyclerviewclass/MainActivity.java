package com.example.recyclerviewclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> listHeroes;
    private EditText etSearch;
    private HeroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listHeroes = new ArrayList<>();
        rvHeroes = findViewById(R.id.rvHeroes);
        etSearch = findViewById(R.id.etSearch);

        listHeroes.add(new Hero("Rajesh Hamal", R.drawable.rajesh, "9808046576", 9, "rajeshdai@gmail.com"));
        listHeroes.add(new Hero("Bhuwan KC", R.drawable.bhuwan, "9804087659", 0, "bhuwandai@gmail.com"));
        listHeroes.add(new Hero("Dayahang Lama", R.drawable.dahayang, "9811346657", 3, "dayahangdai@gmail.com"));
        listHeroes.add(new Hero("Saugat Malla", R.drawable.saugat, "9845685264", 8, "saugatdai@gmail.com"));

        adapter = new HeroAdapter(this, listHeroes);
        rvHeroes.setAdapter(adapter);
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<Hero> filtered = new ArrayList<>();
                String filterText = s.toString().toLowerCase();

                for (Hero hero : listHeroes) {
                    String heroName = hero.getName().toLowerCase();
                    if (heroName.contains(filterText)) {
                        filtered.add(hero);
                    }
                }
                adapter.filterList(filtered);
            }
        });
    }
}