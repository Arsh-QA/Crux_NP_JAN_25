package reviseOOPS2;

public class Car {
	public String colour;
	int price;
	private int speed;

	public Car(String colour, int price, int speed) {
		this.colour = colour;
		this.price = price;
		this.speed = speed;
	}

	public void displayCar() {
		System.out.println("C=" + this.colour + " P=" + this.price + " S=" + this.speed);
	}
}