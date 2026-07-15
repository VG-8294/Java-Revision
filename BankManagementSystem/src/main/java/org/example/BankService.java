package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankService {
    Map<User, BankAccount> usersMap ;
    Scanner sc = new Scanner(System.in);
    private AfterLogin afl;
    private Menu menu;
    public BankService(AfterLogin afterLogin, Menu menu) {
        this.usersMap = new HashMap<>();
        this.afl = afterLogin;
        this.menu = menu;
    }

    public void registerUser(){
            RegisterRequest rr = menu.registerMenu();
            User user = new User(rr.getName(), rr.getEmail(), rr.getPassword(), rr.getAge());
            if(rr.isAcc()){
                SavingsAccount sv = new SavingsAccount(rr.getInitialAmt());
                usersMap.put(user, sv);
            }
            else{
                CurrentAccount ca = new CurrentAccount(rr.getInitialAmt(), 10000);
                usersMap.put(user, ca);
            }
            System.out.println("Congratulations, Your account has been created!");
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
            LoginRequest lr = menu.loginMenu();
            BankAccount b = authenticate(lr.getEmail(), lr.getPassword());
            if (b instanceof SavingsAccount) {
                afl.loginSaving(b);
            }
            else if(b instanceof CurrentAccount){
                afl.loginCurrent(b);
            }
            else{
                System.out.println("User not found!");
            }
        }
    }

