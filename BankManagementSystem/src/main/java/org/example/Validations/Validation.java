package org.example.Validations;

import org.example.Exception.InvalidAgeException;
import org.example.Exception.InvalidInputException;

public interface Validation {
    // Java - 8 implementation - Predicates
    boolean validateBalance(double bal);

    // Java - 8 implementation - BiPredicates
    boolean validateBalSavings(double bal, double amt);

    boolean validateBalCurrent(double bal, double overdraft, double amt);

    boolean validateEmail(String email);

    boolean validatePassword(String password);

    void validateAge(int age) throws InvalidAgeException;

    void validateInput(int totalInp, int userInp) throws InvalidInputException;

    //  Using Java 8 - Streams
    boolean duplicateMail(String email);
}
