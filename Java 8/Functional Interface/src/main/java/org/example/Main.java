package org.example;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws InvalidAgeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age");
        int age = sc.nextInt();
        try{
            agePrompt(age);
        }
        catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }

    public static void agePrompt(int age) throws InvalidAgeException {
        if(age < 0){
            throw new InvalidAgeException("Age not acceptable");
        }
    }

}