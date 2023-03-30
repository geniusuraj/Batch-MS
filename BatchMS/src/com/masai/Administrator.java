package com.masai;

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
			System.out.println();
		}
	}

	public void deleteBatch(String batchId) {
		for (Batch batch : batches) {
			if (batch.getBatchId().equals(batchId)) {
				batches.remove(batch);
				System.out.println("Batch deleted successfully!");
				return;
			}
		}
		System.out.println("Batch not found.");
	}

	public static void main(String[] args) {
		Administrator admin = new Administrator();
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
			System.out.println("8. Exit");
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
				System.exit(0);
			default:
				System.out.println("Invalid choice.");
				break;
			}
			System.out.println();
		}
	}
}
