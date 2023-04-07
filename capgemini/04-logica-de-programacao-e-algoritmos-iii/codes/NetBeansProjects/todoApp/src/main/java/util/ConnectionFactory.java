/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luciano
 */
public class ConnectionFactory {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = 
            "jdbc:sqlite:/home/luciano/workspace/lucianodacunha/cursos-java/capgemini/logica-de-programacao-e-algoritmos-iii/codes/NetBeansProjects/todoApp/db/todoapp.db";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection success");
            return conn;
        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
        }

        return conn;
    }

    public static void closeConnection(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Close connection failed");
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement st) {

        try {
            if (conn != null) {
                conn.close();
            }
            
            if (st != null){
                st.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Close connection failed");
        }
    }   
    
    public static void closeConnection(Connection conn, PreparedStatement st, ResultSet rs) {

        try {
            if (conn != null) {
                conn.close();
            }
            
            if (st != null){
                st.close();
            }
            
            if (rs != null){
                rs.close();
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Close connection failed");
        }
    }        

}
