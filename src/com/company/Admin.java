package com.company;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Admin extends Login{
    // да може да добавя нови клиенти и служители, които имена и пароли да се съдържат в съответните листове

    public void menu() throws Exception {
        Scanner inpot = new Scanner(System.in);
        AddingNewWorker worked = new AddingNewWorker();
        AddingNewClient client = new AddingNewClient();

        System.out.println("Hello and welcome to admin.");
        System.out.println("What would you like to do: ");
        System.out.println("1 - add new worker");
        System.out.println("2 - add new client");
        System.out.println("3 - check worker statistics");
        System.out.print("Here: ");
        byte adminMenuChoosing = inpot.nextByte();

        switch (adminMenuChoosing){
            case 1: worked.addNewWorker();
            break;

            case 2: client.addNewClient();
            break;

            case 3: workerStatistic();
            break;

            default: throw new Exception("Invalid input!");
        }
    }

    public void workerStatistic(){
        // търси го по име и изкарва колко време е работил и по кои проекти
    }

    //да се направи метод, в който да търси по дадена седмица и да вижда статистики на служителите
}
