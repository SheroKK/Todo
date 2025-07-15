package org.example;

import javax.swing.text.html.parser.Parser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Controller {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean statusprogramm = true;
        while (statusprogramm) {
            int choice;
            int update;
            int updatestatus;
            int sort;
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
                            service = Repository.datemap.get(numbertask);
                            System.out.println("Enter task description: ");
                            service.setDescription(sc.nextLine());
                            Repository.updatetask(numbertask, service);
                            break;
                        case 3:
                            service = Repository.datemap.get(numbertask);
                            System.out.println("Enter task description: ");
                            String localdateupdatestr = sc.nextLine();
                            DateTimeFormatter formatter1 =DateTimeFormatter.ofPattern("dd.MM.yyyy");
                            try {
                                LocalDate localDate = LocalDate.parse(localdateupdatestr,formatter1);
                                service.setDeadline(localDate);
                                Repository.updatetask(numbertask,service);
                            }catch (DateTimeParseException e){
                                System.out.println("Invalid data format");
                            }
                            break;
                        case 4:
                            System.out.println("Take status");
                            System.out.println("1. TODO");
                            System.out.println("2. IN_PROGRESS");
                            System.out.println("3. DONE");
                            updatestatus = sc.nextInt();
                            sc.nextLine();
                            switch (updatestatus){
                                case 1:
                                    service = Repository.datemap.get(numbertask);
                                    service.setStatus("TODO");
                                    Repository.updatetask(numbertask, service);
                                    break;
                                case 2:
                                    service = Repository.datemap.get(numbertask);
                                    service.setStatus("IN_PROGRESS");
                                    Repository.updatetask(numbertask, service);
                                    break;
                                case 3:
                                    service = Repository.datemap.get(numbertask);
                                    service.setStatus("DONE");
                                    Repository.updatetask(numbertask, service);
                                    break;
                                default:

                            }
                            break;
                        default:
                    }
                    break;
                case 4:
                    System.out.println("Enter task number: ");
                    numbertask = sc.nextInt();
                    Repository.deletetsk(numbertask);
                    break;
                case 5:
                    System.out.println("Select a status ");
                    System.out.println("1. TODO");
                    System.out.println("2. IN_PROGRESS");
                    System.out.println("3. DONE");
                    updatestatus = sc.nextInt();
                    sc.nextLine();
                    switch (updatestatus){
                        case 1:
                            Service.filter("TODO");
                            break;
                        case 2:
                            Service.filter("IN_PROGRESS");
                            break;
                        case 3:
                            Service.filter("DONE");
                            break;
                        default:
                    }
                    break;
                case 6:
                    System.out.println("Select a sort");
                    System.out.println("1. Sort by deadline");
                    System.out.println("2. Sort by status");
                    sort = sc.nextInt();
                    sc.nextLine();
                    switch (sort)
                    {
                        case 1:
                            Service.sortbydeadline();
                            break;
                        case 2:
                            Service.sortbystatus();
                            break;
                        default:
                    }
                    break;
                case 7:
                    statusprogramm = false;
                    break;
                default:
                    System.out.println("Warning!");
            }
        }
    }
}