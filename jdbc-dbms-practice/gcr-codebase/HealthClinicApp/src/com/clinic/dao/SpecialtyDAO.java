package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Specialty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyDAO {

    public void addSpecialty(Specialty s) {
        String sql = "INSERT INTO specialties (name) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Specialty> getAllSpecialties() {
        List<Specialty> list = new ArrayList<>();
        String sql = "SELECT * FROM specialties";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while(rs.next()) {
                Specialty s = new Specialty();
                s.setSpecialtyId(rs.getInt("specialty_id"));
                s.setName(rs.getString("name"));
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
