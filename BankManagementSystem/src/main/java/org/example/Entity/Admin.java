package org.example.Entity;

public class Admin {
    private String mail;
    private String password;

    public Admin() {
        this.mail = "SevaBank@mail.com";
        this.password = "SEVAbank@7384";
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
