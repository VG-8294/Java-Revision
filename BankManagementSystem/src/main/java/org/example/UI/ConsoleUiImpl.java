package org.example.UI;

import org.example.DTO.LoginRequest;
import org.example.DTO.RegisterRequest;
import org.example.Enum.AccountType;
import org.example.Exception.InvalidAgeException;
import org.example.Validations.ValidationImpl;

import java.util.*;

import static java.lang.Math.abs;

public class ConsoleUiImpl implements ConsoleUI{
    Scanner sc = new Scanner(System.in);
    ValidationImpl valid;

    public ConsoleUiImpl(ValidationImpl valid) {
        this.valid = valid;
    }

    @Override
    public int mainMenu(){
        System.out.println("1. Open a new Account");
        System.out.println("2. Login to existing Account");
        System.out.println("3. Login as Admin");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        int ch =  sc.nextInt();
        sc.nextLine();
        return ch;
    }

    @Override
    public RegisterRequest registerMenu(){
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your email");
        String email = sc.next();
        while(valid.duplicateMail(email)){
            System.out.println("Sorry! User Already exists with this mail id");
            System.out.println("Enter your email again");
            email = sc.next();
        }
        while(valid.validateEmail(email)){
            System.out.println("Email is not in correct format");
            System.out.println("Enter your email again");
            email = sc.next();
        }
        System.out.println("Enter your password");
        String pass = sc.next();
        while(valid.validatePassword(pass)){
            System.out.println("Password must contain uppercase and lowercase letters, numbers, and special characters");
            System.out.println("Enter your password");
            pass = sc.next();
        }
        System.out.println("Enter your age");
        int age = sc.nextInt();
        System.out.println("Which type of account you want?\n" +
                "1. Saving\n" +
                "2. Current");
        int accNo = sc.nextInt();
        AccountType acc;
        if(accNo == 1){
            acc = AccountType.SAVING;
        }
        else{
            acc = AccountType.CURRENT;
        }
        double bal;
        while(true){
            try{
                System.out.println("Enter your initial balance: ");
                bal = sc.nextDouble();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a valid numeric amount.");
                sc.next();
            }
        }
        RegisterRequest rr = new RegisterRequest(name, email, pass, age, acc, bal);
        return rr;
    }

    @Override
    public LoginRequest loginMenu(){
        System.out.println("Enter your email");
        String mail = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();
        return new LoginRequest(mail, password);
    }

    @Override
    public String emailRequest(){
        System.out.println("Enter the email:");
        return sc.next();
    }


    @Override
    public void greeting(){
        System.out.println("Logged in successfully!");
        System.out.println("<--------Welcome to your Account-------->");
    }

    @Override
    public int AdminMenu(){
        System.out.println("1. Get all users alphabetically");
        System.out.println("2. Get all users above a specific balance");
        System.out.println("3. Get the user with maximum balance");
        System.out.println("4. Total money in the bank");
        System.out.println("5. Total number of accounts in the bank");
        System.out.println("6. Get all users email");
        System.out.println("7. Sort account by balance");
        System.out.println("8. Search a user by email");
        System.out.println("9. Get all old age users");
        System.out.println("10. Sort users by age");
        System.out.println("11. Get Users having Saving Account");
        System.out.println("12. Get Users having Current Account");
        System.out.println("13. Get Users b/w specific age");
        System.out.println("14. Get Users less than a specific balance");
        System.out.println("15. Exit");
        System.out.println("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();
        return ch;
    }

    @Override
    public List<Integer> askingAge(){
        System.out.println("Enter the range of age");
        int age1, age2;
        while(true){
            try{
                System.out.println("Enter starting age:");
                age1 = sc.nextInt();
                valid.validateAge(age1);
                break;
            }
            catch(InvalidAgeException e){
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try{
                System.out.println("Enter ending age:");
                age2 = sc.nextInt();
                valid.validateAge(age2);
                break;
            }
            catch(InvalidAgeException e){
                System.out.println(e.getMessage());
            }
        }
        return Arrays.asList(age1, age2);
    }

    @Override
    public int SavingsMenu(){
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check your balance");
        System.out.println("4. Check your interest amount");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();
        return ch;
    }

    @Override
    public double deposit(){
        System.out.println("Enter the amount you want to deposit:");
        return sc.nextDouble();
    }
    @Override
    public double amt(){
        System.out.println("Enter the amount :");
        return sc.nextDouble();
    }


    @Override
    public double withdraw(){
        System.out.println("Enter the amount you want to withdraw:");
        return sc.nextDouble();
    }

    @Override
    public void balance(double bal){
        System.out.println("Your bank balance is :" + bal);
    }

    @Override
    public int currentMenu(){
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check your balance");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();
        return ch;
    }

    public void interest(double inter){
        System.out.println("Your interest amount is: " + inter);
    }

    public void warning(){
        System.out.println("Invalid email or password!");
    }

    public void withdrawWarnSavings(){
        System.out.println("Balance is not enough");
    }

    public void withdrawWarnCurrent(){
        System.out.println("Overdraft limit exceeded");
    }


    public void withdrawGreet(){
        System.out.println("Successfully withdrawn");
    }

    public void withdrawGreetCurr(Double amt){
        System.out.println("But you owe bank a sum of " + abs(amt));
    }

    public void depositGreet(){
        System.out.println("Amount deposited!");
    }

    public void congrats(){
        System.out.println("Congratulations, Your account has been created!");
    }

}
