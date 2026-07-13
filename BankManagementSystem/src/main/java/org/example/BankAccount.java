package org.example;

abstract class BankAccount {
    protected double balance;
    protected double amount;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void deposit(double amt){
        balance += amt;
        System.out.println("Amount deposited!");
    }

    abstract void withdraw(double amt);

    public void checkBalance(){
        System.out.println("Your current balance is: " + balance);
    }
}
