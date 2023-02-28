package com.coursemangement.trainer;

import com.coursemangement.dto.Course;
import com.coursemangement.repository.CourseRepository;

import java.util.List;

public class TrainerModel implements TrainerModelCallback {
    TrainerModelControllerCallback trainerController;

    TrainerModel(TrainerModelControllerCallback trainerController) {
        this.trainerController = trainerController;
    }

    @Override
    public void getAllocatedCourse(String trainerId) {
        List<Course> courseList = CourseRepository.getInstance().getAllocatedCourse(trainerId);
        if(courseList!=null){
            trainerController.getAllocatedCourseSuccess(courseList);
        }else{
            trainerController.getAllocatedCourseFailure("There is no course allocated in this course");
        }
    }
}