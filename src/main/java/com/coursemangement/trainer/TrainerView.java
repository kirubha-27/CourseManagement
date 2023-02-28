package com.coursemangement.trainer;

import com.coursemangement.dto.Course;
import com.coursemangement.dto.Trainer;
import com.coursemangement.util.Read;

import java.util.InputMismatchException;
import java.util.List;

public class TrainerView implements TrainerViewCallback {
    private TrainerViewControllerCallback trainerController;

    public TrainerView() {
        trainerController = new TrainerController(this);
    }

    public void trainerViewSetup(Trainer trainer){
        boolean flag = true;
        while(flag){
            System.out.println("1.Profile");
            System.out.println("2.Allocated Course");
            System.out.println("3.Logout");
            int choice = 0;
            try {
                choice = Read.stringToInt(Read.input("Enter the choice: "));
            }catch (InputMismatchException e){}
            if(choice==3){
                return;
            }
            this.checkValidChoice(choice,trainer);
        }
    }
    private void checkValidChoice(int choice,Trainer trainer){
        switch (choice){
            case 1:
                showTrainerProfile(trainer);
                break;
            case 2:
                trainerController.getAllocatedCourse(trainer.getTrainerId());
                break;
            default:
                System.out.println("Enter the valid choices");
        }
    }
    private void showTrainerProfile(Trainer trainer){
        System.out.println("-----------------PROFILE--------------------");
        System.out.println();
        System.out.printf("Trainer ID: %10s\n",trainer.getTrainerId());
        System.out.println();
        System.out.printf("Trainer Name: %10s\n",trainer.getTrainerName());
        System.out.println();
        System.out.printf("Email Id: %17s\n",trainer.getEmail());
        System.out.println();
        System.out.println("Trainer Skill set:");
        for(String string : trainer.getSkillSet()){
            System.out.println(string);
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
    }

    @Override
    public void getAllocatedCourseFailure(String s) {
        System.out.println(s);
    }

    @Override
    public void getAllocatedCourseSuccess(List<Course> courseList) {
        int i = 1;
        for (Course course : courseList) {
            System.out.println("----------------->Course " + i + "<-----------------------");
            System.out.println();
            System.out.println("course Id: " + course.getCourseId());
            System.out.println();
            System.out.println("course Name: " + course.getCourseName());
            System.out.println();
            System.out.println(""+course.getTrainerId());
            System.out.println();
            System.out.println("-----------------------------------------------------------------");

        }
    }
}
    