package org.example;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    void withdraw(double amt) {
        if(amt > balance){
            System.out.println("Balance not enough");
        }
        else{
            balance -= amt;
            System.out.println("Successfully withdrawn");
        }
    }
}
