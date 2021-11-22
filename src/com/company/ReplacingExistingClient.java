package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReplacingExistingClient extends AddingNewClient{
    AddingNewClient client = new AddingNewClient();

    protected void replace(Scanner inpot){
        System.out.print("Please enter the name of the new worker: ");
        String name = inpot.nextLine();
        System.out.print("Please enter the name of the project: ");
        String projectName = inpot.nextLine();
        System.out.println("Please enter the ending date for this project: " + projectName + " in format 'dd/MM/yyyy'.");
        String dateOfExpire = inpot.nextLine();

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate finalDate = LocalDate.parse(dateOfExpire, dtf);
            Client client = new Client(name, projectName, finalDate);
            System.out.println("Please enter the client ID of the one that you want to replace: ");
            byte oldId = inpot.nextByte();
            clientList.set(oldId, client);
            System.out.println("This client " + name + " has client ID: " + clientList.indexOf(client));
            admin.menu(inpot);
        }catch (Exception e){
            new Exception("The date format is not correct!");
            //провери къде те връща оттук!!!!
        }
    }
}
