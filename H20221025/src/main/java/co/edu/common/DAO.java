package co.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public PreparedStatement psmt;
	// Connection 반환 getConnect

	public Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kjh", "kjh");
			System.out.println("연결성공");

		} catch (Exception e) {
			System.out.println("연결실패");
		}
		return conn;

	}

	// Resource 해제 disConnect
	public void disConnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			if (psmt != null)
				psmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
