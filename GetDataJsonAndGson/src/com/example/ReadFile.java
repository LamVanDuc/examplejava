package com.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class ReadFile {

    public void getDataJson(){
        JSONParser parser  = new JSONParser();

        try{
            FileReader fileReader = new FileReader("GetDataJsonAndGson/src/com/example/customer.json");
            Object obj = parser.parse(fileReader);

            JSONArray customerList = (JSONArray) obj;

            customerList.forEach( cus -> parserCustomer((JSONObject) cus));

        }catch (IOException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
    }

    public void parserCustomer(JSONObject object){
        long id = (long) object.get("id");
        String first_name = (String) object.get("first_name");
        String last_name = (String) object.get("last_name");
        String email = (String) object.get("email");
        String mobile = (String) object.get("mobile");
        String address = (String) object.get("address");

        System.out.printf("%5d | %10s %s | %30s | %15s | %s \n" ,id , first_name,last_name,email , mobile, address);
    }

    public void getDataGson(){
        Gson gson = new Gson();
        List<Customer> customerList;

        try{
            FileReader fileReader = new FileReader("GetDataJsonAndGson/src/com/example/customer.json");
            customerList = new Gson().fromJson(fileReader , new TypeToken<List<Customer>>(){}.getType());
            for (Customer customer: customerList){
                System.out.printf(String.valueOf(customer));

            }

        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

