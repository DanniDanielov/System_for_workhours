package com.company;

public class Worker extends AddingNewWorker{
    protected String name;
    protected String password;

    public Worker(String name, String password){
        this.name = name;
        this.password = password;
    }

    public void menu(){
        // тука правиш малък диалог и питаш какво иска да се прави, т.е. дали иска да разпределя работата
        // или да провери протоколите
        // това са съответните класове
    }
}