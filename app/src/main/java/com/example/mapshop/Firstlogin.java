package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Firstlogin extends AppCompatActivity implements View.OnClickListener {
    private Button play;
    private Button play2;
    private Button play3;
    private ImageView logout;
    private ImageView message;
    private ImageView user;
    private  String name;
    FirebaseAuth mAuth;
    FirebaseUser userc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        logout =(ImageView) findViewById(R.id.logout);
        message =(ImageView) findViewById(R.id.message);
        user =(ImageView) findViewById(R.id.user);
        Intent intent = getIntent();
        play =(Button) findViewById(R.id.menu1);
        play2 =(Button) findViewById(R.id.menu2);
        play3 =(Button) findViewById(R.id.menu3);
        play.setOnClickListener(this);
        play2.setOnClickListener(this);
        play3.setOnClickListener(this);
        logout.setOnClickListener(this);
        message.setOnClickListener(this);
        user.setOnClickListener(this);
        name =intent.getStringExtra("name");
        Bundle bundle = intent.getExtras();

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            FirebaseUser userc = mAuth.getCurrentUser();
        if (userc != null) {
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(name)
                    .build();
            userc.updateProfile(profile);
            FirebaseAuth.getInstance().signOut();
             intent = new Intent(this,login.class);
            startActivity(intent);
            finish();
        }
    }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu1 :openMagasins();
            break;
            case R.id.menu2 :openH();
            break;
            case R.id.menu3 :openlist();
                break;
            case R.id.logout :logout();
                break;
            case R.id.message :message();
                break;
            case R.id.user :moncompte();
                break;
        }
    }
    private void openH() {
        Intent intent = new Intent(this,Historique.class);
        startActivity(intent);
        finish();
    }

    private void openMagasins() {
        Intent intent = new Intent(this,Magasins.class);
        startActivity(intent);
        finish();
    }

    private void openlist() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
        finish();
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),login.class));
        finish();
    }
    private void message() {
        Intent intent = new Intent(this,message.class);
        startActivity(intent);
        finish();
    }
    private void moncompte() {
        Intent intent = new Intent(this,Moncompte.class);
        startActivity(intent);
        finish();
    }
}
