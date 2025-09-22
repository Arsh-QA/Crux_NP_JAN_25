package reviseComparatorComparable;

public class Cars {// implements Comparable<Cars> {
	int price;
	int speed;
	String colour;

	public Cars() {

	}

	public Cars(int price, int speed, String colour) {
		this.price = price;
		this.speed = speed;
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "P : " + this.price + " S : " + this.speed + " C : " + this.colour;
	}

//	@Override
//	public int compareTo(Cars o) {
////		return this.price - o.price;
//		return o.speed - this.speed;
//	}
}