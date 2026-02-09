package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Visit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitDAO {

    public void addVisit(Visit v) {
        String sql = "INSERT INTO visits (appointment_id, diagnosis, notes, visit_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, v.getAppointmentId());
            ps.setString(2, v.getDiagnosis());
            ps.setString(3, v.getNotes());
            ps.setString(4, v.getVisitDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Visit> getVisitsByPatient(int patientId) {
        List<Visit> list = new ArrayList<>();
        String sql = "SELECT v.* FROM visits v JOIN appointments a ON v.appointment_id=a.appointment_id WHERE a.patient_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Visit v = new Visit();
                v.setVisitId(rs.getInt("visit_id"));
                v.setAppointmentId(rs.getInt("appointment_id"));
                v.setDiagnosis(rs.getString("diagnosis"));
                v.setNotes(rs.getString("notes"));
                v.setVisitDate(rs.getString("visit_date"));
                list.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
