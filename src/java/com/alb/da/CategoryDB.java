/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import com.alb.entities.Author;
import com.alb.entities.Category;
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
public class CategoryDB {
    
    /**
     * Get all of the Categories.
     * 
     * @return 
     */
    public List<Category> getAllCategories() {
        try {
            List<Category> lists = new ArrayList<>();
            
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM categories");
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Category c = new Category(); 
                c.setId(rs.getInt(Category.ID));
                c.setName(rs.getString(Category.NAME));
                
                lists.add(c);
            }
           
            return lists;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Category by giving ID.
     * 
     * @param id
     * @return 
     */
    public Category getCategoryById(int id) {
        try {
            Connection con = DBConnection.getConnection();
            Category c = new Category();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM categories WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                c.setId(rs.getInt(Category.ID));
                c.setName(rs.getString(Category.NAME));
            }
            
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
