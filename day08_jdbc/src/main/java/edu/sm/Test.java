package edu.sm;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test  {
    public static void main(String[] args) {
        // 1. MySQL JDBC Driver Loading
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        // 2. Connection
        String url = "jdbc:mysql://localhost:3306/sm_db";
        String sqlid = "smuser";
        String sqlpwd = "111111";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, sqlid, sqlpwd);
            System.out.println("Connected to database");
            Thread.sleep(5000);
        }catch (CommunicationsException e){
            System.out.println("Communications error");
            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            try {
                conn = DriverManager.getConnection(url, sqlid, sqlpwd);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Connected to database");
        }
        catch (SQLException e) {
            System.out.println("Connection error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
