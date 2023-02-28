package com.coursemangement.login;

import com.coursemangement.dto.Admin;
import com.coursemangement.dto.User;

public interface LoginModelCallback {
    public void isValidAdmin(String adminId,String password);
    public void isValidTrainer(String trainerId,String password);
    public void isValidUser(String userId,String password);

    public User addNewUser(String userName, long phoneNumber, String emailId, String password);
}