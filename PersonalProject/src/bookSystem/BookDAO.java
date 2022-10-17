package bookSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends DAO {

	// 회원가입
	public void user(Login user) {
		String sql = "insert into user_table (id, passwd, user_name)"//
				+ "values('" + user.getId()//
				+ "', '" + user.getPasswd()//
				+ "', '" + user.getName() + "')";
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

	// 로그인
	public boolean getId(String id, String passwd) {
		conn = getConnect();
		boolean chk = false;
		List<String> str = new ArrayList<String>();
		String sql = "select * from user_table where id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			while (rs.next()) {
				str.add(rs.getString("id"));
				str.add(rs.getString("passwd"));
				if (str.get(0).equals(id) && str.get(1).equals(passwd)) {
					System.out.println("로그인 성공.");
					chk = true;
				}
			}

		} catch (Exception e) {
			System.out.println("로그인 실패.");
			chk = false;
		} finally {
			disConnect();
		}
		return chk;

	}

	// 도서등록
	public void insert(Book book) {
		String sql = "insert into book_table (bNo, title, genre, author)" //
				+ "values(" + book.getbNo()//
				+ ", '" + book.getTitle()//
				+ "', '" + book.getGenre()//
				+ "', '" + book.getAuthor() + "')";

		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 도서목록
	public List<Book> search() {
		conn = getConnect();
		List<Book> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from book_table");
			while (rs.next()) {
				list.add(new Book(rs.getString("bNo")//
						, rs.getString("title")//
						, rs.getString("genre")//
						, rs.getString("author")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 한건만 조회
	public Book getList(String bNo) {
		conn = getConnect();
		Book list = null;
		String sql = "select * from book_table where bNo = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bNo);

			rs = psmt.executeQuery();
			if (rs.next()) {
				list = new Book(rs.getString("bNo")//
						, rs.getString("title")//
						, rs.getString("genre")//
						, rs.getString("author"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public void update(Book book) {
		String sql = "update book_table "//
				+ "set title = ?, "//
				+ "    genre = ?, "//
				+ "    author = ? "//
				+ "where bNo = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getGenre());
			psmt.setString(3, book.getAuthor());
			psmt.setString(4, book.getbNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	public void delete(String bNo) {
		String sql = "delete from book_table Where bNo=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bNo);
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}
}
