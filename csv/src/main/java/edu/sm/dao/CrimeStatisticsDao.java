package edu.sm.dao;

import edu.sm.dto.CrimeStatistics;
import edu.sm.frame.Sql;
import edu.sm.frame.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CrimeStatisticsDao implements Dao<Integer, CrimeStatistics> {
    @Override
    public CrimeStatistics insert(CrimeStatistics crimeStatistics, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.insert);
            ps.setString(1, crimeStatistics.getMajorCategory());
            ps.setString(2, crimeStatistics.getMinorCategory());
            ps.setInt(3, crimeStatistics.getTime00To03());
            ps.setInt(4, crimeStatistics.getTime03To06());
            ps.setInt(5, crimeStatistics.getTime06To09());
            ps.setInt(6, crimeStatistics.getTime09To12());
            ps.setInt(7, crimeStatistics.getTime12To15());
            ps.setInt(8, crimeStatistics.getTime15To18());
            ps.setInt(9, crimeStatistics.getTime18To21());
            ps.setInt(10, crimeStatistics.getTime21To24());
            ps.setInt(11, crimeStatistics.getTimeUnknown());
            ps.setInt(12, crimeStatistics.getSunday());
            ps.setInt(13, crimeStatistics.getMonday());
            ps.setInt(14, crimeStatistics.getTuesday());
            ps.setInt(15, crimeStatistics.getWednesday());
            ps.setInt(16, crimeStatistics.getThursday());
            ps.setInt(17, crimeStatistics.getFriday());
            ps.setInt(18, crimeStatistics.getSaturday());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("범죄 통계 등록 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(ps != null) {
                ps.close();
            }
        }
        return crimeStatistics;
    }

    @Override
    public CrimeStatistics update(CrimeStatistics crimeStatistics, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.update);
            ps.setString(1, crimeStatistics.getMajorCategory());
            ps.setString(2, crimeStatistics.getMinorCategory());
            ps.setInt(3, crimeStatistics.getTime00To03());
            ps.setInt(4, crimeStatistics.getTime03To06());
            ps.setInt(5, crimeStatistics.getTime06To09());
            ps.setInt(6, crimeStatistics.getTime09To12());
            ps.setInt(7, crimeStatistics.getTime12To15());
            ps.setInt(8, crimeStatistics.getTime15To18());
            ps.setInt(9, crimeStatistics.getTime18To21());
            ps.setInt(10, crimeStatistics.getTime21To24());
            ps.setInt(11, crimeStatistics.getTimeUnknown());
            ps.setInt(12, crimeStatistics.getSunday());
            ps.setInt(13, crimeStatistics.getMonday());
            ps.setInt(14, crimeStatistics.getTuesday());
            ps.setInt(15, crimeStatistics.getWednesday());
            ps.setInt(16, crimeStatistics.getThursday());
            ps.setInt(17, crimeStatistics.getFriday());
            ps.setInt(18, crimeStatistics.getSaturday());
            ps.setInt(19, crimeStatistics.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("범죄 통계 수정 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(ps != null) {
                ps.close();
            }
        }
        return crimeStatistics;
    }

    @Override
    public boolean delete(Integer id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.delete);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new Exception("범죄 통계 삭제 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public CrimeStatistics select(Integer id, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        CrimeStatistics crimeStatistics = null;
        try {
            ps = conn.prepareStatement(Sql.select + " WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                crimeStatistics = extractCrimeStatisticsFromResultSet(rs);
            }
        } catch (Exception e) {
            throw new Exception("범죄 통계 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
        return crimeStatistics;
    }

    @Override
    public List<CrimeStatistics> select(Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CrimeStatistics> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(Sql.select);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(extractCrimeStatisticsFromResultSet(rs));
            }
        } catch (Exception e) {
            throw new Exception("전체 범죄 통계 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
        return list;
    }

    public Map<String, Map<String, Integer>> selectByDay(Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Map<String, Integer>> result = new HashMap<>();
        try {
            ps = conn.prepareStatement(Sql.selectByDay);
            rs = ps.executeQuery();
            while(rs.next()) {
                String majorCategory = rs.getString("major_category");
                Map<String, Integer> dayStats = new HashMap<>();
                dayStats.put("sunday", rs.getInt("total_sunday"));
                dayStats.put("monday", rs.getInt("total_monday"));
                dayStats.put("tuesday", rs.getInt("total_tuesday"));
                dayStats.put("wednesday", rs.getInt("total_wednesday"));
                dayStats.put("thursday", rs.getInt("total_thursday"));
                dayStats.put("friday", rs.getInt("total_friday"));
                dayStats.put("saturday", rs.getInt("total_saturday"));
                result.put(majorCategory, dayStats);
            }
        } catch (Exception e) {
            throw new Exception("요일별 범죄 통계 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
        return result;
    }

    public Map<String, Map<String, Integer>> selectByTime(Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Map<String, Integer>> result = new HashMap<>();
        try {
            ps = conn.prepareStatement(Sql.selectByTime);
            rs = ps.executeQuery();
            while(rs.next()) {
                String majorCategory = rs.getString("major_category");
                Map<String, Integer> timeStats = new HashMap<>();
                timeStats.put("00_to_03", rs.getInt("total_00_to_03"));
                timeStats.put("03_to_06", rs.getInt("total_03_to_06"));
                timeStats.put("06_to_09", rs.getInt("total_06_to_09"));
                timeStats.put("09_to_12", rs.getInt("total_09_to_12"));
                timeStats.put("12_to_15", rs.getInt("total_12_to_15"));
                timeStats.put("15_to_18", rs.getInt("total_15_to_18"));
                timeStats.put("18_to_21", rs.getInt("total_18_to_21"));
                timeStats.put("21_to_24", rs.getInt("total_21_to_24"));
                result.put(majorCategory, timeStats);
            }
        } catch (Exception e) {
            throw new Exception("시간대별 범죄 통계 조회 중 오류 발생: " + e.getMessage(), e);
        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
        return result;
    }

    private CrimeStatistics extractCrimeStatisticsFromResultSet(ResultSet rs) throws Exception {
        return new CrimeStatistics(
                rs.getInt("id"),
                rs.getString("major_category"),
                rs.getString("minor_category"),
                rs.getInt("time_00_to_03"),
                rs.getInt("time_03_to_06"),
                rs.getInt("time_06_to_09"),
                rs.getInt("time_09_to_12"),
                rs.getInt("time_12_to_15"),
                rs.getInt("time_15_to_18"),
                rs.getInt("time_18_to_21"),
                rs.getInt("time_21_to_24"),
                rs.getInt("time_unknown"),
                rs.getInt("sunday"),
                rs.getInt("monday"),
                rs.getInt("tuesday"),
                rs.getInt("wednesday"),
                rs.getInt("thursday"),
                rs.getInt("friday"),
                rs.getInt("saturday")
        );
    }
}