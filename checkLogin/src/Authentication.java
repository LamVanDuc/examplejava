import com.sun.net.httpserver.Authenticator;

import java.util.List;
import java.util.Scanner;

public class Authentication {
    private String user_name;
    private String pass_word;
    ReadAccount readAccount = new ReadAccount();
    List<Account> accountList;
    public void login(){
        String status = "false";
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap user name : ");
        user_name = input.next();
        System.out.println("Nhap pass word : ");
        pass_word = input.next();
        accountList = readAccount.getAccountList();


        for (int i= 0 ; i < accountList.size();i++){
            if (user_name.equals(accountList.get(i).getUser_name()) && pass_word.equals(accountList.get(i).getPass_word())){
                status = "Success";
                break;
            }else {
                status = "false";
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("result : "+status);
        System.out.println("-----------------------------------------------------------");
        login();
    }
}
