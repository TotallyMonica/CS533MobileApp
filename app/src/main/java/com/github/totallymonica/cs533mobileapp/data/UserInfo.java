package com.github.totallymonica.cs533mobileapp.data;

public class UserInfo {
    public String name;
    public String address;
    public String username;
    public String password;
    public String phoneNumber;
    public String emailAddress;

    public UserInfo(String username, String password, String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}
