package org.example.Entity;

import org.example.Enum.AccountType;

import static java.lang.Math.abs;

public class CurrentAccount extends BankAccount {
    private final double overDraft;
    public CurrentAccount(double balance, double overDraft) {
        super(balance, AccountType.CURRENT);
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }
}
