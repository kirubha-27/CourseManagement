package com.coursemangement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Course {
    private String courseName;
    private String courseId;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate lastDateToApply;

    private String trainerId;



    private int numberOfSeats;

    private int bookedSeats;

    private List<String> description;

    public Course(String courseName, String courseId, LocalDate startDate, LocalDate endDate, LocalDate lastDateToApply, String trainerId, int numberOfSeats, int bookedSeats, List<String> description) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastDateToApply = lastDateToApply;
        this.trainerId = trainerId;

        this.numberOfSeats = numberOfSeats;
        this.bookedSeats = bookedSeats;
        this.description = description;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getLastDateToApply() {
        return lastDateToApply;
    }

    public void setLastDateToApply(LocalDate lastDateToApply) {
        this.lastDateToApply = lastDateToApply;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }



    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
