package org.example.Service;

import org.example.Exception.InvalidAgeException;

public interface BankServices {
    void start() throws InvalidAgeException;

    void registerUser();

    void loginUser();
}
