package org.example.Service;

import org.example.Entity.*;
import org.example.DTO.LoginRequest;
import org.example.DTO.RegisterRequest;
import org.example.UI.ConsoleUI;
import org.example.Validations.Validations;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, BankAccount> usersMap ;
    private ConsoleUI ui;
    Validations valid;
    Admin admin;
    public BankService(Map<User, BankAccount> usersMap, ConsoleUI ui, Validations valid, Admin admin) {
        this.usersMap = usersMap;
        this.ui = ui;
        this.valid = valid;
        this.admin = admin;
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
                    loginAsAdmin();
                    break;

                case 4:
                    key = true;
                    break;
            }
        }
    }

    private void loginAsAdmin() {
        LoginRequest lr = ui.loginMenu();
        System.out.println(admin.getMail());
        if(admin.getMail().equals(lr.getEmail()) && admin.getPassword().equals(lr.getPassword())){
            boolean key = false;
            while (!key) {
                int ch = ui.AdminMenu();
                switch (ch) {
                    case 1:
                        getUsersAlphabetically();
                        break;
                    case 2:
                        double bal = ui.amt();
                        getUsersOverSpecificBalance(bal);
                        break;

                    case 3:
                        getUserWithMaxBalance();
                        break;

                    case 4:
                        System.out.println( "Your bank has a total amount of "+ getTotalMoney());
                        break;
                    case 5:
                        System.out.println("Total number of accounts in your bank is :" + getTotalNoOfAcc());
                        break;
                    case 6:
                        getAllUsersEmail();
                        break;

                    case 7:
                        sortAccByBalance();
                        break;
                    case 8:
                        String mail = ui.emailRequest();
                        getUserByEmail(mail);
                        break;
                    case 9:
                        getOldAgeUsers();
                        break;

                    case 10:
                        sortAllUsersByAge();
                        break;

                    case 11:
                        getUsersHavingSaving();
                        break;

                    case 12:
                        getUsersHavingCurrent();
                        break;
                    case 13:
                        List<Integer> list = ui.askingAge();
                        getUsersBwAge(list.get(0), list.get(1));
                        break;
                    case 14:
                        double amt = ui.amt();
                        getUsersLessThanBal(amt);
                        break;
                    case 15:
                        key = true;
                        break;
                }
            }
        }
    }

    private void getUsersLessThanBal(double bal) {
        usersMap.entrySet()
                .stream()
                .filter(x -> x.getValue().checkBalance() < bal)
                .forEach(x -> System.out.println(x.getKey()));
    }

    private void getUsersBwAge(int age1, int age2){
        usersMap.keySet()
                .stream()
                .filter(x -> x.getAge() > age1 && x.getAge() < age2)
                .forEach(System.out::println);
    }

    private void getUsersHavingCurrent() {
        usersMap.entrySet()
                .stream()
                .filter(x -> !isSavings(x.getValue()))
                .forEach(x -> System.out.println(x.getKey()));
    }

    private void getUsersHavingSaving() {
        usersMap.entrySet()
                .stream()
                .filter(x -> isSavings(x.getValue()))
                .forEach(x-> System.out.println(x.getKey()));
    }

    private void sortAllUsersByAge() {
        usersMap.keySet()
                .stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);
    }

    private void getOldAgeUsers() {
        usersMap.keySet()
                .stream()
                .filter(x -> x.getAge() >= 60)
                .forEach(System.out::println);
    }

    private void getUserByEmail(String mail) {
        usersMap.keySet()
                .stream()
                .filter(x -> x.getEmail().equals(mail))
                .forEach(System.out::println);
    }

    private void getUsersAlphabetically() {
        usersMap.keySet()
                .stream()
                .sorted(Comparator.comparing(User::getName))
                .forEach(System.out::println);
    }

    private void sortAccByBalance() {
        usersMap.entrySet()
                .stream()
                .sorted((x, y) -> (int) (x.getValue().checkBalance() - y.getValue().checkBalance()))
                .forEach(x -> System.out.println(x.getValue()));
    }

    private void getAllUsersEmail() {
        usersMap.keySet()
                .forEach(entry -> System.out.println(entry.getEmail()));
    }

    private long getTotalNoOfAcc() {
        return usersMap.size();
    }

    private double getTotalMoney() {
        return usersMap.entrySet()
                .stream()
                .mapToDouble(x -> x.getValue().checkBalance())
                .sum();
    }

    private void getUserWithMaxBalance() {
        usersMap.entrySet()
                .stream()
                .max(Comparator.comparing(x -> x.getValue().checkBalance()))
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }

    private void getUsersOverSpecificBalance(double i) {
        usersMap.entrySet()
                .stream()
                .filter(x -> x.getValue().checkBalance() > i)
                .forEach(x -> System.out.println(x.getKey().toString()));
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
    //Java 8 implementation - Streams
    private BankAccount authenticate(String mail, String password){
        return usersMap.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getEmail().equals(mail) && entry.getKey().getPassword().equals(password))
                .map(Map.Entry::getValue)  // method-reference implementation
                .findFirst()
                .orElse(null);
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
//                            if(valid.validateBalSavings(b.checkBalance(), withdrawAmt) && isSavings(b)){
//                                b.withdraw(withdrawAmt);
//                                ui.withdrawGreet();
//                            } else if (valid.validateBalCurrent(b.checkBalance(), ((CurrentAccount)b).getOverDraft() , withdrawAmt) && isCurrent(b)) {
//                                b.withdraw(withdrawAmt);
//                                ui.withdrawGreet();
//                                if(b.checkBalance() < 0){
//                                    ui.withdrawGreetCurr(b.checkBalance());
//                                }
//                            } else{
//                                if(isSavings(b)){
//                                    ui.withdrawWarnSavings();
//                                }
//                                else{
//                                    ui.withdrawWarnCurrent();
//                                }
//                            }
                            break;
                        case 3:
                            double balAmt = b.checkBalance();
                            if(isSavings(b)){
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

