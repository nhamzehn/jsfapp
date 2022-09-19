package bean;

public class Dept {

	private Integer id;
	private String name;
	private String location;

	public Dept() {

	}
	
	public Dept(Integer id) {
		this.setId(id);
	}

	public Dept(Integer id, String name, String location) {
		this.setId(id);
		this.name = name;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "Dept [id=" + getId() + ", name=" + name + ", location=" + location + "]\n";
	}

}
