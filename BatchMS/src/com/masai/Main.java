package com.masai;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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

        // Your existing while loop with the switch case and options goes here

        admin.saveDataToFile("BatchMS.txt");
    }
}
