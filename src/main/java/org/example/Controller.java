package org.example;

import javax.swing.text.html.parser.Parser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Controller {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice;
            int update;
            System.out.println("take command:");
            System.out.println("1. add");
            System.out.println("2. show tasks");
            System.out.println("3. edit");
            System.out.println("4. delete");
            System.out.println("5. filter");
            System.out.println("6. sort");
            System.out.println("7. exit");
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
                    String status = "TODO";
                    DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    try {
                        LocalDate localDate = LocalDate.parse(localdatestr, formatter);
                        Service service = new Service(name,description,localDate,status);
                        Repository.createtask(service);
                    }catch (DateTimeParseException e){
                        System.out.println("Invalid date format, please use dd.MM.yyyy format");
                    }
                    break;
                case 2:
                    Repository.readalltask();
                    break;
                case 3:
                    System.out.println("Enter task number: ");
                    int numbertask = sc.nextInt();
                    System.out.println("1. update name ");
                    System.out.println("2. update description ");
                    System.out.println("3. update deadline ");
                    System.out.println("4. update status ");
                    update = sc.nextInt();
                    sc.nextLine();
                    switch (update){
                        case 1:
                            Service service = Repository.datemap.get(numbertask);
                            System.out.println("Enter name task:");
                            service.setName(sc.nextLine());
                            Repository.updatetask(numbertask,service);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                    }
                    break;
                default:
                    System.out.println("Warning!");
            }
        }
    }
}