package org.example.Service;

import org.example.Exception.InvalidAgeException;

public interface AdminServices {
    void loginAsAdmin() throws InvalidAgeException;

    void getUsersLessThanBal(double bal);

    void getUsersBwAge(int age1, int age2);

    void getUsersHavingCurrent();

    void getUsersHavingSaving();

    void sortAllUsersByAge();

    void getOldAgeUsers();

    void getUserByEmail(String mail);

    void getUsersAlphabetically();

    void sortAccByBalance();

    void getAllUsersEmail();

    long getTotalNoOfAcc();

    double getTotalMoney();

    void getUserWithMaxBalance();

    void getUsersOverSpecificBalance(double i);
}
