package co.edu.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmpDbToFile {
	public static void main(String[] args) {

		try {
			FileWriter fw = new FileWriter("c:/Temp/empFile.txt");
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.search();

			for (Employee emp : list) {
				int id = emp.getEmployeeId();
				String name = emp.getLastName();
				String email = emp.getEmail();
				String hireDate = emp.getHireDate();
				String jobId = emp.getJobId();
				fw.write("id: " + id + " name: " + name //
						+ " email: " + email //
						+ " hireDate: " + hireDate //
						+ " jobId: " + jobId + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("complete");

	}
}
