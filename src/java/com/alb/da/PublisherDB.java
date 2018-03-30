/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import com.alb.entities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHUONGTHUAN
 */
public class PublisherDB {
        
    /**
     * Get all of the Publishers.
     * 
     * @return 
     */
    public List<Publisher> getAllPublishers() {
        try {
            List<Publisher> lists = new ArrayList<>();
            
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM publishers");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Publisher p = new Publisher();
                p.setId(rs.getInt(Publisher.ID));
                p.setName(rs.getString(Publisher.NAME));
                p.setAddress(rs.getString(Publisher.ADDRESS));
                p.setPhone(rs.getString(Publisher.PHONE));
                p.setEmail(rs.getString(Publisher.EMAIL));
                
                lists.add(p);
            }
            
            return lists;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Publisher by giving ID
     * 
     * @param id
     * @return 
     */
    public Publisher getPublisherById(int id) {
        try {
            Connection con = DBConnection.getConnection();
            Publisher p = new Publisher();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM publishers WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                p.setId(rs.getInt(Publisher.ID));
                p.setName(rs.getString(Publisher.NAME));
                p.setAddress(rs.getString(Publisher.ADDRESS));
                p.setPhone(rs.getString(Publisher.PHONE));
                p.setEmail(rs.getString(Publisher.EMAIL));
            }
            
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
