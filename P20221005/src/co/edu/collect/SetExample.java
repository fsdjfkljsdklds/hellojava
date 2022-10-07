package co.edu.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

class Employee {
	int empId;
	String name;
	int salary;

	public Employee(int empId, String name, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	// 동일한 객체 :
	@Override
	public int hashCode() {
		return empId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee target = (Employee) obj; // casting.
			return (this.empId == target.empId && this.name.equals(target.name) && this.salary == target.salary);
		} else {
			return false;
		}

	}

}

public class SetExample {
	public static void main(String[] args) {
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(new Employee(100, "홍길동", 1000));
		employees.add(new Employee(200, "박유식", 2000));
		employees.add(new Employee(300, "최윤기", 3000));
		employees.add(new Employee(100, "김길동", 1000));

		employees.remove(new Employee(100, "김길동", 1000));

		System.out.println(employees.size());

		Iterator<Employee> iter = employees.iterator();
		while (iter.hasNext()) {
			Employee emp = iter.next();
			System.out.printf("사번은 %d, 이름은 %s, 급여는 %d\n", emp.empId, emp.name, emp.salary);
		}

		Set<Integer> set = new HashSet<Integer>();
		// 중복허용X
//		while (set.size() < 7) {
//			set.add((int) (Math.random() * 45) + 1);
//		}
//		for (int n : set) {
//			System.out.println(n);
//		}
//		
		int lotto[] = new int[7];

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			System.out.println(lotto[i]);

		}
	}

}
