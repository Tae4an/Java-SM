package edu.sm.dao;

import edu.sm.dto.Cart;
import edu.sm.exception.NotFoundException;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDao implements Dao<Integer, Cart> {
    @Override
    public Cart insert(Cart cart, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.insertCartItem, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cart.getCustId());
            ps.setInt(2, cart.getProductId());
            ps.setInt(3, cart.getQuantity());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cart.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            throw new Exception("장바구니 아이템 추가 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) ps.close();
        }
        return cart;
    }

    @Override
    public Cart update(Cart cart, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.updateCartItem);
            ps.setInt(1, cart.getQuantity());
            ps.setInt(2, cart.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("장바구니 아이템 수정 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) ps.close();
        }
        return cart;
    }

    @Override
    public boolean delete(Integer id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.deleteCartItem);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new Exception("장바구니 아이템 삭제 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public Cart select(Integer id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cart cart = null;
        try {
            ps = conn.prepareStatement(Sql.selectOneCartItem);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cart = Cart.builder()
                        .id(rs.getInt("id"))
                        .custId(rs.getString("cust_id"))
                        .productId(rs.getInt("product_id"))
                        .quantity(rs.getInt("quantity"))
                        .build();
            }
        } catch (Exception e) {
            throw new Exception("장바구니 아이템 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return cart;
    }

    @Override
    public List<Cart> select(Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cart> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(Sql.selectCartItems);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cart item = Cart.builder()
                        .id(rs.getInt("id"))
                        .custId(rs.getString("cust_id"))
                        .productId(rs.getInt("product_id"))
                        .quantity(rs.getInt("quantity"))
                        .build();
                list.add(item);
            }
        } catch (Exception e) {
            throw new NotFoundException("장바구니 아이템 전체 조회 중 오류 발생: " + e.getMessage() + e);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return list;
    }
}