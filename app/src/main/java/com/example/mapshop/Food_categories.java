package com.example.mapshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Food_categories extends AppCompatActivity {
    public static final String cat="cat";

    public ImageView Iveg_fruits,Icream,Imeat_fish,Iepicerie,Ilaitrie,IBoulangerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_categories);

        Iveg_fruits=findViewById(R.id.veg_fruits);
        Icream=findViewById(R.id.cream);
        Imeat_fish=findViewById(R.id.meat_fish);
        Iepicerie=findViewById(R.id.epecrie);
        Ilaitrie=findViewById(R.id.laitrie);
        IBoulangerie=findViewById(R.id.boulangerie);



        Iveg_fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Food_categories.this,veg_fruitsCat.class);
                startActivity(intent);
                finish();
            }
        });
        IBoulangerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Food_categories.this,BoulangerieCat.class);
                startActivity(intent);
                finish();

            }
        });
        Iepicerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Food_categories.this,epiceriecat.class);
                startActivity(intent);
                finish();
            }
        });
        Imeat_fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Food_categories.this,meat_fishCat.class);
                startActivity(intent);
                finish();
            }
        });
        Ilaitrie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Food_categories.this,laiterieCat.class);
                startActivity(intent);
                finish();
            }
        });
        Icream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Food_categories.this,HomeActivity.class);
                intent.putExtra(cat,"I");
                startActivity(intent);
                finish();

            }
        });
    }
}
