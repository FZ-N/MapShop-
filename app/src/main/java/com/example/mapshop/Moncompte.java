package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mapshop.Model.HisCart;
import com.example.mapshop.Model.Users;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Moncompte extends AppCompatActivity implements View.OnClickListener {

    private ImageView logout;
    private ImageView logo;
    private EditText prenom;
    private EditText nom;
    private EditText mail;
    private EditText pwd;
    private EditText adr;
    private EditText age;
    private String uid,genre;
    private RadioGroup bgenre;
    private RadioButton f;
    private RadioButton h;
    Button save;
    FirebaseAuth mAuth;
    FirebaseUser user;
    private String adresse;
    private static final String TAG = "Moncompte";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moncompte);
        logout =(ImageView) findViewById(R.id.logout);
        logo=(ImageView) findViewById(R.id.logo);
        logout.setOnClickListener(this);
        logo.setOnClickListener(this);
        prenom = findViewById(R.id.prenom);
        mail = findViewById(R.id.mail);
        pwd = findViewById(R.id.pwd);
        save = findViewById(R.id.save);
        adr = findViewById(R.id.adr);
        age = findViewById(R.id.age);
        mAuth = FirebaseAuth.getInstance();
        this.bgenre= (RadioGroup) this.findViewById(R.id.bgenre);
        this.h = (RadioButton) this.findViewById(R.id.h);
        this.f  =  (RadioButton)this.findViewById(R.id.f);
       user = mAuth.getCurrentUser();
            loadUserInformation();

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInformation();
            }
        });
    }





    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void loadUserInformation() {
        final FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            uid = user.getUid();
            if (user.getDisplayName() != null) {
                prenom.setText(user.getDisplayName());
            }

            mail.setText(user.getEmail());
            final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("users").child(uid);

            cartListRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    adr.setText(dataSnapshot.child("adr").getValue().toString());
                    age.setText(dataSnapshot.child("age").getValue().toString());
                    String res = dataSnapshot.child("genre").getValue().toString();
                    if ( res.equals("femme")){
                        bgenre.check(R.id.f);
                    }
                    else if (res.equals("homme")){
                        bgenre.check(R.id.h);
                    }

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });


        }
    }


    private void saveUserInformation() {

                // get selected radio button from radioGroup
                int selectedId = bgenre.getCheckedRadioButtonId();

                // find the radiobutton by returned id
            //    radioSexButton = (RadioButton) findViewById(selectedId);

  if(selectedId== R.id.h) {
            genre = "homme";
        }
        else
        {
            genre = "femme";
        }

        String displayName = prenom.getText().toString();

        if (displayName.isEmpty()) {
            nom.setError("Name required");
            nom.requestFocus();
            return;
        }


        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)
                    .build();
            HashMap<String, Object> ordersMap = new HashMap<>();
            ordersMap.put("adr", adr.getText().toString());
            ordersMap.put("age", age.getText().toString());
            ordersMap.put("genre", genre);
            uid = user.getUid();
            final DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference();
            ordersRef
                    .child("users")
                    .child(uid)
                    .updateChildren(ordersMap);
            user.updateProfile(profile)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Moncompte.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }


        String password = pwd.getText().toString();

        if (TextUtils.isEmpty(password)) {
            pwd.setError("Password Must be >= 6 characters");
        }
        else {
        updatePassword();}
        updateEmail();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.logout :logout();
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
    public void updateEmail() {
        // [START update_email]

        String email = mail.getText().toString();
        user.updateEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User email address updated.");
                        }
                    }
                });
        // [END update_email]
    }

    public void updatePassword() {
        // [START update_password]
        String newPassword = pwd.getText().toString();
        user.updatePassword(newPassword)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User password updated.");
                        }
                    }
                });
        // [END update_password]
    }

    private void back() {
        Intent intent = new Intent(this,First.class);
        startActivity(intent);
        finish();
    }
}
