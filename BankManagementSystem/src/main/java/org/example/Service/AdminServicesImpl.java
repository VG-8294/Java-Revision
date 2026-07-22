package org.example.Service;

import org.example.DTO.LoginRequest;
import org.example.Entity.Admin;
import org.example.Entity.BankAccount;
import org.example.Entity.SavingsAccount;
import org.example.Entity.User;
import org.example.Exception.InvalidInputException;
import org.example.UI.ConsoleUiImpl;
import org.example.Validations.ValidationImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class AdminServicesImpl implements AdminServices{

    private final Map<User, BankAccount> usersMap ;
    private ConsoleUiImpl ui;
    ValidationImpl valid;
    Admin admin;

    public AdminServicesImpl(Map<User, BankAccount> usersMap, ConsoleUiImpl ui, ValidationImpl valid, Admin admin) {
        this.usersMap = usersMap;
        this.ui = ui;
        this.valid = valid;
        this.admin = admin;
    }


    @Override
    public void loginAsAdmin(){
        LoginRequest lr = ui.loginMenu();
        System.out.println(admin.getMail());
        if(admin.getMail().equals(lr.getEmail()) && admin.getPassword().equals(lr.getPassword())){
            boolean key = false;
            while (!key) {
                int ch = ui.AdminMenu();
                try{
                    valid.validateInput(15, ch);
                }
                catch (InvalidInputException e){
                    System.out.println(e.getMessage());
                }
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
        else {
            ui.warning();
        }
    }

    private boolean isSavings(BankAccount b){
        return b instanceof SavingsAccount;
    }

    @Override
    public void getUsersHavingCurrent() {
        usersMap.entrySet()
                .stream()
                .filter(x -> !isSavings(x.getValue()))
                .forEach(x -> System.out.println(x.getKey()));
    }

    @Override
    public void getUsersHavingSaving() {
        usersMap.entrySet()
                .stream()
                .filter(x -> isSavings(x.getValue()))
                .forEach(x-> {
                    System.out.println(x.getKey());
                    System.out.println("Account number: " + x.getValue().getAccNo());
                });
    }
    @Override
    public void sortAllUsersByAge() {
        usersMap.keySet()
                .stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);
    }

    @Override
    public void getOldAgeUsers() {
        usersMap.keySet()
                .stream()
                .filter(x -> x.getAge() >= 60)
                .forEach(System.out::println);
    }

    @Override
    public void getUserByEmail(String mail) {
        usersMap.keySet()
                .stream()
                .filter(x -> x.getEmail().equals(mail))
                .forEach(System.out::println);
    }

    @Override
    public void getUsersAlphabetically() {
        usersMap.keySet()
                .stream()
                .sorted(Comparator.comparing(User::getName))
                .forEach(System.out::println);
    }

    @Override
    public void sortAccByBalance() {
        usersMap.entrySet()
                .stream()
                .sorted((x, y) -> (int) (x.getValue().checkBalance() - y.getValue().checkBalance()))
                .forEach(x -> System.out.println(x.getValue()));
    }
    @Override
    public void getAllUsersEmail() {
        usersMap.keySet()
                .forEach(entry -> System.out.println(entry.getEmail()));
    }
    @Override
    public long getTotalNoOfAcc() {
        return usersMap.size();
    }

    @Override
    public double getTotalMoney() {
        return usersMap.values()
                .stream()
                .mapToDouble(BankAccount::checkBalance)
                .sum();
    }

    @Override
    public void getUserWithMaxBalance() {
        usersMap.entrySet()
                .stream()
                .max(Comparator.comparing(x -> x.getValue().checkBalance()))
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }

    @Override
    public void getUsersOverSpecificBalance(double i) {
        usersMap.entrySet()
                .stream()
                .filter(x -> x.getValue().checkBalance() > i)
                .forEach(x -> System.out.println(x.getKey().toString()));
    }

    @Override
    public void getUsersBwAge(int age1, int age2){
        usersMap.keySet()
                .stream()
                .filter(x -> x.getAge() > age1 && x.getAge() < age2)
                .forEach(System.out::println);
    }

    @Override
    public void getUsersLessThanBal(double bal) {
        usersMap.entrySet()
                .stream()
                .filter(x -> x.getValue().checkBalance() < bal)
                .forEach(x -> System.out.println(x.getKey()));
    }
}
