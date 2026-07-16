package org.example;

import org.example.Entity.BankAccount;
import org.example.Entity.User;
import org.example.Service.BankService;
import org.example.UI.ConsoleUI;
import org.example.Validations.Validations;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Validations valid = new Validations();
        ConsoleUI ui = new ConsoleUI();
        Map<User, BankAccount> usersMap = new HashMap<>();
        BankService bankService = new BankService(usersMap, ui, valid);

        bankService.start();
    }
}
