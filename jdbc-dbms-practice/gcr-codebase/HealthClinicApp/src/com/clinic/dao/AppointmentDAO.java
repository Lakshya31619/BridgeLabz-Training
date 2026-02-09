package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.util.InputUtil;

import java.sql.*;

public class AppointmentDAO {

    public void bookAppointment(){
        int patientId = InputUtil.getInt("Enter Patient ID: ");
        int doctorId = InputUtil.getInt("Enter Doctor ID: ");
        String date = InputUtil.getString("Enter Date (YYYY-MM-DD): ");
        String time = InputUtil.getString("Enter Time (HH:MM): ");
        String sql = "INSERT INTO appointments (patient_id,doctor_id,date,time,status) VALUES (?,?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,patientId);
            ps.setInt(2,doctorId);
            ps.setString(3,date);
            ps.setString(4,time);
            ps.setString(5,"SCHEDULED");
            if(ps.executeUpdate()>0) System.out.println("Appointment booked successfully.");
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void checkAvailability(){
        int doctorId = InputUtil.getInt("Enter Doctor ID: ");
        String date = InputUtil.getString("Enter Date (YYYY-MM-DD): ");
        String sql = "SELECT COUNT(*) AS cnt FROM appointments WHERE doctor_id=? AND date=? AND status='SCHEDULED'";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,doctorId);
            ps.setString(2,date);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Scheduled appointments for doctor "+doctorId+" on "+date+": "+rs.getInt("cnt"));
            }
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void cancelAppointment(){
        int appointmentId = InputUtil.getInt("Enter Appointment ID to cancel: ");
        String sql = "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,appointmentId);
            if(ps.executeUpdate()>0) System.out.println("Appointment cancelled.");
            else System.out.println("Appointment not found.");
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void rescheduleAppointment(){
        int appointmentId = InputUtil.getInt("Enter Appointment ID to reschedule: ");
        String newDate = InputUtil.getString("Enter New Date (YYYY-MM-DD): ");
        String newTime = InputUtil.getString("Enter New Time (HH:MM): ");
        int doctorId = InputUtil.getInt("Enter New Doctor ID: ");
        String sql = "UPDATE appointments SET doctor_id=?, date=?, time=? WHERE appointment_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,doctorId);
            ps.setString(2,newDate);
            ps.setString(3,newTime);
            ps.setInt(4,appointmentId);
            if(ps.executeUpdate()>0) System.out.println("Appointment rescheduled.");
            else System.out.println("Appointment not found.");
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void viewDailySchedule(){
        String date = InputUtil.getString("Enter Date (YYYY-MM-DD) to view schedule: ");
        String sql = "SELECT a.appointment_id,a.time,p.name AS patient_name,d.name AS doctor_name FROM appointments a INNER JOIN patients p ON a.patient_id=p.patient_id INNER JOIN doctors d ON a.doctor_id=d.doctor_id WHERE a.date=? ORDER BY a.time";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,date);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Appointment ID:"+rs.getInt("appointment_id")+" | Time:"+rs.getString("time")+" | Patient:"+rs.getString("patient_name")+" | Doctor:"+rs.getString("doctor_name"));
            }
        }catch(SQLException e){ e.printStackTrace();}
    }
}
