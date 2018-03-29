/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import java.util.*;
import java.sql.*;
import com.alb.entities.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHUONGTHUAN
 */
public class BookDB {
    
    PreparedStatement ps;

    public List<Book> getAllBooks() {
        try {
            
            List<Book> books = new ArrayList<>();

            ps = getAllBooksStatement();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getInt(6),
                        rs.getInt(7))
                );
            }
            return books;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public List<Book> getBooksByName(String name) {
        try {

            ps = getSearchStatement();
            ps.setString(1, "%"+name+"%");
            ResultSet rs = ps.executeQuery();
            List<Book> books = new LinkedList<Book>();

            while(rs.next()) {
                books.add(new Book(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getInt(6),
                        rs.getInt(7)));
            }

            return books;
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    private PreparedStatement getSearchStatement() throws ClassNotFoundException, SQLException {
        if (ps == null) {
            Connection conn = new DBConnection().getConnection();
            ps = conn.prepareStatement("SELECT * FROM books WHERE name like ?");
        }
        return ps;
    }
    
    private PreparedStatement getAllBooksStatement() throws SQLException, ClassNotFoundException {
        if (ps == null) {
            Connection conn = new DBConnection().getConnection();
            ps = conn.prepareStatement("SELECT * FROM books");
        }
        return ps;
    }
    
    
    
}
