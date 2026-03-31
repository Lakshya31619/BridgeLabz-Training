package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Visit;
import com.clinic.model.Appointment;
import com.clinic.util.InputUtil;

import java.sql.*;

public class VisitDAO {

    public void recordVisit() { // UC-4.1
        int appointmentId = InputUtil.getInt("Enter Appointment ID: ");
        String diagnosis = InputUtil.getString("Enter Diagnosis: ");
        String notes = InputUtil.getString("Enter Notes: ");
        String sqlInsert = "INSERT INTO visits (appointment_id, diagnosis, notes) VALUES (?,?,?)";
        String sqlUpdate = "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement psInsert = conn.prepareStatement(sqlInsert);
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)){
            conn.setAutoCommit(false);
            psInsert.setInt(1,appointmentId);
            psInsert.setString(2,diagnosis);
            psInsert.setString(3,notes);
            psInsert.executeUpdate();
            psUpdate.setInt(1,appointmentId);
            psUpdate.executeUpdate();
            conn.commit();
            System.out.println("Visit recorded and appointment marked completed.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void viewVisitHistory(int patientId) { // UC-1.4
        String sql = "SELECT v.visit_id, v.diagnosis, v.notes, d.name AS doctor_name, a.date " +
                     "FROM visits v INNER JOIN appointments a ON v.appointment_id=a.appointment_id " +
                     "INNER JOIN doctors d ON a.doctor_id=d.doctor_id WHERE a.patient_id=? ORDER BY a.date";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,patientId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Visit ID:"+rs.getInt("visit_id")+" | Date:"+rs.getString("date")+
                        " | Doctor:"+rs.getString("doctor_name")+" | Diagnosis:"+rs.getString("diagnosis")+
                        " | Notes:"+rs.getString("notes"));
            }
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void viewMedicalHistory() { // UC-4.2
        int patientId = InputUtil.getInt("Enter Patient ID: ");
        String sql = "SELECT v.visit_id, v.diagnosis, v.notes, d.name AS doctor_name, a.date " +
                     "FROM visits v INNER JOIN appointments a ON v.appointment_id=a.appointment_id " +
                     "INNER JOIN doctors d ON a.doctor_id=d.doctor_id WHERE a.patient_id=? ORDER BY a.date DESC";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,patientId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Visit ID:"+rs.getInt("visit_id")+" | Date:"+rs.getString("date")+
                        " | Doctor:"+rs.getString("doctor_name")+" | Diagnosis:"+rs.getString("diagnosis")+
                        " | Notes:"+rs.getString("notes"));
            }
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void addPrescription() { // UC-4.3
        int visitId = InputUtil.getInt("Enter Visit ID: ");
        String medicine = InputUtil.getString("Enter Medicine Name: ");
        String dosage = InputUtil.getString("Enter Dosage: ");
        String duration = InputUtil.getString("Enter Duration: ");
        String sql = "INSERT INTO prescriptions (visit_id, medicine_name, dosage, duration) VALUES (?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,visitId);
            ps.setString(2,medicine);
            ps.setString(3,dosage);
            ps.setString(4,duration);
            ps.executeUpdate();
            System.out.println("Prescription added.");
        }catch(SQLException e){ e.printStackTrace();}
    }
}
