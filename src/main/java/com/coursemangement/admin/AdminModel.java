package com.coursemangement.admin;

import com.coursemangement.dto.Course;
import com.coursemangement.repository.CourseRepository;

import java.time.LocalDate;
import java.util.List;

public class AdminModel implements AdminModelCallback {

    private static int generateTrainerId = 0;

    private static int generateCourseId = 0;
    private String trainerId = "T000";

    private String courseId = "C000";
    AdminModelControllerCallback adminController;

    AdminModel(AdminModelControllerCallback adminController) {
        this.adminController = adminController;
    }

    public void addTrainer(String trainerName, String email, List<String> skillSet){
        String tempTrainerId = trainerId+(++generateTrainerId);
         if(CourseRepository.getInstance().setTrainer(trainerName,email,skillSet,tempTrainerId)){
             adminController.trainerAddSuccessful("Trainer added successfully \nTrainer Name: "+trainerName+"\nTrainer Id: "+tempTrainerId);
         }
    }

    public void addCourse(String courseName, LocalDate startDate, LocalDate endDate, LocalDate lastDateToApply, String trainerId1, int numberOfSeats, int bookedSeats, List<String> tempDescription){
        String tempCourseId = courseId+(++generateCourseId);
        if(CourseRepository.getInstance().setCourse(courseName,startDate,endDate,lastDateToApply,trainerId1,numberOfSeats,bookedSeats,tempDescription,tempCourseId)){
            adminController.courseAddSuccessful("course Id: "+courseId+" course name: "+courseName+" added successfully");
        }
    }

    public void removeTrainer(String trainerName,String trainerId){
        if(CourseRepository.getInstance().deleteTrainer(trainerName,trainerId)){
            adminController.trainerDeleteSuccessful(trainerId+" is successfully deleted");
        }else{
            adminController.trainerDeleteFailure("Trainer cannot be deleted or Trainer details is not valid");
        }
    }
//    public void addCourse(String courseName){
//
//    }
}