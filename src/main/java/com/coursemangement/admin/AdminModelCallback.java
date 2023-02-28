package com.coursemangement.admin;

import java.time.LocalDate;
import java.util.List;

public interface AdminModelCallback {
    public void addTrainer(String trainerName, String email, List<String> skillSet);

    public void removeTrainer(String trainerName,String trainerId);

    public void addCourse(String courseName, LocalDate startDate, LocalDate endDate, LocalDate lastDateToApply, String trainerId1, int numberOfSeats, int bookedSeats, List<String> tempDescription);
}