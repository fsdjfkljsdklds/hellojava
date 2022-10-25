package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {

	// 생성
	public void memberInsert(MemberVO vo) {
		String sql = "insert into members (id,passwd,name,email,responsibility)" //
				+ "values(?,?,?,?,'user')";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			psmt.executeUpdate();
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
						, rs.getString("email"));//
			} else {
				System.out.println("해당 멤버는 없습니다");
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
		conn = getConnect();
		String name = null;
		String sql = "update members set id =?,"//
				+ "passwd =?, name =?, email=?"//
				+ "where id ='" + vo.getId() + "'";

		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			int rs= psmt.executeUpdate();

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

	// 로그인(String id, String passwd) =>MemberVO
	public MemberVO login(String id, String passwd) {
		getConnect();
		String sql = "select * from members where id=? and passwd=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);

			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResponsibility(rs.getString("responsibility"));
				return vo;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

}
