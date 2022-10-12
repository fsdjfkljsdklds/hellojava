package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.jdbc.Employee;

//C(reate) R(ead) U(pdate) D(elete)
public class BoardDAO extends DAO {
	// 등록
	public void insert(Board brd) {
		String sql = "insert into board (board_number, board_title, board_content, board_writer)"//
				+ "values(" + brd.getNumber()//
				+ ", '" + brd.getTitle()//
				+ "', '" + brd.getContent()//
				+ "', '" + brd.getWriter() + "')";
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 수정
	public void update(Board brd) {
		String sql = "update board "//
				+ "set board_content = ?, "//
				+ "    creation_date = ?" //
				+ "where board_number = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getContent());
			psmt.setString(2, brd.getDate());
			psmt.setInt(3, brd.getNumber());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 삭제
	public void delete(int number) {
		String sql = "delete from board where board_number = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 목록
	public List<Board> search() {
		conn = getConnect();
		List<Board> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board");
			while (rs.next()) {
				list.add(new Board(rs.getInt("board_number")//
						, rs.getString("board_title")//
						, rs.getString("board_content")//
						, rs.getString("board_writer")//
						, rs.getString("creation_date")//
						, rs.getInt("cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 상세조회
	public Board getNum(int number) {
		// 한건만 반환
		conn = getConnect();
		Board brd = null;
		String sql = "select * from board where board_number = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, number);

			rs = psmt.executeQuery();
			if (rs.next()) {
				brd = new Board(rs.getInt("board_number")//
						, rs.getString("board_title")//
						, rs.getString("board_content")//
						, rs.getString("board_writer")//
						, rs.getString("creation_date"), rs.getInt("cnt"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return brd;

	}
}
