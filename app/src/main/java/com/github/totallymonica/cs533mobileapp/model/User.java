package com.github.totallymonica.cs533mobileapp.model;


public class User {
    String name;
    String email;
    String phone;
    String passwd;

    public User() {
    }

    public User(String name, String email, String phone, String passwd) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return phone;
    }

    public void setMobile(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return passwd;
    }

    public void setPassword(String passwd) {
        this.passwd = passwd;
    }
}
