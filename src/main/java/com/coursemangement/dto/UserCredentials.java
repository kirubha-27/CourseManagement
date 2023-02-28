package com.coursemangement.dto;

import java.util.List;

public class UserCredentials extends User{
    private String password;

    public UserCredentials(String userName, String userId, List<String> courseList, long phoneNumber, String emailId, String password) {
        super(userName, userId, courseList, phoneNumber, emailId);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
