/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wardatumilah
 */
public class databaseconfig {

    private static final String URL = "jdbc:mysql://localhost:3306/uangkas";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection openconnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            } else {
                try {
                    Class.forName(DRIVER);
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                } catch (ClassNotFoundException | SQLException e) {
                    System.out.println("Database.getConnection() eror -->" + e.getMessage());
                }
            }
        } catch (SQLException ex) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Database,getconection()eror -->" + e.getMessage());
            }
        }
        return connection;
    }
}
