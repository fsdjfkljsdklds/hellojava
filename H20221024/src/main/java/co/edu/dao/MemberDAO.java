package co.edu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {

	// 생성
	public void memberInsert(MemberVO vo) {
		String sql = "insert into members (id,passwd,name,email)" //
				+ "values( '" + vo.getId()//
				+ "', '" + vo.getPasswd()//
				+ "', '" + vo.getName()//
				+ "', '" + vo.getEmail() + "')";

		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "멤버 등록완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 한건조회
	public MemberVO memberSearch(String id) {
		conn = getConnect();
		MemberVO list = null;
		String sql = "select * from members where id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				list = new MemberVO(rs.getString("id")//
						, rs.getString("passwd")//
						, rs.getString("name")//
						, rs.getString("email"));
			} else {
				System.out.println("해당 아이디는 없습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 수정
	public void memberUpdate(MemberVO vo) {
		getConnect();
		String sql = "update members "//
				+ "set passwd = ?, "//
				+ "    name = ?, "//
				+ "    email = ? "//
				+ "where id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 삭제
	public void memberDelete(String id) {
		getConnect();
		String sql = "delete from members where id = ?"; // Id 기준으로 삭제
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨."); // 쿼리실행
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 전체조회
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		getConnect();
		String sql = "select * from members order by id";

		try {
			psmt = conn.prepareStatement(sql);
			int r = psmt.executeUpdate();
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVO(rs.getString("id")//
						, rs.getString("passwd")//
						, rs.getString("name")//
						, rs.getString("email")));
			}
			if (r == 0) {
				System.out.println("목록이 없습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

}
