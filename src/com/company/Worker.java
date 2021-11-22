package com.company;

public class Worker extends AddingNewWorker{
    protected String name;
    protected String password;
    protected AddingNewClient client;

    public Worker(String name, String password, AddingNewClient client){
        this.name = name;
        this.password = password;
        this.client = client;
    }


    public void menu(){

    }

    public void createProtocol(){
        // създава протокол, който се въвежа по кoй проект е работил и по колко време е работил
        // ще трябва това да се изкарва в статистиките в админ и да се изписва
        // трябва да съответства с работника

    }
}