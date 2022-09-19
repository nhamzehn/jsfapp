package javacourse;

import java.util.HashSet;

public class TestSet {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		
		boolean b1 = set.add("ABC");
		boolean b2 = set.add("XYZ");
		boolean b3 = set.add("ABC");
		
		System.out.println(b1 + " " + b2 + " " + b3);
		
		System.out.println(set);

	}

}
