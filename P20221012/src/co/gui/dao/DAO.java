package co.gui.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//DB연결 Connection 생성
public class DAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;
	// Connection 반환 getConnect

	public Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
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
