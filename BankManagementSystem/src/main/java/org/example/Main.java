package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        Menu menu = new Menu();
        boolean key = false;
        while (!key) {
            int ch = menu.mainMenu();
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
