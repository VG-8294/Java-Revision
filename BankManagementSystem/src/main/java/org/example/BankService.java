package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankService {
    Map<User, BankAccount> usersMap ;
    Scanner sc = new Scanner(System.in);

    public BankService() {
        this.usersMap = new HashMap<>();
    }

    public void registerUser(String name, String email, String password, int age, int acc, double balance){
            User user = new User(name, email, password, age);
            if(acc == 1){
                SavingsAccount sv = new SavingsAccount(balance);
                usersMap.put(user, sv);
            }
            else{
                CurrentAccount ca = new CurrentAccount(balance, 10000);
                usersMap.put(user, ca);
            }
            System.out.println("Congratulations, Your account has been created!");
    }

    public void loginUser(String mail, String password){
        boolean found = false;
        for (Map.Entry<User, BankAccount> entry : usersMap.entrySet()) {
            String userMail = entry.getKey().getEmail();
            String userPass = entry.getKey().getPassword();
            if (userMail.equals(mail) && userPass.equals(password)) {
                System.out.println("Logged in successfully!");
                found = true;
                BankAccount b = entry.getValue();
                boolean innerKey = false;
                while (!innerKey) {
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check your balance");
                    if (b instanceof SavingsAccount) {
                        System.out.println("4. Check your interest amount");
                        System.out.println("5. Exit");
                        System.out.println("Enter your choice");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter the amount you want to deposit:");
                                double depositAmt = sc.nextDouble();
                                b.deposit(depositAmt);
                                break;
                            case 2:
                                System.out.println("Enter the amount you want to withdraw:");
                                double withdrawAmt = sc.nextDouble();
                                b.withdraw(withdrawAmt);
                                break;
                            case 3:
                                double balAmt = b.checkBalance();
                                System.out.println("Your bank balance is :" + balAmt);
                                break;
                            case 4:
                                double inter = ((SavingsAccount) b).calculateInterest();
                                System.out.println("Your interest amount is: " + inter);
                                break;
                            case 5:
                                innerKey = true;
                                break;
                        }
                    } else {
                        System.out.println("4. Exit");
                        System.out.println("Enter your choice");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter the amount you want to deposit:");
                                double depositAmt = sc.nextDouble();
                                b.deposit(depositAmt);
                                break;
                            case 2:
                                System.out.println("Enter the amount you want to withdraw:");
                                double withdrawAmt = sc.nextDouble();
                                b.withdraw(withdrawAmt);
                                break;
                            case 3:
                                double balAmt = b.checkBalance();
                                System.out.println("Your bank balance is :" + balAmt);
                                break;
                            case 4:
                                innerKey = true;
                                break;
                        }
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Invalid email or password");
        }
    }
}

