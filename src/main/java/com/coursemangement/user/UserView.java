package com.coursemangement.user;

import com.coursemangement.dto.Course;
import com.coursemangement.dto.User;
import com.coursemangement.repository.CourseRepository;
import com.coursemangement.util.Read;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserView implements UserViewCallback {
    private Scanner scanner = new Scanner(System.in);
    private UserViewControllerCallback userController;

    public UserView() {
        userController = new UserController(this);
    }




    public void userViewSetup(User user){
        boolean flag = true;
        while(flag){
            System.out.println("1.View Profile");
            System.out.println("2.My Learnings");
            System.out.println("3.View Course");
            System.out.println("4.Logout");
            int choice = 0;
            try {
                choice = Read.stringToInt(Read.input("Enter the choice: "));
            }catch (InputMismatchException e){}
            if(choice==4){
                return;
            }
            this.checkValidChoice(choice,user);
        }
    }
    private void checkValidChoice(int choice,User user){
        switch (choice){
            case 1:
                viewProfile(user);
                break;

            case 2:
                userController.getMyLearning(user.getCourseList());
                //System.out.println("hello");
                break;
            case 3:
                userController.getCourses();
                break;
        }
    }

    private void viewProfile(User user){
        System.out.println("-----------------PROFILE--------------------");
        System.out.println();
        System.out.printf("User ID: %10s\n",user.getUserId());
        System.out.println();
        System.out.printf("User Name: %12s\n",user.getUserName());
        System.out.println();
        System.out.printf("Phone Number: %12s\n",user.getPhoneNumber());
        System.out.println();
        System.out.printf("Email Id: %17s\n",user.getEmailId());
        System.out.println();
        System.out.println("-----------------------------------------------");
    }
    public void getMyLearningSuccess(List<Course> courseList1) {
        int i = 0;
        for (Course course : courseList1) {
            System.out.println("----------------->MY LEARNING " + i + "<-----------------------");
            System.out.println();
            System.out.println("course Id: " + course.getCourseId());
            System.out.println();
            System.out.println("course Name: " + course.getCourseName());
            System.out.println();
            System.out.println("---->course description<------");
            for(String string : course.getDescription()){
                System.out.println(string);
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------");

        }
    }
    public void getMyLearningFailure(String errorMessage){
        System.out.println(errorMessage);
    }



    @Override
    public void getAllCoursesSuccess(List<Course> coursesList) {
        int i = 1;
        for (Course course : coursesList) {
            System.out.println("----------------->Course " + i + "<-----------------------");
            System.out.println();
            System.out.println("course Id: " + course.getCourseId());
            System.out.println();
            System.out.println("course Name: " + course.getCourseName());
            System.out.println();
            System.out.println("---->course description<------");
            for(String string : course.getDescription()){
                System.out.println(string);
            }
            System.out.println();
            System.out.println("------------------------------------------------------");
            i++;
        }
        System.out.println("Do you want enroll any course? (y/n)");
        char s = scanner.next().charAt(0);
        if(s=='y'){
            String courseId = Read.input("Enter the course Id: ");
            enrollCourse(courseId);
        }
    }
    private void enrollCourse(String courseId){
        userController.enrollCourses(courseId);
    }

    @Override
    public void getAllCoursesFailure(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void enrollCourseSuccess(String course_enrolled_successfully) {
        System.out.println(course_enrolled_successfully);
    }

    @Override
    public void enrollCourseFailure(String course_cannot_be_enrolled) {
        System.out.println(course_cannot_be_enrolled);
    }
}    
    