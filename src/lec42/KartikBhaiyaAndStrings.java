package lec42;

public class KartikBhaiyaAndStrings {

	public static void main(String[] args) {
		String s = "aaababbababababababbabbaaa";
		int k = 3;
		int flipA = maximumLength(s, k, 'a');
		int flipB = maximumLength(s, k, 'b');
		System.out.println(Math.max(flipA, flipB));
	}

	public static int maximumLength(String s, int k, char ch) {
		int si = 0, ei = 0, flip = 0, ans = 0;
		while (ei < s.length()) {
			// Grow
			if (s.charAt(ei) == ch) {
				flip++;
			}

			// Shrink
			while (flip > k && si <= ei) {
				if (s.charAt(si) == ch) {
					flip--;
				}
				si++;
			}

			// ans calculate
			ans = Math.max(ans, ei - si + 1);
			ei++;
		}
		return ans;
	}
}
