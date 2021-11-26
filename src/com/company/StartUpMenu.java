package com.company;

import java.util.Locale;
import java.util.Scanner;

public class StartUpMenu extends ChoosingNextStepAfterDoneWorker{

    public void startUp(Scanner inpot) throws Exception {
        System.out.println("Hello and welcome to our program for monitoring the work hours in your company.");
        System.out.println("Please enter as the position you want to be logged as: ");
        System.out.println("Admin or worker.");
        System.out.print("Here: ");
        String loginPos = inpot.nextLine();
        String lowerCase = loginPos.toLowerCase(Locale.ROOT);

        if (lowerCase.equals("admin")){
            loginAsAdmin(inpot);
        }else if (lowerCase.equals("worker")){
            loginAsWorker(inpot);
        }else {
            startUp(inpot);
            throw new Exception("Invalid input!");
        }
    }

    public void loginAsAdmin(Scanner inpot){
        Login log = new Login();

        System.out.println("You have chosen to login as admin.");
        System.out.print("Please enter the password for admin here: ");
        String pass = inpot.nextLine();
        try {
            log.adminLogin(pass, inpot);
        }catch (Exception e){
            System.out.println("Pssss... the password is 'admin'.");
            loginAsAdmin(inpot);
        }
    }

    public void loginAsWorker(Scanner inpot) throws Exception {
        Login log = new Login();

        System.out.println("You have chosen to login as worker");
        System.out.println("Please enter the username and password of the worker.");
        try {
            System.out.print("Username: ");
            String nickname = inpot.nextLine();
            try {
                System.out.print("Password: ");
                String password = inpot.nextLine();
                log.workerLogin(nickname,password, inpot);
            }catch (Exception e){
                System.out.println("Invalid password!");
                afterDone(inpot);
            }
        }catch (Exception e){
            System.out.println("Invalid username!");
            afterDone(inpot);
        }
    }
}
