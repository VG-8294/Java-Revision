package org.example;

import org.example.Entity.*;
import org.example.Service.AdminServicesImpl;
import org.example.Service.BankServiceImpl;
import org.example.UI.ConsoleUiImpl;
import org.example.Validations.ValidationImpl;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(){
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
        usersMap.put(
                new User("Ramesh Sharma", "ramesh@gmail.com", "Ramesh@123", 62),
                new SavingsAccount(150000)
        );

        usersMap.put(
                new User("Suresh Verma", "suresh@gmail.com", "Suresh@123", 68),
                new CurrentAccount(95000, 10000)
        );

        usersMap.put(
                new User("Anita Mehta", "anita@gmail.com", "Anita@123", 72),
                new SavingsAccount(320000)
        );

        usersMap.put(
                new User("Rajesh Gupta", "rajesh@gmail.com", "Rajesh@123", 65),
                new CurrentAccount(210000, 10000)
        );

        usersMap.put(
                new User("Sunita Kapoor", "sunita@gmail.com", "Sunita@123", 70),
                new SavingsAccount(180000)
        );

        usersMap.put(
                new User("Mahesh Joshi", "mahesh@gmail.com", "Mahesh@123", 61),
                new SavingsAccount(125000)
        );
        ValidationImpl valid = new ValidationImpl(usersMap);
        ConsoleUiImpl ui = new ConsoleUiImpl(valid);
        Admin admin = new Admin();
        AdminServicesImpl adminServices = new AdminServicesImpl(usersMap, ui, valid, admin);
        BankServiceImpl bankService = new BankServiceImpl(usersMap, ui, valid, adminServices);

        bankService.start();
    }
}
