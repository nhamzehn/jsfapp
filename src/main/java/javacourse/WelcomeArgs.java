package javacourse;

public class WelcomeArgs {

	public static void main(String[] args) {
		
		if (args.length == 2) {
			System.out.println("Welcome " + args[0] + " " + args[1]);
		} else if (args.length == 1) {
			System.out.println("Welcome " + args[0]);
		} else {
			System.out.println("Welcome");
		}

	}
}
