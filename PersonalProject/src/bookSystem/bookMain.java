package bookSystem;

import java.util.List;
import java.util.Scanner;

public class bookMain {
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		Scanner scn = new Scanner(System.in);
		boolean chk = false;
		while (!chk) {
			System.out.println("==================================");
			System.out.println("도서관리 프로그램에 오신것을 환영합니다.");
			System.out.println("메뉴=>1.로그인 2.회원가입");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("Id>>");
				String id = scn.nextLine();
				System.out.println("Passwd>>");
				String passwd = scn.nextLine();
				chk = dao.getId(id, passwd);
				if(chk==false) {
					chk=false;
				}
			} else if (menu == 2) {
				System.out.println(">>>>>회원가입 페이지입니다<<<<<");
				System.out.println("id생성>> ");
				String id = scn.nextLine();
				System.out.println("pwd생성>> ");
				String pwd = scn.nextLine();
				System.out.println("이름입력>> ");
				String name = scn.nextLine();
				dao.user(new Login(id, pwd, name));
				if(chk=false) {
					chk=false;
				}
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
			while (chk) {
				System.out.println("메뉴=> 1.도서등록 2.전체조회 3.상세조회 4.정보수정 5.도서삭제 9.종료");
				System.out.println("선택>> ");
				int subMenu = Integer.parseInt(scn.nextLine());

				try {
					if (subMenu == 1) {
						System.out.println("도서번호 입력>> ");
						String bNo = scn.nextLine();
						System.out.println("도서제목 입력>> ");
						String title = scn.nextLine();
						System.out.println("도서장르 입력>> ");
						String genre = scn.nextLine();
						System.out.println("도서작가 입력>> ");
						String author = scn.nextLine();
						dao.insert(new Book(bNo, title, genre, author));
					} else if (subMenu == 2) {
						List<Book> list = dao.search();
						for (Book emp : list) {
							System.out.println(emp);
						}
					} else if (subMenu == 3) {
						System.out.println("도서번호 입력>> ");
						String bNo = scn.nextLine();
						System.out.println(dao.getList(bNo));
					} else if (subMenu == 4) {
						System.out.println("수정할 도서번호 입력>> ");
						String bNo = scn.nextLine();
						System.out.println("수정페이지입니다.");
						System.out.println("========================");
						System.out.println("수정할 도서제목 입력>> ");
						String title = scn.nextLine();
						System.out.println("수정할 도서장르 입력>> ");
						String genre = scn.nextLine();
						System.out.println("수정할 도서작가 입력>> ");
						String author = scn.nextLine();
						dao.update(new Book(bNo, title, genre, author));
					} else if (subMenu == 5) {
						System.out.println("삭제할 도서번호 입력>> ");
						String bNo = scn.nextLine();
						dao.delete(bNo);
					} else if (subMenu == 6) {

					} else if (subMenu == 9) {
						System.out.println("종료합니다.");
						break;
					} else {
						System.out.println("잘못된 번호입니다.");
					}
				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력입니다.");
				}
			}
			scn.close();
		}
	}

