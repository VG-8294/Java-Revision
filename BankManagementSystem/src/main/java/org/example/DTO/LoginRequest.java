package org.example.DTO;

public class LoginRequest {
    private int accNo;
    private String email;
    private String password;

    public LoginRequest(int accNo, String email, String password) {
        this.accNo = accNo;
        this.email = email;
        this.password = password;
    }

    public int getAccNo() {
        return accNo;
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
}
