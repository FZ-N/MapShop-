package com.example.mapshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class meat_fishCat extends AppCompatActivity {
    public ImageView Imeat,Ifish;
    public static final String cat="cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat_fish_cat);

        Imeat=findViewById(R.id.meat);
        Ifish=findViewById(R.id.fish);




        Imeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(meat_fishCat.this,HomeActivity.class);
                intent.putExtra(cat,"G");

                startActivity(intent);
                finish();
            }
        });
        Ifish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(meat_fishCat.this,HomeActivity.class);
                intent.putExtra(cat,"B");

                startActivity(intent);
                finish();
            }
        });
    }
}
