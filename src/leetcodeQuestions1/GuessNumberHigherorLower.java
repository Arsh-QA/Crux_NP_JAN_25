package leetcodeQuestions1;

public class GuessNumberHigherorLower {

	public static void main(String[] args) {
		System.out.println(guess(10));
	}

	public static int guessNumber(int n, int num) {
		int low = 1;
		int high = n;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (guess(mid) == 1) {
				low = mid + 1;
			} else if (guess(mid) == -1) {
				high = mid - 1;
			} else {
				ans = mid;
				break;
			}
		}
		return ans;
	}

	public static int guess(int mid) {
		return 0;
	}
}