package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Prescription;

import java.sql.*;

public class PrescriptionDAO {

    public void addPrescription(Prescription p) {
        String sql = "INSERT INTO prescriptions (visit_id, medicine_name, dosage, duration) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getVisitId());
            ps.setString(2, p.getMedicineName());
            ps.setString(3, p.getDosage());
            ps.setString(4, p.getDuration());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
