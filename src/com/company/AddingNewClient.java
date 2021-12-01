package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class
AddingNewClient extends ChoosingNextStepAfterDoneAdmin implements AddingInterface{
    private String projectName;

    List<Client> clientList = new ArrayList<>(10);
    Admin admin = new Admin();
    ReplacingExistingClient replacingExistingClient = new ReplacingExistingClient();

    @Override
    public void isEnoughSpace(Scanner inpot) throws Exception {
        System.out.println("The current number of clients is: " + clientList.size());
        if (clientList.size() >= 10){
            throwingToReplacing(inpot);
        }else {
            addNew(inpot);
        }
    }

    @Override
    public void throwingToReplacing(Scanner inpot) throws Exception {
        System.out.println("Sorry but we have reached the capacity of clients. Would you like to replace someone: ");
        System.out.println("Would you like to replace existing client?");
        String ans = inpot.nextLine();
        String ansLowerCase = ans.toLowerCase(Locale.ROOT);
        StartUpMenu start = new StartUpMenu();

        if (ansLowerCase.equals("yes")){
            replacingExistingClient.replace(inpot);
        }else if(ansLowerCase.equals("no")){
            afterDone(inpot);
        }else {
            throwingToReplacing(inpot);
            throw new Exception("Invalid input!");
        }
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public void addNew(Scanner inpot) throws Exception {
            System.out.print("Please enter the name ID of the client here: ");
            String name = inpot.nextLine();

            if (clientList.contains(name)){
                addNew(inpot);
                throw new Exception("This client name is already taken! Please enter new name for this client!");
            }else{
                System.out.print("Please enter the name of the project here: ");
                String projectName = inpot.nextLine();
                setProjectName(projectName);
                System.out.println("Please enter the ending date for this project: " + projectName + " in format 'dd/MM/yyyy'.");
                String dateOfExpire = inpot.nextLine();

                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate finalDate = LocalDate.parse(dateOfExpire, dtf);
                    Client client = new Client(name, projectName, finalDate);
                    clientList.add(client);
                    System.out.println("This client " + name + " has client ID: " + clientList.indexOf(client));
                    Gson gson = new GsonBuilder().create();
                    JsonArray jsonArray = gson.toJsonTree(clientList).getAsJsonArray();
                    FileWriter file = new FileWriter("ClientsFile.json");
                    file.write(String.valueOf(jsonArray));
                    file.flush();
                    admin.menu(inpot);
                }catch (Exception e){
                    addNew(inpot);
                    new Exception("The date format is not correct!");
                }
            }
        }
    }