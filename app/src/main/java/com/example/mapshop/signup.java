package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private static final String TAG = "signup";

    private static final String KEY1 = "prenom";
    private static final String KEY2 = "nom";
    private static final String KEY3 = "mail";
    private static final String KEY4 = "password";
    private EditText nom;
    private EditText editText_1;
    private EditText editText_2;
    private EditText editText_3;
    private EditText editText_4;
    private ImageView user;

    FirebaseAuth mAuth;
    Button msave;
    FirebaseAuth fAuth;

  //  private FirebaseFirestore db = FirebaseFirestore.getInstance();
   // private DocumentReference noteRef = db.document("compte/raefat2");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        editText_2  = findViewById(R.id.prenom);
        user  = findViewById(R.id.logo);
        editText_3 = findViewById(R.id.mail);
        editText_4 = findViewById(R.id.pwd);
        msave = findViewById(R.id.save);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });
        fAuth = FirebaseAuth.getInstance();



        msave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = editText_2.getText().toString();
                String mail = editText_3.getText().toString();
                String password = editText_4.getText().toString();


                if (TextUtils.isEmpty(mail)) {
                    editText_3.setError("Veuillez entrer votre mail");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    editText_4.setError("Le mot de passe doit contenir au moins  6 caractères");
                    return;
                }
                if (TextUtils.isEmpty(nom)) {
                    editText_3.setError("Veuillez entrer votre nom");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(getApplicationContext(), Firstlogin.class);
                           intent.putExtra("name",nom);
                           startActivity(intent);
                        } else {
                            Toast.makeText(signup.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }



}
