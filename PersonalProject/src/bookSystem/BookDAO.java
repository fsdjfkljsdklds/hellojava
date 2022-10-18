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
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			return;
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
		String sql = "insert into book_table (bNo, title, genre, author, company, price)" //
				+ "values(" + book.getbNo()//
				+ ", '" + book.getTitle()//
				+ "', '" + book.getGenre()//
				+ "', '" + book.getAuthor()//
				+ "', '" + book.getCompany()//
				+ "', '" + book.getPrice() + "')";

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

	// 대여목록 등록
	public void insertBorrow(Borrow book) {
		String sql = "insert into borrow_table (bNo, title, genre, author, company, price)" //
				+ "values(" + book.getbNo()//
				+ ", '" + book.getTitle()//
				+ "', '" + book.getGenre()//
				+ "', '" + book.getAuthor()//
				+ "', '" + book.getCompany()//
				+ "', '" + book.getPrice() + "')";

		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
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
						, rs.getString("author")//
						, rs.getString("company")//
						, rs.getString("inputdate")//
						, rs.getString("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 대여도서목록
	public List<Borrow> borrowSearch() {
		conn = getConnect();
		List<Borrow> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from borrow_table");
			while (rs.next()) {
				list.add(new Borrow(rs.getString("bNo")//
						, rs.getString("title")//
						, rs.getString("genre")//
						, rs.getString("author")//
						, rs.getString("company")//
						, rs.getString("inputdate")//
						, rs.getString("price")//
						, rs.getString("available")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 대여중인 목록
	public List<Return> returnSearch() {
		conn = getConnect();
		List<Return> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from borrow_table");
			while (rs.next()) {
				list.add(new Return(rs.getString("bNo")//
						, rs.getString("title")//
						, rs.getString("available")));
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
						, rs.getString("author")//
						, rs.getString("company")//
						, rs.getString("inputdate")//
						, rs.getString("price"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 수정
	public void update(Book book) {
		String sql = "update book_table "//
				+ "set title = ?, "//
				+ "    genre = ?, "//
				+ "    author = ?, "//
				+ "    company = ?, "//
				+ "    inputdate = Sysdate, "//
				+ "    price = ? "//
				+ "where bNo = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getGenre());
			psmt.setString(3, book.getAuthor());
			psmt.setString(4, book.getCompany());
			psmt.setString(5, book.getPrice());
			psmt.setString(6, book.getbNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 대여
	public void borrowUpdate(Borrow book) {
		String sql = "update borrow_table "//
				+ "set available = '불가능' "//
				+ "where bNo = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getbNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 반납
	public void returnUpdate(Borrow book) {
		String sql = "update borrow_table "//
				+ "set available = '가능' "//
				+ "where bNo = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getbNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	// 삭제
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

	// 대여목록 삭제
	public void borrowDelete(String bNo) {
		String sql = "delete from borrow_table Where bNo=?";
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
