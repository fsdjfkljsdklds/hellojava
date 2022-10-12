package co.edu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAO {

	public void delete(int empId) {
		String sql = "delete from empl Where employee_id=?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	public void update(Employee emp) {
		String sql = "update empl "//
				+ "set email = ?, "//
				+ "    hire_date = ?, "//
				+ "    job_id = ? "//
				+ "where employee_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getEmail());
			psmt.setString(2, emp.getHireDate());
			psmt.setString(3, emp.getJobId());
			psmt.setInt(4, emp.getEmployeeId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	public void insert(Employee emp) {
		String sql = "insert into empl (employee_id, last_name, email, hire_date,job_id)" //
				+ "values(" + emp.getEmployeeId()//
				+ ", '" + emp.getLastName()//
				+ "', '" + emp.getEmail()//
				+ "', '" + emp.getHireDate()//
				+ "', '" + emp.getJobId() + "')";

		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 조회
	public List<Employee> search() {
		conn = getConnect();
		List<Employee> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empl");
			while (rs.next()) {
				list.add(new Employee(rs.getInt("employee_id")//
						, rs.getString("last_name")//
						, rs.getString("email")//
						, rs.getString("hire_date")//
						, rs.getString("job_id")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public Employee getEmp(int empId) {
		// 한건만 반환
		conn = getConnect();
		Employee emp = null;
		String sql = "select * from empl where employee_id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				emp = new Employee(rs.getInt("employee_id")//
						, rs.getString("last_name")//
						, rs.getString("email")//
						, rs.getString("hire_date")//
						, rs.getString("job_id"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return emp;

//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select * from empl where employee_id =" + empId);
//			while (rs.next()) {
//				result = (new Employee(rs.getInt("employee_id")//
//						, rs.getString("last_name")//
//						, rs.getString("email")//
//						, rs.getString("hire_date")//
//						, rs.getString("job_id")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disConnect();
//		}
//		return result;

	}

}
