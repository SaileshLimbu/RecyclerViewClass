package com.example.recyclerviewclass;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {
    private Context context;
    private ArrayList<Hero> listHeroes;

    public HeroAdapter(Context context, ArrayList<Hero> listHeroes) {
        this.context = context;
        this.listHeroes = listHeroes;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder heroViewHolder, int i) {
        final Hero hero = listHeroes.get(i);
        heroViewHolder.imgHero.setImageResource(hero.getImg());
        heroViewHolder.tvName.setText(hero.getName());
        heroViewHolder.tvPhoneNumber.setText(hero.getPhoneNo());
        if (hero.getNumMessage() != 0) {
            heroViewHolder.tvNumMessage.setText(hero.getNumMessage() + "");
        } else {
            heroViewHolder.tvNumMessage.setVisibility(View.GONE);
            heroViewHolder.imgTick.setVisibility(View.VISIBLE);
        }

        heroViewHolder.imgHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name", hero.getName());
                intent.putExtra("image", hero.getImg());
                intent.putExtra("phoneNumber", hero.getPhoneNo());
                intent.putExtra("email", hero.getEmail());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHeroes.size();

    }

    public void filterList(ArrayList<Hero> listHeroes) {
        this.listHeroes = listHeroes;
        notifyDataSetChanged();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvPhoneNumber, tvNumMessage;
        ImageView imgHero, imgTick;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            tvNumMessage = itemView.findViewById(R.id.tvNumMessage);
            imgHero = itemView.findViewById(R.id.imgHero);
            imgTick = itemView.findViewById(R.id.imgTick);
        }
    }
}