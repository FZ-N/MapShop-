package com.example.mapshop.Model;

public class HisCart
{
    private String date,price,liste;

    public HisCart() {
    }

    public HisCart(String price, String date, String liste) {

        this.date = date;
        this.price = price;
        this.liste = liste;
    }
    public String getPrice() {
    return price;
}

    public void setPrice(String price) {
        this.price = price;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getListe() {
        return liste;
    }

    public void setListe(String liste) {
        this.liste = liste;
    }
}
