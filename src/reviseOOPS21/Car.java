package reviseOOPS21;

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

	public String getColour() {
		return colour;
	}

	public int getPrice() {
		return price;
	}

	public int getSpeed() {
		return speed;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setPrice(int price) throws Exception {
		if (price < 0) {
			throw new Exception("Price is never negative");
		}
		this.price = price;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}