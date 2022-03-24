package com.example;

public class User {
    private long id;
    private String username;
    private String password;
    private Double balance;
    private long stk;


    public User(){}

    public User(long id, String username, String password, Double balance, long stk) {
        this.id = id;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public long getStk() {
        return stk;
    }

    public void setStk(long stk) {
        this.stk = stk;
    }

    @Override
    public String toString(){
        return id+" "+ username + " "+password+ " "+balance+" "+stk;
    }
}
