package bookSystem;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends DAO {
	boolean chk = false;
	// 파일만들기

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
			System.out.println("잘못된 입력입니다");
			return;
		} finally {
			disConnect();
		}
	}

	// 환영
	public List<Login> welcome(String id) {
		conn = getConnect();
		List<Login> list = new ArrayList<Login>();
		String sql = "select user_name from user_table where id =?  ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Login(rs.getString("user_name")));
			}
			for (Login l : list) {
				System.out.println(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 로그인
	public boolean getId(String id, String passwd) {
		conn = getConnect();

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
					System.out.println("로그인 성공");
					chk = true;
				}
			}

		} catch (Exception e) {
			System.out.println("로그인 실패");
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
			System.out.println("도서등록 완료");
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
		String sql = "select * from book_table order by cast(bNo as int)";
		List<Book> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			psmt = conn.prepareStatement(sql);
			int r = psmt.executeUpdate();
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getString("bNo")//
						, rs.getString("title")//
						, rs.getString("genre")//
						, rs.getString("author")//
						, rs.getString("company")//
						, rs.getString("inputdate")//
						, rs.getString("price")));
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

	// 대여도서목록
	public List<Borrow> borrowSearch() {
		conn = getConnect();
		List<Borrow> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from borrow_table order by cast(bNo as int)");
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
			rs = stmt.executeQuery("select * from borrow_table order by cast(bNo as int)");
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

	// 한건만 조회(책번호)
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
			} else {
				System.out.println("해당 도서번호는 없습니다");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 한건만 조회(책이름 검색)
	public List<Book> getTitleList(String title) {
		conn = getConnect();
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book_table where title like '%'||?||'%' order by cast(bNo as int)  ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			rs = psmt.executeQuery();
			if (r == 0) {
				System.out.println("해당 도서명은 없습니다");
			} else {
				while (rs.next()) {
					list.add(new Book(rs.getString("bNo")//
							, rs.getString("title")//
							, rs.getString("genre")//
							, rs.getString("author")//
							, rs.getString("company")//
							, rs.getString("inputdate")//
							, rs.getString("price")));
				}
			}
			for (Book l : list) {
				System.out.println(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 한건만 조회(장르 검색)
	public List<Book> getGenreList(String genre) {
		conn = getConnect();
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book_table where genre like '%'||?||'%' order by cast(bNo as int)  ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, genre);
			int r = psmt.executeUpdate();
			rs = psmt.executeQuery();
			if (r == 0) {
				System.out.println("해당 장르는 없습니다");
			} else {
				while (rs.next()) {
					list.add(new Book(rs.getString("bNo")//
							, rs.getString("title")//
							, rs.getString("genre")//
							, rs.getString("author")//
							, rs.getString("company")//
							, rs.getString("inputdate")//
							, rs.getString("price")));
				}
			}
			for (Book l : list) {
				System.out.println(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 한건만 조회(작가 검색)
	public List<Book> getAuthorList(String author) {
		conn = getConnect();
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book_table where author like '%'||?||'%' order by cast(bNo as int)  ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, author);
			int r = psmt.executeUpdate();
			rs = psmt.executeQuery();
			if (r == 0) {
				System.out.println("해당 작가의 도서는 없습니다");
			} else {
				while (rs.next()) {
					list.add(new Book(rs.getString("bNo")//
							, rs.getString("title")//
							, rs.getString("genre")//
							, rs.getString("author")//
							, rs.getString("company")//
							, rs.getString("inputdate")//
							, rs.getString("price")));
				}
			}
			for (Book l : list) {
				System.out.println(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 한건만 조회(출판사 검색)
	public List<Book> getCompanyList(String company) {
		conn = getConnect();
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book_table where company like '%'||?||'%' order by cast(bNo as int)  ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, company);
			int r = psmt.executeUpdate();
			rs = psmt.executeQuery();
			if (r == 0) {
				System.out.println("해당 출판사의 도서는 없습니다");
			} else {
				while (rs.next()) {
					list.add(new Book(rs.getString("bNo")//
							, rs.getString("title")//
							, rs.getString("genre")//
							, rs.getString("author")//
							, rs.getString("company")//
							, rs.getString("inputdate")//
							, rs.getString("price")));
				}
			}
			for (Book l : list) {
				System.out.println(l);
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

	// 대여수정
	public void borrowList(Borrow book) {
		String sql = "update borrow_table "//
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
			if (r == 0) {
				System.out.println("대여실패");
			} else {
				System.out.println("대여완료");
			}

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

			if (r == 0) {
				System.out.println("반납실패");
			} else {
				System.out.println("반납완료");
			}
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

			if (r == 1) {
				System.out.println("삭제완료");
			} else {
				System.out.println("삭제할 내역이 없습니다");
			}

		} catch (SQLSyntaxErrorException e) {

		} catch (Exception e) {
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