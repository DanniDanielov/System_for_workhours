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
            Worker newWorker = new Worker(name, password);
            worker.workerList.set(id, newWorker);
    }
}
