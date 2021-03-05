package com.example.app.models;

public class Contact {
    private String name;
    private String phoneNumber;
    private String gender;
    private String avatar;

    public Contact() {
        super();
    }

    public Contact(String name, String phoneNumber, String gender, String avatar) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
