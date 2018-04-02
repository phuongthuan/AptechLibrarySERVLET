/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import com.alb.entities.*;
import java.sql.*;

/**
 *
 * @author PHUONGTHUAN
 */
public class UserDB {
    
        public boolean checkUser(String username, String password) {
        
            boolean st = false;
            try {
                Connection con = DBConnection.getConnection();
                User user = new User();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                
                st = rs.next();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return st;
        }
}
