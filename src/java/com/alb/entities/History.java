/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.entities;

/**
 *
 * @author PHUONGTHUAN
 */
public class History {
    
    public static final String ID="id";
    public static final String BOOK_ID="book_id";
    public static final String STUDENT_NAME="student_name";
    public static final String CREATED_AT="created_at";
    public static final String UPDATED_AT="updated_at";
    
    /**
     * History fields.
     */
    private Integer id;
    private Integer book_id;
    
    private Book book;
    private String student_name;
    
    
    private String created_at;
    private String updated_at;

    public History(Integer id, Book book, String student_name, String created_at, String updated_at) {
        this.id = id;
        this.book = book;
        this.student_name = student_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public History(Integer book_id, String student_name) {
        this.book_id = book_id;
        this.student_name = student_name;
    }

    public History() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", book_id=" + book_id + ", book=" + book + ", student_name=" + student_name + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

}
