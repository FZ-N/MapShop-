package com.example.mapshop.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mapshop.Interface.ItemClickListner;
import com.example.mapshop.R;

public class HisHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductPrice, txtDate;
    private ItemClickListner itemClickListner;


    public HisHolder(View itemView)
    {
        super(itemView);

       // txtName = itemView.findViewById(R.id.cart_name);
        txtDate = itemView.findViewById(R.id.cart_date);
        txtProductPrice = itemView.findViewById(R.id.cart_product_price);
    }

    @Override
    public void onClick(View view)
    {
        itemClickListner.onClick(view, getAdapterPosition(), false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner)
    {
        this.itemClickListner = itemClickListner;
    }
}
