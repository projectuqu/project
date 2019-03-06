package com.example.myapplication103;

public class PlayGround {
    private String id;
    private String name;
    private String price;
    private String phone;

    public PlayGround(String name, String price, String phone) {
        this.name = name;
        this.price = price;
        this.phone = phone;
    }

    public PlayGround() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}