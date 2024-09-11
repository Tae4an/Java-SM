package edu.sm;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItemCRUD {

    // 1. MySQL JDBC Driver Loading
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }
    // 2. Connection
    private String url = "jdbc:mysql://localhost:3306/sm_db";
    private String sqlid = "smuser";
    private String sqlpwd = "111111";

    private static Connection conn = null;
    private static PreparedStatement ps = null;

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, sqlid, sqlpwd);
    }

    // Insert
    public void insertItem(Item item) {
        String insertSql = "INSERT INTO items (name, price, imgName, registrant) VALUES (?, ?, ?, ?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(insertSql);
            ps.setString(1, item.getName());
            ps.setInt(2, item.getPrice());
            ps.setString(3, item.getImgName());
            ps.setString(4, item.getRegistrant());
            int result = ps.executeUpdate();
            System.out.println(result + " 개의 아이템이 삽입되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Read
    public Item getItem(int id) {
        String readSql = "SELECT * FROM items WHERE id = ?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(readSql);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractItemFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items.add(extractItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Update
    public void updateItem(Item item) {
        String sql = "UPDATE items SET name = ?, price = ?, imgName = ?, updateDate = ?, registrant = ? WHERE id = ?";
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setInt(2, item.getPrice());
            ps.setString(3, item.getImgName());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setString(5, item.getRegistrant());
            ps.setInt(6, item.getId());
            int result = ps.executeUpdate();
            System.out.println(result + " item updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            System.out.println(result + " item deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Item extractItemFromResultSet(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setPrice(rs.getInt("price"));
        item.setImgName(rs.getString("imgName"));
        item.setRegistrationDate(rs.getDate("registrationDate").toLocalDate());
        Date updateDate = rs.getDate("updateDate");
        if (updateDate != null) {
            item.setUpdateDate(updateDate.toLocalDate());
        }
        item.setRegistrant(rs.getString("registrant"));
        return item;
    }
}