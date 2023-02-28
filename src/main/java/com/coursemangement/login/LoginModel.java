package com.coursemangement.login;

import com.coursemangement.dto.Admin;
import com.coursemangement.dto.Trainer;
import com.coursemangement.dto.User;
import com.coursemangement.repository.CourseRepository;

public class LoginModel implements LoginModelCallback {
    private static int idGenerator = 0;
    String idGeneratorStr = "U100";

    private static  int courseCodeGenerator = 0;

    String courseCodeGeneratorStr = "C200";
    private LoginModelControllerCallback loginController;

    LoginModel(LoginModelControllerCallback loginController) {
        this.loginController = loginController;
    }

    public void isValidAdmin(String adminId,String password){
        Admin admin = CourseRepository.getInstance().getAdmin(adminId,password);
        if(admin==null){
            loginController.adminValidationFailure("Invalid Admin Credentials");
        }else{
            loginController.adminValidationSuccess(admin);
        }
    }
    public void isValidTrainer(String trainerId,String password){
        Trainer trainer = CourseRepository.getInstance().getTrainer(trainerId,password);
        if(trainer==null){
            loginController.trainerValidationFailure("Invalid Trainer Credentials");
        }else{
            loginController.trainerValidationSuccess(trainer);
        }
    }

    public void isValidUser(String userId,String password){
        User user = CourseRepository.getInstance().getUser(userId,password);
        if(user==null){
            loginController.userValidationFailure("Invalid Trainer Credentials");
        }else{
            loginController.userValidationSuccess(user);
        }
    }

    public User addNewUser(String userName,long phoneNumber,String emailId,String password){
        return CourseRepository.getInstance().setUser(userName,password,phoneNumber,emailId,idGeneratorStr+(++idGenerator),courseCodeGeneratorStr+(++courseCodeGenerator),null);
    }

}