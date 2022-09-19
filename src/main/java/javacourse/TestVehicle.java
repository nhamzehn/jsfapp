package javacourse;

public class TestVehicle {

	public static void main(String[] args) {

		Bicycle bicycle = new Bicycle();
		Bike bike = new Bike();

		bicycle.changeGear(2);
		bicycle.speedUp(5);
		bicycle.applyBrakes(1);
		bicycle.printStates();
		
		bike.changeGear(3);
		bike.speedUp(10);
		bike.applyBrakes(2);
		bike.printStates();

	}

}
