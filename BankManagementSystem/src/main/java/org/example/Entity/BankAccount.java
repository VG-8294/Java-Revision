package org.example.Entity;

import org.example.Enum.AccountType;

public abstract class BankAccount {
    protected double balance;
    protected double amount;
    protected AccountType accountType;

    public BankAccount(double balance, AccountType saving){
        this.balance = balance;
    }

    public void deposit(double amt){
        balance += amt;
    }

    public void withdraw(double amt){
        balance -= amt;
    }

    public double checkBalance(){
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", amount=" + amount +
                '}';
    }
}
