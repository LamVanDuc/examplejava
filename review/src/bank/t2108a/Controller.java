package bank.t2108a;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private static long balanceNumber = 1000000;
    List<TransactionHistory> listHistory = new ArrayList<TransactionHistory>();
    Scanner inputI = new Scanner(System.in);
    private static boolean  status = false;


    public long getBalanceNumber(){
        return balanceNumber;
    }

    public static long tranfer(long money){
        // kiem tra neu so tien nho hon 50.000 thi thong bao so tien chuyen toi thieu phai la 50.000
        // neu so tien chuyen lon hon so du thi thong bao tai khoan khong du
        // neu chuyen thanh cong,in ra so du moi va them lich su giao dich

        if (money > balanceNumber){
            System.out.println("Tai khoan khong du !");
            status = false;
        }else if(money < 50000){
            System.out.println("So tien chuyen toi thieu la 50.000");
            status = false;
        }else{
            balanceNumber -=money;
            status = true;
        }
        return balanceNumber;
    }

    public void acctionTransfer(){
        String beneficiaryAccount;
        long money;
        String content;
        // thuc hien cac cong viec nhu nhap so tai khoarn thu huong, so tien , mo ta tai day
        try{
            boolean check = true;
            while (check){
                System.out.println("vui long nhap so tai khoan: ");
                beneficiaryAccount = ValidateAccount.validateNumber(inputI.next());
                System.out.println("vui long nhap so tien: ");
                money = inputI.nextLong();
                tranfer(money);
                if (status == true){
                    System.out.println("noi dung chuyen khoan: ");
                    content = inputI.next();
                    listHistory.add(new TransactionHistory(content , beneficiaryAccount , money));
                    System.out.println("chuyen khoan thanh cong");
                }
                check = false;
            }


        }catch (InputMismatchException e){
            System.out.println("bạn nhâp sai định dạng .");
        }catch (NullPointerException e1){
            System.out.println(" bạn chưa nhập :"+e1.getMessage());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


    }

    public void getHistory(){
        try {
            for (int i = 0; i < listHistory.size(); i++) {

                    System.out.printf("Ngày: %15s \nNội dung chuyển khoản :  %s  \nSố tiền:  %s   \nNgười nhận : %s \n", listHistory.get(i).getDayTranding(), listHistory.get(i).getDescription(), Controller.formatMoney(listHistory.get(i).getMoney()), listHistory.get(i).getBeneficiaryAccount());
                    System.out.println("--------------------------------------------------------------");



            }
            if (listHistory.size() <= 0){
                System.out.println("chưa có giao dịch được thực hiện !");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static  String formatMoney(long money){
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(money);
    }
}
