package edu.sm.frame;

public class Sql{
    public static String insertCust = "Insert INTO cust VALUES(?,?,?)";
    public static String selectCust = "SELECT * FROM cust";
    public static String deleteCust = "DELETE FROM cust WHERE id = ?";
    public static String selectOneCust = "SELECT * FROM cust WHERE id = ?";
    public static String updateCust = "UPDATE cust SET name = ?, pwd = ? WHERE id = ?  ";

    public static String insertProduct = "INSERT INTO product (name, price, reg_date) VALUES (?, ?, ?)";
    public static String selectProduct = "SELECT * FROM product";
    public static String deleteProduct = "DELETE FROM product WHERE id = ?";
    public static String selectOneProduct = "SELECT * FROM product WHERE id = ?";
    public static String updateProduct = "UPDATE product SET name = ?, price = ? WHERE id = ?";

}
