package com.riderent.riderent.Doa;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.riderent.riderent.model.User;
import com.riderent.riderent.util.DBConnection;

public class UserDAO {
    
    private Connection conn;

    public UserDAO() {
        this.conn = DBConnection.getConnection();
    }

   
    public boolean registerUser(User user) {
        boolean f = false;
        try {
            // Query: Data insert karne ke liye
            String query = "INSERT INTO users(name, email, password, role, phone) VALUES(?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, "CUSTOMER"); // Default role hum CUSTOMER 
            ps.setString(5, user.getPhone());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true; // insert successful hua
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    public User loginUser(String email, String password ) {
    	
    	User user=null;
    	try { String query= "Select  * from users where email=? and password =? ";
    	      
    	PreparedStatement ps     = conn.prepareStatement(query);
    	  
    	           ps.setString(1, email);
    	           ps.setString(2, password);
    		   
    	      ResultSet rs = ps.executeQuery();
    	      if(rs.next()) {
    	    	  user= new User();
    	    	  user.setId(rs.getInt("id"));
    	    	  user.setName(rs.getString("name"));
    	    	  user.setEmail(rs.getString("email"));
    	    	  user.setPassword(rs.getString("password"));
    	    	  user.setPhone(rs.getString("phone"));
    	    	  user.setRole(rs.getString("role"));
    	    	  
    	    	
    	      }
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	// agar user mila tho user jaye nai tho null 
    	return user;
    }
}