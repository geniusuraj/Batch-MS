package com.masai;

import java.util.List;

public class Faculty {
    private String id;
    private String name;
    private String username;
    private String password;

    public Faculty(String id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FacultyBatchMapping> viewAssignedBatches() {
        return null;
        // TODO: Implement method to view assigned batches
    }

    public void deleteAccount() {
        // TODO: Implement method to delete account
    }
}

