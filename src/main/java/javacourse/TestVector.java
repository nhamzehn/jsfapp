package javacourse;

import java.util.Vector;

public class TestVector {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Vector vl = new Vector();
		Vector vs = new Vector();
		Vector<String> vstring = new Vector<String>();
		Vector<Employee> vemp = new Vector<Employee>();

		vs.addElement("Hamzeh");
		vs.addElement("Asefan");
		vl.add(1);
		vl.add(vs);
		vl.add(1000.0);
		System.out.println(vl);
		System.out.println("Element At 0: " + vl.elementAt(0));
		System.out.println("Element At 1: " + ((Vector) vl.elementAt(1)).elementAt(1));

		// ////////////////////////////////
		vstring.add("Hamzeh");
		vstring.add("Ali");
		System.out.println(vstring);
		
		// ////////////////////////////////
		Employee e1 = new Employee(1, "Sami", 750.0);
		Employee e2 = new Employee(2, "Hamzeh", 1000.0);
		vemp.add(e1);
		vemp.add(e2);
		System.out.println(vemp);

	}

}
