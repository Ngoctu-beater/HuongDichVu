/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBContext {
    // thông tin kết nối SQL server
    private static final String urlDB = "jdbc:sqlserver://LAPTOP-HSS8HFAH;databaseName=CarShop;encrypt=true;trustServerCertificate=true";
    private static final String user = "sa";
    private static final String password = "291004";
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(urlDB, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conn;
    }
    
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(DBContext.getConnection());
    }
}
