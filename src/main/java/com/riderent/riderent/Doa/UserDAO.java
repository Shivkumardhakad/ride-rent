package com.riderent.riderent.Doa;



import java.sql.Connection;
import java.sql.PreparedStatement;

import com.riderent.riderent.model.User;
import com.riderent.riderent.util.DBConnection;

public class UserDAO {
    
    private Connection conn;

    public UserDAO() {
        this.conn = DBConnection.getConnection();
    }

    // User Register karne ka method
    public boolean registerUser(User user) {
        boolean f = false;
        try {
            // Query: Data insert karne ke liye
            String query = "INSERT INTO users(name, email, password, role, phone) VALUES(?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, "CUSTOMER"); // Default role hum CUSTOMER rakhenge
            ps.setString(5, user.getPhone());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true; // Agar insert successful hua
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}