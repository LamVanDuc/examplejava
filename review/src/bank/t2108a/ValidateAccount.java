package bank.t2108a;

import java.security.PublicKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {

    public final String MOBILE = "1";
    public final String PASSWORD ="2";


    public boolean checkAccount(String mobile , String password ){
        if (mobile.equals(MOBILE)){
            if (password.equals(PASSWORD)){
                System.out.println("Dang nhap thanh cong");
                return true;
            }else{
                System.out.println("mat khau sai, vui long nhap lai");
                return false;
            }
        }else {
            System.out.println("Kiem tra lai so dien thoai !");
            return false;
        }
    }
    public static final Pattern Number = Pattern.compile("^(0|[1-9][0-9]*)$",Pattern.CASE_INSENSITIVE);
    public static String validateNumber(String number){
        Matcher matcher = Number.matcher(number);
        if (matcher.find()){
            return number;
        }else {
            throw new RuntimeException("Nhập sai định dạng !");
        }
    }
}
