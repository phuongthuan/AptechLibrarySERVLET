/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import com.alb.entities.Category;
import com.alb.entities.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHUONGTHUAN
 */
public class StatusDB {
    /**
     * Get all of the Statuses.
     * 
     * @return 
     */
    public List<Status> getAllStatuses() {
        try {
            List<Status> lists = new ArrayList<>();
            
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM statuses");
            ResultSet rs = preparedStatement.executeQuery();
            
            
            while (rs.next()) {
                Status s = new Status();
                s.setId(rs.getInt(Status.ID));
                s.setName(rs.getString(Status.NAME));
                
                lists.add(s);
            }
           
            return lists;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Status by giving ID.
     * 
     * @param id
     * @return 
     */
    public Status getStatusById(int id) {
        try {
            Connection con = DBConnection.getConnection();
            Status c = new Status();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM statuses WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                c.setId(rs.getInt(Status.ID));
                c.setName(rs.getString(Status.NAME));
            }
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
