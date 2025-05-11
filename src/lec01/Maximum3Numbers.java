package lec01;

public class Maximum3Numbers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 19;
		int b = 11;
		int c = 7;
		if (a >= b && a >= c) {
			System.out.println(a);
		} else if (b >= a && b >= c) {
			System.out.println(b);
		} else {
			System.out.println(c);
		}

	}
}
