package edu.sm.frame;

public class Sql{
    public static String insertCust = "Insert INTO cust VALUES(?,?,?,sysdate())";
    public static String selectCust = "SELECT * FROM cust";
    public static String deleteCust = "DELETE FROM cust WHERE id = ?";
    public static String selectOneCust = "SELECT * FROM cust WHERE id = ?";
    public static String updateCust = "UPDATE cust SET name = ?, pwd = ? WHERE id = ?  ";

    public static String insertProduct = "INSERT INTO product (name, price, reg_date) VALUES (?, ?, ?)";
    public static String selectProduct = "SELECT * FROM product";
    public static String deleteProduct = "DELETE FROM product WHERE id = ?";
    public static String selectOneProduct = "SELECT * FROM product WHERE id = ?";
    public static String updateProduct = "UPDATE product SET name = ?, price = ? WHERE id = ?";
    public static String searchProductByName = "SELECT * FROM product WHERE name LIKE ?";


    public static String insertCartItem = "INSERT INTO cart (cust_id, product_id, quantity) VALUES (?, ?, ?)";
    public static String updateCartItem = "UPDATE cart_item SET quantity = ? WHERE id = ?";
    public static String deleteCartItem = "DELETE FROM cart WHERE id = ?";
    public static String selectOneCartItem = "SELECT * FROM cart WHERE id = ?";
    public static String selectCartItems = "SELECT * FROM cart";

    public static String insertOrder = "INSERT INTO `order` (cust_id, product_id ,order_date, total_price) VALUES (?, ? ,?, ?)";
    public static String updateOrder = "UPDATE `order` SET status = ?, total_price = ? WHERE id = ?";
    public static String deleteOrder = "DELETE FROM `order` WHERE id = ?";
    public static String selectOneOrder = "SELECT * FROM `order` WHERE id = ?";
    public static String selectOrders = "SELECT * FROM `order`";
    public static String selectOrdersByCustId =
            "SELECT id, cust_id, product_id, total_price, order_date " +
                    "FROM `order` WHERE cust_id = ? ORDER BY order_date DESC";

}
