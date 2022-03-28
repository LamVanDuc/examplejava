package com.movie.t2108a.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.movie.t2108a.model.Netflix;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class NetflixRepository {
    public   List<Netflix> netflixesList ;
    public List<Netflix> getData(){

        try{
            FileReader fileReader = new FileReader("Lab9/netflix.json");
            Type type = new TypeToken<List<Netflix>>(){}.getType();
            netflixesList = new Gson().fromJson(fileReader,type);
        }catch (Exception e){
            e.printStackTrace();
        }

        return netflixesList;
    }
}
