package com.company;


import java.util.Scanner;

public class Worker extends AddingNewWorker {
    protected String name;
    protected String password;
    Scanner inpot = new Scanner(System.in);

    public Worker (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void menu () {
        // тука правиш малък диалог и питаш какво иска да се прави, т.е. дали иска да разпределя работата
        // или да провери протоколите
        // това са съответните класове
        System.out.println("Write a name of a project");
        String choice = inpot.nextLine();
        AddingNewClient addingNewClient = new AddingNewClient();
        for (Client client : addingNewClient.clientList) {
            if (client.projectName.equals(choice)) {
                WorkDistribution distribution = new WorkDistribution();
                distribution.clientDistribution(Integer.parseInt(inpot.next()));
            }
            else {
                System.out.println("Don't have project with that name");
            }

        }
    }
}