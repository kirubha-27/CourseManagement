package com.coursemangement.dto;

public class AdminCredentials extends Admin{
    private String password;

    public AdminCredentials(String adminName, String adminId, String password) {
        super(adminName, adminId);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
