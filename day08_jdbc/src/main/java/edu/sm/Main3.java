package edu.sm;
import java.sql.*;

public class Main3 {
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
            updateCustomer(conn, "id03", "새비밀번호", "김철수(수정됨)");  // 수정할 고객의 정보를 지정
        } catch (SQLException e) {
            System.out.println("데이터베이스 작업 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void updateCustomer(Connection conn, String id, String newPwd, String newName) throws SQLException {
        String sql = "UPDATE cust SET pwd = ?, name = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPwd);
            pstmt.setString(2, newName);
            pstmt.setString(3, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println(affectedRows + " 행이 수정되었습니다. 수정된 ID: " + id);
            } else {
                System.out.println("수정할 고객을 찾을 수 없습니다. ID: " + id);
            }
        }
    }
}