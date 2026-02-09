package com.clinic.model;

public class Doctor {
    private int doctorId;
    private String name;
    private int specialtyId;
    private String phone;
    private double consultationFee;
    private boolean isActive;

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getSpecialtyId() { return specialtyId; }
    public void setSpecialtyId(int specialtyId) { this.specialtyId = specialtyId; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
