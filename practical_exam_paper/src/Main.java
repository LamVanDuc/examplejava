package Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Customer> customerList = new ArrayList<Customer>();
    Scanner scanner = new Scanner(System.in);




    public static void main(String[] args) {
        Main main = new Main();
        int choice;
        try{
            while (true) {
                System.out.println("1. Add new customer");
                System.out.println("2. Find By Name");
                System.out.println("3. Display all");
                System.out.println("4. Exit");
                System.out.println("Choice: ");
                choice = new Scanner(System.in).nextInt();
                switch (choice) {

                    case 1:
                        main.add();
                        break;
                    case 2:
                        main.findByName();
                        break;

                    case 3:main.displayAll();
                        break;
                    case 4:System.exit(0);
                        break;
                    default:System.out.println("invalid option !");
                        System.exit(0);
                }
            }}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void add(){
        String name , email ;
        int phone;

        System.out.println("Enter the Name : " );
        name=scanner.next();
        System.out.println("Enter the email");
        email = scanner.next();
        System.out.println("Enter the phone number : ");
        phone = scanner.nextInt();

        customerList.add(new Customer(name,email,phone));
    }

    public void findByName(){
        System.out.println("Enter the name :");
        String name = scanner.next();
        System.out.printf("%-20s %s\n" ,"Name" ,"Phone");
        for (int i = 0 ; i< customerList.size() ; i++) {
            if (customerList.get(i).getName().equals(name)){
                System.out.printf("%-20s %d\n",customerList.get(i).getName() , customerList.get(i).getPhone());
            }else{
                System.out.println("Not found !");
            }

        }
    }

    public void displayAll(){
        System.out.printf("%-20s %s\n" ,"Name" ,"Phone");
        customerList.forEach(cus ->{

            System.out.printf("%-20s %d\n",cus.getName() , cus.getPhone());
        });
    }
}

