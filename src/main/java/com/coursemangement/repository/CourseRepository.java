package com.coursemangement.repository;

import com.coursemangement.dto.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseRepository {
    public static CourseRepository courseDbRepository;

    List<AdminCredentials> adminList = new ArrayList<>();
    List<UserCredentials> userList = new ArrayList<>();
    List<TrainerCredentials> trainerList = new ArrayList<>();

    List<Course> courseList = new ArrayList<>();
    private CourseRepository(){

    }

    public static CourseRepository getInstance() {
        if (courseDbRepository == null) {
            courseDbRepository = new CourseRepository();
            courseDbRepository.initialSetup();
        }
        return courseDbRepository;
    }

    private void initialSetup(){
        courseList.add(new Course("java", "j001", LocalDate.now(), LocalDate.parse("2023-02-26"), LocalDate.now(),"T0001", 54, 43,new ArrayList<String>(Arrays.asList("intro","operator","loops")) ));
        adminList.add(new AdminCredentials("kirubha","zs1","25"));
        userList.add(new UserCredentials("sathish","zs2",new ArrayList<>(Arrays.asList("j001")),8754986135l,"S@gmail.com","35"));
        trainerList.add(new TrainerCredentials("surya","zs3","kir@gmail",new ArrayList<>(Arrays.asList("java","c++")),"45"));
    }

    public Admin getAdmin(String adminId, String password){
        for(AdminCredentials credentials : adminList){
            if(credentials.getAdminId().equals(adminId)&&credentials.getPassword().equals(password)){
                return credentials;
            }
        }
        return null;
    }

    public Trainer getTrainer(String trainerId, String password){
        for(TrainerCredentials credentials : trainerList){
            if(credentials.getTrainerId().equals(trainerId)&&credentials.getPassword().equals(password)){
                return credentials;
            }
        }
        return null;
    }

    public User getUser(String userId, String password){
        for(UserCredentials credentials : userList){
            if(credentials.getUserId().equals(userId)&&credentials.getPassword().equals(password)){
                return credentials;
            }
        }
        return null;
    }
//    userName,password,phoneNumber,emailId,
//    idGeneratorStr+(++idGenerator),courseCodeGeneratorStr+(++courseCodeGenerator),null
//String userName, String userId, String courseId,
//    List<String> courseList, long phoneNumber, String emailId
    public User setUser(String userName,String password,long phoneNumber,String emailId,String userId,String courseId,List<String> courseList){
        userList.add(new UserCredentials(userName,userId,courseList,phoneNumber,emailId,password));
        return userList.get(userList.size()-1);
    }

    public boolean setTrainer(String trainerName, String email, List<String> skillSet,String trainerId){
        trainerList.add(new TrainerCredentials(trainerName,trainerId,email,skillSet,"0000"));
        return true;
    }

    public boolean deleteTrainer(String trainerName,String trainerId){
        for(TrainerCredentials trainer : trainerList){
            if(trainer.getTrainerId().equals(trainerId)&&trainer.getTrainerName().equals(trainerName)){
                trainerList.remove(trainer);
                return true;
            }
        }
        return false;
    }

    public boolean setCourse(String courseName, LocalDate startDate, LocalDate endDate, LocalDate lastDateToApply, String trainerId1, int numberOfSeats, int bookedSeats, List<String> tempDescription,String courseId) {
        courseList.add(new Course(courseName,courseId,startDate,endDate,lastDateToApply,trainerId1,numberOfSeats,bookedSeats,tempDescription));
        return true;
    }

    public List<Course> getCourse(List<String> courseId){
        if(courseId==null){
            return null;
        }
        List<Course> courseList1 = new ArrayList<>();
        for(Course course:courseList){
            if(courseId.contains(course.getCourseId())){
                courseList1.add(course);
            }
        }
        return courseList1;
    }

    public List<Course> getCourses() {
        return courseList;
    }

    public List<Course> getAllocatedCourse(String trainerId) {
        List<Course> courseList1 = new ArrayList<>();
        for(Course course:courseList){
            if(course.getTrainerId().equals(trainerId)){
                courseList1.add(course);
            }
        }
        return courseList1;
    }

    public boolean setCourse(String courseId) {
        for(User user:userList){
            if(!user.getCourseList().contains(courseId)){
                for(Course course:courseList){
                    if(course.getCourseId().equals(courseId)){
                        if(course.getLastDateToApply().isAfter(LocalDate.now())){
                            user.getCourseList().add(courseId);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
