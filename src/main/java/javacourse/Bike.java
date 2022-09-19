package javacourse;

public class Bike implements Vehicle {
	
	int gear;
	int speed;

	@Override
	public void changeGear(int newGear) {
		gear = newGear;
	}

	@Override
	public void speedUp(int increment) {
		speed = speed + increment;
	}

	@Override
	public void applyBrakes(int decrement) {
		speed = speed - decrement;
	}
	
	public void printStates() {
		System.out.println("Bike: " + "Gear: " + gear + " Speed: " + speed);
	}

}
