package session14;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class AccountMain {
    static String userId ="admin";
    static String password = "Admin@123" ;

    public static String enodePassword(){
        String base64encodePassword="";
        try{
            base64encodePassword = Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
            System.out.println("Base64 Encoded String(Basic)"+base64encodePassword);
        }catch (UnsupportedEncodingException e){
            System.out.println("Error : "+e.getMessage());
        }

        return base64encodePassword;
    }


    public static String decodePassword(){
        String encodePassword = enodePassword();
        String base64DecodePassword = new String();
        try{
            byte[] decodedPassword = Base64.getDecoder().decode(encodePassword);
            System.out.println("Original String: "+ new String(decodedPassword,"utf-8"));
            base64DecodePassword = new String(decodedPassword,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return base64DecodePassword;
    }

    public static Boolean validatePassword(Account objAccount){
        boolean output;
        String decodedPassword = decodePassword();
        String inputPassword = objAccount.getPassword();
        output = decodedPassword.equals(inputPassword);
        return output;
    }
    public static void main(String[] args){
        String inPassword ;
        Scanner input = new Scanner(System.in);

        Account objAccount = new Account();

        objAccount.setUserId(userId);
        System.out.println("Enter the password");
        inPassword = input.next();
        objAccount.setPassword(inPassword);

        if (validatePassword(objAccount)){
            System.out.println("Admin password is successfully validated");
            System.out.println(objAccount.toString());
        }else {
            System.out.println("invalid ");
        }
    }
}


