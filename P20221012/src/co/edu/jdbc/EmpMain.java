package co.edu.jdbc;

import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);

		// 메뉴 => 1.사원등록(insert) 2.한건조회(getEmp) 3.수정 4.삭제 5.목록조회 9.종료

		while (true) {
			System.out.println("메뉴 => 1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 9.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			try {
				if (menu == 1) {
					System.out.println("===========================");
					System.out.println("empId 입력>>");
					int empId = Integer.parseInt(scn.nextLine());
					System.out.println("lastName 입력>>");
					String lastName = scn.nextLine();
					System.out.println("email 입력>>");
					String email = scn.nextLine();
					System.out.println("hireDate 입력>>");
					String hireDate = scn.nextLine();
					System.out.println("jobId 입력>>");
					String jobId = scn.nextLine();
					dao.insert(new Employee(empId, lastName, email, hireDate, jobId));
				} else if (menu == 2) {
					System.out.println("사원번호입력>>");
					int empId = Integer.parseInt(scn.nextLine());
					System.out.println(dao.getEmp(empId));
				} else if (menu == 3) {
					System.out.println("===========================");
					System.out.println("수정empId입력>>");
					int empId = Integer.parseInt(scn.nextLine());
					System.out.println("===========================");
					System.out.println("이메일입력>>");
					String email = scn.nextLine();
					System.out.println("입사일입력>>");
					String hireDate = scn.nextLine();
					System.out.println("직책입력>>");
					String jobId = scn.nextLine();
					dao.update(new Employee(empId, null, email, hireDate, jobId));

				} else if (menu == 4) {
					System.out.println("사원번호입력>>");
					int empId = Integer.parseInt(scn.nextLine());
					dao.delete(empId);
				} else if (menu == 5) {
					List<Employee> employees = dao.search();
					for (Employee emp : employees) {
						System.out.println(emp);
					}
				} else if (menu == 9) {
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
