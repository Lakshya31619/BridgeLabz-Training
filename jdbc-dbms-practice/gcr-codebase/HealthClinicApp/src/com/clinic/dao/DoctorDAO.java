package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void addDoctor(Doctor d) {
        String sql = "INSERT INTO doctors (name, specialty_id, phone, consultation_fee, is_active) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.setInt(2, d.getSpecialtyId());
            ps.setString(3, d.getPhone());
            ps.setDouble(4, d.getConsultationFee());
            ps.setBoolean(5, d.isActive());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDoctorSpecialty(int doctorId, int specialtyId) {
        String sql = "UPDATE doctors SET specialty_id=? WHERE doctor_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, specialtyId);
            ps.setInt(2, doctorId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deactivateDoctor(int doctorId) {
        String sql = "UPDATE doctors SET is_active=false WHERE doctor_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> getDoctorsBySpecialty(int specialtyId) {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE specialty_id=? AND is_active=true";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, specialtyId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialtyId(rs.getInt("specialty_id"));
                d.setPhone(rs.getString("phone"));
                d.setConsultationFee(rs.getDouble("consultation_fee"));
                d.setActive(rs.getBoolean("is_active"));
                list.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
