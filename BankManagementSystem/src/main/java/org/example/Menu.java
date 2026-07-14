package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    BankService bs = new BankService();

    public int mainMenu(){
        System.out.println("1. Open a new Account");
        System.out.println("2. Login to existing Account");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();
        return ch;
    }

    public void registerMenu(){
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your email");
        String email = sc.next();
        System.out.println("Enter your password");
        String pass = sc.next();
        System.out.println("Enter your age");
        int age = sc.nextInt();
        System.out.println("Which type of account you want?\n" +
                "1. Saving\n" +
                "2. Current");
        int acc = sc.nextInt();
        System.out.println("Enter your initial balance: ");
        double bal = sc.nextDouble();
        bs.registerUser(name, email, pass, age, acc, bal);

    }

    public void loginMenu(){
        System.out.println("Enter your email");
        String mail = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();
        bs.loginUser(mail, password);
    }

    public void savingsMenu(){
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check your balance");
        System.out.println("4. Check your interest amount");
        System.out.println("5. Exit");
        System.out.println("Enter your choice");
    }

    public void currentMenu(){
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check your balance");
        System.out.println("5. Exit");
        System.out.println("Enter your choice");
    }
}
