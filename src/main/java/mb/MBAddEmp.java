package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Dept;
import bean.Emp;
import dao.DeptDAO;
import dao.EmpDAO;
import util.Message;

@ManagedBean(name = "mbAddEmp")
public class MBAddEmp {

	private Emp emp;
	private List<String> jobTable;
	private List<Dept> deptTable;
	private EmpDAO empDAO;

	@PostConstruct
	public void init() {
		empDAO = new EmpDAO();
		jobTable = empDAO.selectJobs();

		DeptDAO deptDAO = new DeptDAO();
		deptTable = deptDAO.selectAll();
	}

	public String save() {
		
		empDAO.insert(emp);
		Message.addMessageByKey("INFO", " ", "msg_save");

		emp = new Emp();
		emp.setDept(new Dept());
		return null;
	}

	public Emp getEmp() {
		if (emp == null) {
			emp = new Emp();
			emp.setDept(new Dept());
		}
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public List<String> getJobTable() {
		return jobTable;
	}

	public void setJobTable(List<String> jobTable) {
		this.jobTable = jobTable;
	}

	public List<Dept> getDeptTable() {
		return deptTable;
	}

	public void setDeptTable(List<Dept> deptTable) {
		this.deptTable = deptTable;
	}

	public Dept getDept(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("no id provided");
		}
		for (Dept dept : deptTable) {
			if (id.equals(dept.getId())) {
				return dept;
			}
		}
		return null;
	}

}
