package recursionRevision;

public class CountSubSequence {
	public static void main(String[] args) {
		int noc = 4;
		System.out.println(coinToss(noc, ""));
	}

	public static int coinToss(int noc, String ans) {
		if (noc == 0) {
			System.out.println(ans);
			return 1;
		}
		int a1 = 0;
		if (ans.length() == 0 || ans.charAt(ans.length() - 1) != 'H')
			a1 = coinToss(noc - 1, ans + "H");
		int a2 = coinToss(noc - 1, ans + "T");
		return a1 + a2;
	}
}