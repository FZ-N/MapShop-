package com.example.mapshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class laiterieCat extends AppCompatActivity {

    public ImageView Icheese,Imilk;
    public static final String cat="cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laiterie_cat);

        Icheese=findViewById(R.id.cheese);
        Imilk=findViewById(R.id.milk);




        Icheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(laiterieCat.this,HomeActivity.class);
                intent.putExtra(cat,"N");

                startActivity(intent);
                finish();
            }
        });
        Imilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(laiterieCat.this,HomeActivity.class);
                intent.putExtra(cat,"O");

                startActivity(intent);
                finish();
            }
        });
    }}
