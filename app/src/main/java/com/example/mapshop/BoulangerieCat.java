package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BoulangerieCat extends AppCompatActivity {
    public ImageView Ibread,Icake;
    public static final String cat="cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boulangerie_cat);

        Icake=findViewById(R.id.cake);
        Ibread=findViewById(R.id.bread);




        Icake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BoulangerieCat.this,HomeActivity.class);
                intent.putExtra(cat,"J");

                startActivity(intent);
                finish();
            }
        });
        Ibread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BoulangerieCat.this,HomeActivity.class);
                intent.putExtra(cat,"A");

                startActivity(intent);
                finish();
            }
        });
    }
}
