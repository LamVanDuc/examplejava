package com.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.example.model.StudentList;

import com.example.entity.Student;

import javax.annotation.processing.SupportedSourceVersion;

public class Application {

    private  static Scanner input = new Scanner(System.in);
    private static StudentList list;

    public static void menu(){
        System.out.println("\n1. Add new student to the list");
        System.out.println("2. Delete a student from the list");
        System.out.println("3. Search by name");
        System.out.println("4. Search by id");
        System.out.println("5. Print student info in descending order of mark");
        System.out.println("6. exit");
        System.out.println("------------------------------------------------------");
    }

    public static void main(String[] args) {
        list = new StudentList();
        menu();
            while (true) {
                int choice;
                System.out.println("# : ");
                choice = input.nextInt();
                if (choice == 1) {
                    addStudent();
                    menu();
                } else if (choice == 2) {
                    deleteStudent();
                    menu();
                } else if (choice == 3) {
                    searchName();
                    menu();
                } else if (choice == 4) {
                    searchById();
                    menu();
                } else if (choice == 5) {
                    printSorted();
                    menu();
                } else if (choice == 6) {
                    System.exit(0);}
                else {
                    System.out.println("choice number 1-6");
                }
            }
    }

    public static void addStudent(){

        int id ;
        String firstName;
        String lastName;
        double mark;
        try{
            System.out.println("Enter student ID: ");  id = input.nextInt();

            System.out.println("Enter first name: "); firstName = input.next();

            System.out.println("Enter last name: "); lastName = input.next();

            System.out.println("Enter the mark");  mark = input.nextDouble();
            Student s = new Student(id,firstName,lastName,mark);
            list.add(s);
        }catch (InputMismatchException e){
            System.out.println("kieu du lieu khong hop le");
        }
        finally {
            menu();
        }

    }

    public static void deleteStudent(){
        int id ;
        System .out.println("Enter student id: ");
        id = input.nextInt();
        list.remove(id);
    }

    public static void searchName(){
        String name;
        System.out.println("Enter a name : ");
        name = input.next();
        ArrayList<Student> found = list.findByName(name);
        list.showList(found);
    }

    public static void searchById(){
        int id ;
        System.out.println("Enter an ID: ");
        id = input.nextInt();
        Student s = list.findByID(id);
        if (s==null){
            System.out.println("Not found !");
        }else {
            s.printInfo();
        }
    }

    public static void printSorted(){
        try{
            list.sortByMarks();
            list.showList();

        }catch (Exception e){
            System.out.println("Not found Student");
        }
    }

}
