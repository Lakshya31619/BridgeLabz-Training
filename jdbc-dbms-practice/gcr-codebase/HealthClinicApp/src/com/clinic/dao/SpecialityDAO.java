package com.clinic.dao;

import com.clinic.config.DBConnection;
import com.clinic.model.Speciality;
import com.clinic.util.InputUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialityDAO {

    public void addSpeciality() { // Create
        String name = InputUtil.getString("Enter Specialty Name: ");
        String sql = "INSERT INTO specialties (name) VALUES (?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, name);
            int rows = ps.executeUpdate();
            if(rows > 0) {
                System.out.println("Specialty added successfully.");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSpeciality() { // Update
        int id = InputUtil.getInt("Enter Specialty ID to update: ");
        String newName = InputUtil.getString("Enter New Name: ");
        String sql = "UPDATE specialties SET name=? WHERE specialty_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, newName);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if(rows > 0) System.out.println("Specialty updated successfully.");
            else System.out.println("Specialty not found.");
        } catch(SQLException e) { e.printStackTrace(); }
    }

    public void deleteSpeciality() { // Delete
        int id = InputUtil.getInt("Enter Specialty ID to delete: ");
        String check = "SELECT COUNT(*) AS cnt FROM doctors WHERE specialty_id=?";
        String sql = "DELETE FROM specialties WHERE specialty_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement psCheck = conn.prepareStatement(check);
            PreparedStatement psDelete = conn.prepareStatement(sql)){

            psCheck.setInt(1, id);
            ResultSet rs = psCheck.executeQuery();
            if(rs.next() && rs.getInt("cnt") > 0){
                System.out.println("Cannot delete. Doctors are assigned to this specialty.");
                return;
            }

            psDelete.setInt(1, id);
            int rows = psDelete.executeUpdate();
            if(rows > 0) System.out.println("Specialty deleted successfully.");
            else System.out.println("Specialty not found.");
        } catch(SQLException e){ e.printStackTrace(); }
    }

    public void viewSpecialties() { // Read
        String sql = "SELECT * FROM specialties";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("ID:"+rs.getInt("specialty_id")+" | Name:"+rs.getString("name"));
            }
        } catch(SQLException e){ e.printStackTrace(); }
    }

    public List<Speciality> getAllSpecialties() { // For other DAOs
        List<Speciality> list = new ArrayList<>();
        String sql = "SELECT * FROM specialties";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Speciality s = new Speciality();
                s.setSpecialtyId(rs.getInt("specialty_id"));
                s.setName(rs.getString("name"));
                list.add(s);
            }
        } catch(SQLException e){ e.printStackTrace(); }
        return list;
    }
}
