package com.coursemangement.trainer;

import com.coursemangement.dto.Course;

import java.util.List;

public interface TrainerModelControllerCallback {

    void getAllocatedCourseSuccess(List<Course> courseList);

    void getAllocatedCourseFailure(String s);
}