package com.example.mapshop.Model;

public class Cart
{
    private String pid, pname, price, quantity, category,date;

    public Cart() {
    }

    public Cart(String pid, String pname, String price, String quantity, String category) {
        this.pid = pid;
        this.date = date;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }



    public String getDate() {
        return category;
    }

    public void setDate(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
