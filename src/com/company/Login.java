package com.company;

import java.util.Scanner;


public class Login implements LoginInterface{
    @Override
    public void adminLogin(String password, Scanner inpot) throws Exception {
        Admin admin = new Admin();
        StartUpMenu start = new StartUpMenu();

        if (password.equals("аdmin")){
            System.out.println("Access granted!");
            admin.menu(inpot);
        }else{
            start.loginAsAdmin(inpot);
            throw new Exception("Access denied! Invalid password.");
        }
    }

    @Override
    public void workerLogin(String nickname, String password, Scanner inpot) throws Exception {
        AddingNewWorker workerList = new AddingNewWorker();
        Worker worker = new Worker(nickname, password);
        StartUpMenu start = new StartUpMenu();


        if (workerList.workerList.contains(nickname)){
            if (workerList.workerList.contains(password)){
                System.out.println("Access granted.");
                System.out.println("The work ID number of: " + nickname + " is: " + workerList.workerList.indexOf(nickname));
                worker.menu(inpot);
            }else{
                start.loginAsWorker(inpot);
                throw new Exception("Access denied! Invalid password.");
            }
        }else{
            start.loginAsWorker(inpot);
            throw new Exception("Access denied! Invalid nickname");
        }
    }
}