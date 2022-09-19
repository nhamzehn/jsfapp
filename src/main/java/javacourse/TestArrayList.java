package javacourse;

import java.util.ArrayList;

public class TestArrayList {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		ArrayList as = new ArrayList();
		ArrayList<String> vstring = new ArrayList<String>();
		ArrayList<Employee> vemp = new ArrayList<Employee>();

		as.add("Hamzeh");
		as.add("Asefan");
		al.add(1);
		al.add(as);
		al.add(1000.0);
		System.out.println(al);
		System.out.println("Element At 0: " + al.get(0));
		System.out.println("Element At 1: " + ((ArrayList) al.get(1)).get(1));

		// ////////////////////////////////
		vstring.add("Hamzeh");
		vstring.add("Ali");
		boolean add = vstring.add("AAAA");
		System.out.println(add);
		System.out.println(vstring);
		
		// ////////////////////////////////
		Employee e1 = new Employee(1, "Sami", 750.0);
		Employee e2 = new Employee(2, "Hamzeh", 1000.0);
		vemp.add(e1);
		vemp.add(e2);
		System.out.println(vemp);

	}

}
