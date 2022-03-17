package com.example.model;

public class ValidateData {
    public static void checkPerson(Person p) throws ValidateException{
        try{

        }catch(Exception e){
            throw new ValidateException(e);
        }
    }
}
