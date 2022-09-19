package javacourse;

public class TestArray {

	public static void main(String[] args) {
		
		boolean a[] = new boolean[5];
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		String b[] = new String[10];
		b[0] = "Ali";
		b[1] = "Sami";
//		for (int i = 0; i < b.length; i++) {
//			System.out.println(b[i] + " Length: " + b[i].length());
//		}
		
		try {
			int arr[] = {1, 4, 9};
			System.out.println(arr[4]);
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}

	}

}
