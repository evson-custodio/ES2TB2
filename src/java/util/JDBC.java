/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import config.MySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evson
 */
public class JDBC {
    protected static Connection connection = null;

    public JDBC() {
    }
    
    static {
        try {
            Class.forName(MySQL.CLASS);
            connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
