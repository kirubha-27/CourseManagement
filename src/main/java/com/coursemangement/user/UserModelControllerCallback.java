package com.coursemangement.user;

import com.coursemangement.dto.Course;

import java.util.List;

public interface UserModelControllerCallback {

    public void getMyLearningSuccess(List<Course> courseList1);

    public void getMyLearningFailure(String no_course_in_your_learnings);

    public void getAllCoursesSuccess(List<Course> coursesList);

    void getAllCoursesFailure(String errorMessage);

    void enrollCourseSuccess(String course_enrolled_successfully);

    void enrollCourseFailure(String course_cannot_be_enrolled);
}