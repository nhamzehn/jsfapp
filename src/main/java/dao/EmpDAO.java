package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Dept;
import bean.Emp;
import database.Database;

public class EmpDAO {

	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Emp> empTable;
	private int row;

	public List<Emp> selectAll() {

		try {
			db = new Database();
			empTable = new ArrayList<Emp>();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select empno, ename, job, sal, comm, mgr, hiredate, deptno from emp order by empno");
			rs = ps.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp();

				emp.setId(rs.getInt("empno"));
				emp.setName(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSalary(rs.getDouble("sal"));
				emp.setCommission(rs.getDouble("comm"));
				emp.setManager(rs.getInt("mgr"));
				emp.setHireDate(rs.getDate("hiredate"));

				DeptDAO deptDAO = new DeptDAO();
				Dept dept = deptDAO.selectById(rs.getInt("deptno"));
				emp.setDept(dept);

				empTable.add(emp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return empTable;
	}

	public List<String> selectJobs() {

		List<String> jobTable = new ArrayList<String>();
		try {
			db = new Database();
			empTable = new ArrayList<Emp>();
			connection = db.getConnection();
			ps = connection.prepareStatement("select distinct job from emp where job is not null order by job");
			rs = ps.executeQuery();

			while (rs.next()) {
				jobTable.add(rs.getString("job"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return jobTable;
	}
	
	private int selectMaxId(Connection connection) {
		try {
			ps = connection.prepareStatement("select nvl(max(empno),0) AS empno from emp");
			rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("empno");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally");
			Database.close(rs);
			//Database.close(ps);
		}

		return 0;
	}

	public int insert(Emp emp) {

		try {
			db = new Database();
			connection = db.getConnection();
			
			int maxId = selectMaxId(connection);
			System.out.println(maxId);
			
			ps = connection.prepareStatement(
					"insert into emp (empno, ename, job, sal, comm, mgr, hiredate, deptno) values(?, ?, ?, ?, ?, ?, ?, ?)");
			int counter = 1;
			//ps.setInt(counter++, emp.getId());
			ps.setInt(counter++, maxId + 1);
			ps.setString(counter++, emp.getName());
			ps.setString(counter++, emp.getJob());
			ps.setDouble(counter++, emp.getSalary());
			ps.setDouble(counter++, emp.getCommission());
			ps.setInt(counter++, emp.getManager());
			ps.setDate(counter++, new Date(emp.getHireDate().getTime()));
			ps.setInt(counter++, emp.getDept().getId());

			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;
	}

	public int update(Emp emp) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update emp set ename = ?, sal = ?, comm = ?, job = ?, "
					+ "mgr = ?, hiredate = ?, deptno =? where empno = ?");

			int counter = 1;
			ps.setString(counter++, emp.getName());
			ps.setDouble(counter++, emp.getSalary());
			ps.setDouble(counter++, emp.getCommission());
			ps.setString(counter++, emp.getJob());
			ps.setInt(counter++, emp.getManager());
			ps.setDate(counter++, new Date(emp.getHireDate().getTime()));
			ps.setInt(counter++, emp.getDept().getId());
			ps.setInt(counter++, emp.getId());

			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}

	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete emp where empno = ?");
			ps.setInt(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;
	}

}
