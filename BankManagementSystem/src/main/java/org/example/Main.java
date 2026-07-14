package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        boolean key = false;
        while (!key) {
            menu.mainMenu();
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    menu.registerMenu();
                    break;
                case 2:
                    menu.loginMenu();
                    break;

                case 3:
                    key = true;
                    break;
            }
        }
    }
}
