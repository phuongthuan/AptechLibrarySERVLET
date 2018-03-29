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
    
    public List<Book> getBooks() {
        return new BookDB().getAllBooks();
    }
    
    public List<Book> getBooksByName() {
        return new BookDB().getBooksByName(keyword);
    }
}
