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
    private int option;
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setOption(int option) {
        this.option = option;
    }
    
    public boolean login(String username, String password) {
        return new UserDB().checkUser(username, password);
    }
    
    public List<Book> getBooksByName() {
        return new BookDB().findBooksByName(keyword);
    }
    
    public List<Book> getBooksByStatus() {
        return new BookDB().findBooksByStatus(option);
    }
    
    public List<Book> getAllBooks() {
        return new BookDB().getAllBooks();
    }
    
    public Book getBookById(int id) {
        return new BookDB().getBookById(id);
    }
    
    public History getHistoryById(int id) {
        return new HistoryDB().getHistoryById(id);
    }
    
    public List<History> getAllHistories() {
        return new HistoryDB().getAllHistories();
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
