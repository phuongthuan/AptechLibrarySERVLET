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
    
//    public static void main(String[] args) {
//        System.out.println(getBookById(1));
////        Book b = new Book();
////        b.setName("Change the world start off by making your bed");
////        b.setDescription("A story about life");
////        b.setCategory(new Category(1));
////        b.setAuthor(new Author(1));
////        b.setPublisher(new Publisher(1));
////        b.setStatus(0);
////        addNewBook(b);
//
////        for (Book book : getBooksByName("velit")) {
////            System.out.println(book.toString());
////        }
////        
////        for (Book book : getAllBooks()) {
////            System.out.println(book.toString());
////        }
//    }

    /**
     * Get all of the Books.
     * 
     * @return 
     */
    public static List<Book> getAllBooks() {
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
    public static Book getBookById(int id) {
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
    public static List<Book> getBooksByName(String name) {
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
    public static boolean addNewBook(Book b) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO books VALUES(?,?,?,?,?,?");
            
            ps.setString(1, b.getName());
            ps.setString(2, b.getDescription());
            ps.setInt(3, b.getCategory().getId());
            ps.setInt(4, b.getAuthor().getId());
            ps.setInt(5, b.getPublisher().getId());
            ps.setInt(6, b.getStatus().getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception ex) {
            ex.printStackTrace();
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
