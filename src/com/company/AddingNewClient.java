package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AddingNewClient extends Admin{
    List<Client> clientList = new ArrayList<>(10);
    Admin admin = new Admin();
    ReplacingExistingClient replacingExistingClient = new ReplacingExistingClient();

    protected void addNewClient(Scanner inpot) throws Exception {
        //проверка дали има достатъчно място - да
        //да провери дали вече съществува - да
        //създава нов клиент и го записва в лист - да

        System.out.println("The current number of clients is: " + clientList.size());
        if (clientList.size() >= 10){
            System.out.println("Sorry but we have reached the capacity of clients. Would you like to replace someone: ");
            System.out.println("Would you like to replace existing client?");
            String ans = inpot.nextLine();
            String ansLowerCase = ans.toLowerCase(Locale.ROOT);

            if (ansLowerCase.equals("yes")){
                replacingExistingClient.replace(inpot);
            }else if(ansLowerCase.equals("no")){
                //измисли на къде трябва да продължава оттук. Дали да свършва или да дава възможност между изход и началото
            }else {
                throw new Exception("Invalid input!");
            }
        }else{
            System.out.print("Please enter the name ID of the client here: ");
            String name = inpot.nextLine();

            if (clientList.contains(name)){
                throw new Exception("This client name is already taken! Please enter new name for this client!");
                //провери дали връща на същото място ил трябва да допълня!!!
            }else{
                System.out.print("Please enter the name of the project here: ");
                String projectName = inpot.nextLine();
                System.out.println("Please enter the ending date for this project: " + projectName + " in format 'dd/MM/yyyy'.");
                String dateOfExpire = inpot.nextLine();

                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate finalDate = LocalDate.parse(dateOfExpire, dtf);
                    Client client = new Client(name, projectName, finalDate);
                    clientList.add(client);
                    System.out.println("This client " + name + " has client ID: " + clientList.indexOf(client));
                    admin.menu(inpot);
                }catch (Exception e){
                    new Exception("The date format is not correct!");
                    //провери къде те връща оттук!!!!
                }
            }
        }
    }
}