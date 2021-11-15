package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingNewClient extends Admin{
    protected List<String> clientNameList = new ArrayList<>(10);
    protected List<String> clientProjNameList = new ArrayList<>(10);
    protected List<LocalDate> dateOfExpressionOfProjList = new ArrayList<>(10);

    protected void addNewClient() throws Exception {
        //проверка дали има достатъчно място - да
        //да провери дали вече съществува - да
        //създава нов клиент и го записва в лист - да
        Scanner inpot = new Scanner(System.in);

        System.out.println("The current number of clients is: " + clientNameList.size());
        if (clientNameList.size() >= 10){
            System.out.println("Sorry but we have reached the capacity of clients. Would you like to replace someone: ");
            //продължи с смяната на клиенти
        }else{
            System.out.print("Please enter the name ID of the client here: ");
            String clientName = inpot.nextLine();

            if (clientNameList.contains(clientName)){
                throw new Exception("This client name is already taken! Please enter new name for this client!");
                //провери дали връща на същото място ил трябва да допълня!!!
            }else{
                clientNameList.add(clientName);
                System.out.print("Please enter the name of the project here: ");
                String projectName = inpot.nextLine();
                clientProjNameList.add(projectName);

                System.out.println("Please enter the ending date for this project: " + projectName + " in format 'dd/MM/yyyy'.");
                String dateOfExpire = inpot.nextLine();

                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate finalDate = LocalDate.parse(dateOfExpire, dtf);

                    dateOfExpressionOfProjList.add(finalDate);
                }catch (Exception e){
                    new Exception("The date format is not correct!");
                    //провери къде те връща оттук!!!!
                }
            }
        }
    }
}