package com.masai;

import java.util.Scanner;

public class Main {

 public static void main(String[] args) {
    System.out.println("|-------------------------------------------|");
    System.out.println("Welcome to Batch Management System - BatchMS!");
    System.out.println("|-------------------------------------------|");
     Administrator admin = new Administrator();
     admin.loadDataFromFile("BatchMS.txt");

     Scanner scanner = new Scanner(System.in);
     System.out.print("Username: ");
     String username = scanner.nextLine();
     System.out.print("Password: ");
     String password = scanner.nextLine();

     while (!admin.login(username, password)) {
         System.out.print("Username: ");
         username = scanner.nextLine();
         System.out.print("Password: ");
         password = scanner.nextLine();
     }

     while (true) {
         System.out.println("Choose an option:");
         System.out.println("1. Create batch");
         System.out.println("2. Update batch");
         System.out.println("3. Assign faculty to batch");
         System.out.println("4. View batch details by ID");
         System.out.println("5. View batch details by faculty ID");
         System.out.println("6. View all batches");
         System.out.println("7. Delete batch");
         System.out.println("8. Logout");
         int choice = scanner.nextInt();
         scanner.nextLine();
         switch (choice) {
             case 1:
                 System.out.print("Batch ID: ");
                 String batchId = scanner.nextLine();
                 System.out.print("Course Name: ");
                 String courseName = scanner.nextLine();
                 System.out.print("Number of Seats: ");
                 int numberOfSeats = scanner.nextInt();
                 scanner.nextLine();
                 System.out.print("Start Date (DD/MM/YYYY): ");
                 String startDate = scanner.nextLine();
                 System.out.print("Duration (in months): ");
                 int duration = scanner.nextInt();
                 scanner.nextLine();
                 admin.createBatch(batchId, courseName, numberOfSeats, startDate, duration);
                 break;
             case 2:
                 System.out.print("Batch ID: ");
                 batchId = scanner.nextLine();
                 System.out.print("Course Name: ");
                 courseName = scanner.nextLine();
                 System.out.print("Number of Seats: ");
                 numberOfSeats = scanner.nextInt();
                 scanner.nextLine();
                 System.out.print("Start Date (DD/MM/YYYY): ");
                 startDate = scanner.nextLine();
                 System.out.print("Duration (in months): ");
                 duration = scanner.nextInt();
                 scanner.nextLine();
                 admin.updateBatch(batchId, courseName, numberOfSeats, startDate, duration);
                 break;
             case 3:
                 System.out.print("Faculty ID: ");
                 String facultyId = scanner.nextLine();
                 System.out.print("Batch ID: ");
                 batchId = scanner.nextLine();
                 System.out.print("Date Assigned (DD/MM/YYYY): ");
                 String dateAssigned = scanner.nextLine();
                 admin.assignFacultyToBatch(facultyId, batchId, dateAssigned);
                 break;
             case 4:
                 System.out.print("Batch ID: ");
                 batchId = scanner.nextLine();
                 admin.viewBatchDetailsById(batchId);
                 break;
             case 5:
                 System.out.print("Faculty ID: ");
                 facultyId = scanner.nextLine();
                 admin.viewBatchDetailsByFacultyId(facultyId);
                 break;
             case 6:
                 admin.viewAllBatches();
                 break;
             case 7:
                 System.out.print("Batch ID: ");
                 batchId = scanner.nextLine();
                 admin.deleteBatch(batchId);
                 break;
             case 8:
                 admin.saveDataToFile("BatchMS.txt");
                 System.exit(0);
             default:
                 System.out.println("Invalid choice.");
                 break;
         }
         System.out.println();
     }
 }
}
