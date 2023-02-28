package com.coursemangement.trainer;

import com.coursemangement.dto.Course;

import java.util.List;

public interface TrainerViewCallback {

    void getAllocatedCourseFailure(String s);

    void getAllocatedCourseSuccess(List<Course> courseList);
}