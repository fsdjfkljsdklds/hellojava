package bookSystem;

import java.util.List;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {

		BookDAO dao = new BookDAO();
		Scanner scn = new Scanner(System.in);
		boolean chk = false;
		
		try {
			while (!chk) {
				System.out.println("==================================");
				System.out.println("도서관리 프로그램에 오신것을 환영합니다.");
				System.out.println("1.로그인 2.회원가입");
				System.out.println("선택>>> ");
				int menu = Integer.parseInt(scn.nextLine());

				if (menu == 1) {
					System.out.println(">>>>>로그인 페이지입니다<<<<<");
					System.out.println("Id>>");
					String id = scn.nextLine();
					System.out.println("Passwd>>");
					String passwd = scn.nextLine();
					chk = dao.getId(id, passwd);
					if (chk == true) {
						dao.welcome(id);
					}
					if (chk == false) {
						System.out.println("로그인 실패");
						chk = false;
					}

				} else if (menu == 2) {
					System.out.println(">>>>>회원가입 페이지입니다<<<<<");
					System.out.println("id생성>> ");
					String id = scn.nextLine();
					System.out.println("pwd생성>> ");
					String pwd = scn.nextLine();
					System.out.println("사용자이름입력>> ");
					String name = scn.nextLine();
					dao.user(new Login(id, pwd, name));
					if (chk = false) {
						chk = false;
					}
				} else {
					System.out.println("잘못된 입력입니다");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다");
		}

		while (chk) {
			System.out.println(">>>>>메뉴 선택<<<<<");
			System.out.println("메뉴=> 1.도서관리메뉴 2.대여메뉴 9.종료");
			System.out.println("선택>> ");
			int subMenu = Integer.parseInt(scn.nextLine());

			if (subMenu == 1) {
				System.out.println(">>>>도서관리메뉴입니다<<<<");
				System.out.println("==================================");
				System.out.println("메뉴=> 1.도서등록 2.전체조회 3.상세조회 4.정보수정 5.도서삭제 9.종료");
				System.out.println("선택>> ");
				int subMenu1 = Integer.parseInt(scn.nextLine());

				try {
					if (subMenu1 == 1) {
						System.out.println("도서번호 입력>> ");
						String bNo = scn.nextLine();
						System.out.println("도서명 입력>> ");
						String title = scn.nextLine();
						System.out.println("장르 입력>> ");
						String genre = scn.nextLine();
						System.out.println("작가명 입력>> ");
						String author = scn.nextLine();
						System.out.println("출판사 입력>> ");
						String company = scn.nextLine();
						System.out.println("가격 입력(숫자)>> ");
						String price = scn.nextLine();
						dao.insert(new Book(bNo, title, genre, author, company, price));
						dao.insertBorrow(new Borrow(bNo, title, genre, author, company, price));
					} else if (subMenu1 == 2) {
						List<Book> list = dao.search();
						for (Book emp : list) {
							System.out.println(emp);
						}
					} else if (subMenu1 == 3) {
						System.out.println("메뉴=> 1.도서번호 검색 2.도서명 검색 9.종료");
						int subMenu4 = Integer.parseInt(scn.nextLine());
						if (subMenu4 == 1) {
							System.out.println("도서번호 입력>> ");
							String bNo = scn.nextLine();
							if (dao.getList(bNo) != null) {
								System.out.println(dao.getList(bNo));
							}
						} else if (subMenu4 == 2) {
							System.out.println("도서명 입력>> ");
							String title = scn.nextLine();

							dao.getTitleList(title);

						} else if (subMenu4 == 9) {
							System.out.println("종료합니다");
							break;
						} else {
							System.out.println("잘못된 입력입니다.");
						}

					} else if (subMenu1 == 4) {
						System.out.println("수정할 도서번호 입력>> ");
						String bNo = scn.nextLine();

						if (dao.getList(bNo) != null) {
							System.out.println("수정페이지입니다.");
							System.out.println("========================");
							System.out.println("수정할 도서명 입력>> ");
							String title = scn.nextLine();
							System.out.println("수정할 장르 입력>> ");
							String genre = scn.nextLine();
							System.out.println("수정할 작가명 입력>> ");
							String author = scn.nextLine();
							System.out.println("수정할 출판사 입력>> ");
							String company = scn.nextLine();
							System.out.println("수정할 가격(숫자) 입력>> ");
							String price = scn.nextLine();
							dao.update(new Book(bNo, title, genre, author, company, price));
							dao.borrowList(new Borrow(bNo, title, genre, author, company, price));
						}

					} else if (subMenu1 == 5) {
						System.out.println("삭제할 도서번호 입력>> ");
						String bNo = scn.nextLine();
						dao.delete(bNo);
						dao.borrowDelete(bNo);
					} else if (subMenu1 == 6) {

					} else if (subMenu1 == 9) {
						System.out.println("종료합니다");
						break;
					} else {
						System.out.println("잘못된 입력입니다");
					}
				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력입니다");
				}
			} else if (subMenu == 2) {
				System.out.println(">>>>대여메뉴입니다<<<< ");
				System.out.println("==================================");
				System.out.println("도서목록");
				List<Borrow> list = dao.borrowSearch();
				for (Borrow emp : list) {
					System.out.println(emp);
				}
				System.out.println("메뉴=> 1.대여하기 2.반납하기 9.종료");
				System.out.println("선택>> ");
				int subMenu3 = Integer.parseInt(scn.nextLine());
				try {
					if (subMenu3 == 1) {
						System.out.println("대여할 책번호 입력>> ");
						String bNo = scn.nextLine();
						dao.borrowUpdate(new Borrow(bNo));
					} else if (subMenu3 == 2) {
						System.out.println("반납할 책번호 입력>> ");
						String bNo = scn.nextLine();
						dao.returnUpdate(new Borrow(bNo));
					} else if (subMenu3 == 9) {
						System.out.println("종료합니다.");
						break;
					} else {
						System.out.println("잘못된 입력입니다");
					}

				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력입니다");
				}

			} else {
				System.out.println("잘못된 입력입니다");
			}

		}
		scn.close();
	}
}
