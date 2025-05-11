package lec16;

public class CoinToss {

	public static void main(String[] args) {
		int noc = 4;
		coinToss(noc, "");
	}

	public static void coinToss(int noc, String ans) {
		if (noc == 0) {
			System.out.println(ans);
			return;
		}
		coinToss(noc - 1, ans + "H");
		coinToss(noc - 1, ans + "T");
	}
}