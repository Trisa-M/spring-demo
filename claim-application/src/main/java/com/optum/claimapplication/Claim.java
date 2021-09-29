package com.optum.claimapplication;

public class Claim {

    private Integer claimNumber;
    private String patientName;
    private int patientAge;
    private double claimAmount;

    public Claim(int claimNumber, String patientName, int patientAge, double claimAmount) {
        this.claimNumber = claimNumber;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.claimAmount = claimAmount;
    }

    public Integer getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(Integer claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }
}
