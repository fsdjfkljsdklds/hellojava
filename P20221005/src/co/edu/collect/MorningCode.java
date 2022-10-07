package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

class Employ {
	int empId;
	String empName;
	int salary;

	public Employ(int empId, String empName, int salary) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employ [사원번호 = " + empId + ", 이름 = " + empName + ", 급여 = " + salary + "]";
	}


}

public class MorningCode {
	public static void main(String[] args) {
		String tok = "Hello World Good";
		Scanner scn = new Scanner(tok);
		Scanner scanner = new Scanner(System.in);

		ArrayList<Employ> list = new ArrayList<>();
		while (true) {
			System.out.println("입력>> ex) 100 홍길동 2500");
			System.out.println(">>>");
			String inputVal = scanner.nextLine();
			String[] inputs = inputVal.split(" ");
			// quit => 종료.
			if (inputs[0].equals("quit")) {
				break;
			}
			if (inputs.length != 3) {
				System.out.println("다시입력...");
			}
			list.add(new Employ(Integer.parseInt(inputs[0]), inputs[1], Integer.parseInt(inputs[2])));
			for (Employ a : list) {
				System.out.println(a.toString());
			}

		}
	}
}

// 첫번째 값=> empId, 두번째 값=> empName, 세번째 값=> salary
// Employee 클래스의 인스턴스 생성.
// ArrayList에 저장.
// 종료를 하고 싶으면 quit 입력시 종료.

// for(반복문) 출력.
//		for(Employ emp : list) {
//			System.out.println(emp);
//		}

//		while (scn.hasNext())
//			System.out.println(scn.next());

//		String[] toks = tok.split(" ");
//		for (String str : toks) {
//			System.out.println(str);
//		} 
