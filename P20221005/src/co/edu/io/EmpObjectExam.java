package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpObjectExam {
	public static void main(String[] args) throws Exception {

		// C:/Temp/emp.dat
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("1.사원등록 2.목록출력 3.삭제 9.종료");
			System.out.println("선택>>");

			int menu = scn.nextInt();
			if (menu == 1) {
				System.out.println("사번 >>");
				int id = scn.nextInt();
				System.out.println("이름 >>");
				scn.nextLine();
				String name = scn.nextLine();
				System.out.println("부서 >>");
				String dept = scn.nextLine();
				try {
					empList.add(new Emp(id, name, dept));
				} catch (Exception e) {
					System.out.println("정확하게 입력하시오.");
				}

			} else if (menu == 2) {
				for (int i = 0; i < empList.size(); i++) {
					System.out.print(empList.get(i).toString() + "\n");
				}
				System.out.println();
			} else if (menu == 3) {
				// 사원번호를 기준으로 삭제.
				System.out.println("삭제할 사번입력>>");
				int type = scn.nextInt();
				for(int i=0; i<empList.size();i++) {
					if(empList.get(i)!=null && empList.get(i).id == type) {
						empList.remove(i);
					}
				}

			} else if (menu == 9) {

				// 컬렉션에 있던 내용들을 ObjectOutputStream을 활용해서 C:/Temp/emp.dat에 저장

				try (FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos);) {

					oos.writeObject(empList);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
	}
}
