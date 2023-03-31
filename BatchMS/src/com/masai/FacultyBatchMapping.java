package com.masai;



import java.io.Serializable;

public class FacultyBatchMapping implements Serializable {
    private String facultyId;
    private String batchId;
    private String dateAssigned;

    public FacultyBatchMapping(String facultyId, String batchId, String dateAssigned) {
        this.facultyId = facultyId;
        this.batchId = batchId;
        this.dateAssigned = dateAssigned;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getDateAssigned() {
        return dateAssigned;
    }
}
