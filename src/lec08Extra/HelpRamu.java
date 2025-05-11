package lec08Extra;

import java.util.Scanner;

public class HelpRamu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			int c3 = sc.nextInt();
			int c4 = sc.nextInt();
			int n = sc.nextInt();// number of Rickshaws
			int m = sc.nextInt();// number of Cabs
			int[] rickshawRide = new int[n];
			int[] cabRide = new int[m];
			for (int i = 0; i < rickshawRide.length; i++) {
				rickshawRide[i] = sc.nextInt();
			}
			for (int i = 0; i < cabRide.length; i++) {
				cabRide[i] = sc.nextInt();
			}
			System.out.println(minimumSum(c1, c2, c3, c4, rickshawRide, cabRide));
			T--;
		}
		sc.close();
	}

	public static int minimumSum(int c1, int c2, int c3, int c4, int[] rickshawRide, int[] cabRide) {
		int rickshawCost = 0;
		for (int i = 0; i < rickshawRide.length; i++) {
			rickshawCost = rickshawCost + Math.min(rickshawRide[i] * c1, c2);
		}
		rickshawCost = Math.min(rickshawCost, c3);
		int cabCost = 0;
		for (int i = 0; i < cabRide.length; i++) {
			cabCost = cabCost + Math.min(cabRide[i] * c1, c2);
		}
		cabCost = Math.min(cabCost, c3);
		int totalCost = rickshawCost + cabCost;
		return Math.min(totalCost, c4);
	}
}