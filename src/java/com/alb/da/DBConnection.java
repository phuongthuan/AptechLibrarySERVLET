/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alb.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PHUONGTHUAN
 */
public class DBConnection {
    
    private static Connection connection;
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String urlDriver = "jdbc:mysql://";
    private static String hostName = "localhost";
    private static String port = "3306";
    private static String databaseName = "library";
    private static String username = "root";
    private static String password = "";
    
    
    public static synchronized Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(driver);
            connection = DriverManager.getConnection(urlDriver + hostName + ":" + port + "/" + databaseName, username, password);
        }
        return connection;
    }
}
