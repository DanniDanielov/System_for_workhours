package com.company;

import java.util.Scanner;

public interface LoginInterface {
    void adminLogin(String password, Scanner inpot) throws Exception ;
    void workerLogin(String nickname, String password) throws Exception ;
}
