package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Map<User, BankAccount> usersMap = new HashMap<>();
        boolean key = false;
        Scanner sc = new Scanner(System.in);
        while(!key){
            System.out.println("1. Open a new Account");
            System.out.println("2. Login to existing Account");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:
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
                    User user = new User(name, email, pass, age);
                    if(acc == 1){
                        SavingsAccount sv = new SavingsAccount(bal);
                        usersMap.put(user, sv);
                    }
                    else{
                        CurrentAccount ca = new CurrentAccount(bal, 10000);
                        usersMap.put(user, ca);
                    }
                    System.out.println("Congratulations, Your account has been created!");
                    break;
                case 2:
                    System.out.println("Enter your email");
                    String mail = sc.next();
                    System.out.println("Enter your password");
                    String password = sc.next();
                    boolean found = false;
                    for(Map.Entry<User, BankAccount> entry: usersMap.entrySet()){
                        String userMail = entry.getKey().getEmail();
                        String userPass = entry.getKey().getPassword();
                        if(userMail.equals(mail) && userPass.equals(password)){
                            System.out.println("Logged in successfully!");
                            found = true;
                            BankAccount b = entry.getValue();
                            boolean innerKey = false;
                            while(!innerKey){
                                System.out.println("1. Deposit");
                                System.out.println("2. Withdraw");
                                System.out.println("3. Check your balance");
                                if(b instanceof SavingsAccount){
                                    System.out.println("4. Check your interest amount");
                                    System.out.println("5. Exit");
                                    System.out.println("Enter your choice");
                                    int choice = sc.nextInt();
                                    switch(choice){
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
                                else {
                                    System.out.println("4. Exit");
                                    System.out.println("Enter your choice");
                                    int choice = sc.nextInt();
                                    switch(choice){
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
                    if(!found){
                        System.out.println("Invalid email or password");
                    }
                    break;

                case 3:
                    key = true;
                    break;
            }
        }
    }
}
