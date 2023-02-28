package com.coursemangement.admin;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class AdminController implements AdminViewControllerCallback, AdminModelControllerCallback {
    private AdminViewCallback adminView;
    private AdminModelCallback adminModel;

    AdminController(AdminViewCallback adminView) {
        this.adminView = adminView;
        adminModel = new AdminModel(this);
    }
    public int getWeeks(LocalDate startDate, LocalDate endDate){
        Period period = Period.between(startDate,endDate);
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        int weeks = (int)((months*30)+days)/7;
        return weeks;
    }
    public void addCourse(String courseName, LocalDate startDate, LocalDate endDate, LocalDate lastDateToApply, String trainerId1, int numberOfSeats, int bookedSeats, List<String> tempDescription){
        adminModel.addCourse(courseName,startDate,endDate,lastDateToApply,trainerId1,numberOfSeats,bookedSeats,tempDescription);
    }
    public void addTrainer(String trainerName, String emailId, List<String> skillSet){
        adminModel.addTrainer(trainerName,emailId,skillSet);
    }
    public void removeTrainer(String trainerName,String trainerId){
        adminModel.removeTrainer(trainerName,trainerId);
    }
    public void courseAddSuccessful(String msg){
        adminView.courseAddSuccessful(msg);
    }
    public void trainerAddSuccessful(String msg){
        adminView.trainerAddSuccessful(msg);
    }
    public void trainerDeleteSuccessful(String msg){
        adminView.trainerDeleteSuccessful(msg);
    }

    public void trainerDeleteFailure(String msg){
        adminView.trainerDeleteSuccessful(msg);
    }
}