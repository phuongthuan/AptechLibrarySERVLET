/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

/**
 *
 * @author PHUONGTHUAN
 */
public class UserDBTest {
    
    public static void main(String[] args) {
        UserDB user = new UserDB();
        System.out.println(user.checkUser("admin", "admin"));
    }
    
    
    
}
