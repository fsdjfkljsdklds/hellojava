package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {
	Scanner scn = new Scanner(System.in);
	ArrayList friends = new ArrayList();

	// 친구등록 - 학교 / 회사 / 친구...
	public void exe() {

		while (true) {
			System.out.println("1.친구등록 2.친구조회 3.종료");
			System.out.print("선택>>");

			int menu = scn.nextInt();
			if (menu == 1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int subMenu = scn.nextInt();
				if (subMenu == 1) {
					addComFriend();
				} else if (subMenu == 2) {
					addUnivFriend();
				} else if (subMenu == 3) {
					addFriend();
				} else {
					System.out.println("잘못된 메뉴를 선택했습니다.");
				}

			} else if (menu == 2) {
				searchFriend();
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
		System.out.println("프로그램 종료.");
	} // end of exe()

	// 추가 메소드.
	void addComFriend() {
		System.out.println("회사친구등록");
		scn.nextLine();
		System.out.println("이름 입력");
		String name = scn.nextLine();
		System.out.println("연락처 입력");
		String phone = scn.nextLine();
		System.out.println("회사명 입력");
		String company = scn.nextLine();
		System.out.println("부서 입력");
		String dept = scn.nextLine();

		ComFriend frd = new ComFriend(name, phone, company, dept);
		friends.add(frd);
		// 원래답은 밑에거
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = frd;
//				System.out.println("등록되었습니다.");
//				break;
//			}
//		}

	}

	void addUnivFriend() {
		System.out.println("학교친구등록");
		scn.nextLine();
		System.out.println("이름 입력");
		String name = scn.nextLine();
		System.out.println("연락처 입력");
		String phone = scn.nextLine();
		System.out.println("학교명 입력");
		String univ = scn.nextLine();
		System.out.println("전공 입력");
		String major = scn.nextLine();

		UnivFriend frd = new UnivFriend(name, phone, univ, major);
		friends.add(frd);
		// 원래답은 밑에거
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = frd;
//				System.out.println("등록되었습니다.");
//				break;
//			}
//		}
	}

	void addFriend() {
		System.out.println("친구등록");
		scn.nextLine();
		System.out.println("이름 입력");
		String name = scn.nextLine();
		System.out.println("연락처 입력");
		String phone = scn.nextLine();

		Friend frd = new Friend(name, phone);
		friends.add(frd);
		// 원래답은 밑에거
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = frd;
//				System.out.println("등록되었습니다.");
//				break;
//			}
//		}
	}

	void searchFriend() {
		// 권수미, 권미현, 강민기 =>
		System.out.println("친구조회.");
		System.out.println("검색할 이름을 입력하시오");
		scn.nextLine();
		String searchKey = scn.nextLine();

		for (int i = 0; i < friends.size(); i++) {
			// Friend 클래스의 상속. Friend, ComFriend, UnivFriend
			Object frnd = friends.get(i); // Object
			if (frnd instanceof Friend && ((Friend) frnd).getName().contains(searchKey)) {
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());

			} else if (frnd instanceof ComFriend && ((ComFriend) frnd).getName().contains(searchKey)) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
				
			} else if (frnd instanceof UnivFriend && ((UnivFriend) frnd).getName().contains(searchKey)) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}

		}
		// 원래 답은 밑에거
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] != null && friends[i].getName().contains(searchKey)) {
//				System.out.println(friends[i].showInfo());
//			}
//		}

//		for (Friend frd : friends) {
//			if (frd != null) {
//				System.out.println(frd.showInfo());
//			}
//		}
	}
}
