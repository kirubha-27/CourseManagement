package com.coursemangement.dto;

import java.util.List;

public class User {
    private String userName;
    private String userId;

    private List<String> courseList;
    private long phoneNumber;
    private String emailId;

    public User(String userName, String userId, List<String> courseList, long phoneNumber, String emailId) {
        this.userName = userName;
        this.userId = userId;
        this.courseList = courseList;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
