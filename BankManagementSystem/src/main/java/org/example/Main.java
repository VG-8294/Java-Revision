package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        ConsoleUI ui = new ConsoleUI();
        Map<User, BankAccount> usersMap = new HashMap<>();
        BankService bankService = new BankService(usersMap, ui);

        bankService.start();
    }
}
