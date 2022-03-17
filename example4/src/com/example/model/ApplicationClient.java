package com.example.model;

public class ApplicationClient {
    public static void main(String[] args){
        Person objPerson = new Person();

        try{
            ValidateData.checkPerson(objPerson);
            System.out.print(objPerson.getGender());
        }catch(ValidateException e){
            e.printStackTrace();
        }
    }
}
