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
    
    public List getListbooks() {

        try {
            ps = getListBooksStatement();
            ResultSet rs = ps.executeQuery();
            List<String[]> listbooks = new ArrayList<>();
            while (rs.next()) {
                listbooks.add(new String[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                });

            }
            return listbooks;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List getBookDetails(int id) {
        try {
            ps = getBookDetailStatement();
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            List<String[]> bookdetails = new ArrayList<>();
            while (rs.next()) {
                bookdetails.add(new String[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                });
            }
            return bookdetails;

        } catch (Exception e) {
            e.printStackTrace();
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

    public void deleteBook(Integer id) {
        try {
            ps = getDeleteBookStatement();
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
    private PreparedStatement getBookDetailStatement() throws SQLException, ClassNotFoundException {
        if (ps == null) {
            Connection conn = new DBConnection().getConnection();
            ps = conn.prepareStatement("SELECT b.id, c.name, b.name, b.description, a.name, p.name, b.status FROM books b INNER JOIN authors a ON b.author_id = a.id INNER JOIN publishers p ON b.publisher_id = p.id INNER JOIN categories c ON b.category_id = c.id WHERE b.id=?");
        }
        return ps;
    }
    
    private PreparedStatement getListBooksStatement() throws SQLException, ClassNotFoundException {
        if (ps == null) {
            Connection conn = new DBConnection().getConnection();
            ps = conn.prepareStatement("SELECT b.id, c.name, b.name, b.description, a.name, p.name, b.status FROM books b INNER JOIN authors a ON b.author_id = a.id INNER JOIN publishers p ON b.publisher_id = p.id INNER JOIN categories c ON b.category_id = c.id");
        }
        return ps;
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
    
    private PreparedStatement getDeleteBookStatement() throws SQLException, ClassNotFoundException {
        if (ps == null) {
            Connection conn = new DBConnection().getConnection();
            ps = conn.prepareStatement("DELETE FROM books WHERE id=?");
        }
        return ps;
    }

    
}
