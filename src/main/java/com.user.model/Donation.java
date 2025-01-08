package com.user.model;

import java.util.Date;

public class Donation {
    private int donationId;
    private int userId;
    private String donationType;
    private double donationAmount;
    private String donationDescription;
    private Date donatedAt;

    // Getters and Setters
    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getDonationDescription() {
        return donationDescription;
    }

    public void setDonationDescription(String donationDescription) {
        this.donationDescription = donationDescription;
    }

    public Date getDonatedAt() {
        return donatedAt;
    }

    public void setDonatedAt(Date donatedAt) {
        this.donatedAt = donatedAt;
    }
}
