package org.example.Entity;

public class Admin {
    private String mail;
    private String password;

    public Admin() {
        this.mail = "Seva";
        this.password = "Bank";
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
