package org.example;

import static java.lang.Math.abs;

public class CurrentAccount extends BankAccount{
    private final double overDraft;
    public CurrentAccount(double balance, double overDraft) {
        super(balance);
        this.overDraft = overDraft;
    }

    @Override
    void withdraw(double amt) {
        if(amt > overDraft + balance){
            System.out.println("Overdraft limit exceeded");
        }
        else{
            balance -= amt;
            if(balance < 0){
                System.out.println("Successfully withdrawn but you owe the bank an amount of " + abs(balance));
            }
            else{
                System.out.println("Successfully withdrawn");
            }
        }
    }
}
