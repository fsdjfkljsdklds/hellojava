package co.edu.emp;

//CRUD 처리.
public interface EmployeeService {
	// 초기화(init)
	public void init();

	public void input(); // 추가

	public String search(int employeeId); // 사원아이디에 이름 반환.

	public void print(); // 전체사원정보 출력.
}
