package javacourse;

public class Employee {

	private int id;
	private String name;
	private double salary;

	public Employee() {
		// Connect to DB, Select 
	}

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public Employee(int id, String name, double salary) {
		this("Name", 1000);
		this.id = id;
		this.name = name;
		this.salary = salary;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object obj) {

		Employee that = (Employee) obj;
		if (this.id == that.id) {
			return true;
		} else {
			return false;
		}

	}

}
