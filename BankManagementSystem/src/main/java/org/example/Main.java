package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        SavingsAccount sv = new SavingsAccount(5000);
        sv.deposit(2000);
        sv.checkBalance();
        sv.withdraw(3000);
        sv.checkBalance();

        CurrentAccount ca = new CurrentAccount(20000, 20000);
        ca.checkBalance();
        ca.withdraw(30000);
        ca.checkBalance();
    }
}
