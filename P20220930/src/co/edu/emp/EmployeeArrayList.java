package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

// 컬렉션(ArrayList)을 활용해서 데이터 저장.
public class EmployeeArrayList implements EmployeeService {

	Scanner scn = new Scanner(System.in);
	ArrayList<Employee> list;
	int idx = 0;

	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료.");
	}

	@Override
	public void input() {
		System.out.println("사번 입력>>>");
		int eId = Integer.parseInt(scn.nextLine());
		System.out.println("이름>>>");
		String name = scn.nextLine();
		System.out.println("급여>>>");
		int sal = Integer.parseInt(scn.nextLine());
		System.out.println("부서>>>");
		int deptId = Integer.parseInt(scn.nextLine());
		System.out.println("이메일>>>");
		String email = scn.nextLine();
		Employee emp = new Employee(eId, name, sal, deptId, email);
		list.add(emp);

	}

	@Override
	public String search(int employeeId) {
		String result = null;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getEmployeeId() == employeeId) {
//				result = list.get(i).getName();
//				break;
//			}
//		}
		for (Employee emp : list) {
			if (emp.getEmployeeId() == employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("    사원번호      사원이름   급여");
			System.out.println("=================================");
			System.out.printf("(" + (i + 1) + ")" + "%5d %10s %7d\n", list.get(i).getEmployeeId(),
					list.get(i).getName(), list.get(i).getSalary());
			System.out.println("=================================");
		}
	}

	@Override
	public int searchSal(int employeeId) {
		int result = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmployeeId() == employeeId) {
				result = list.get(i).getSalary();
				break;
			}
		}
		return result;
	}

}
