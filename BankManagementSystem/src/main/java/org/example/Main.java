package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        ConsoleUI ui = new ConsoleUI();
        Map<User, BankAccount> usersMap = new HashMap<>();
        BankService bankService = new BankService(usersMap, ui);
        boolean key = false;
        while (!key) {
            int ch = ui.mainMenu();
            switch (ch) {
                case 1:
                    bankService.registerUser();
                    break;
                case 2:
                    bankService.loginUser();
                    break;

                case 3:
                    key = true;
                    break;
            }
        }
    }
}
