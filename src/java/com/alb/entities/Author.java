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
public class Author {
    
    public static final String ID="id";
    public static final String NAME="name";
    public static final String DESCRIPTION="description";
    public static final String PHONE="phone";
    public static final String EMAIL="email";
    
    /**
     * Author fields.
     */
    private Integer id;
    private String name;
    private String description;
    private String phone;
    private String email;

    /**
     * Author constructor.
     * 
     * @param id
     * @param name
     * @param description
     * @param phone
     * @param email 
     */
    public Author(Integer id, String name, String description, String phone, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.email = email;
    }

    public Author(Integer id) {
        this.id = id;
    }

    public Author(String name, String description, String phone, String email) {
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.email = email;
    }
    
    public Author() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + ", description=" + description + ", phone=" + phone + ", email=" + email + '}';
    }

}
