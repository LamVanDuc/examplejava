package com.example.model;

import com.example.entity.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CustomeException extends Exception{

    public CustomeException(String mesage) {
        super();
        System.out.println(mesage);
    }
}
public class EmployeeSystem {
    public static Map<Integer,Employee> map = new HashMap();
    // thao tacs lien quan ve mo ta
    public static void addEmployee(int id , String name , int age){
        Employee employee = new Employee(name, age , id);
        map.put(id, employee);
        operation();

    }
    public static void deleteEmployee(int id) throws CustomeException {
        if (map.containsKey(id)){
            map.remove(id);
            System.out.println("Successfully Delete from the List Employee");
        }else{
            throw new CustomeException(" Not found Exception");
            }
        operation();

        }

    public static void searchEmployee(int EmId) throws CustomeException{
        if (map.containsKey(EmId)){
            System.out.println("Employee Details :- "+map.get(EmId));
        }else{
            throw new CustomeException("Not Found Exception");
        }

        operation();
    }
    public static void employeeList(){
        System.out.println(map.keySet() +" : "+ map.values());
    }

    public static void operation(){
        System.out.println("-----------Employee management system------------");
        System.out.println("1. Add Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. Search Employee");
        System.out.println("4. Employee List");

        Scanner input = new Scanner(System.in);
        System.out.print("choice: ");
        int userInput = input.nextInt();

        switch (userInput){
            case 1: System.out.println("Enter Employee Details : (id , name , age)");
                    Scanner inputEmployee = new Scanner(System.in);
                    int id =  inputEmployee.nextInt();
                    String name =  inputEmployee.next();
                    int age =  inputEmployee.nextInt();
                    if (!name.equals("") && age !=0 && id !=0){
                        addEmployee(id , name , age);
                    }
                    break;

            case 2: System.out.println("Enter Employee ID");
                    Scanner inputIdDelete = new Scanner(System.in);

                    int EmpId = inputIdDelete.nextInt();
                    try{
                        deleteEmployee(EmpId);

                    } catch (CustomeException e) {
                        e.printStackTrace();
                    }
                    break;

            case 3: System.out.println("Enter Employee ID Search");
                    Scanner inputSearchId = new Scanner(System.in);
                     int empID =inputSearchId.nextInt();

                     try{
                         searchEmployee(empID);
                     }catch (CustomeException e){
                         e.printStackTrace();
                     }
                     break;

            case 4:
                    employeeList();
                    operation();
                    break;
            }

    }

    public static void main(String[] args) {
        operation();
    }

    }