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
public class Publisher {
    
    public static final String ID="id";
    public static final String NAME="name";
    public static final String ADDRESS="address";
    public static final String PHONE="phone";
    public static final String EMAIL="email";
    
    /**
     * Publisher fields.
     */
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String email;

    /**
     * Publisher constructor.
     * 
     * @param id
     * @param name
     * @param address
     * @param phone
     * @param email 
     */
    public Publisher(Integer id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Publisher(Integer id) {
        this.id = id;
    }

    public Publisher() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "Publisher{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }
}
