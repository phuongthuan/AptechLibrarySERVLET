/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import com.alb.entities.Author;

/**
 *
 * @author PHUONGTHUAN
 */
public class AuthorDBTest {
        
    public static void main(String[] args) {
        AuthorDB a = new AuthorDB();
        System.out.println(a.getAuthorById(2));
        
        for (Author author : a.getAllAuthors()) {
            System.out.println(author.toString());
        }
    }
    
}
