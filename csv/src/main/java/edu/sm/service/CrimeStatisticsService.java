package edu.sm.service;

import edu.sm.dao.CrimeStatisticsDao;
import edu.sm.dto.CrimeStatistics;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CrimeStatisticsService implements MService<Integer, CrimeStatistics> {

    CrimeStatisticsDao dao;
    ConnectionPool cp;

    public CrimeStatisticsService() {
        dao = new CrimeStatisticsDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CrimeStatistics add(CrimeStatistics crimeStatistics) throws Exception {
        Connection con = cp.getConnection();
        try {
            con.setAutoCommit(false);
            dao.insert(crimeStatistics, con);
            System.out.println("Add:"+ crimeStatistics.getMinorCategory());
            con.commit();
        } catch(Exception e) {
            con.rollback();
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return crimeStatistics;
    }

    @Override
    public CrimeStatistics modify(CrimeStatistics crimeStatistics) throws Exception {
        Connection con = cp.getConnection();
        try {
            dao.update(crimeStatistics, con);
            System.out.println("Update:" +  crimeStatistics.getMinorCategory());
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return crimeStatistics;
    }

    @Override
    public Boolean remove(Integer id) throws Exception {
        Connection con = cp.getConnection();
        Boolean result = false;
        try {
            result = dao.delete(id, con);
            System.out.println("Delete:" + id);
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    @Override
    public CrimeStatistics get(Integer id) throws Exception {
        Connection con = cp.getConnection();
        CrimeStatistics result = null;
        try {
            result = dao.select(id, con);
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    @Override
    public List<CrimeStatistics> get() throws Exception {
        Connection con = cp.getConnection();
        List<CrimeStatistics> result = null;
        try {
            result = dao.select(con);
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }
}