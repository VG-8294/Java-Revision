package org.example.Validations;

import org.example.Entity.BankAccount;
import org.example.Entity.User;
import org.example.Exception.InvalidAgeException;
import org.example.Exception.InvalidBalanceException;
import org.example.Exception.InvalidInputException;

import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ValidationImpl implements Validation{
    private final Map<User, BankAccount> usersMap ;
    public ValidationImpl(Map<User, BankAccount> usersMap) {
        this.usersMap = usersMap;
    }

    // Java - 8 implementation - Predicates
    @Override
    public void validateBalance(double bal) throws InvalidBalanceException {
        Predicate<Double> pred = x -> x < 10000;
        if(pred.test(bal)){
            throw new InvalidBalanceException("Balance less then 10k");
        }
    }

    // Java - 8 implementation - BiPredicates
    @Override
    public boolean validateBalSavings(double bal, double amt){
        BiPredicate<Double, Double> isBalLessOrMore = (x, y) -> x > y;
        return isBalLessOrMore.test(bal, amt);
    }

    @Override
    public boolean validateBalCurrent(double bal, double overdraft, double amt){
        double totalBal = bal + overdraft;
        BiPredicate<Double, Double> isBalLessOrMore = (x, y) -> x > y;
        return isBalLessOrMore.test(totalBal, amt);
    }

    @Override
    public boolean validateEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$";
        return !email.matches(regex);
    }

    @Override
    public boolean validatePassword(String password){
        String regex =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return !password.matches(regex);
    }

    @Override
    public void validateAge(int age) throws InvalidAgeException {
        if(age < 0){
            throw new InvalidAgeException("Age cannot be negative");
        }
    }

    @Override
    public void validateInput(int totalInp, int userInp) throws InvalidInputException {
        if((userInp > totalInp) || (userInp < 1)){
            throw new InvalidInputException("No such option exist!");
        }
    }

    //  Using Java 8 - Streams
    @Override
    public boolean duplicateMail(String email){
        return usersMap.keySet()
                .stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

}
