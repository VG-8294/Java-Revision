package org.example;

import java.util.function.Predicate;

public class Validations {

    public boolean validateBalance(double bal){
        Predicate<Double> pred = x -> x < 10000;
        return pred.test(bal);
    }

    public boolean validateEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$";
        if(email.matches(regex)){
            return false;
        }
        return true;
    }

    public boolean validatePassword(String password){
        String regex =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        if(password.matches(regex)){
            return false;
        }
        return true;
    }

}
