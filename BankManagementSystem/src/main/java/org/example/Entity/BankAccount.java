package org.example.Entity;

import org.example.Enum.AccountType;

public abstract class BankAccount {
    private static int nextAccNo = 1000;
    protected int accNo;
    protected double balance;
    protected double amount;
    protected AccountType accountType;

    public BankAccount(double balance, AccountType saving){
        this.balance = balance;
        this.accNo = nextAccNo++;
    }

    public int getAccNo() {
        return accNo;
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
                "Account Number =" + accNo +
                ", balance=" + balance +
                ", amount=" + amount +
                ", accountType=" + accountType +
                '}';
    }
}
