package javacourse;

public class TestEmployee {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e4 = new Employee(4, "Sami", 750.0);
		Employee e11 = new Employee(1, "Hamzeh", 1000.0);
		PartTimeEmployee e5 = new PartTimeEmployee();
		FullTimeEmployee e6 = new FullTimeEmployee();
		
		e1.setId(1);
		e1.setName("Hamzeh");
		e1.setSalary(1000.0);
		
		e2.setId(2);
		e2.setName("Ali");
		e2.setSalary(1500);
		
		e5.setId(5);
		e5.setName("ABC");
		e5.setSalary(800);
		e5.setHour(4);
		
		e6.setId(6);
		e6.setName("XYZ");
		e6.setSalary(1800);
		e6.setVacation(21);
		
		System.out.println(e5);
		
		System.out.println(e1.getId() + " " + e1.getName() + " " + e1.getSalary());
		System.out.println(e2.getId() + " " + e2.getName() + " " + e2.getSalary());
		System.out.println(e3.getId() + " " + e3.getName() + " " + e3.getSalary());
		System.out.println(e4.getId() + " " + e4.getName() + " " + e4.getSalary());
		System.out.println(e5.getId() + " " + e5.getName() + " " + e5.getSalary() + " " + e5.getHour());
		System.out.println(e6.getId() + " " + e6.getName() + " " + e6.getSalary() + " " + e6.getVacation());
		
		System.out.println("----------------------------------------------------");
		
		System.out.println(e1);
		System.out.println(e11);
		
		if (e1.equals(e11)) {
			System.out.println("E1 is equal E11");
		} else {
			System.out.println("Is not equal");
		}


	}

}
