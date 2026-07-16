package org.example.Entity;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    public double calculateInterest(){
        return balance*0.03;
    }
}
