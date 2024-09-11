package edu.sm;
import java.sql.*;

public class Main2 {
    private static final String URL = "jdbc:mysql://localhost:3306/sm_db";
    private static final String USER = "smuser";
    private static final String PASSWORD = "111111";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            deleteCustomer(conn, "id04");  // 삭제할 고객의 ID를 지정
        } catch (SQLException e) {
            System.out.println("데이터베이스 작업 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteCustomer(Connection conn, String id) throws SQLException {
        String deleteSql = "DELETE FROM cust WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
            ps.setString(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println(affectedRows + " 행이 삭제되었습니다. 삭제된 ID: " + id);
            } else {
                System.out.println("삭제할 고객을 찾을 수 없습니다. ID: " + id);
            }
        }
    }
}