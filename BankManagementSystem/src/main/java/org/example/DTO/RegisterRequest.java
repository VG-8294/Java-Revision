package org.example.DTO;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private int age;
    private boolean acc;
    private double initialAmt;

    public RegisterRequest(String name, String email, String password, int age, boolean acc, double initialAmt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.acc = acc;
        this.initialAmt = initialAmt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAcc() {
        return acc;
    }

    public void setAcc(boolean acc) {
        this.acc = acc;
    }

    public double getInitialAmt() {
        return initialAmt;
    }

    public void setInitialAmt(double initialAmt) {
        this.initialAmt = initialAmt;
    }
}
