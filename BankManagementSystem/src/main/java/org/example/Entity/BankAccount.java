package org.example.Entity;

public abstract class BankAccount {
    protected double balance;
    protected double amount;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void deposit(double amt){
        balance += amt;
        System.out.println("Amount deposited!");
    }

    public abstract void withdraw(double amt);

    public double checkBalance(){
        return balance;
    }
}
