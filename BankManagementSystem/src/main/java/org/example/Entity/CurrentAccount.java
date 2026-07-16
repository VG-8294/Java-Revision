package org.example.Entity;

import static java.lang.Math.abs;

public class CurrentAccount extends BankAccount {
    private final double overDraft;
    public CurrentAccount(double balance, double overDraft) {
        super(balance);
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }
}
