package lec31;

public class Pair<T, P> {

	T x;
	P y;

	public Pair() {

	}

	public T getx() {
		return x;
	}

	public P gety() {
		return y;
	}

	public static void main(String[] args) {
		Pair<Integer, Integer> p1 = new Pair<>();
		Pair<Character, Integer> p2 = new Pair<>();
	}
}
