package com.company;

import java.util.Scanner;

public abstract class ChoosingNextStepAfterDoneAdmin {
    public void afterDone(Scanner inpot) throws Exception {
        Admin adminMenu = new Admin();
        StartUpMenu start = new StartUpMenu();

        System.out.println("Do you want to: ");
        System.out.println("1 - exit to admin menu");
        System.out.println("2 - exit to main menu");
        System.out.println("3 - exit the program");
        byte ans = inpot.nextByte();

        switch (ans){
            case 1 -> adminMenu.menu(inpot);
            case 2 -> start.startUp(inpot);
            case 3 -> {
                System.out.println("Thank you");
                break;
            }
            default -> {
                afterDone(inpot);
                throw new Exception("Invalid input");
            }
        }
    }
}
