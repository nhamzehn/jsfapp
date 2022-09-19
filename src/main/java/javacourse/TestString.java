package javacourse;

public class TestString {

	public static void main(String[] args) {
		
		String name = "Hamzeh";
		
		
		System.out.println("Length: " + name.length());
		System.out.println("Sub String: " + name.substring(2, 5));
		System.out.println("Char At: " + name.charAt(2));
		System.out.println("Index Of: " + name.indexOf("m"));
		System.out.println("To Lower Case " + name.toLowerCase());
		System.out.println("To Upper Case " + name.toUpperCase());
		
		if (name.equals("HAMZEH")) {
			System.out.println("Equals");
		} else {
			System.out.println("Not Equals");
		}
		
		// Hamzeh --> hezmaH
		// Reverse Name
		for (int i = name.length() - 1; i >= 0; i--) {
			System.out.print(name.charAt(i));
		}
		
		
		
	}

}
