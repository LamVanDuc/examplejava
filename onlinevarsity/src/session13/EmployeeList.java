package session13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EmployeeList {
    public static void main(String[] args) {
        try {
            int id;
            String name;

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            Map<String, LocalDate> hm = new HashMap<String , LocalDate>();
            System.out.println("Enter the total number of employee: ");
            int size = Integer.parseInt(input.readLine());

            for (int i = 0 ; i <size ; i++){
                System.out.println("Enter the employee id");
                String empId =input.readLine();
                System.out.println("Enter ther date of birth in this format dd/MM/yyyy");
                String strDOB = input.readLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dob = LocalDate.parse(strDOB , formatter);

                hm.put(empId , dob);
            }
            retirementList(hm);


        }catch (IOException e){
            System.out.println(e.getMessage());

        }

    }
    public static void retirementList(Map<String,LocalDate> hm){
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Current Date is: "+currentDate.format(formatter));
        LocalDate dateOfBirth;
        String empId;

        List<String> list= new ArrayList<String>();

        System.out.println("Retirement List");

        for(Map.Entry<String , LocalDate> me : hm.entrySet()){
            empId = me.getKey();

            dateOfBirth = me.getValue();
            Period diff = Period.between(dateOfBirth , currentDate);

            int diff1 = Period.between(dateOfBirth,currentDate).getYears();
            int dif4 = 66 -(int) diff1;

            int diff2 = Period.between(dateOfBirth , currentDate).getMonths();

            int dif6 = 12 - diff2;
            int age = diff.getYears();

            if (age>66){
                list.add(empId);
                System.out.println("Emp Id:" +empId+ "retired already");
            }else{
                System.out.println("Emp Id:" +empId+ "has" +dif4 + "years" +dif6 + "months for retirement");
            }
        }
    }
}
