package javacourse;

public class LeapYear {

	public static void main(String[] args) {
	
		for (int i = 2000; i <= 2022; i++) {
			if (i % 4 == 0) {
				System.out.println("Year: " + i); 
			}
		}

	}

}
