package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class message extends AppCompatActivity  implements View.OnClickListener {

    private ImageView logout;
    private ImageView logo;
    private ImageView user;

    private static final String TAG = "message";

    private static final String KEY_TITLE = "mail";
    private static final String KEY_DESCRIPTION = "message";


    private EditText editText;
    private FirebaseAuth mAuth;
    private TextView mail;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
    String currentDateandTime = sdf.format(new Date());
    private DocumentReference noteRef = db.document("contact/"+currentDateandTime);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        logout =(ImageView) findViewById(R.id.logout);
        logo=(ImageView) findViewById(R.id.logo);
        user=(ImageView) findViewById(R.id.user);
        logout.setOnClickListener(this);
        logo.setOnClickListener(this);
        user.setOnClickListener(this);
        editText = findViewById(R.id.msg);
        mail = findViewById(R.id.mail);
        mAuth = FirebaseAuth.getInstance();
        String email = mAuth.getCurrentUser().getEmail();
        mail.setText("Votre mail: "+email);
    }

    public void saveNote(View v) {
        mail = findViewById(R.id.mail);
        mAuth = FirebaseAuth.getInstance();
        String userm = mAuth.getCurrentUser().getEmail();
        String text = editText.getText().toString();

        Map<String, Object> note = new HashMap<>();
        note.put(KEY_TITLE, userm);
        note.put(KEY_DESCRIPTION, text);

        noteRef.set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(message.this, "Votre message a bien été envoyé", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), message.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(message.this, "Erreur!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });


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