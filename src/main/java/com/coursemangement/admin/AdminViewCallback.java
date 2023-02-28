package com.coursemangement.admin;

import java.util.List;

public interface AdminViewCallback {
    public void trainerAddSuccessful(String msg);
    public void trainerDeleteSuccessful(String msg);

    public void trainerDeleteFailure(String msg);

    public void courseAddSuccessful(String msg);
}