package test;

import java.util.List;

import bean.Dept;
import dao.DeptDAO;

public class TestDeptDAO {

	public static void main(String[] args) {

		DeptDAO dao = new DeptDAO();
		
		// Delete
		int row = dao.delete(50);
		System.out.println(row + " deleted");

		// Insert
		Dept dept = new Dept();
		dept.setName("TEST Nm");
		dept.setLocation("TEST Loc");
		row = dao.insert(dept);
		System.out.println(row + " inserted");
		
		// Update
		dept.setName("DEV123");
		dept.setLocation("IRBID");
		row = dao.update(dept);
		System.out.println(row + " updated");
		
		// Select All
		List<Dept> deptTable = dao.selectAll();
		System.out.println(deptTable);
	}

}
