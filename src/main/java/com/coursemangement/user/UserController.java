package com.coursemangement.user;

import com.coursemangement.dto.Course;

import java.util.List;

public class UserController implements UserViewControllerCallback, UserModelControllerCallback {
    private UserViewCallback userView;
    private UserModelCallback userModel;

    UserController(UserViewCallback userView) {
        this.userView = userView;
        userModel = new UserModel(this);
    }

    public void getMyLearning(List<String> courseList){
        userModel.getMyLearning(courseList);
    }
    public void getMyLearningSuccess(List<Course> courseList1){
        userView.getMyLearningSuccess(courseList1);
    }

    public void getMyLearningFailure(String errorMessage){
        userView.getMyLearningFailure(errorMessage);
    }

    @Override
    public void getAllCoursesSuccess(List<Course> coursesList) {
        userView.getAllCoursesSuccess(coursesList);
    }

    @Override
    public void getAllCoursesFailure(String errorMessage) {
        userView.getAllCoursesFailure(errorMessage);
    }

    @Override
    public void enrollCourseSuccess(String course_enrolled_successfully) {
        userView.enrollCourseSuccess(course_enrolled_successfully);
    }

    @Override
    public void enrollCourseFailure(String course_cannot_be_enrolled) {
        userView.enrollCourseFailure(course_cannot_be_enrolled);
    }

    public void getCourses(){
        userModel.getCourses();
    }

    public void enrollCourses(String courseId){
        userModel.enrollCourses(courseId);
    }


}