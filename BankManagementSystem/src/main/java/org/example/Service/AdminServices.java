package org.example.Service;

public interface AdminServices {
    void loginAsAdmin();

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
