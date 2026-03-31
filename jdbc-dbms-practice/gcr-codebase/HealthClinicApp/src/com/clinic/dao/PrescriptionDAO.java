package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Prescription;
import com.clinic.util.InputUtil;

import java.sql.*;

public class PrescriptionDAO {

    public void addPrescription(){ // Optional separate DAO for UC-4.3 if needed
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
            System.out.println("Prescription added successfully.");
        }catch(SQLException e){ e.printStackTrace();}
    }
}
