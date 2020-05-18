package com.example.mapshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapshop.Model.Products;
import com.example.mapshop.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import io.paperdb.Paper;


public class HomeActivity extends AppCompatActivity
{
    private DatabaseReference ProductsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private ImageView logo,logo2;
    private String type = "",cat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logo=(ImageView) findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomeActivity.this, First.class);
                startActivity(intent);
            }
        });
        logo2=(ImageView) findViewById(R.id.logo2);
        logo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomeActivity.this, categories.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        cat =intent.getStringExtra("cat");
        Bundle bundle = intent.getExtras();




        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Cat").child(cat);


        Paper.init(this);


        recyclerView = findViewById(R.id.recycler_menu);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }


    @Override
    protected void onStart()
    {
        super.onStart();

        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(ProductsRef, Products.class)
                        .build();


        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Products model)
                    {
                        holder.txtProductName.setText(model.getPname());
                        holder.txtProductDescription.setText(model.getDescription());
                        holder.txtProductPrice.setText("Price = " + model.getPrice() + "DH");
                        Picasso.get().load(model.getImage()).into(holder.imageView);


                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {

                                Intent intent = new Intent(HomeActivity.this, ProductDetailsActivity.class);
                                intent.putExtra("pid", model.getPid());
                                intent.putExtra("cat", cat);
                                startActivity(intent);

                            }
                        });
                    }

                    @NonNull
                    @Override
                    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                    {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent, false);
                        ProductViewHolder holder = new ProductViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (!type.equals("Admin"))
                {
                    Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                    startActivity(intent);
                }
            }
        });

        FloatingActionButton fabsearch = (FloatingActionButton) findViewById(R.id.fabsearch);
        fabsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (!type.equals("Admin"))
                {
                    Intent intent = new Intent(HomeActivity.this, SearchProductsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

//        if (id == R.id.action_settings)
//        {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }



}
