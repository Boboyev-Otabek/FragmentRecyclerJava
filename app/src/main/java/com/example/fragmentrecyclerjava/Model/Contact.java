package com.example.fragmentrecyclerjava.Model;

public class Contact {
    private String ism;
    private String familiya;
    public Contact(String ism, String familiya){
        this.ism=ism;
        this.familiya=familiya;
    }

    public String getIsm() {
        return ism;
    }

    public String getFamiliya() {
        return familiya;
    }
}
