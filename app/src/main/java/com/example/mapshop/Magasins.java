package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Magasins extends AppCompatActivity implements View.OnClickListener {

    private ImageView logout;
    private ImageView marjane;
    private ImageView user;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magasins);
        logout =(ImageView) findViewById(R.id.logout);
        marjane =(ImageView) findViewById(R.id.marjane);
        user =(ImageView) findViewById(R.id.user);
        logo  =(ImageView) findViewById(R.id.logo);

        logo.setOnClickListener(this);
        logout.setOnClickListener(this);
        marjane.setOnClickListener(this);
        user.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.logout :logout();
                break;

            case R.id.user :moncompte();
                break;
            case R.id.marjane :myshop();
                break;
            case R.id.logo :back();
                break;
        }
    }


    private void logout() {
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
        finish();
    }
    private void myshop() {
        Intent intent = new Intent(this,categories.class);
        startActivity(intent);
        finish();
    }
    private void moncompte() {
        Intent intent = new Intent(this,Moncompte.class);
        startActivity(intent);
        finish();
    }
    private void back() {
        Intent intent = new Intent(this,First.class);
        startActivity(intent);
        finish();
    }
}