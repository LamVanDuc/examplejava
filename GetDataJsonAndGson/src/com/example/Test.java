package com.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public void getData() {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("GetDataJsonAndGson/src/account.json");
            Object obj = jsonParser.parse(reader);
            JSONArray account = (JSONArray) obj;

            account.forEach(acc -> output((JSONObject) acc));


        }catch (FileNotFoundException notfoud){
            notfoud.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void output(JSONObject obj){
        long id = (long) obj.get("id");
        String user_name = (String) obj.get("user_name");
        String pass_word = (String) obj.get("pass_word");
        String email = (String) obj.get("email");
        System.out.printf("%5d | %10s | %10s | %30s\n" ,id , user_name , pass_word , email);
    }
}
