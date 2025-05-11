package lec16prefix;

public class CoinToss2 {

	public static void main(String[] args) {
//		coinToss(3, "");

		System.out.println(countCoinToss(3, ""));
	}

	public static void coinToss(int noc, String result) {
		if (noc == 0) {
			System.out.println(result);
			return;
		}

		if (result.length() == 0 || result.charAt(result.length() - 1) != 'H')
			coinToss(noc - 1, result + "H");
		coinToss(noc - 1, result + "T");
	}

	public static int countCoinToss(int noc, String result) {
		if (noc == 0) {
			System.out.println(result);
			return 1;
		}

		int a1 = 0;
		if (result.length() == 0 || result.charAt(result.length() - 1) != 'H')
			a1 = countCoinToss(noc - 1, result + "H");
		int a2 = countCoinToss(noc - 1, result + "T");
		return a1 + a2;
	}
}