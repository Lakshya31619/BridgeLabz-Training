package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Bill;

import java.sql.*;

public class BillingDAO {

    public void generateBill(Bill b) {
        String sql = "INSERT INTO bills (visit_id, amount, payment_status, payment_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, b.getVisitId());
            ps.setDouble(2, b.getAmount());
            ps.setString(3, b.getPaymentStatus());
            ps.setString(4, b.getPaymentDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
