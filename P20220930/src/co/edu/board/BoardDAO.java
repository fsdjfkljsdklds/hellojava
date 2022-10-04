package co.edu.board;

import java.util.Arrays;
import java.util.Scanner;

// 기능만.
public class BoardDAO {
	// Singleton 방식의 인스턴스 생성.
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100];

	// 1. 글등록
	public void addBoard() {
		System.out.println("글등록 기능.");
		System.out.println("글번호입력 >>>");
		int bNo = scn.nextInt();
		scn.nextLine();
		System.out.println("글제목입력 >>>");
		String title = scn.nextLine();
		System.out.println("글내용입력 >>>");
		String content = scn.nextLine();

		Board brd = new Board(bNo, title, content);
		// 배열 등록.
		for (int i = 0; i < myBoards.length; i++) {
			if (myBoards[i] == null) {
				myBoards[i] = brd;
				System.out.println("등록되었습니다.");
				break;
			}
		}

	}

	// 2. 글목록
	public void boardList() {
		System.out.println("글목록 기능.");
		for (Board brd : myBoards) {
			if (brd != null) {
				System.out.println(brd.toString());
			}
		}
	}

	// 3. 글상세보기
	public void boardDetail() {
		System.out.println("상세보기 기능.");
		for(Board brd : myBoards) {
			if(brd != null) {
				System.out.println(brd.toString());
			}
		}
		System.out.println("글번호입력>>>");
		int bNo = scn.nextInt();
		for (int i = 0; i < myBoards.length; i++) {
			if (myBoards[i] != null && bNo == myBoards[i].getBoardNo()) {
				System.out.println(myBoards[i].toString());
				break;
			}
			
		}

	}

	// 4. 글삭제
	public void delBoard() {
		System.out.println("글삭제 기능");
		for(Board brd : myBoards) {
			if(brd != null) {
				System.out.println(brd.toString());
			}
		}
		System.out.println("글번호입력>>>");
		int bNo = scn.nextInt();
		for (int i = 0; i < myBoards.length; i++) {
			if (myBoards[i] != null && bNo == myBoards[i].getBoardNo()) {
				myBoards[i] = null;
				System.out.println(bNo + "번이 삭제되었습니다.");
			}
		}
	}
	// 5. 전체메뉴

	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("1.글등록 2.글목록 3.글상세보기 4.글삭제 9.종료");
			System.out.println("선택>> ");

			int menu = scn.nextInt();
			switch (menu) {
			case 1:
				addBoard();
				break;
			case 2:
				boardList();
				break;
			case 3:
				boardDetail();
				break;
			case 4:
				delBoard();
				break;
			case 9:
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}

		} // end of while
		System.out.println("프로그램 종료.");
	} // end of exe()

}
