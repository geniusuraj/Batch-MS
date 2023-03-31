package com.masai;



import java.io.Serializable;

public class Batch implements Serializable {
    private String batchId;
    private String courseName;
    private int numberOfSeats;
    private String startDate;
    private int duration;

    public Batch(String batchId, String courseName, int numberOfSeats, String startDate, int duration) {
        this.batchId = batchId;
        this.courseName = courseName;
        this.numberOfSeats = numberOfSeats;
        this.startDate = startDate;
        this.duration = duration;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

