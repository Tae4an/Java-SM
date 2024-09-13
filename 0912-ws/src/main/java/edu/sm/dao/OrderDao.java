package edu.sm.dao;

import edu.sm.dto.Order;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements Dao<Integer, Order> {
    @Override
    public Order insert(Order order, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.insertOrder, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getCustId());
            ps.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
            ps.setDouble(3, order.getTotalPrice());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                order.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            throw new Exception("주문 생성 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) ps.close();
        }
        return order;
    }

    @Override
    public Order update(Order order, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.updateOrder);
            ps.setDouble(1, order.getTotalPrice());
            ps.setInt(2, order.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("주문 수정 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) ps.close();
        }
        return order;
    }

    @Override
    public boolean delete(Integer id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.deleteOrder);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new Exception("주문 삭제 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public Order select(Integer id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order = null;
        try {
            ps = conn.prepareStatement(Sql.selectOneOrder);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                order = Order.builder()
                        .id(rs.getInt("id"))
                        .custId(rs.getString("cust_id"))
                        .orderDate(rs.getDate("order_date"))
                        .totalPrice(rs.getInt("total_price"))
                        .build();
            }
        } catch (Exception e) {
            throw new Exception("주문 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return order;
    }

    @Override
    public List<Order> select(Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Order> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(Sql.selectOrders);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = Order.builder()
                        .id(rs.getInt("id"))
                        .custId(rs.getString("cust_id"))
                        .orderDate(rs.getDate("order_date"))
                        .totalPrice(rs.getInt("total_price"))
                        .build();
                list.add(order);
            }
        } catch (Exception e) {
            throw new Exception("주문 전체 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return list;
    }
}