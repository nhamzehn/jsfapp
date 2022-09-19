package javacourse;

public class Average{
	
	public static void main(String[] args) {
		
		//Integer g = new Integer(0);
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			System.out.println("Mark " + (i+1) + ": " + args[i]);
			sum = sum + Integer.parseInt(args[i]);
		}
		
		System.out.println("-----------");
		System.out.println("Sum = " + sum + " Average = " + (sum/args.length));
		
	}

}
