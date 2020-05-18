package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Shop extends AppCompatActivity implements View.OnClickListener {

    private ImageView logout;
    private ImageView logo;
    private ImageView user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        logout =(ImageView) findViewById(R.id.logout);
        logo=(ImageView) findViewById(R.id.logo);
        user=(ImageView) findViewById(R.id.user);
        logout.setOnClickListener(this);
        logo.setOnClickListener(this);
        user.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.logout :logout();
                break;

            case R.id.logo :back();
                break;

            case R.id.user :moncompte();
                break;

        }
    }


    private void logout() {
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
        finish();
    }

    private void back() {
        Intent intent = new Intent(this,First.class);
        startActivity(intent);
        finish();
    }

    private void moncompte() {
        Intent intent = new Intent(this,Moncompte.class);
        startActivity(intent);
        finish();
    }
}
