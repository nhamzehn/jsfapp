package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "emp")
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "emp_gen")
	@TableGenerator(name = "emp_gen", table = "ID_GENERATION", allocationSize = 1, initialValue = 1111)
	@Column(name = "empno")
	private int id;

	@Column(name = "ename")
	private String name;

	@Column(name = "job")
	private String job;

	@Column(name = "mgr")
	private Integer manager;

	@Column(name = "sal")
	private double salary;

	@Column(name = "comm")
	private Double commission;

	@Column(name = "hiredate")
	private Date hiredate;

	@ManyToOne
	@JoinColumn(name = "deptno")
	private Dept dept;
	
	public Emp() {

	}

	public Emp(int id) {
		this.id = id;
	}

	public Emp(String name, String job, double salary) {
		this.name = name;
		this.salary = salary;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "\nEmp [id=" + id + ", name=" + name + ", job=" + job + ", manager=" + manager + ", salary=" + salary + ", commission="
				+ commission + ", hiredate=" + hiredate + ", dept=" + dept.getId() + ", " + dept.getName() + ", " + dept.getLocation() + "]";
	}

}
