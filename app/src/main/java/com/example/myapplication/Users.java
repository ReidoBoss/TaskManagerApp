package com.example.myapplication;

public class Users {

    private String fname,lname,username,password,desc;
    private Integer ctr;


    public Users(){


    }


    public Users(String fname, String lname, String username, String password,int ctr) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.ctr = ctr;
    }
    public Users(int ctr) {
        this.ctr = ctr;
    }



    public int getCtr() {
        return ctr;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
