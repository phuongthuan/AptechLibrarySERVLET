/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import com.alb.entities.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author PHUONGTHUAN
 */
public class AuthorDB {
    
    public static void main(String[] args) {
        AuthorDB a = new AuthorDB();
        System.out.println(a.getAuthorById(2));
        
        for (Author author : a.getAllAuthors()) {
            System.out.println(author.toString());
        }
    }
    /**
     * Get all of the Authors.
     * 
     * @return 
     */
    public List<Author> getAllAuthors() {
        try {
            List<Author> lists = new ArrayList<>();

            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM authors");
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next()) {
                //Must be inside while lop
                Author a = new Author();

                a.setId(rs.getInt(Author.ID));
                a.setName(rs.getString(Author.NAME));
                a.setDescription(rs.getString(Author.DESCRIPTION));
                a.setPhone(rs.getString(Author.PHONE));
                a.setEmail(rs.getString(Author.EMAIL));
                
                lists.add(a);
            }
            
            return lists;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Author by giving ID.
     * 
     * @param id
     * @return 
     */
    public Author getAuthorById(int id) {
        try {
            Connection con = DBConnection.getConnection();
            Author author = new Author();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM authors WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                author.setId(rs.getInt(Author.ID));
                author.setName(rs.getString(Author.NAME));
                author.setDescription(rs.getString(Author.DESCRIPTION));
                author.setPhone(rs.getString(Author.PHONE));
                author.setEmail(rs.getString(Author.EMAIL));
            }
            
            return author;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   
    
}
