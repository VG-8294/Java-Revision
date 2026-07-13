package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
//        SavingsAccount sv = new SavingsAccount(5000);
//        sv.deposit(2000);
//        sv.checkBalance();
//        sv.withdraw(3000);
//        sv.checkBalance();
//
//        CurrentAccount ca = new CurrentAccount(20000, 20000);
//        ca.checkBalance();
//        ca.withdraw(30000);
//        ca.checkBalance();
        List<User> allUsers = new ArrayList<>();
        boolean key = false;
        Scanner sc = new Scanner(System.in);
        while(!key){
            System.out.println("1. Open a new Account");
            System.out.println("2. Login to existing Account");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter your name");
                    String name = sc.next();
                    System.out.println("Enter your email");
                    String email = sc.next();
                    System.out.println("Enter your password");
                    String pass = sc.next();
                    System.out.println("Enter your age");
                    int age = sc.nextInt();
                    System.out.println("Which type of account you want?" +
                            "1. Saving" +
                            "2. Current");
                    int acc = sc.nextInt();
                    System.out.println("Enter your initial balance: ");
                    double bal = sc.nextDouble();
                    User user = new User(name, email, pass, age);
                    if(acc == 1){
                        SavingsAccount sv = new SavingsAccount(bal);
                    }
                    else{
                        CurrentAccount ca = new CurrentAccount(bal, 10000);
                    }
                    allUsers.add(user);
                    System.out.println("Congratulations, Your account has been created!");
                    break;
                case 2:
                    System.out.println("Enter your email");
                    String mail = sc.next();
                    System.out.println("Enter your password");
                    String password = sc.next();
                    boolean found = false;
                    for(User u: allUsers){
                        if(u.getEmail().equals(mail) && u.getPassword().equals(password)) {
                            found = true;
                            System.out.println("You are logged in successfully!");
                        }
                    }
                    if(!found){
                        System.out.println("Invalid email or password");
                    }
                    else{
                        boolean innerKey = false;
                        while(!innerKey){
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check your balance");
                            System.out.println("Enter your choice");
                            int choice = sc.nextInt();
                            switch(choice){
                                case 1:


                            }
                        }
                    }
                    break;

                default:
                    key = true;
                    break;
            }
        }
    }
}
