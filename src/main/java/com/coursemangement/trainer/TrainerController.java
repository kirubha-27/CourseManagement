package com.coursemangement.trainer;

import com.coursemangement.dto.Course;

import java.util.List;

public class TrainerController implements TrainerViewControllerCallback, TrainerModelControllerCallback {
    private TrainerViewCallback trainerView;
    private TrainerModelCallback trainerModel;

    TrainerController(TrainerViewCallback trainerView) {
        this.trainerView = trainerView;
        trainerModel = new TrainerModel(this);
    }

    @Override
    public void getAllocatedCourse(String trainerId) {
        trainerModel.getAllocatedCourse(trainerId);
    }

    @Override
    public void getAllocatedCourseSuccess(List<Course> courseList) {
        trainerView.getAllocatedCourseSuccess(courseList);
    }

    @Override
    public void getAllocatedCourseFailure(String s) {
        trainerView.getAllocatedCourseFailure(s);
    }
}