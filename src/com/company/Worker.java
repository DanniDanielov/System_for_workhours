package com.company;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Worker extends AddingNewWorker {
    protected String name;
    protected String password;

    public Worker (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void menu (Scanner inpot) throws IOException {
        // тука правиш малък диалог и питаш какво иска да се прави, т.е. дали иска да разпределя работата
        // или да провери протоколите
        // това са съответните класове
        System.out.println("Write a name of a project");
        String choice = inpot.nextLine();
        AddingNewClient addingNewClient = new AddingNewClient();
        for (Client client : addingNewClient.clientList) {
            if (client.projectName.equals(choice) && client.expiringDate.isAfter(LocalDate.now())) {
             Login login= new Login();

                WorkDistribution distribution = new WorkDistribution();
                System.out.print("Write working hours: ");
                int hours = inpot.nextInt();
                distribution.clientDistribution(hours);
            }
            else {
                System.out.println("Don't have project with that name");

            }

        }
    }
}