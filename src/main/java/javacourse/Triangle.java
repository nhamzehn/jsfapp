package javacourse;

public class Triangle extends Shape {
	
	private double height;
	private double base;
	
	public Triangle() {
		
	}

	public Triangle(double height, double base) {
		this.height = height;
		this.base = base;
	}

	@Override
	public double calcArea() {
		return 0.5 * height * base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "Triangle [height=" + height + ", base=" + base + "]";
	}
	

}
