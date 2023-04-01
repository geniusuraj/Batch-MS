package com.masai;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Administrator {
    private List<Batch> batches;
    private Map<String, Faculty> faculties;

    public Administrator() {
        this.batches = new ArrayList<Batch>();
        this.faculties = new HashMap<String, Faculty>();
    }

    public boolean login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public void createBatch(String batchId, String courseName, int numberOfSeats, String startDate, int duration) {
        Batch batch = new Batch(batchId, courseName, numberOfSeats, startDate, duration);
        batches.add(batch);
        System.out.println("Batch created successfully!");
    }

    public void updateBatch(String batchId, String courseName, int numberOfSeats, String startDate, int duration) {
        for (Batch batch : batches) {
            if (batch.getBatchId().equals(batchId)) {
                batch.setCourseName(courseName);
                batch.setNumberOfSeats(numberOfSeats);
                batch.setStartDate(startDate);
                batch.setDuration(duration);
                System.out.println("Batch updated successfully!");
                return;
            }
        }
        System.out.println("Batch not found.");
    }

    public void assignFacultyToBatch(String facultyId, String batchId, String dateAssigned) {
        if (!faculties.containsKey(facultyId)) {
            System.out.println("Faculty not found.");
            return;
        }
        boolean batchFound = false;
        for (Batch batch : batches) {
            if (batch.getBatchId().equals(batchId)) {
                batchFound = true;
                break;
            }
        }
        if (!batchFound) {
            System.out.println("Batch not found.");
            return;
        }
        FacultyBatchMapping mapping = new FacultyBatchMapping(facultyId, batchId, dateAssigned);
        faculties.get(facultyId).viewAssignedBatches().add(mapping);
        System.out.println("Faculty assigned to batch successfully!");
    }

    public void viewBatchDetailsById(String batchId) {
        for (Batch batch : batches) {
            if (batch.getBatchId().equals(batchId)) {
                System.out.println("Batch ID: " + batch.getBatchId());
                System.out.println("Course Name: " + batch.getCourseName());
                System.out.println("Number of Seats: " + batch.getNumberOfSeats());
                System.out.println("Start Date: " + batch.getStartDate());
                System.out.println("Duration: " + batch.getDuration() + " months");
                return;
            }
        }
        System.out.println("Batch not found.");
    }

    public void viewBatchDetailsByFacultyId(String facultyId) {
        if (!faculties.containsKey(facultyId)) {
            System.out.println("Faculty not found.");
            return;
        }
        List<FacultyBatchMapping> mappings = faculties.get(facultyId).viewAssignedBatches();
        if (mappings.isEmpty()) {
            System.out.println("No batches assigned to this faculty.");
            return;
        }
        System.out.println("Batches assigned to " + faculties.get(facultyId).getName() + ":");
        for (FacultyBatchMapping mapping : mappings) {
            System.out.println("Batch ID: " + mapping.getBatchId());
            System.out.println("Date Assigned: " + mapping.getDateAssigned());
        }
    }

    public void viewAllBatches() {
        if (batches.isEmpty()) {
            System.out.println("No batches found.");
            return;
        }
        System.out.println("All batches:");
        for (Batch batch : batches) {
            System.out.println("Batch ID: " + batch.getBatchId());
            System.out.println("Course Name: " + batch.getCourseName());
            System.out.println("Number of Seats: " + batch.getNumberOfSeats());
            System.out.println("Start Date: " + batch.getStartDate());
            System.out.println("Duration: " + batch.getDuration() + " months");
        }
    }
    
    public void deleteBatch(String batchId) {
        for (int i = 0; i < batches.size(); i++) {
            if (batches.get(i).getBatchId().equals(batchId)) {
                batches.remove(i);
                System.out.println("Batch deleted successfully!");
                return;
            }
        }
        System.out.println("Batch not found.");
    }
    
    public void loadDataFromFile(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            batches = (List<Batch>) in.readObject();
            faculties = (Map<String, Faculty>) in.readObject();
            in.close();
            fileIn.close();
        } 
        catch (FileNotFoundException e) {
            // System.out.println("No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void saveDataToFile(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(batches);
            out.writeObject(faculties);
            out.close();
            fileOut.close();
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    

