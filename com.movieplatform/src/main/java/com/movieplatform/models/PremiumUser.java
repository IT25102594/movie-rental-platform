package com.movieplatform.models;

public class PremiumUser extends User {

    public PremiumUser(String id, String name, String email, String password) {
        super(id, name, email, password, "PREMIUM");
    }

    @Override
    public String getUserType() {
        return "PREMIUM";
    }

    @Override
    public int getRentalDurationDays() {
        return 7;
    }
}