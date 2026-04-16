package com.movieplatform.models;

public class AdminUser extends User {

    private String permissionLevel;

    public AdminUser(String id, String name, String email, String password, String permissionLevel) {
        super(id, name, email, password, "ADMIN");
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String getUserType() {
        return "ADMIN";
    }

    @Override
    public int getRentalDurationDays() {
        return 0;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void suspendUser(User user) {
        user.setStatus("SUSPENDED");
    }

    public void activateUser(User user) {
        user.setStatus("ACTIVE");
    }

    @Override
    public String toFileString() {
        return getUserId() + "|" + getName() + "|" + getEmail() + "|" + permissionLevel + "|" + getStatus();
    }
}