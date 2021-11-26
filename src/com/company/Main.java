package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner inpot = new Scanner(System.in);
        StartUpMenu start = new StartUpMenu();

        start.startUp(inpot);
    }
}