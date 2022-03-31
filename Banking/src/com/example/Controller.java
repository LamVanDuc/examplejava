package com.example;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private String username;
    private String password;
    private String cmnd;
    Repository repository = new Repository();
    List<User> users = repository.getUsers();
    Scanner input = new Scanner(System.in);


    public void home(){
        try {
        Menu.mainMenu();
        int choice = input.nextInt();
        switch (choice){
            case 1:login();
                    break;

            case 2: creatAccount();
                    break;
            default:System.out.println("Lựa chọn không hợp lệ vui lòng thực hiện lại !");
                    home();
                    break;
        }
        }catch (InputMismatchException e){
            System.out.println("Cú pháp không hợp lệ !");
        }
    }

    // đăng nhập
    public void login(){
        System.out.println("------------------ Đăng nhập ------------------");
        boolean checklogin = false;
        while (!checklogin){
            System.out.println("user name: ");
            username = input.next();
            int count = 0 ;
            for (int i = 0 ; i < users.size(); i ++){
                if (username.equals(users.get(i).getUsername())){
                    System.out.println("password: ");
                    password = input.next();
                    count ++;
                    if (password.equals(users.get(i).getPassword())){
                        loginSuccess();
                        checklogin = true;
                    }else{
                        loginFalse();
                        break;
                    }
                }
            }
            if (count == 0 ){
                System.out.println("Username không tồn tại ! ");
                login();
            }
        }
    }

    // login truot
    public void loginFalse(){
        System.out.println("password khong chinh xac !");
        System.out.println("------------------------------------------");
        Menu.loginFalse();
        int choice = input.nextInt();
        switch (choice){
            case 1: login();
                    break;

            case 2:forgotPassword();
                    break;

            case 0:home();
                break;

            default:System.out.println("sai cú pháp vui lòng chọn lại");
                    loginFalse();
                    break;
        }

    }


    //login thanh cong
    public void loginSuccess(){
        System.out.println("-------------- Xin chào: "+username+" --------------");
        Menu.loginSuccess();
        System.out.printf("");
        int choice = input.nextInt();
        switch (choice){
            case 1:showAccount();
                    break;

            case 2:withdrawMoney();
                    break;
            case 3:transfers();
                break;
            case 4:sendMony();
                    break;
            case 5:home();
                   break;
            default:
                System.out.println("cú pháp không hợp lệ ! ");
                break;
        }
    }


    // quên mật khẩu
    public void forgotPassword(){
        System.out.println("------------------- quên mật khẩu -------------------");
        boolean check  = false;
        outer:
        while (!check){
            System.out.println("vui lòng nhập user name:");
            username = input.next();
            try {
            for (int i = 0 ; i< users.size(); i ++){
                if (username.equals(users.get(i).getUsername())){

                    System.out.println("vui lòng nhập số chứng minh nhân dân: ");
                    cmnd = Validate.validateCMND(input.next());
                        if (cmnd.equals(users.get(i).getCmnd())){
                            changePassword();
                            check = true;
                        }else{
                            System.out.println("số cmnd không chính xác , vui lòng thực hiện lại !");
                            continue outer;
                        }

                }else{
                    System.out.println("user name Không tồn tại");
                    continue outer;
                }
            }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }

    }

    public void changePassword(){
         boolean checkChangePassword = false;
        for (int i = 0; i < users.size(); i++) {
            while (!checkChangePassword){
                try {

                        System.out.println("Mật khẩu mới: ");
                        String newPassword = Validate.validatePassword(input.next());
                        System.out.println("Nhập lại mật khẩu: ");
                        String comfirmPassword = Validate.validatePassword(input.next());
                        if (newPassword.equals(comfirmPassword)) {
                            users.get(i).setPassword(newPassword);
                            System.out.println("Đổi mật khẩu thành công!");
                            checkChangePassword = true;
                        } else {
                            System.out.println("mật khẩu không khớp!");
                            changePassword();
                        }

                    }catch (RuntimeException e){
                    e.printStackTrace();
                }
                }
            login();
        }

    }

    // rút tiền
    public void withdrawMoney(){
      boolean checkwithdrawMony = true;
      double monney;
      String checkMoney;
      while (checkwithdrawMony){
          try {
              System.out.println("vui lòng nhập số tiền bạn cần rút: ");
              checkMoney = Validate.validateNumber(input.next());
              monney = Double.valueOf(checkMoney);
              if (monney < 20000001){
                  for(int i = 0 ; i < users.size();i++){
                      if (username.equals(users.get(i).getUsername())){
                        if (monney > users.get(i).getBalance()){
                            throw new RuntimeException("Số tiền rút lớn hơn số tiền có trong tài khoản của bạn !");
                        }else if (monney > users.get(i).getBalance() - 50000){
                            throw new RuntimeException("Tài khoản cần dư 50,000 để duy trì phí dịch vụ !");
                        }else{
                            users.get(i).setBalance(users.get(i).getBalance()- monney);
                            System.out.println("Số tiền đã rút : "+monney);
                            System.out.println("tài khoản còn : "+users.get(i).getBalance());
                            checkwithdrawMony = false;
                        }
                      }
                  }
              }else {
                  System.out.println("Số tiền rút cần nhỏ hơn 20,000,000  1 lần !");
                  withdrawMoney();
              }
          }catch (RuntimeException e){
              System.out.println(e.getMessage());
          }
          loginSuccess();
      }
    }


    // xem thông tin tài khoản
    public void showAccount(){
        System.out.println("------------------------ Thông tin tài khoản ------------------------");
        boolean checkShow = true;
        while (checkShow){
            try {

                for (int i = 0 ; i < users.size() ; i++){
                    if (username.equals(users.get(i).getUsername())){
                        System.out.println("  số chứng minh   |  tài khoản đăng nhập  |      số tài khoản    |      số tiền     ");
                        System.out.printf("    %-12s  |  %-20s |   %-20s |   %-20f \n",
                                users.get(i).getCmnd(),
                                users.get(i).getUsername(),
                                users.get(i).getStk(),
                                users.get(i).getBalance());
                        checkShow = false;
                    }
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());

            }
        }
        loginSuccess();
    }


    //gửi tiền
    public void sendMony(){
        boolean checkwithdrawMony = true;
        Double monney;
        String checkMoney;
        while (checkwithdrawMony){
            try {
                System.out.println("vui lòng nhập số tiền bạn cần gửi : ");
                checkMoney = Validate.validateNumber(input.next());
                monney = Double.valueOf(checkMoney);
                if (monney>0) {
                    for (int i = 0; i < users.size(); i++) {
                        if (username.equals(users.get(i).getUsername())) {
                            users.get(i).setBalance( users.get(i).getBalance() + monney);
                            System.out.println("Số tiền trong tài khoản là: "+users.get(i).getBalance());
                            checkwithdrawMony = false;
                        }
                    }
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }

        }
            loginSuccess();
    }



    //chuyển tiền
    public void transfers() {
        System.out.println("---------------------- Dịch vụ chuyển tiền ----------------------");
        //Khai báo biến cần thiết
        boolean checkTransfersWhile = true;
        String stk;
        double money;
        String parserMoney;
        int count = 0;
        int receiver = 0;

        while (checkTransfersWhile) {
            try {
                System.out.println("vui lòng nhập số tài khoản : ");
                stk = Validate.validateNumber(input.next());
                for (int i = 0; i < users.size(); i++) {
                    if (username.equals(users.get(i).getUsername())) {
                        count++;
                        for (int j = 0; j < users.size(); j++) {
                            if (stk.equals(users.get(j).getStk())) {
                                count++;
                                System.out.println("số tài khoản: "+ users.get(j).getStk());
                                System.out.println("họ và tên : "+ users.get(j).getName());
                                System.out.println("Số tiền: ");
                                parserMoney = Validate.validateNumber(input.next());
                                money = Double.valueOf(parserMoney);
                                if (money <= users.get(i).getBalance() && money > 0){
                                    if (money <=20000000){
                                    users.get(i).setBalance(users.get(i).getBalance() - money);
                                    users.get(j).setBalance(users.get(j).getBalance()+money);
                                    String a = input.next();
                                    System.out.println(a);
                                    System.out.println("Chuyển thành công !");
                                    System.out.println("--------------------------------------------");


                                    System.out.println(" số chứng minh   |  tài khoản đăng nhập  |      số tài khoản    |      số tiền     |");
                                    System.out.printf("    %-12s |  %-20s | %-20s | %-20f \n",
                                    users.get(j).getCmnd(),
                                    users.get(j).getUsername(),
                                    users.get(j).getStk(),
                                    users.get(j).getBalance());
                                    checkTransfersWhile = false;
                                    break;
                                    }
                                }
                                break;
                            }
                         }if (count == 0){
                                throw  new RuntimeException("Không tìm thấy tài khoản");
                            }else if (count == 1){
                                throw new RuntimeException("Không tìm thấy tài khoản người nhận !");
                            }
                    }
                }
            }catch(RuntimeException e){
                System.out.println(e.getMessage() + " , Vui lòng thực hiện lại ");
            }
            loginSuccess();
        }
    }


    //tạo tài khoản
    public void creatAccount(){
        boolean checkCreatAccount = true;
        long id = 0;
        String cmnd = null;
        String name = null;
        String user_name = null;
        String password = null;
        double balance =0;
        String stk = null;
        long random = (long) (Math.random() * 1000000000);
        while (checkCreatAccount) {

            try {
                    System.out.println("------------------- Đăng ký -------------------");
                    System.out.println("Số chứng minh nhân dân: ");
                    cmnd = Validate.validateCMND(input.next());
                    System.out.println("Họ và Tên");
                    name = input.next();
                    System.out.println("User name: ");
                    user_name = input.next();
                    System.out.println("Password (trên 7 chữ số,có chứa ký tự viết hoa và viết thường) : ");
                    password = Validate.validatePassword(input.next());
                    stk =  Long.toString(random);
                    id = (long) (Math.random() * 10000);
                for (int i = 0; i < users.size(); i++) {
                    if (cmnd.equals(users.get(i).getCmnd()))
                        throw new RuntimeException("Căn cước công dân này đã được đăng ký!");
                    if (user_name.equals(users.get(i).getUsername()))
                        throw new RuntimeException("User name đã tồn tại !");
                    checkCreatAccount = false;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()+", Vui lòng thực hiện lại: ");
            }
        }
            users.add(new User(id , cmnd ,name, user_name , password , balance , stk));
            System.out.println("Đăng ký thành công");
            login();

    }





}
