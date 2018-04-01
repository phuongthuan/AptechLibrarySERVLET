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
public class Book {
    
    public static final String ID="id";
    public static final String NAME="name";
    public static final String DESCRIPTION="description";
    public static final String CATEGORY_ID="category_id";
    public static final String AUTHOR_ID="author_id";
    public static final String PUBLISHER_ID="publisher_id";
    public static final String STATUS_ID="status_id";
    
    /**
     * Book fields.
     */
    private Integer id;
    private String name;
    private String description;
    private Integer category_id;
    private Integer author_id;
    private Integer publisher_id;
    private Integer status_id;
    
    private Category category;
    private Author author;
    private Publisher publisher;
    private Status status;
    
    
    public Book() {
    }

        /**
     * Book constructor.
     * 
     * @param id
     * @param name
     * @param description
     * @param category_id
     * @param author_id
     * @param publisher_id 
     * @param status_id
     */
    
    public Book(Integer id, String name, String description, Category category, Author author, Publisher publisher, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.status = status;
    }

    public Book(String name, String description, Integer category_id, Integer author_id, Integer publisher_id, Integer status_id) {
        this.name = name;
        this.description = description;
        this.category_id = category_id;
        this.author_id = author_id;
        this.publisher_id = publisher_id;
        this.status_id = status_id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Integer publisher_id) {
        this.publisher_id = publisher_id;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", description=" + description + ", category=" + category + ", author=" + author + ", publisher=" + publisher + ", status=" + status + '}';
    }
}
