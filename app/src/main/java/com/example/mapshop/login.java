package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private static final String TAG = "login";
    FirebaseAuth fAuth;
    EditText email,pass;
    Button mlogin;
    TextView mCreateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);
        FirebaseAuth.getInstance().signOut();
    email= findViewById(R.id.editText5);
    pass= findViewById(R.id.pwd);
     mCreateBtn= findViewById(R.id.createText);
      mlogin= findViewById(R.id.login);

        fAuth = FirebaseAuth.getInstance();



      mlogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String mail = email.getText().toString();
              String password = pass.getText().toString();


              if(TextUtils.isEmpty(mail))
              {
                  email.setError("Veuillez entrer votre mail");
                  return;
              }
              if(TextUtils.isEmpty(password)){
                  pass.setError("Le mot de passe doit contenir au moins 6 caractères ");
                  return;
              }



              fAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful() && !mail.isEmpty()){
                          //Toast.makeText(login.this, "Vous êtes connecté",Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(getApplicationContext(),First.class));
                      } else
                      {
                          Toast.makeText(login.this,"Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                  }
                  }
              });
          }
      });

      mCreateBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(getApplicationContext(),signup.class));
          }
      });

    }







}
