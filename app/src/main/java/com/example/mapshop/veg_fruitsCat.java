package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class veg_fruitsCat extends AppCompatActivity {
    public ImageView Iveg,Ifruits;
    public static final String cat="cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_fruits_cat);

        Iveg=findViewById(R.id.veg);
        Ifruits=findViewById(R.id.fruit);




        Iveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(veg_fruitsCat.this,HomeActivity.class);
                intent.putExtra(cat,"E");

                startActivity(intent);
                finish();
            }
        });
        Ifruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(veg_fruitsCat.this,HomeActivity.class);
                intent.putExtra(cat,"F");

                startActivity(intent);
                finish();
            }
        });
    }
}

