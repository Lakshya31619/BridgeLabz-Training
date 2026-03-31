package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.PaymentTransaction;

import java.sql.*;

public class PaymentTransactionDAO {

    public void recordPayment(PaymentTransaction pt) {
        String sql = "INSERT INTO payment_transactions (bill_id, payment_date, payment_mode, amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pt.getBillId());
            ps.setString(2, pt.getPaymentDate());
            ps.setString(3, pt.getPaymentMode());
            ps.setDouble(4, pt.getAmount());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
