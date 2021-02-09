package com.Task2.jdbcmodel;

import java.util.Date;

public class TimeObject {

    private String startTime;
    private String endTime;

    public TimeObject() {
    }

    public TimeObject(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
