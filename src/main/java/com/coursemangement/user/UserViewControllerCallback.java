package com.coursemangement.user;

import java.util.List;

public interface UserViewControllerCallback {

    public void getMyLearning(List<String> courseList);

    public void getCourses();

    void enrollCourses(String courseId);
}