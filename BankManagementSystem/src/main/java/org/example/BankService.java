package org.example;

import java.util.Map;
import java.util.Scanner;

public class BankService {
    private Map<User, BankAccount> usersMap ;
    private ConsoleUI ui;
    public BankService(Map<User, BankAccount> usersMap, ConsoleUI ui) {
        this.usersMap = usersMap;
        this.ui = ui;
    }

    public void registerUser(){
            RegisterRequest rr = ui.registerMenu();
            User user = new User(rr.getName(), rr.getEmail(), rr.getPassword(), rr.getAge());
            if(rr.isAcc()){
                SavingsAccount sv = new SavingsAccount(rr.getInitialAmt());
                usersMap.put(user, sv);
            }
            else{
                CurrentAccount ca = new CurrentAccount(rr.getInitialAmt(), 10000);
                usersMap.put(user, ca);
            }
           ui.congrats();
    }

    private BankAccount authenticate(String mail, String password){
        for (Map.Entry<User, BankAccount> entry : usersMap.entrySet()) {
            String userMail = entry.getKey().getEmail();
            String userPass = entry.getKey().getPassword();
            if (userMail.equals(mail) && userPass.equals(password)) {
                BankAccount b = entry.getValue();
                return b;
            }
        }
        return null;
    }

    public void loginUser(){
            LoginRequest lr = ui.loginMenu();
            BankAccount b = authenticate(lr.getEmail(), lr.getPassword());
            if (b instanceof SavingsAccount) {
                ui.greeting();
                boolean innerKey = false;
                while (!innerKey) {
                    int choice = ui.SavingsMenu();
                    switch (choice) {
                        case 1:
                            double depositAmt = ui.deposit();
                            b.deposit(depositAmt);
                            break;
                        case 2:
                            double withdrawAmt =  ui.withdraw();
                            b.withdraw(withdrawAmt);
                            break;
                        case 3:
                            double balAmt = b.checkBalance();
                            ui.balance(balAmt);
                            break;
                        case 4:
                            double inter = ((SavingsAccount) b).calculateInterest();
                            ui.interest(inter);
                            break;
                        case 5:
                            innerKey = true;
                            break;
                    }
                }
            }
            else if(b instanceof CurrentAccount){
                ui.greeting();
                boolean innerKey = false;
                while (!innerKey) {
                    int choice = ui.currentMenu();
                    switch (choice) {
                        case 1:
                            double depositAmt = ui.deposit();
                            b.deposit(depositAmt);
                            break;
                        case 2:
                            double withdrawAmt = ui.withdraw();
                            b.withdraw(withdrawAmt);
                            break;
                        case 3:
                            double balAmt = b.checkBalance();
                            ui.balance(balAmt);
                            break;
                        case 4:
                            innerKey = true;
                            break;
                    }
                }
            }
            else{
                ui.warning();
            }
        }
    }

