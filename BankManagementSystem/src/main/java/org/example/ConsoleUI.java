package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI {
    Scanner sc = new Scanner(System.in);

    public int mainMenu(){
        System.out.println("1. Open a new Account");
        System.out.println("2. Login to existing Account");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();
        return ch;
    }

    public RegisterRequest registerMenu(){
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
        int accNo = sc.nextInt();
        boolean acc = false;
        if(accNo == 1){
            acc = true;
        }
        System.out.println("Enter your initial balance: ");
        double bal = sc.nextDouble();
        RegisterRequest rr = new RegisterRequest(name, email, pass, age, acc, bal);
        return rr;
    }

    public LoginRequest loginMenu(){
        System.out.println("Enter your email");
        String mail = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();
        Map<String, String> mp = new HashMap<>();
        return new LoginRequest(mail, password);
    }


    public void greeting(){
        System.out.println("Logged in successfully!");
        System.out.println("<--------Welcome to your Account-------->");
    }

    public int SavingsMenu(){
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check your balance");
        System.out.println("4. Check your interest amount");
        System.out.println("5. Exit");
        System.out.println("Enter your choice");
        return sc.nextInt();
    }

    public double deposit(){
        System.out.println("Enter the amount you want to deposit:");
        return sc.nextDouble();
    }

    public double withdraw(){
        System.out.println("Enter the amount you want to withdraw:");
        return sc.nextDouble();
    }

    public void balance(double bal){
        System.out.println("Your bank balance is :" + bal);
    }

    public void interest(double inter){
        System.out.println("Your interest amount is: " + inter);
    }

    public int currentMenu(){
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check your balance");
        System.out.println("4. Exit");
        System.out.println("Enter your choice");
        return sc.nextInt();
    }

    public void warning(){
        System.out.println("Invalid email or password!");
    }

    public void congrats(){
        System.out.println("Congratulations, Your account has been created!");
    }

}
