package com.otm.model.base;


public class BaseEntity implements Base {

    protected String status = "active";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
