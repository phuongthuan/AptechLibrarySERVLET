/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.beans;

import com.alb.da.*;
import com.alb.entities.*;
import java.util.*;

/**
 *
 * @author PHUONGTHUAN
 */
public class LibraryModelBean {
    
    private String keyword;
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public boolean login(String username, String password) {
        return new UserDB().checkUser(username, password);
    }
    
    public List<Book> getBooksByName() {
        return new BookDB().getBooksByName(keyword);
    }
    
    public Book getBookById(int id) {
        return new BookDB().getBookById(id);
    }
    
    public List<Book> getAllBooks() {
        return new BookDB().getAllBooks();
    }
    
    public boolean updateBook(String name, String description, int category_id, int author_id, int publisher_id, int status_id, int bookId) {
        return new BookDB().updateBook(name, description, category_id, author_id, publisher_id, status_id, bookId);
    }
    
    public boolean deleteBook(int id) {
        return new BookDB().deleteBook(id);
    }
    
    public boolean addBook(Book b) {
       return new BookDB().addNewBook(b);
    }
}
