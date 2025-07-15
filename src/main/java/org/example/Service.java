package org.example;

import javax.swing.text.Style;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Service {

    private String name;
    private String description;
    private  LocalDate deadline;
    private String status;

    public Service(String name, String description, LocalDate deadline, String status) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name + ", " + description + ", " + deadline + ", " + status;
    }
}
