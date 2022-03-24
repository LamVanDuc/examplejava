package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.lang.reflect.Type;

public class Repository {
    List<User> users;
    public List<User> getUsers(){
        try {
            FileReader file = new FileReader("Banking/account.json");
            Type type = new TypeToken<List<User>>(){}.getType();
            users = new Gson().fromJson(file,type);
        }catch (IOException e){
            e.printStackTrace();
        }
        return users;
    }
}
