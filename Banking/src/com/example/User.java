package com.example;

public class User {
    public final String currency= "USD";
    private long id;
    private String cmnd;
    private String name;
    private String username;
    private String password;
    private double balance;
    private String stk;



    public User(){}

    public User(long id,String cmnd,String name, String username, String password, double balance, String stk  ) {
        this.id = id;
        this.cmnd = cmnd;
        this.name = name;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.stk = stk;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    @Override
    public String toString(){
        return id+" "+cmnd+" "+ username + " "+password+ " "+balance+" "+stk;
    }
}
