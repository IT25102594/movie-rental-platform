package com.movieplatform.models;

public class RegularUser extends User {

    public RegularUser(String id, String name, String email, String password) {
        super(id, name, email, password, "REGULAR");
    }

    @Override
    public String getUserType() {
        return "REGULAR";
    }

    @Override
    public int getRentalDurationDays() {
        return 3;
    }
}