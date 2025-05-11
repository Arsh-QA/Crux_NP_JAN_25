package lec16;

public class CoinToss2 {

	public static void main(String[] args) {
		int noc = 4;
		coinToss(noc, "");
	}

	public static void coinToss(int noc, String ans) {
		if (noc == 0) {
			System.out.println(ans);
			return;
		}
		if (ans.length() == 0 || ans.charAt(ans.length() - 1) != 'H')
			coinToss(noc - 1, ans + "H");
		coinToss(noc - 1, ans + "T");
	}
}