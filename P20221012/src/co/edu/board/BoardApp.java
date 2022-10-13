package co.edu.board;

import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import co.edu.jdbc.Employee;

//main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		boolean login = true;

		System.out.println("Id>>");
		String id = scn.nextLine();
		System.out.println("Passwd>>");
		String passwd = scn.nextLine();
		login = dao.getId(id, passwd);
		while (true) {
			if (login == false) {
				break;
			}
			System.out.println("메뉴 => 1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("===========================");
				System.out.println("글번호입력>>");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println("글제목입력>>");
				String title = scn.nextLine();
				System.out.println("글내용입력>>");
				String content = scn.nextLine();
				System.out.println("작성자입력>>");
				String writer = scn.nextLine();
				dao.insert(new Board(number, title, content, writer));
			} else if (menu == 2) {
				System.out.println("===========================");
				System.out.println("수정-글번호입력>>");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println("===========================");
				System.out.println("글내용입력>>");
				String content = scn.nextLine();
				dao.update(new Board(number, content));
			} else if (menu == 3) {
				System.out.println("글번호입력>>");
				int number = Integer.parseInt(scn.nextLine());
				dao.delete(number);
			} else if (menu == 4) {
				List<Board> brd = dao.search();
				for (Board a : brd) {
					System.out.println(a);
				}
			} else if (menu == 5) {
				System.out.println("글번호입력>>");
				int number = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getNum(number));
			} else if (menu == 9) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}

		}
	}
}
