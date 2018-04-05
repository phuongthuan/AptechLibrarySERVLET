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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHUONGTHUAN
 */
public class HistoryDB {
    
    /**
     * Get all of the Books.
     * 
     * @return 
     */
    public List<History> getAllHistories() {
        try {
            List<History> histories = new ArrayList<>();
            
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM histories");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                History b = new History();
                
                b.setId(rs.getInt(History.ID));
                b.setBook_id(rs.getInt(History.BOOK_ID));
                b.setStudent_name(rs.getString(History.STUDENT_NAME));
                b.setCreated_at(rs.getString(History.CREATED_AT));
                b.setUpdated_at(rs.getString(History.UPDATED_AT));
                
                histories.add(b);
            }
            
            return histories;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get History by giving ID.
     * 
     * @param id
     * @return 
     */
    public History getHistoryById(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM histories WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            History b = new History();

            rs.next();
                
            b.setId(rs.getInt(History.ID));
//            b.setBook(new BookDB().getBookById(rs.getInt(History.BOOK_ID)));
            b.setBook_id(rs.getInt(History.BOOK_ID));
            b.setStudent_name(rs.getString(History.STUDENT_NAME));
            b.setCreated_at(rs.getString(History.CREATED_AT));
            b.setUpdated_at(rs.getString(History.UPDATED_AT));
            
            return b;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Add a New History.
     * 
     * @param b
     * @return 
     */
    public boolean addNewHistory(History b) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO histories (book_id, student_name) VALUES(?,?)");
            
            ps.setInt(1, b.getBook_id());
            ps.setString(2, b.getStudent_name());
            return ps.executeUpdate() > 0;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
