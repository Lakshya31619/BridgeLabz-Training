package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Doctor;
import com.clinic.model.Speciality;
import com.clinic.util.InputUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public boolean addDoctor(Doctor doctor){
        String sql = "INSERT INTO doctors (name,specialty_id,phone,consultation_fee,is_active) VALUES (?,?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, doctor.getName());
            ps.setInt(2, doctor.getSpecialtyId());
            ps.setString(3, doctor.getPhone());
            ps.setDouble(4, doctor.getConsultationFee());
            ps.setBoolean(5,true);
            int rows = ps.executeUpdate();
            if(rows>0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    doctor.setDoctorId(rs.getInt(1));
                }
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void assignSpecialty(){
        int docId = InputUtil.getInt("Enter Doctor ID: ");
        int specId = InputUtil.getInt("Enter Specialty ID: ");
        String sql = "UPDATE doctors SET specialty_id=? WHERE doctor_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,specId);
            ps.setInt(2,docId);
            int updated = ps.executeUpdate();
            if(updated>0) System.out.println("Specialty assigned/updated successfully.");
            else System.out.println("Doctor not found.");
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void viewDoctorsBySpecialty(){
        int specId = InputUtil.getInt("Enter Specialty ID to view doctors: ");
        String sql = "SELECT d.doctor_id,d.name,d.phone,d.consultation_fee,s.name AS specialty FROM doctors d INNER JOIN specialties s ON d.specialty_id=s.specialty_id WHERE d.specialty_id=? AND d.is_active=1";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,specId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("ID:"+rs.getInt("doctor_id")+" | Name:"+rs.getString("name")+" | Phone:"+rs.getString("phone")+" | Fee:"+rs.getDouble("consultation_fee")+" | Specialty:"+rs.getString("specialty"));
            }
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void deactivateDoctor(int doctorId){
        String check = "SELECT COUNT(*) AS cnt FROM appointments WHERE doctor_id=? AND status='SCHEDULED'";
        String sql = "UPDATE doctors SET is_active=false WHERE doctor_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement psCheck = conn.prepareStatement(check);
            PreparedStatement psUpdate = conn.prepareStatement(sql)){
            psCheck.setInt(1,doctorId);
            ResultSet rs = psCheck.executeQuery();
            if(rs.next() && rs.getInt("cnt")>0){
                System.out.println("Cannot deactivate. Future appointments exist.");
                return;
            }
            psUpdate.setInt(1,doctorId);
            if(psUpdate.executeUpdate()>0) System.out.println("Doctor deactivated successfully.");
            else System.out.println("Doctor not found.");
        }catch(SQLException e){ e.printStackTrace();}
    }
}
