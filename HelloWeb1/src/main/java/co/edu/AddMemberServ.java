package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMemberServ() {
		super();
	}

	protected void doGet(HttpServletRequest request//
			, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		System.out.println("/addMemberSer 페이지입니다.");
		String empId = request.getParameter("employee_id");
		System.out.println(empId);
		String lastName = request.getParameter("last_name");
		System.out.println(lastName);
		String email = request.getParameter("email");
		System.out.println(email);
		String hireDate = request.getParameter("hire_date");
		System.out.println(hireDate);
		String jobId = request.getParameter("job_id");
		System.out.println(jobId);

		// 입력
		EmployeeVO emp = new EmployeeVO(Integer.parseInt(empId), lastName, email, hireDate, jobId);
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(emp);
		System.out.println("입력완료");

		PrintWriter out = response.getWriter(); // 출력스트림
		out.print("<h3>입력결과:</h3>"
				+ "<br>사원번호:"+empId
				+ "<br>성:"+lastName
				+ "<br>이메일:"+email
				+ "<br>입사일자:"+hireDate
				+ "<br>직무:"+jobId
				+ "입니다."
				+ "<br><a href=\"http://localhost:8081/HelloWeb1/index.html\">첫페이지로 이동</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
