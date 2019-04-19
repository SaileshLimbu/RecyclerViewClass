package com.example.recyclerviewclass;

public class Hero {
    private String name;
    private int img;
    private String phoneNo;
    private int numMessage;
    private String email;

    public Hero(String name, int img, String phoneNo, int numMessage, String email) {
        this.name = name;
        this.img = img;
        this.phoneNo = phoneNo;
        this.numMessage = numMessage;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getNumMessage() {
        return numMessage;
    }

    public void setNumMessage(int numMessage) {
        this.numMessage = numMessage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}