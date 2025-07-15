package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Repository {

    static Map <Integer, Service> datemap = new HashMap<>()   ;
    static int COUNT = 1;

    public  static void createtask (Service service)
    {
        datemap.put(COUNT,service);
        COUNT++;
    }
    public static void  readalltask()
    {
        String readmap = datemap.entrySet().stream().map(e->e.getKey() +": " + e.getValue()).collect(Collectors.joining(", "));
        System.out.println(readmap);
    }

    public static void  updatetask (int numbertask,Service service){
        datemap.replace(numbertask, service);
    }
    public static void  deletetsk(int numbertask)
    {
        datemap.remove(numbertask);
    }

}
