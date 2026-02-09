package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // Add patient
    public boolean addPatient(Patient patient) {
        String sql = "INSERT INTO patients (name, dob, phone, email, address, blood_group) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getDob());
            ps.setString(3, patient.getPhone());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getBloodGroup());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                // get auto-generated patient ID
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        patient.setPatientId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get patient by ID
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Patient p = new Patient();
                    p.setPatientId(rs.getInt("patient_id"));
                    p.setName(rs.getString("name"));
                    p.setDob(rs.getString("dob"));
                    p.setPhone(rs.getString("phone"));
                    p.setEmail(rs.getString("email"));
                    p.setAddress(rs.getString("address"));
                    p.setBloodGroup(rs.getString("blood_group"));
                    return p;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Search patients by name or phone (partial match)
    public List<Patient> searchPatients(String keyword) {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE name LIKE ? OR phone LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String likeKeyword = "%" + keyword + "%";
            ps.setString(1, likeKeyword);
            ps.setString(2, likeKeyword);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Patient p = new Patient();
                    p.setPatientId(rs.getInt("patient_id"));
                    p.setName(rs.getString("name"));
                    p.setDob(rs.getString("dob"));
                    p.setPhone(rs.getString("phone"));
                    p.setEmail(rs.getString("email"));
                    p.setAddress(rs.getString("address"));
                    p.setBloodGroup(rs.getString("blood_group"));
                    list.add(p);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
