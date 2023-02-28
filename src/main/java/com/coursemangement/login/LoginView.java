package com.coursemangement.login;

import com.coursemangement.admin.AdminView;
import com.coursemangement.dto.Admin;
import com.coursemangement.dto.Trainer;
import com.coursemangement.dto.User;
import com.coursemangement.trainer.TrainerView;
import com.coursemangement.user.UserView;
import com.coursemangement.util.Read;

import java.util.InputMismatchException;

public class LoginView implements LoginViewCallback {
    private LoginViewControllerCallback loginController;

    LoginView() {
        loginController = new LoginController(this);
    }
    public static void main(String[] args){
        LoginView loginView = new LoginView();
        loginView.loginSetup();
    }
    private void loginSetup(){
        boolean flag = true;
        while(flag){
            System.out.println("1.Admin");
            System.out.println("2.Trainer");
            System.out.println("3.User SignUp");
            System.out.println("4.User Login");
            System.out.println("5.Exit");
            int choice = 0;
            try {
                choice = Read.stringToInt(Read.input("Enter the choice: "));
            }catch (NumberFormatException e){}
            if(choice==5){
                return;
            }
            this.checkValidChoice(choice);
        }
    }
    private void checkValidChoice(int choice){
        switch (choice){
            case 1:
                String adminId = Read.input("Enter the Admin ID: ");
                String adminPassword = Read.input("Enter the password: ");
                loginController.isValidAdmin(adminId,adminPassword);
                break;
            case 2:
                String trainerId = Read.input("Enter the Trainer ID: ");
                String trainerPassword = Read.input("Enter the password: ");
                loginController.isValidTrainer(trainerId,trainerPassword);
                break;
            case 3:
                String userName = Read.input("Enter the User Name: ");
                long phoneNumber = Read.stringToLong(Read.input("Enter the phone Number: "));
                String emailId = Read.getEmail("Enter the email id: ");
                String password = Read.getPassword("Enter the password: ");
                User currentUser = loginController.addNewUser(userName,phoneNumber,emailId,password);

                if(currentUser!=null){
                    System.out.println("User Id: "+currentUser.getUserId());
                    System.out.println("User Name: "+currentUser.getUserName());
                    System.out.println("User added successfully");

                }else{
                    System.out.println("User is not added");
                }
                break;
            case 4:
                String userId = Read.input("Enter the User ID: ");
                String userPassword = Read.input("Enter the password: ");
                loginController.isValidUser(userId,userPassword);
                break;
            default:
                System.out.println("Enter valid choices");
                this.loginSetup();

        }
    }

    public void adminValidationFailure(String errorMessage){
        System.out.println(errorMessage);
    }

    public void adminValidationSuccess(Admin admin){
        AdminView adminView = new AdminView();
        adminView.adminLoginSetup(admin);
    }

    public void trainerValidationFailure(String errorMessage){
        System.out.println(errorMessage);
    }

    public void trainerValidationSuccess(Trainer trainer){
        TrainerView trainerView = new TrainerView();
        trainerView.trainerViewSetup(trainer);
    }
    public void userValidationFailure(String errorMessage){
        System.out.println(errorMessage);
    }

    public void userValidationSuccess(User user){
        UserView userView = new UserView();
        userView.userViewSetup(user);
    }
}    
    