package org.example.Entity;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amt) {
        if(amt > balance){
            System.out.println("Balance not enough");
        }
        else{
            balance -= amt;
            System.out.println("Successfully withdrawn");
        }
    }
    public double calculateInterest(){
        return balance*0.03;
    }
}
