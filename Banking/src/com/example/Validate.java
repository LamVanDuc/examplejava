package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
// Email : hợp lệ trước dấu chấm thì không có " !#$%&'*+/=?`{|}~^- "
    public  static  final Pattern EmailRegex = Pattern.compile(
            "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9]+\\.)+[a-zA-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public static final Pattern PasswordRegex = Pattern.compile(
            "(?=.*[a-z])(?=.*[A-Z])(?=.*[.,-_;]).{7,15}",Pattern.CASE_INSENSITIVE);


    public static final Pattern Number = Pattern.compile("^(0|[1-9][0-9]*)$",Pattern.CASE_INSENSITIVE);
    public static final Pattern CMND = Pattern.compile("^(0|[1-9][0-9]*).{12}$",Pattern.CASE_INSENSITIVE);

    public static String validateCMND(String cmnd){
        Matcher matcher = CMND.matcher(cmnd);

        if (matcher.find()){
            return cmnd;
        }else {
            throw new RuntimeException("Số cmnd không hợp lệ!!");
        }
    }
    public static String validateEmail(String email){
        Matcher matcher = EmailRegex.matcher(email);
        if (matcher.find()){
            return email;
        }else{
            throw new RuntimeException("Email không hợp lệ !");
        }
    }

    public static String validatePassword(String password){
        Matcher matcher = PasswordRegex.matcher(password);
        if (matcher.find()){
            return password;

        }else {
            throw new RuntimeException("Password không hợp lệ !");
        }
    }

    public static String validateNumber(String number){
        Matcher matcher = Number.matcher(number);
        if (matcher.find()){
            return number;
        }else {
            throw new RuntimeException("Nhập sai định dạng !");
        }
    }
}
