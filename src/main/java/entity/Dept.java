package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "dept")
public class Dept {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "dept_gen")
	@TableGenerator(name = "dept_gen", table = "ID_GENERATION", allocationSize = 10, initialValue = 50)
	@Column(name = "deptno")
	private int id;

	@Column(name = "dname")
	private String name;

	@Column(name = "loc")
	private String location;

	@OneToMany(mappedBy = "dept")
	private List<Emp> emps = new ArrayList<Emp>();

	public Dept() {

	}

	public Dept(String name, String location) {
		this.name = name;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + /*", Emps=" + emps +*/ "]";
	}

}
