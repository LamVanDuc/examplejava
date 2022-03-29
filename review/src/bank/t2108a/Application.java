package bank.t2108a;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ValidateAccount validate = new ValidateAccount();
        Controller controller = new Controller();
        try {


        boolean isCheck = false ;
        while (!isCheck) {
            System.out.println("nhap so dien thoai");
            String mobile =  input.next();

            System.out.println("nhap mat khau");
            String password  = input.next();

            isCheck = validate.checkAccount(mobile, password);


            }
        }catch (InputMismatchException ex){
            System.out.println("nhap sai dinh dang");
        }

        while (true){
            menu();
            int choose = input.nextInt();

            switch (choose){
                case 1:
                    System.out.println("So du: ");
                    long balance = controller.getBalanceNumber();
                    System.out.println(Controller.formatMoney(balance));
                    break;
                case 2:
                    controller.acctionTransfer();
                    break;
                case 3:
                    System.out.println("-------- lich su giao dich --------- ");
                    controller.getHistory();
                    break;
                case 0:
                    input.close();
                    System.exit(0);
                    break;
                default:System.out.println("khong co lua chon nay");
                break;
            }
        }
    }


    public static void menu(){
        System.out.println("Lua chon cua ban: ");
        System.out.println("1 : Xem so du tai khoan ");
        System.out.println("2 : Chuyen khoan");
        System.out.println("3 : Xem lich su giao dich ");
        System.out.println("0 : thoat ");
    }
}
