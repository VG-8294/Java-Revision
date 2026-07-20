package org.example.Entity;

import org.example.Enum.AccountType;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance, AccountType.SAVING);
    }

    public double calculateInterest(){
        return balance*0.03;
    }
}
