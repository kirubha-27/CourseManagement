package com.coursemangement.dto;

import java.util.List;

public class TrainerCredentials extends Trainer{
    private String password;

    public TrainerCredentials(String trainerName, String trainerId, String email, List<String> skillSet, String password) {
        super(trainerName, trainerId, email, skillSet);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
