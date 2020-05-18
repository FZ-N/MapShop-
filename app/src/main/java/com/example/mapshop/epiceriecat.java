package com.example.mapshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class epiceriecat extends AppCompatActivity {

    public ImageView Iepicerie,Idrink;
    public static final String cat="cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epiceriecat);

        Iepicerie=findViewById(R.id.epicerie);
        Idrink=findViewById(R.id.drink);




        Idrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(epiceriecat.this,HomeActivity.class);
                intent.putExtra(cat,"Q");

                startActivity(intent);
                finish();
            }
        });
        Iepicerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(epiceriecat.this,HomeActivity.class);
                intent.putExtra(cat,"H");

                startActivity(intent);
                finish();
            }
        });
    }
}
