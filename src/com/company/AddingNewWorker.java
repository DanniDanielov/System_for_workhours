package com.company;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class AddingNewWorker{
    List<Worker> workerList = new ArrayList<>(10);
    Admin admin = new Admin();
    ReplacingExistingWorker replacingExistingWorker = new ReplacingExistingWorker();
    private AddingNewClient client;

    protected void isEnoughSpace(Scanner inpot) throws Exception {
        System.out.println("The current number of workers is: " + workerList.size());
        if (workerList.size() >= 10){
            throwingToReplacing(inpot);
        }else{
            addNewWorker(inpot);
        }
    }

    protected void throwingToReplacing(Scanner inpot) throws Exception {
        System.out.println("Sorry but we reached our capacity of workers. Would you like to replace someone.");
        //направи логика за замяна на елемент от листовете - да
        System.out.println("Do you want to replace someone of the workers?");
        String ans = inpot.nextLine();
        String ansLowerCase = ans.toLowerCase(Locale.ROOT);

        if (ansLowerCase.equals("yes")){
            replacingExistingWorker.replace(inpot);
        }else if(ansLowerCase.equals("no")){
            //измисли на къде трябва да продължава оттук. Дали да свършва или да дава възможност между изход и началото
        }else {
            throw new Exception("Invalid input!");
        }
    }

    protected void addNewWorker(Scanner inpot) throws Exception {
            System.out.print("Please enter the name ID of the new worker here: ");
            String nickname = inpot.nextLine();
            if (workerList.contains(nickname)){
                throw new Exception("This user name is already taken! Please insert new nickname.");
                //провери дали връща на същото място ил трябва да допълня!!!
            }else {
                System.out.print("Choose an unique password for this user here: ");
                String password = inpot.nextLine();
                System.out.print("And please insert the name of the client that this worker will assign here: ");
                String assClient = inpot.nextLine();
                if (assClient.equals(client.clientList)) {
                    Worker worker = new Worker(nickname, password, client);
                    workerList.add(worker);
                    System.out.println("Worker " + nickname + " has been successfully added!");
                    System.out.println("The work ID of " + nickname + " is: " + workerList.indexOf(worker));
                    Gson gson = new GsonBuilder().create();
                    JsonArray jsonArray = gson.toJsonTree(workerList).getAsJsonArray();
                    FileWriter file = new FileWriter("GsonFile.json");
                    file.write(String.valueOf(jsonArray));
                    file.flush();
                    admin.menu(inpot);
                }else{
                    throw new Exception("Invalid client's name!");
                }
            }
        }
    }
