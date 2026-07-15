package org.example;

import java.util.Scanner;

public class AfterLogin {
    Scanner sc = new Scanner(System.in);
    private Menu menu;
    public AfterLogin(Menu menu) {
        this.menu = menu;
    }

    public void loginSaving(BankAccount b){
        System.out.println("Logged in successfully!");
        System.out.println("<--------Welcome to your Savings Account-------->");
        boolean innerKey = false;
        while (!innerKey) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check your balance");
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
        }
    }

    public void loginCurrent(BankAccount b){
        System.out.println("Logged in successfully!");
        System.out.println("<--------Welcome to your Current Account-------->");
        boolean innerKey = false;
        while (!innerKey) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check your balance");
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
