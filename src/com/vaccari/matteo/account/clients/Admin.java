package com.vaccari.matteo.account.clients;

public class Admin extends Client {

    private String userName="Admin";
    private String passWord="123456";

   public Admin(String name) {
        this.name= name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
