package com.example;

import java.util.List;
import java.util.Scanner;

public class controller {
    private String username;
    private String password;
    Repository repository = new Repository();
    List<User> users = repository.getUsers();
    Scanner input = new Scanner(System.in);


    public void home(){
        Menu.mainMenu();
        int choice = input.nextInt();
        switch (choice){
            case 1: break;


            case 2: break;
        }
    }

    // đăng nhập
    public void login(){}


    // quên mật khẩu
    public void forgotPassword(){}

    // rút tiền
    public void withdrawMoney(){}


    // xem thông tin tài khoản
    public void showAccount(){}



    //tạo tài khoản
    public void creatAccount(){}

    //chuyển tiền
    public void transfers(){}
}
