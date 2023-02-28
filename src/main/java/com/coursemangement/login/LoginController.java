package com.coursemangement.login;

import com.coursemangement.dto.Admin;
import com.coursemangement.dto.Trainer;
import com.coursemangement.dto.User;

public class LoginController implements LoginViewControllerCallback, LoginModelControllerCallback {
    private LoginViewCallback loginView;
    private LoginModelCallback loginModel;

    LoginController(LoginViewCallback loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }

    public void isValidAdmin(String adminId,String password){
        loginModel.isValidAdmin(adminId,password);
    }
    public void isValidTrainer(String trainerId,String password){ loginModel.isValidTrainer(trainerId,password);}

    public void isValidUser(String userId,String password){ loginModel.isValidUser(userId,password);}

    public User addNewUser(String userName,long phoneNumber,String emailId,String password){
        return loginModel.addNewUser(userName,phoneNumber,emailId,password);
    }
    public void adminValidationFailure(String errorMessage){
        loginView.adminValidationFailure(errorMessage);
    }

    public void adminValidationSuccess(Admin admin){
        loginView.adminValidationSuccess(admin);
    }

    public void trainerValidationFailure(String errorMessage){
        loginView.trainerValidationFailure(errorMessage);
    }

    public void trainerValidationSuccess(Trainer trainer){
        loginView.trainerValidationSuccess(trainer);
    }

    public void userValidationFailure(String errorMessage){
        loginView.userValidationFailure(errorMessage);
    }

    public void userValidationSuccess(User user){
        loginView.userValidationSuccess(user);
    }

}