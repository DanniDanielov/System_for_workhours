package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingNewWorker extends Admin{
    protected List<String> workerNicknameList = new ArrayList<>(10);
    protected List<String> workerPasswordList = new ArrayList<>(10);

    protected void addNewWorker() throws Exception {
        //проверка дали има достатъчно място - да
        // проверка дали вече същестува - да
        //създаване на име и парола. Записване в съответните листове - да
        Scanner inpot = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println("The current number of workers is: " + workerNicknameList.size());
        if (workerNicknameList.size() >= 10){
            System.out.println("Sorry but we reached our capacity of workers. Would you like to replace someone.");
            //направи логика за замяна на елемент от листовете
        }else{
            System.out.print("Please write the name ID of the new worker here: ");
            String nickname = inpot.nextLine();

            if (workerNicknameList.contains(nickname)){
                throw new Exception("This user name is already taken! Please insert new nickname.");
            }else {
                workerNicknameList.add(nickname);
                System.out.println("And choose an unique password for this user here: ");
                String password = inpot.nextLine();
                workerPasswordList.add(password);

                System.out.println("Worker " + nickname + " has been successfully added!");
                System.out.println("The work ID of " + nickname + " is: " + workerNicknameList.indexOf(nickname));
                admin.menu();
            }
        }
    }
}
