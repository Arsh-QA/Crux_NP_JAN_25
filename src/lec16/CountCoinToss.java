package lec16;

public class CountCoinToss {

	public static void main(String[] args) {
		int noc = 4;
		System.out.println(countCoinToss(noc, ""));
	}

	public static int countCoinToss(int noc, String ans) {
		if (noc == 0) {
//			System.out.println(ans);
			return 1;
		}
		int a1 = countCoinToss(noc - 1, ans + "H");
		int a2 = countCoinToss(noc - 1, ans + "T");
		return a1 + a2;
	}
}