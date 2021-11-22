package com.company;

import java.util.Scanner;

public class ReplacingExistingWorker extends AddingNewWorker{
    AddingNewWorker worker = new AddingNewWorker();
    private AddingNewClient client;

    protected void replace(Scanner inpot) throws Exception {
        System.out.print("Enter the name of the new worker: ");
        String name = inpot.nextLine();
        System.out.print("Enter a password for the new worker: ");
        String password = inpot.nextLine();
        System.out.print("Enter the work ID of the worker you want to replace: ");
        byte id = inpot.nextByte();
        System.out.print("And enter the name of the assigned client here: ");
        String assClient = inpot.nextLine();
        if (assClient.equals(client.clientList)){
            Worker newWorker = new Worker(name, password, client);
            worker.workerList.set(id, newWorker);
        }else{
            throw new Exception("Invalid client's name!");
        }
    }
}
