package com.company;

import java.util.Scanner;

public class Login {
    //прави се проверка за какъв иска да е: админ или служител - да
    //в main
    //служител

    public void adminLogin(Scanner password) throws Exception {
        Admin admin = new Admin();

        if (password.equals("аdmin")){
            System.out.println("Access granted!");
            admin.menu();
        }else{
            throw new Exception("Access denied! Invalid password.");
        }
    }

    protected void workerLogin(Scanner nickname, Scanner password) throws Exception {
        AddingNewWorker worker = new AddingNewWorker();

        if (worker.workerNicknameList.contains(nickname)){
            if (worker.workerPasswordList.contains(password)){
                System.out.println("Access granted.");
                System.out.println("The work ID number of: " + nickname + " is: " + worker.workerNicknameList.indexOf(nickname));
                worker.menu();
            }else{
                throw new Exception("Access denied! Invalid password.");
            }
        }else{
            throw new Exception("Access denied! Invalid nickname");
        }
    }
}