package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
            //направи логика за замяна на елемент от листовете - да
            System.out.println("Do you want to replace someone of the workers?");
            String ans = inpot.nextLine();
            String ansLowerCase = ans.toLowerCase(Locale.ROOT);

            if (ansLowerCase.equals("yes")){
                System.out.print("Please insert the work ID here: ");
                int workerId = inpot.nextByte();
                System.out.print("Please enter the name of the new worker here: ");
                String workerName = inpot.nextLine();
                System.out.print("And please enter password for the new worker here: ");
                String workerPass = inpot.nextLine();
                workerNicknameList.set(workerId,workerName);
                workerPasswordList.set(workerId, workerPass);

                System.out.println("The change has been successfully made. The new worker: " + workerName + " has work ID: " + workerId + ".");
            }else{
                //измисли на къде трябва да продължава оттук. Дали да свършва или да дава възможност между изход и началото
            }
        }else{
            System.out.print("Please enter the name ID of the new worker here: ");
            String nickname = inpot.nextLine();

            if (workerNicknameList.contains(nickname)){
                throw new Exception("This user name is already taken! Please insert new nickname.");
                //провери дали връща на същото място ил трябва да допълня!!!
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
