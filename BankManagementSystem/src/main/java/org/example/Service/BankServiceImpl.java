package org.example.Service;

import org.example.Entity.*;
import org.example.DTO.LoginRequest;
import org.example.DTO.RegisterRequest;
import org.example.Enum.AccountType;
import org.example.Exception.InvalidAgeException;
import org.example.Exception.InvalidBalanceException;
import org.example.Exception.InvalidInputException;
import org.example.UI.ConsoleUI;
import org.example.UI.ConsoleUiImpl;
import org.example.Validations.Validation;
import org.example.Validations.ValidationImpl;

import java.util.Map;

public class BankServiceImpl implements BankServices {
    private final Map<User, BankAccount> usersMap;
    private final ConsoleUI ui;
    private final Validation valid;
    private final AdminServices adminServices;

    public BankServiceImpl(
            Map<User, BankAccount> usersMap,
            ConsoleUI ui,
            Validation valid,
            AdminServices adminServices) {

        this.usersMap = usersMap;
        this.ui = ui;
        this.valid = valid;
        this.adminServices = adminServices;
    }

    @Override
    public void start() throws InvalidAgeException {
        boolean key = false;
        while (!key) {
            int ch = ui.mainMenu();
            try{
                valid.validateInput(4, ch);
            }
            catch (InvalidInputException e){
                System.out.println(e.getMessage());
            }
            switch (ch) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;

                case 3:
                    adminServices.loginAsAdmin();
                    break;

                case 4:
                    key = true;
                    break;
            }
        }
    }

    @Override
    public void registerUser() {
            RegisterRequest rr = ui.registerMenu();
            User user = new User(rr.getName(), rr.getEmail(), rr.getPassword(), rr.getAge());
            if (rr.isAcc() == AccountType.SAVING) {
                SavingsAccount sv = new SavingsAccount(rr.getInitialAmt());
                usersMap.put(user, sv);
                ui.congrats(sv.getAccNo());
            }
            else{
                CurrentAccount ca = new CurrentAccount(rr.getInitialAmt(), 10000);
                usersMap.put(user, ca);
                ui.congrats(ca.getAccNo());
            }
    }
    //Java 8 implementation - Streams
    private BankAccount authenticate(int accNo, String mail, String password){
        return usersMap.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getEmail().equals(mail) && entry.getKey().getPassword().equals(password) && entry.getValue().getAccNo() == accNo)
                .map(Map.Entry::getValue)  // method-reference implementation
                .findFirst()
                .orElse(null);
    }

    private boolean isSavings(BankAccount b){
        return b instanceof SavingsAccount;
    }

    @Override
    public void loginUser(){
            LoginRequest lr = ui.loginMenu();
            BankAccount b = authenticate(lr.getAccNo(), lr.getEmail(), lr.getPassword());
            if(b != null){
                ui.greeting();
                boolean innerKey = false;
                while (!innerKey) {
                    int ch;
                    if(isSavings(b)){
                        ch = ui.SavingsMenu();
                        try{
                            valid.validateInput(5, ch);
                        }
                        catch(InvalidInputException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        ch = ui.currentMenu();
                        try{
                            valid.validateInput(4, ch);
                        }
                        catch(InvalidInputException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    switch (ch) {
                        case 1:
                            double depositAmt = ui.deposit();
                            b.deposit(depositAmt);
                            ui.depositGreet();
                            break;
                        case 2:
                            double withdrawAmt =  ui.withdraw();
                            if(isSavings(b)){
                                if(valid.validateBalSavings(b.checkBalance(), withdrawAmt)){
                                    b.withdraw(withdrawAmt);
                                    ui.withdrawGreet();
                                }
                                else{
                                    ui.withdrawWarnSavings();
                                }
                            }
                            else{
                                if(valid.validateBalCurrent(b.checkBalance(), ((CurrentAccount)b).getOverDraft() , withdrawAmt)){
                                    b.withdraw(withdrawAmt);
                                    ui.withdrawGreet();
                                    if(b.checkBalance() < 0){
                                        ui.withdrawGreetCurr(b.checkBalance());
                                    }
                                }
                                else{
                                    ui.withdrawWarnCurrent();
                                }
                            }
                            break;
                        case 3:
                            double balAmt = b.checkBalance();
                            if(isSavings(b)){
                                try{
                                    valid.validateBalance(balAmt);
                                }
                                catch (InvalidBalanceException e){
                                    System.out.println(e.getMessage());
                                }
                                ui.balance(balAmt);
                            }
                            else{
                                System.out.println("Your balance is: " + balAmt);
                            }
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

