package com.company;

import java.time.LocalDate;

public class Client extends Admin{
    protected String name;
    protected String projectName;
    protected LocalDate expiringDate;

    public Client(String name, String projectName, LocalDate expiringDate){
        this.name = name;
        this.projectName = projectName;
        this.expiringDate = expiringDate;
    }
}
