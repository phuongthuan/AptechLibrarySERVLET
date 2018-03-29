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
public class Category {
    
    /**
     * Category fields.
     */
    private Integer id;
    private String name;

    /**
     * Category constructor.
     * 
     * @param id
     * @param name 
     */
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
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

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + '}';
    }
}
