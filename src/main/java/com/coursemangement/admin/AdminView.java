package com.coursemangement.admin;

import com.coursemangement.dto.Admin;
import com.coursemangement.util.Read;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class AdminView implements AdminViewCallback {
    private AdminViewControllerCallback adminController;

    public AdminView() {
        adminController = new AdminController(this);
    }

    public void adminLoginSetup(Admin admin){
        boolean flag = true;
        while(flag){
            System.out.println("1.Add Course");
            System.out.println("2.Add Trainer");
            System.out.println("3.Remove Trainer");
            System.out.println("4.Logout");
            int choice = 0;
            try {
                choice = Read.stringToInt(Read.input("Enter the choice: "));
            }catch (NumberFormatException e){}
            if(choice==4) return;
            this.checkValidChoice(choice,admin);
        }
    }

    private void checkValidChoice(int choice,Admin admin){
        switch (choice){
            case 1:

                String courseName = Read.input("Enter the Course Name: ");
                LocalDate startDate = LocalDate.parse(Read.getDate("Enter the Starting date(yyyy-mm-dd): "));
                LocalDate endDate = LocalDate.parse(Read.getDate("Enter the Ending Date(yyyy-mm-dd"));
                LocalDate lastDateToApply = LocalDate.parse(Read.getDate("Enter Last Date To Apply"));
                String trainerId1 = Read.input("Enter the trainer id: ");

                int numberOfSeats = Read.stringToInt(Read.input("Enter the number of seats: "));
                int bookedSeats = Read.stringToInt(Read.input("Enter the booked seats: "));
                int weeks = adminController.getWeeks(startDate,endDate);

                List<String> tempDescription = new ArrayList<>();
                System.out.println("Enter the course description: ");
                for(int i=0;i<weeks;i++){
                    tempDescription.add(Read.input(""));
                }
                adminController.addCourse(courseName,startDate,endDate,lastDateToApply,trainerId1,numberOfSeats,bookedSeats,tempDescription);
                break;
            case 2:
                String trainerName = Read.input("Enter Trainer Name: ");
                String emailId = Read.getEmail("Enter Email Id: ");
                int numberOfSkillSet = Read.stringToInt(Read.input("Enter Number of skill set: "));
                System.out.println("Enter the skill set: ");
                List<String> skillList = new ArrayList<>();
                for(int i=0;i<numberOfSkillSet;i++){

                    skillList.add(Read.input(""));
                }
                adminController.addTrainer(trainerName,emailId,skillList);
                break;
            case 3:
                String trainerId = Read.input("Enter trainer Id: ");
                String trainerName1 = Read.input("Enter trainer name: ");
                adminController.removeTrainer(trainerName1,trainerId);
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }

    public void trainerAddSuccessful(String msg){
        System.out.println("--------->Trainer Details<--------");
        System.out.println(msg);
        System.out.println("----------------------------------");
    }
    public void trainerDeleteSuccessful(String msg){
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println(msg);
        System.out.println();
        System.out.println("--------------------------------");
    }
    public void courseAddSuccessful(String msg){
        System.out.println(msg);
    }
    public void trainerDeleteFailure(String msg){
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println(msg);
        System.out.println();
        System.out.println("--------------------------------");
    }
}
    