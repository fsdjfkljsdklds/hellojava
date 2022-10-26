package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.BoardVO;
import co.edu.common.DAO;

public class BoardDAO extends DAO {
	// 입력,조회,수정,삭제.목록

	public BoardVO insertBoard(BoardVO vo) {
		// 입력처리중에 에러가 발생하면 null;
		getConnect();
		String sql = "select board_seq.nextval from dual";
		String sql2 = "insert into tbl_board (board_no, title, content,writer)"//
				+ "values(?,'?','?','?')";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			if (rs.next()) {
				nextSeq = rs.getInt(1);
			}
			// insert
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			int r = psmt.executeUpdate();
			if (r > 0) {
				vo.setBoardNo(nextSeq);
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null; // 실패할 경우에는 null
	}

	public BoardVO searchBoard(int boardNo) {

	}

	public List<BoardVO> boardList(BoardVO vo) {

		List<BoardVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from tbl_board"//
				+ "where 1=1" //
				+ "and title like '%'||?||'%'"//
				+ "and content like '%'||?||'%'"//
				+ "and writer like '%'||?||'%' ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());

			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public boolean updateBoard(BoardVO vo) {
		// 처리건수가 0이면 false;

	}

	public boolean deleteBoard(int boardNo) {
		// 처리건수가 0이면 false;
		getConnect();
		String sql = "delete from tbl_board where board_no = ?"; // Id 기준으로 삭제
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.get);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨."); // 쿼리실행
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}
}
