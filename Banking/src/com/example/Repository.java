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

//if (username.equals(users.get(i).getUsername())){
//
//
//        for (int j = 0 ; j < users.size() ; j++){
//        if (stk.equals(users.get(j).getStk())){
//        System.out.println("số tài khoản: "+ users.get(j).getStk());
//        System.out.println("họ và tên : "+ users.get(j).getName());
//
//        System.out.println("Nhập số tiền cần chuyển : ");
//        parserMoney = Validate.validateNumber(input.next());
//        money = Double.valueOf(parserMoney);
//        if (money <= users.get(i).getBalance() && money > 0){
//        if (money <=20000000){
//        users.get(i).setBalance(users.get(i).getBalance() - money);
//        users.get(j).setBalance(users.get(j).getBalance()+money);
//        System.out.println("Chuyển thành công !");
//        System.out.println("--------------------------------------------");
//
//
//        System.out.println(" số chứng minh   |  tài khoản đăng nhập  |      số tài khoản    |      số tiền     |");
//        System.out.printf("    %-12s |  %-20s | %-20s | %-20f \n",
//        users.get(j).getCmnd(),
//        users.get(j).getUsername(),
//        users.get(j).getStk(),
//        users.get(j).getBalance());
//        checkTransfersWhile = false;
//        }else {
//        throw new RuntimeException("Số tiền chuyển quá hạn mức !");
//        }
//        }
//        else{
//        throw new RuntimeException("Số tiền chuyển cần lớn hơn 0 và nhỏ hơn số dư !");
//        }
//        }else {
//        throw new RuntimeException("Không tìm thấy số tài khoản người nhận !!");
//        }
//        }
//
//        }else {
//        throw new RuntimeException(" lỗi không tìm thấy tài khoản !");
//        }
//        }
