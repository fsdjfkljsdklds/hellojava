package com.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp implements StudentService {

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	public void execute() {
		while (true) {
			System.out.println("1.등록 2.목록 3.수정 9.종료");
			System.out.println("선택>>");
			int menu = scn.nextInt();

			if (menu == 1) {
				System.out.println("1.학생 2.고등학생 3.대학생");
				int subMenu = scn.nextInt();
				if (subMenu == 1) {
					System.out.println("번호입력>>");
					scn.nextLine();
					String studNo = scn.nextLine();
					System.out.println("이름입력>>");
					String studName = scn.nextLine();
					System.out.println("점수입력>>");
					int score = Integer.parseInt(scn.nextLine());

					Student std = new Student(studNo, studName, score);
					addStudent(std);
				} else if (subMenu == 2) {
					System.out.println("번호입력>>");
					scn.nextLine();
					String studNo = scn.nextLine();
					System.out.println("이름입력>>");
					String studName = scn.nextLine();
					System.out.println("점수입력>>");
					int score = Integer.parseInt(scn.nextLine());
					System.out.println("담임교사입력>>");
					String teacher = scn.nextLine();
					System.out.println("학년입력>>");
					String grade = scn.nextLine();

					list.add(new HighStudent(studNo, studName, score, teacher, grade));
				} else if (subMenu == 3) {
					System.out.println("번호입력>>");
					scn.nextLine();
					String studNo = scn.nextLine();
					System.out.println("이름입력>>");
					String studName = scn.nextLine();
					System.out.println("점수입력>>");
					int score = Integer.parseInt(scn.nextLine());
					System.out.println("담당교수입력>>");
					String prof = scn.nextLine();
					System.out.println("전공입력>>");
					String major = scn.nextLine();

					list.add(new CollegeStudent(studNo, studName, score, prof, major));
				}
			} else if (menu == 2) {
				List<Student> list = studentList();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) != null) {
						System.out.println(list.get(i).toString());
					}
				}
			} else if (menu == 3) {
				System.out.println("변경할 학생번호입력>>");
				scn.nextLine();
				String studNo = scn.nextLine();
				System.out.println("==================");
				System.out.println("변경할 점수 입력>>");
				int score = Integer.parseInt(scn.nextLine());
				modStudent(studNo,score);
//				for (int i = 0; i < list.size(); i++) {
//					if (list.get(i) != null && list.get(i).getStudNo().equals(studNo)) {
//						list.get(i).setScore(score);
//						break;
//					}
//				}
			} else if (menu == 9) {
				System.out.println("종료합니다.");
				break;

			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	@Override
	public void addStudent(Student student) {
		list.add(student);
	}

	@Override
	public List<Student> studentList() {
		return list;
	}


	@Override
	public void modStudent(String studNo, int score) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).getStudNo().equals(studNo)) {
				list.get(i).setScore(score);
				break;
			}
		}
	}

}
