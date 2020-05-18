package com.example.mapshop.Model;

public class Users {
    String gender,adr;
    int age;

    public Users(String name, String gender, String emailAddress,String adr, int age) {
        this.gender = gender;
        this.age = age;
        this.adr = adr;
    }


    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}


    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getAdr() {return adr;}
    public void setAdr(String adr) {this.adr = adr;}
}