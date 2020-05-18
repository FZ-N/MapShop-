package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class categories extends AppCompatActivity {
//try to test commit
    public static final String cat="cat";

    public ImageView Ifood,Ihealthy,Ihyg,Ibook,Ibeauty,IiT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Ifood=findViewById(R.id.food);
        Ihealthy=findViewById(R.id.health);
        Ihyg=findViewById(R.id.hyg);
        Ibook=findViewById(R.id.books);
        Ibeauty=findViewById(R.id.beauty);
        IiT=findViewById(R.id.it);



        Ifood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(categories.this,Food_categories.class);
                startActivity(intent);
                finish();
            }
        });
        Ihealthy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(categories.this,HomeActivity.class);
                intent.putExtra(cat,"O");
                startActivity(intent);
                finish();

            }
        });
        Ibeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(categories.this,HomeActivity.class);
                intent.putExtra(cat,"M");
                startActivity(intent);
                finish();
            }
        });
        Ihyg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(categories.this,HomeActivity.class);
                intent.putExtra(cat,"A");
                startActivity(intent);
                finish();
            }
        });
        IiT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(categories.this,HomeActivity.class);
                intent.putExtra(cat,"N");
                startActivity(intent);
                finish();
            }
        });
        Ibook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(categories.this,HomeActivity.class);
                intent.putExtra(cat,"D");
                startActivity(intent);
                finish();

            }
        });
    }

}
