package edu.sm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
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
        } catch (SQLException e) {
            System.out.println("Connection error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        // 3. SQL
        String insertSql = "INSERT INTO cust VALUES(?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(insertSql);
            ps.setString(1, "id01");
            ps.setString(2, "pwd03");
            ps.setString(3, "최태산");
            int result = ps.executeUpdate();
            System.out.println(result);
            System.out.println("Inserted rows into database");
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 4. Close
    }
}