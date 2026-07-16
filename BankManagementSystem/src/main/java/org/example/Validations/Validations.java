package org.example.Validations;

import org.example.Entity.BankAccount;
import org.example.Entity.User;

import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Validations {
    private final Map<User, BankAccount> usersMap ;
    public Validations(Map<User, BankAccount> usersMap) {
        this.usersMap = usersMap;
    }

    // Java - 8 implementation - Predicates
    public boolean validateBalance(double bal){
        Predicate<Double> pred = x -> x < 10000;
        return pred.test(bal);
    }

    // Java - 8 implementation - BiPredicates
    public boolean validateBalSavings(double bal , double amt){
        BiPredicate<Double, Double> isBalLessOrMore = (x, y) -> x > y;
        return isBalLessOrMore.test(bal, amt);
    }

    public boolean validateBalCurrent(double bal, double overdraft, double amt){
        double totalBal = bal + overdraft;
        BiPredicate<Double, Double> isBalLessOrMore = (x, y) -> x > y;
        return isBalLessOrMore.test(totalBal, amt);
    }

    public boolean validateEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$";
        return !email.matches(regex);
    }

    public boolean validatePassword(String password){
        String regex =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return !password.matches(regex);
    }

    //  Using Java 8 - Streams
    public boolean duplicateMail(String email){
        return usersMap.keySet()
                .stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

}
