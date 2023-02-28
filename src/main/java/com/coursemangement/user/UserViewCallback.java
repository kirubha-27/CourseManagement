package com.coursemangement.user;

import com.coursemangement.dto.Course;

import java.util.List;

public interface UserViewCallback {

    public void getMyLearningSuccess(List<Course> courseList1);

    public void getMyLearningFailure(String errorMessage);



    public void getAllCoursesSuccess(List<Course> coursesList);

    public void getAllCoursesFailure(String errorMessage);

    void enrollCourseSuccess(String course_enrolled_successfully);

    void enrollCourseFailure(String course_cannot_be_enrolled);
}