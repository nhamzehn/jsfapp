package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bean.Dept;
import bean.Emp;
import dao.EmpDAO;

public class TestEmpDAO {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
	    System.out.println(sdf.format(now));

		EmpDAO dao = new EmpDAO();

		int row = dao.delete(1);
		System.out.println(row + " deleted");

		Emp emp = new Emp(1, "Hamzeh", 1000);
		emp.setJob("DEV");
		emp.setCommission(10);
		emp.setManager(7788);
		emp.setHireDate(new Date());
		emp.setDept(new Dept(10));

		row = dao.insert(emp);
		System.out.println(row + " inserted");

		emp.setName("HmZ123");
		emp.setSalary(2000);
		row = dao.update(emp);
		System.out.println(row + " updated");

		List<Emp> empTable = dao.selectAll();
		System.out.println(empTable);
		now = new Date();
		System.out.println(sdf.format(now));
		
		List<String> jobTable = dao.selectJobs();
		System.out.println(jobTable);
	}

}
