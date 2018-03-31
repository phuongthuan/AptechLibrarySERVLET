/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import com.alb.entities.*;
import java.util.*;

/**
 *
 * @author PHUONGTHUAN
 */
public class BookDBTest {
    
    public static void main(String[] args) {
        
        BookDB db = new BookDB();
//        Book b = new Book("Bua toi mot minh", "Chau Khai Phong", 1, 2, 3, 1);
        
//        Category c = new Category("laptop");
//        Author a = new Author("thuan", "mydesc", "091824827", "thuan@gmail.com");
//        Publisher p = new Publisher("Monster", "VietNam", "9273593874", "monstern@host.com");
//        Status s = new Status("borrowed");
//        
//        b.setName("Change the world start off by making your bed");
//        b.setDescription("A story about life");
//        b.setCategory(new Category(1));
//        b.setAuthor(new Author(1));
//        b.setPublisher(new Publisher(1));
//        b.setStatus(new Status(3));
        
//            db.updateBook("new update", "", 1, 1, 1, 1, 2);
            System.out.println(db.getBooksByName("update"));
            
            
//        db.addNewBook(b);

//        for (Book book : getBooksByName("velit")) {
//            System.out.println(book.toString());
//        }
        
//        for (Book book : getAllBooks()) {
//            System.out.println(book.toString());
//        }
    }
    
}
