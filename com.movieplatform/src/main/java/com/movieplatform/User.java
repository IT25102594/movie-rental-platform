package com.movieplatform.models;

public abstract class User {

    private String userId;
    private String name;
    private String email;
    private String password;
    private String membershipType;
    private String status;

    public User(String userId, String name, String email, String password, String membershipType) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.membershipType = membershipType;
        this.status = "ACTIVE";
    }

    public abstract String getUserType();
    public abstract int getRentalDurationDays();

    public String getUserId()        { return userId; }
    public String getName()          { return name; }
    public String getEmail()         { return email; }
    public String getMembershipType(){ return membershipType; }
    public String getStatus()        { return status; }

    public void setName(String name)      { this.name = name; }
    public void setEmail(String email)    { this.email = email; }
    public void setPassword(String p)     { this.password = p; }
    public void setStatus(String s)       { this.status = s; }

    public String toFileString() {
        return userId + "|" + name + "|" + email + "|" + password + "|" + membershipType + "|" + status;
    }
}