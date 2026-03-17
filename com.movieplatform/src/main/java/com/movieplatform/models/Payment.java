package com.movieplatform.models;

public abstract class Payment {

    private String paymentId;
    private String userId;
    private String rentalId;
    private double amount;
    private String type;
    private String status;
    private String date;

    public Payment(String paymentId, String userId, String rentalId,
                   double amount, String type, String status, String date) {
        this.paymentId = paymentId;
        this.userId    = userId;
        this.rentalId  = rentalId;
        this.amount    = amount;
        this.type      = type;
        this.status    = status;
        this.date      = date;
    }

    // Abstract methods — subclasses MUST implement these (Abstraction + Polymorphism)
    public abstract double calculateAmount();
    public abstract String getPaymentCategory();

    // Getters (Encapsulation — fields are private)
    public String getPaymentId()  { return paymentId; }
    public String getUserId()     { return userId; }
    public String getRentalId()   { return rentalId; }
    public double getAmount()     { return amount; }
    public String getType()       { return type; }
    public String getStatus()     { return status; }
    public String getDate()       { return date; }

    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setAmount(double amount) { this.amount = amount; }

    // Saves to payments.txt in the correct format
    public String toFileString() {
        return paymentId + "|" + userId + "|" + rentalId + "|" +
                amount + "|" + type + "|" + status + "|" + date;
    }
}