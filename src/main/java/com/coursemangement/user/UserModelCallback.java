package com.coursemangement.user;

import com.coursemangement.dto.Course;

import java.util.List;

public interface UserModelCallback {

    public void getMyLearning(List<String> courseList);


    public void getCourses();

    void enrollCourses(String courseId);
}