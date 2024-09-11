package edu.sm;

import java.sql.*;

public class Main4 {
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
        String selectOnSql = "SELECT * FROM cust WHERE id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement(selectOnSql);
            ps.setString(1,"id01");
            rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("pwd"));
            System.out.println(rs.getString("name"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
