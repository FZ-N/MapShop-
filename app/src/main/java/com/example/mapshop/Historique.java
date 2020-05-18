package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapshop.Model.HisCart;
import com.example.mapshop.ViewHolder.HisHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Historique extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private Button NextProcessBtn;
    private TextView txtTotalAmount, txtMsg1;
    private EditText listext;
    private int overTotalPrice = 0;
    private String cat = "";
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_his);

        mAuth = FirebaseAuth.getInstance();
        String name = mAuth.getCurrentUser().getDisplayName();
        recyclerView = findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
     //   layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        NextProcessBtn = (Button) findViewById(R.id.next_btn);
        txtTotalAmount = (TextView) findViewById(R.id.total_price);
        txtMsg1 = (TextView) findViewById(R.id.msg1);

        NextProcessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth = FirebaseAuth.getInstance();
                String name = mAuth.getCurrentUser().getDisplayName();
                Intent intent = new Intent(Historique.this, First.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        mAuth = FirebaseAuth.getInstance();
        String name = mAuth.getCurrentUser().getDisplayName();
        // CheckOrderState(name);


        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Orders");

        FirebaseRecyclerOptions<HisCart> options =
                new FirebaseRecyclerOptions.Builder<HisCart>()
                        .setQuery(cartListRef
                                .child(name).orderByChild("date"), HisCart.class)
                        .build();

        FirebaseRecyclerAdapter<HisCart, HisHolder> adapter
                = new FirebaseRecyclerAdapter<HisCart, HisHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull HisHolder holder, int position, @NonNull final HisCart model) {

                holder.txtDate.setText( model.getDate());
                holder.txtProductPrice.setText("Prx total: " + model.getPrice() + "DH");

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {

                        Intent intent = new Intent(Historique.this, HisDetailsActivity.class);
                        intent.putExtra("date", model.getDate());
                        intent.putExtra("price", model.getPrice());
                        intent.putExtra("liste", model.getListe());
                        startActivity(intent);

                    }
                });
            }

            @NonNull
            @Override
            public HisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_his_layout, parent, false);
                HisHolder holder = new HisHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

}