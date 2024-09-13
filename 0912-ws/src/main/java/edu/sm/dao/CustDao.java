package edu.sm.dao;

import edu.sm.dto.Cust;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.frame.Sql;
import edu.sm.frame.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class CustDao implements Dao<String, Cust> {
    @Override
    public Cust insert(Cust cust, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.insertCust);
            ps.setString(1, cust.getId());
            ps.setString(2, cust.getPwd());
            ps.setString(3, cust.getName());
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            throw new DuplicatedIdException("EX0001");
        } catch (Exception e) {
            throw new Exception("고객 등록 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(ps != null) {
                ps.close();
            }
        }
        return cust;
    }

    @Override
    public Cust update(Cust cust, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.updateCust);
            ps.setString(1, cust.getId());
            ps.setString(2, cust.getPwd());
            ps.setString(3, cust.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("고객 정보 수정 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(ps != null) {
                ps.close();
            }
        }
        return cust;
    }

    @Override
    public boolean delete(String id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.deleteCust);
            ps.setString(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        }
        catch (Exception e) {
            throw new Exception("고객 삭제 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public Cust select(String id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cust cust = null;
        try {
            ps = conn.prepareStatement(Sql.selectOneCust);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                cust = new Cust(
                        rs.getString("id"),
                        rs.getString("pwd"),
                        rs.getString("name")
                );
            }
        } catch (Exception e) {
            throw new Exception("고객 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
        return cust;
    }

    @Override
    public List<Cust> select(Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cust> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(Sql.selectCust);
            rs = ps.executeQuery();
            while(rs.next()) {
                Cust cust = new Cust(
                        rs.getString("id"),
                        rs.getString("pwd"),
                        rs.getString("name")
                );
                list.add(cust);
            }
        } catch (Exception e) {
            throw new Exception("전체 고객 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
        return list;
    }
}