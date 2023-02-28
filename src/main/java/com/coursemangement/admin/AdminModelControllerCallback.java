package com.coursemangement.admin;

import java.util.List;

public interface AdminModelControllerCallback {
    public void trainerAddSuccessful(String msg);

    public void trainerDeleteSuccessful(String msg);
    public void trainerDeleteFailure(String msg);

    void courseAddSuccessful(String msg);
}