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
public class Status {
    
    public static final String ID="id";
    public static final String NAME="name";
    
    /**
     * Status fields.
     */
    private Integer id;
    private String name;

    public Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Status(String name) {
        this.name = name;
    }
    
    public Status() {
    }

    public Status(Integer id) {
        this.id = id;
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
        return "Status{" + "id=" + id + ", name=" + name + '}';
    }
}
