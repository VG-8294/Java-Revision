package org.example.UI;

import org.example.DTO.LoginRequest;
import org.example.DTO.RegisterRequest;

import java.util.List;

public interface ConsoleUI {
    int mainMenu();

    RegisterRequest registerMenu();

    LoginRequest loginMenu();

    String emailRequest();

    void greeting();

    int AdminMenu();

    List<Integer> askingAge();

    int SavingsMenu();

    double deposit();

    double amt();

    double withdraw();

    void balance(double bal);

    int currentMenu();

    void interest(double inter);

    void warning();

    void withdrawWarnSavings();

    void withdrawWarnCurrent();

    void withdrawGreet();

    void withdrawGreetCurr(Double amt);

    void depositGreet();

    void congrats(int accNo);
}
