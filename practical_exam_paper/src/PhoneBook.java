import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    String name;
    String phoneNumber;
    static List<PhoneBook> phoneBookList= new ArrayList<>();

    public PhoneBook(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    static String search;
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);


        String name ;
        String phone;
        int choice;



        try {
            while (true){
            System.out.println("1 . insert");
            System.out.println("2 . Look Up");
            System.out.println("3 . delete");
            System.out.println(" choice : ");
            choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter The Name: ");
                        name = input.next();
                        System.out.println("Enter The Phone Number: ");
                        phone = input.next();
                        insert(name , phone);
                        break;
                    case 2:
                        System.out.println("Enter The name : ");
                        search = input.next();
                        lookUp(search);
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        for (int i = 0 ; i< phoneBookList.size() ; i++){
                            System.out.printf("%-20s %s\n" , phoneBookList.get(i).getName(),phoneBookList.get(i).getPhoneNumber());
                        }
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
   }

    public static void insert(String name , String phoneNumber){

        phoneBookList.add(new PhoneBook(name,phoneNumber));
    }

    public static void delete(){

        int count = 0;
        for (int i=0 ; i< phoneBookList.size() ; i++){
            if (phoneBookList.get(i).getName().contains(search)){
                phoneBookList.remove(i);
                System.out.println("successful delete");
                count++;
            }
        }if (count==0){
            System.out.println("Not Found "+ search);

        }

    }

    public static void lookUp(String search) throws FileNotFoundException {
            int count = 0;
        for (int i = 0 ; i < phoneBookList.size(); i++){
            if (phoneBookList.get(i).getName().contains(search)){
                System.out.printf("%-20s %s\n" , phoneBookList.get(i).getName(),phoneBookList.get(i).getPhoneNumber());
                count++;
            }
        }if (count == 0){
                throw new FileNotFoundException("Not Found "+ search);
        }


    }

}
