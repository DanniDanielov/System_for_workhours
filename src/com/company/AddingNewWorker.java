package com.company;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class AddingNewWorker extends ChoosingNextStepAfterDoneAdmin implements AddingInterface{
    List<Worker> workerList = new ArrayList<>(10);
    Admin admin = new Admin();
    ReplacingExistingWorker replacingExistingWorker = new ReplacingExistingWorker();

    @Override
    public void isEnoughSpace(Scanner inpot) throws Exception {
        System.out.println("The current number of workers is: " + workerList.size());
        if (workerList.size() >= 10){
            throwingToReplacing(inpot);
        }else{
            addNew(inpot);
        }
    }

    @Override
    public void throwingToReplacing(Scanner inpot) throws Exception {
        System.out.println("Sorry but we reached our capacity of workers. Would you like to replace someone.");
        System.out.println("Do you want to replace someone of the workers?");
        String ans = inpot.nextLine();
        String ansLowerCase = ans.toLowerCase(Locale.ROOT);

        if (ansLowerCase.equals("yes")){
            replacingExistingWorker.replace(inpot);
        }else if(ansLowerCase.equals("no")){
            afterDone(inpot);
        }else {
            throwingToReplacing(inpot);
            throw new Exception("Invalid input!");
        }
    }

    @Override
    public void addNew(Scanner inpot) throws Exception {
            System.out.print("Please enter the name ID of the new worker here: ");
            String nickname = inpot.nextLine();
            if (workerList.contains(nickname)){
                addNew(inpot);
                throw new Exception("This user name is already taken! Please insert new nickname.");
            }else {
                System.out.print("Choose an unique password for this user here: ");
                String password = inpot.nextLine();
                    Worker worker = new Worker(nickname, password);
                    workerList.add(worker);
                    System.out.println("Worker " + nickname + " has been successfully added!");
                    System.out.println("The work ID of " + nickname + " is: " + workerList.indexOf(worker));
                    Gson gson = new GsonBuilder().create();
                    JsonArray jsonArray = gson.toJsonTree(workerList).getAsJsonArray();
                    FileWriter file = new FileWriter("WorkerFile.json");
                    file.write(String.valueOf(jsonArray));
                    file.flush();
                    admin.menu(inpot);
            }
        }
    }
