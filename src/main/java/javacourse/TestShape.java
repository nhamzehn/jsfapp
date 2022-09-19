package javacourse;

public class TestShape {

	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle(10, 5);
		Triangle triangle = new Triangle(10,  7);
		
		System.out.println("Area for rectangle: " + rectangle.calcArea());
		System.out.println("Area for triangle: " + triangle.calcArea());
		
		triangle.print("Rectangle");
		triangle.print("Triangle");

	}

}
