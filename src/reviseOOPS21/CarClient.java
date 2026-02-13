package reviseOOPS21;

public class CarClient {
	public static void main(String[] args) throws Exception {
		Car c = new Car("Black", 1929, 25);
		Car c1 = new Car("Red", 19029, 23);
		c.displayCar();
		c1.displayCar();
		c.price = 68890;
		c.displayCar();
		c1.displayCar();
		c.setColour("Green");
		c.setPrice(-1000);
		c.displayCar();
	}
}