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

    /**
     * Get all of the Books.
     * 
     * @return 
     */
    public List<Book> getAllBooks() {
        try {
            List<Book> books = new ArrayList<>();
            
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Book b = new Book();
                
                b.setId(rs.getInt(Book.ID));
                b.setName(rs.getString(Book.NAME));
                b.setDescription(rs.getString(Book.DESCRIPTION));
                
                b.setCategory(new CategoryDB().getCategoryById(rs.getInt(Book.CATEGORY_ID)));
                b.setAuthor(new AuthorDB().getAuthorById(rs.getInt(Book.AUTHOR_ID)));
                b.setPublisher(new PublisherDB().getPublisherById(rs.getInt(Book.PUBLISHER_ID)));
                b.setStatus(new StatusDB().getStatusById(rs.getInt(Book.STATUS_ID)));
                
                b.setCreated_at(rs.getString(Book.CREATED_AT));
                b.setUpdated_at(rs.getString(Book.UPDATED_AT));
                
                books.add(b);
            }
            
            return books;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Book by giving ID.
     * 
     * @param id
     * @return 
     */
    public Book getBookById(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Book b = new Book();
            rs.next();
            
            b.setId(rs.getInt(Book.ID));
            b.setName(rs.getString(Book.NAME));
            b.setDescription(rs.getString(Book.DESCRIPTION));

            b.setCategory(new CategoryDB().getCategoryById(rs.getInt(Book.CATEGORY_ID)));
            b.setAuthor(new AuthorDB().getAuthorById(rs.getInt(Book.AUTHOR_ID)));
            b.setPublisher(new PublisherDB().getPublisherById(rs.getInt(Book.PUBLISHER_ID)));
            b.setStatus(new StatusDB().getStatusById(rs.getInt(Book.STATUS_ID)));
            
            b.setCreated_at(rs.getString(Book.CREATED_AT));
            b.setUpdated_at(rs.getString(Book.UPDATED_AT));
            
            return b;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Book by giving name.
     * 
     * @param name
     * @return 
     */
    public List<Book> getBooksByName(String name) {
        try {
            List<Book> books = new ArrayList<Book>();

            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE name like ?");
            ps.setString(1, "%"+name+"%");
            
            ResultSet rs = ps.executeQuery();
            Book b = new Book();
            
            while(rs.next()) {
                b.setId(rs.getInt(Book.ID));
                b.setName(rs.getString(Book.NAME));
                b.setDescription(rs.getString(Book.DESCRIPTION));
                b.setCategory(new CategoryDB().getCategoryById(rs.getInt(Book.CATEGORY_ID)));
                b.setAuthor(new AuthorDB().getAuthorById(rs.getInt(Book.AUTHOR_ID)));
                b.setPublisher(new PublisherDB().getPublisherById(rs.getInt(Book.PUBLISHER_ID)));
                b.setStatus(new StatusDB().getStatusById(rs.getInt(Book.STATUS_ID)));
                
                books.add(b);
            }

            return books;
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Add a New Book.
     * 
     * @param b
     * @return 
     */
    public boolean addNewBook(Book b) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO books (name, description, category_id, author_id, publisher_id, status_id) VALUES(?,?,?,?,?,?)");
            
            ps.setString(1, b.getName());
            ps.setString(2, b.getDescription());
            ps.setInt(3, b.getCategory_id());
            ps.setInt(4, b.getAuthor_id());
            ps.setInt(5, b.getPublisher_id());
            ps.setInt(6, b.getStatus_id());
            return ps.executeUpdate() > 0;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     * Update a Book by giving ID.
     * 
     * @param name
     * @param description
     * @param category_id
     * @param author_id
     * @param publisher_id
     * @param status_id
     * @param bookId
     * @return 
     */
    public boolean updateBook(String name, String description, int category_id, int author_id, int publisher_id, int status_id, int bookId) {
        
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE books SET name = ?, description = ?, category_id = ?, author_id = ?, publisher_id = ?, status_id = ? WHERE id = ?");
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, category_id);
            ps.setInt(4, author_id);
            ps.setInt(5, publisher_id);
            ps.setInt(6, status_id);
            ps.setInt(7, bookId);
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Delete a Book.
     * 
     * @param id
     * @return 
     */
    public static boolean deleteBook(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
