package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Bill;
import com.clinic.util.InputUtil;

import java.sql.*;

public class BillingDAO {

    public void generateBill() { // UC-5.1
        int visitId = InputUtil.getInt("Enter Visit ID: ");
        double additionalCharges = InputUtil.getDouble("Enter Additional Charges: ");
        String sqlFee = "SELECT d.consultation_fee FROM appointments a INNER JOIN doctors d ON a.doctor_id=d.doctor_id WHERE a.appointment_id=?";
        String sqlInsert = "INSERT INTO bills (visit_id, amount, payment_status) VALUES (?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement psFee = conn.prepareStatement(sqlFee);
            PreparedStatement psInsert = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)){
            psFee.setInt(1,visitId);
            ResultSet rs = psFee.executeQuery();
            if(rs.next()){
                double total = rs.getDouble("consultation_fee") + additionalCharges;
                psInsert.setInt(1,visitId);
                psInsert.setDouble(2,total);
                psInsert.setString(3,"UNPAID");
                psInsert.executeUpdate();
                System.out.println("Bill generated with total amount: "+total);
            } else System.out.println("Visit not found.");
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void recordPayment() { // UC-5.2
        int billId = InputUtil.getInt("Enter Bill ID: ");
        String date = InputUtil.getString("Enter Payment Date (YYYY-MM-DD): ");
        String mode = InputUtil.getString("Enter Payment Mode (CASH/CARD): ");
        double amount = InputUtil.getDouble("Enter Amount Paid: ");
        String sqlUpdate = "UPDATE bills SET payment_status='PAID' WHERE bill_id=?";
        String sqlTransaction = "INSERT INTO payment_transactions (bill_id, payment_date, payment_mode, amount) VALUES (?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
            PreparedStatement psTrans = conn.prepareStatement(sqlTransaction)){
            conn.setAutoCommit(false);
            psUpdate.setInt(1,billId);
            psUpdate.executeUpdate();
            psTrans.setInt(1,billId);
            psTrans.setString(2,date);
            psTrans.setString(3,mode);
            psTrans.setDouble(4,amount);
            psTrans.executeUpdate();
            conn.commit();
            System.out.println("Payment recorded successfully.");
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void viewOutstandingBills() { // UC-5.3
        String sql = "SELECT b.bill_id, p.name AS patient_name, b.amount FROM bills b INNER JOIN visits v ON b.visit_id=v.visit_id INNER JOIN appointments a ON v.appointment_id=a.appointment_id INNER JOIN patients p ON a.patient_id=p.patient_id WHERE b.payment_status='UNPAID'";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Bill ID:"+rs.getInt("bill_id")+" | Patient:"+rs.getString("patient_name")+" | Amount:"+rs.getDouble("amount"));
            }
        }catch(SQLException e){ e.printStackTrace();}
    }

    public void generateRevenueReport() { // UC-5.4
        String fromDate = InputUtil.getString("Enter From Date (YYYY-MM-DD): ");
        String toDate = InputUtil.getString("Enter To Date (YYYY-MM-DD): ");
        String sql = "SELECT d.name AS doctor_name, SUM(b.amount) AS total_revenue " +
                     "FROM bills b INNER JOIN visits v ON b.visit_id=v.visit_id " +
                     "INNER JOIN appointments a ON v.appointment_id=a.appointment_id " +
                     "INNER JOIN doctors d ON a.doctor_id=d.doctor_id " +
                     "WHERE a.date BETWEEN ? AND ? GROUP BY d.name";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,fromDate);
            ps.setString(2,toDate);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Doctor:"+rs.getString("doctor_name")+" | Revenue:"+rs.getDouble("total_revenue"));
            }
        }catch(SQLException e){ e.printStackTrace();}
    }
}
