package edu.sm.dao;

import edu.sm.dto.Product;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.frame.Sql;
import edu.sm.frame.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Integer, Product> {
    @Override
    public Product insert(Product product, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.insertProduct);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());
            ps.setDate(3, new Date(product.getRegDate().getTime()));
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicatedIdException("EX0001");
        } catch (Exception e) {
            throw new Exception("제품 등록 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return product;
    }

    @Override
    public Product update(Product product, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.updateProduct);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());
            ps.setInt(3, product.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("제품 정보 수정 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return product;
    }

    @Override
    public boolean delete(Integer id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.deleteProduct);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new Exception("제품 삭제 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public Product select(Integer id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product product = null;
        try {
            ps = conn.prepareStatement(Sql.selectOneProduct);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                product = Product.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .price(rs.getInt("price"))
                        .regDate(rs.getDate("reg_date"))
                        .build();
            }
        } catch (Exception e) {
            throw new Exception("제품 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return product;
    }

    @Override
    public List<Product> select(Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(Sql.selectProduct);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .price(rs.getInt("price"))
                        .regDate(rs.getDate("reg_date"))
                        .build();
                list.add(product);
            }
        } catch (Exception e) {
            throw new Exception("전체 제품 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return list;
    }


    public List<Product> searchByName(String keyword, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(Sql.searchProductByName);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .price(rs.getInt("price"))
                        .regDate(rs.getDate("reg_date"))
                        .build();
                list.add(product);
            }
        } catch (Exception e) {
            throw new Exception("상품 검색 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return list;
    }
}