package com.example;

public class Menu {
    public static void mainMenu(){

        System.out.println("--------------- ATM SYSTEM ---------------");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("Lựa chọn của bạn là : ");
    }

    public static void loginFalse(){
        System.out.println("1 - Đăng nhập lại ");
        System.out.println("2 - Quên mật khẩu ");
        System.out.println("0 - Quay lại");
        System.out.println("Lựa chọn của bạn là : ");
    }
    public static void loginSuccess(){

        System.out.println("1. Xem thông tin tài khoản");
        System.out.println("2. Rút tiền");
        System.out.println("3. Chuyển tiền");
        System.out.println("4. Gửi tiền");
        System.out.println("5. Đăng xuất");
        System.out.println("Lựa chọn của bạn là : ");
    }
}
