package co.edu.moring;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Moring20221014 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<Member> list = new ArrayList<Member>();
		String fileName = "C:/Temp/memberList.txt";
		while (true) {
			System.out.println("메뉴 => 1.회원등록 2.회원조회 9.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("회원아이디>>");
				String id = scn.nextLine();
				System.out.println("회원이름>>");
				String name = scn.nextLine();
				System.out.println("회원포인트>>");
				String point = scn.nextLine();
				list.add(new Member(id, name, point));
				
				
				try {
					File file = new File(fileName);
					FileWriter fw = new FileWriter(file,true);
					
					fw.write(list.toString());
					fw.flush();
					
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}else if(menu ==2) {
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i).toString() + "\n");
				}
				
			}else if(menu == 9) {
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
