package com.coursemangement.login;

import com.coursemangement.dto.Admin;
import com.coursemangement.dto.Trainer;
import com.coursemangement.dto.User;

public interface LoginViewCallback {
    public void adminValidationFailure(String errorMessage);
    public void adminValidationSuccess(Admin admin);

    public void trainerValidationFailure(String errorMessage);

    public void trainerValidationSuccess(Trainer trainer);

    public void userValidationFailure(String errorMessage);

    public void userValidationSuccess(User user);
}