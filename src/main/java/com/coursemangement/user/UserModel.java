package com.coursemangement.user;

import com.coursemangement.dto.Course;
import com.coursemangement.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class UserModel implements UserModelCallback {
    UserModelControllerCallback userController;

    UserModel(UserModelControllerCallback userController) {
        this.userController = userController;
    }

    public void getMyLearning(List<String> courseList){
        List<Course> courseList1 = CourseRepository.getInstance().getCourse(courseList);
        if(courseList1!=null){
            userController.getMyLearningSuccess(courseList1);
        }else{
            userController.getMyLearningFailure("No course in your learnings");
        }
    }

    public void getCourses(){
        List<Course> coursesList = CourseRepository.getInstance().getCourses();
        if(coursesList!=null){
            userController.getAllCoursesSuccess(coursesList);
        }else{
            userController.getAllCoursesFailure("There is no courses available");
        }


    }
    public void enrollCourses(String courseId){
        if(CourseRepository.getInstance().setCourse(courseId)){
            userController.enrollCourseSuccess("course enrolled successfully");
        }else{
            userController.enrollCourseFailure("course cannot be enrolled");
        }
    }
}