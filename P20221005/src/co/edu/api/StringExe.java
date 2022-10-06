package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {

		String fileName = "src/co/edu/api/Birth.txt";
		File file = new File(fileName);

		Scanner scn = null;
		try {
			scn = new Scanner(file);
			while (true) {
				String str = scn.nextLine();
				if (str == null) {
					break;
				}
				char sex = str.charAt(7);
				switch (sex) {
				case '1':
				case '3':
					System.out.println("남자입니다.");
					break;
				case '2':
				case '4':
					System.out.println("여자입니다.");
					break;
				default :
					System.out.println("잘못된번호입니다.");
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {

		}
		System.out.println("end of prog");
	}

}
