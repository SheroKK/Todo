package org.example;

import javax.swing.text.Style;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Service {


    public static void  createtask (String name,String decription,String deadline)
    {
        Repository.timedatemap.put(decription,deadline);
        Repository.datemap.put(name,Repository.timedatemap);
    }
}
