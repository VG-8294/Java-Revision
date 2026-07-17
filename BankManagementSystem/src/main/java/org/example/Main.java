package org.example;

import org.example.Entity.*;
import org.example.Service.BankService;
import org.example.UI.ConsoleUI;
import org.example.Validations.Validations;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Map<User, BankAccount> usersMap = new HashMap<>();
        usersMap.put(
                new User("Aman", "aman@gmail.com", "Aman@123", 22),
                new SavingsAccount(50000)
        );

        usersMap.put(
                new User("Vishal", "vishal@gmail.com", "Vishal@123", 23),
                new CurrentAccount(80000, 10000)
        );

        usersMap.put(
                new User("Rahul", "rahul@gmail.com", "Rahul@123", 21),
                new SavingsAccount(25000)
        );

        usersMap.put(
                new User("Neha", "neha@gmail.com", "Neha@123", 24),
                new CurrentAccount(120000, 15000)
        );

        usersMap.put(
                new User("Priya", "priya@gmail.com", "Priya@123", 22),
                new SavingsAccount(70000)
        );

        usersMap.put(
                new User("Arjun", "arjun@gmail.com", "Arjun@123", 26),
                new CurrentAccount(45000, 20000)
        );

        usersMap.put(
                new User("Karan", "karan@gmail.com", "Karan@123", 28),
                new SavingsAccount(95000)
        );

        usersMap.put(
                new User("Sneha", "sneha@gmail.com", "Sneha@123", 23),
                new CurrentAccount(60000, 10000)
        );
        Validations valid = new Validations(usersMap);
        ConsoleUI ui = new ConsoleUI(valid);
        Admin admin = new Admin();
        BankService bankService = new BankService(usersMap, ui, valid, admin);

        bankService.start();
    }
}
