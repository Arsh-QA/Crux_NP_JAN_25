package reviseRecursionDP;

public class CoinToss {

	public static void main(String[] args) {
		int n = 3;
		coinToss(n, "");
		System.out.println(countCoinToss(n, ""));
	}

	public static void coinToss(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "T");
	}

	public static int countCoinToss(int n, String ans) {
		if (n == 0) {
//			System.out.println(ans);
			return 1;
		}
		int a1 = countCoinToss(n - 1, ans + "H");
		int a2 = countCoinToss(n - 1, ans + "T");
		return a1 + a2;
	}
}