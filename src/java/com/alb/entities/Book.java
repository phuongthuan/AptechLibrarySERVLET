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
    
    /**
     * Book fields.
     */
    private Integer id;
    private String name;
    private String description;
    private Integer category_id;
    private Integer author_id;
    private Integer publisher_id;
    

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
     */
    public Book(Integer id, String name, String description, Integer category_id, Integer author_id, Integer publisher_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category_id = category_id;
        this.author_id = author_id;
        this.publisher_id = publisher_id;
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

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", description=" + description + ", category_id=" + category_id + ", author_id=" + author_id + ", publisher_id=" + publisher_id + '}';
    }
}
