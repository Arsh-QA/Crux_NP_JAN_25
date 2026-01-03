package reviseRecursionDP;

public class BoardPath {
	public static void main(String[] args) {
		int n = 4;
		printAns(n, 0, "");
	}

	// curr --> current position
	// ending goal --> n
	public static void printAns(int n, int curr, String ans) {
		if (curr == n) {
			System.out.print(ans + " ");
			return;
		}
		if (curr > n)
			return;
		for (int dice = 1; dice <= 3; dice++) {
			printAns(n, curr + dice, ans + dice);
		}
//		printAns(n, curr + 1, ans + 1);
//		printAns(n, curr + 2, ans + 2);
//		printAns(n, curr + 3, ans + 3);
	}
}