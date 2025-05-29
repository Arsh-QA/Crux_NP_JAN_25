package lec20_21_revise;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		int si = 10;
		int ei = 100;

		Random rn = new Random();

		for (int i = 0; i < 10; i++) {
			int item = rn.nextInt(ei - si + 1) + si;
			System.out.print(item + " ");
		}
	}
}