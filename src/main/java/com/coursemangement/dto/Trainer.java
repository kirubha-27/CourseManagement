package com.coursemangement.dto;

import java.util.List;

public class Trainer {
    private String trainerName;
    private String trainerId;

    private String email;

    private List<String> skillSet;

    public Trainer(String trainerName, String trainerId, String email, List<String> skillSet) {
        this.trainerName = trainerName;
        this.trainerId = trainerId;
        this.email = email;
        this.skillSet = skillSet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<String> skillSet) {
        this.skillSet = skillSet;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }
}
