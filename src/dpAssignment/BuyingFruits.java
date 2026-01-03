package dpAssignment;

import java.util.*;

public class BuyingFruits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();// number of shops

			// Read first shop separately to initialize DP
			int costA = sc.nextInt();
			int costM = sc.nextInt();
			int costO = sc.nextInt();

			int prevA = costA; // dpA for shop 0
			int prevM = costM; // dpM for shop 0
			int prevO = costO; // dpO for shop 0

			// Process remaining shops
			for (int i = 1; i < n; i++) {
				costA = sc.nextInt();
				costM = sc.nextInt();
				costO = sc.nextInt();

				int curA = costA + Math.min(prevM, prevO);
				int curM = costM + Math.min(prevA, prevO);
				int curO = costO + Math.min(prevA, prevM);

				prevA = curA;
				prevM = curM;
				prevO = curO;
			}

			int answer = Math.min(prevA, Math.min(prevM, prevO));
			System.out.println(answer);
		}

		sc.close();
	}
}