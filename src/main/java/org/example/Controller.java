package org.example;

import javax.swing.text.html.parser.Parser;
import java.time.LocalDate;
import java.util.Scanner;

public class Controller {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice;
            System.out.println("take command:");
            System.out.println("1. add");
            System.out.println("2. show tasks");
            System.out.println("1. add");
            System.out.println("1. add");
            System.out.println("1. add");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name task:");
                    String name = sc.nextLine();
                    System.out.println("Enter description task: ");
                    String description = sc.nextLine();
                    System.out.println("Enter deadline task: ");
                    String localdatestr = sc.nextLine();
                    Service.createtask(name, description, localdatestr);
                    break;
                case 2:
                    System.out.println(Repository.datemap);
                    break;
                default:
                    System.out.println("Warning!");
            }
        }
    }
}