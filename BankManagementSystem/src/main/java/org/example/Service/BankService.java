package org.example.Service;

import org.example.Entity.BankAccount;
import org.example.Entity.CurrentAccount;
import org.example.Entity.SavingsAccount;
import org.example.DTO.LoginRequest;
import org.example.DTO.RegisterRequest;
import org.example.Entity.User;
import org.example.UI.ConsoleUI;
import org.example.Validations.Validations;

import java.util.Map;

public class BankService {
    private final Map<User, BankAccount> usersMap ;
    private ConsoleUI ui;
    Validations valid;
    public BankService(Map<User, BankAccount> usersMap, ConsoleUI ui) {
        this.usersMap = usersMap;
        this.ui = ui;
    }

    public void start(){
        boolean key = false;
        while (!key) {
            int ch = ui.mainMenu();
            switch (ch) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;

                case 3:
                    key = true;
                    break;
            }
        }
    }

    private void registerUser(){
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
                return entry.getValue();
            }
        }
        return null;
    }

    private boolean isSavings(BankAccount b){
        return b instanceof SavingsAccount;
    }

    private void loginUser(){
            LoginRequest lr = ui.loginMenu();
            BankAccount b = authenticate(lr.getEmail(), lr.getPassword());
            if(b != null){
                ui.greeting();
                boolean innerKey = false;
                while (!innerKey) {
                    int ch;

                    if(isSavings(b)){
                        ch = ui.SavingsMenu();
                    }
                    else{
                        ch = ui.currentMenu();
                    }
                    switch (ch) {
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
                            if(isSavings(b)){
                                double inter = ((SavingsAccount) b).calculateInterest();
                                ui.interest(inter);
                            }
                            else{
                                innerKey = true;
                            }
                            break;
                        case 5:
                            if(b instanceof SavingsAccount){
                                innerKey = true;
                            }
                            break;
                    }
                }
            }
            else{
                ui.warning();
            }
    }
}

