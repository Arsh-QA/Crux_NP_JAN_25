package lec21;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		Random rn = new Random();
		int lo = 10;
		int hi = 100;
		for (int i = 0; i < 10; i++) {
			int n = rn.nextInt(hi - lo + 1) + lo;// 91 --> 0 to 90, now --> 10 to 100
			System.out.println(n);
		}
	}
}